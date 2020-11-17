package com.pinnoocle.storeman.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.PayResult;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MerchantsEnteringActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    private boolean isClick = true;
    private int pos;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchants_entering);
        ButterKnife.bind(this);

        dataRepository = Injection.dataRepository(this);
        if (getIntent().getStringExtra("mark").equals("1")) {
            llMessage.setVisibility(View.VISIBLE);
            tvBuy.setText("支付  " + getIntent().getStringExtra("money") + "元");
        } else {
            if (getIntent().getIntExtra("status", -1) == 0) {
                tvBuy.setText("审核中");
                llMessage.setVisibility(View.GONE);
            } else if (getIntent().getIntExtra("status", -1) == 1) {
                tvBuy.setText("审核通过");
                llMessage.setVisibility(View.GONE);
            } else {
                llMessage.setVisibility(View.VISIBLE);
                tvBuy.setText("审核被拒绝，请重新申请");
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_buy, R.id.iv_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                if (getIntent().getStringExtra("mark").equals("1")) {
                    if (pos == 1) {
                        pays();
                    } else {
                        ToastUtils.showToast("请先同意该协议！");
                    }
                }else {
                    if (getIntent().getIntExtra("status", -1) == 0) {

                    } else if (getIntent().getIntExtra("status", -1) == 1) {
                        ToastUtils.showToast("审核已通过，请前往登录！");
                    } else {
                        if (pos == 1) {
                            Intent intent = new Intent(MerchantsEnteringActivity.this, InformationActivity.class);
                            intent.putExtra("user_id", getIntent().getStringExtra("user_id"));
                            startActivity(intent);
                        } else {
                            ToastUtils.showToast("请先同意该协议！");
                        }
                    }
                }
                break;
            case R.id.iv_select:
                if (isClick) {
                    ivSelect.setImageResource(R.mipmap.select);
                    isClick = false;
                    pos = 1;
                } else {
                    ivSelect.setImageResource(R.mipmap.unselect);
                    isClick = true;
                    pos = 2;
                }
                break;
        }
    }

    private void pays() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("user_id", getIntent().getStringExtra("user_id"));
        map.put("type", "shop");
        dataRepository.pays(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(MerchantsEnteringActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(MerchantsEnteringActivity.this);
                AliPayBean aliPayBean = (AliPayBean) data;
                if (aliPayBean.getCode() == 1) {
                    alipay(aliPayBean.getData().getPayment());
                }
            }
        });
    }

    private void alipay(String payment) {
        final Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(MerchantsEnteringActivity.this);
                Map<String, String> result = alipay.payV2(payment, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showToast("支付成功");
                        Intent intent = new Intent(MerchantsEnteringActivity.this, InformationActivity.class);
                        intent.putExtra("user_id", getIntent().getStringExtra("user_id"));
                        startActivity(intent);
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            ToastUtils.showToast("支付结果确认中");
                        } else if (TextUtils.equals(resultStatus, "6001")) { //用户中途取消
                            ToastUtils.showToast("取消支付");
                        } else {
                            // 其他值就可以判断为支付失败
                            ToastUtils.showToast("支付失败");
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };
}