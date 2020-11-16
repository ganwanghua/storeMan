package com.pinnoocle.storeman.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.ByNowClassBean;
import com.pinnoocle.storeman.bean.PayResult;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AcknowledgementOrderActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.iv_line)
    ImageView ivLine;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_specifications)
    TextView tvSpecifications;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.rl_delivery_fee)
    RelativeLayout rlDeliveryFee;
    @BindView(R.id.ed_message)
    EditText edMessage;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.tv_all_money)
    TextView tvAllMoney;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_we_chat)
    ImageView ivWeChat;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.iv_small_change)
    ImageView ivSmallChange;
    @BindView(R.id.tv_num_one)
    TextView tvNumOne;
    @BindView(R.id.tv_all_money_one)
    TextView tvAllMoneyOne;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_one)
    ImageView ivRightOne;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_ali_pay)
    ImageView ivAliPay;
    @BindView(R.id.iv_select1)
    ImageView ivSelect1;
    @BindView(R.id.iv_select2)
    ImageView ivSelect2;
    private DataRepository dataRepository;
    private static final int SDK_PAY_FLAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgement_order);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        buyNow();
    }


    private void buyNow() {
        dataRepository.buyNow("/shop/api.pay/buyNow", getIntent().getStringExtra("goods_id"), "1", getIntent().getStringExtra("sku_id"), FastData.getShopId(), new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                ByNowClassBean byNowClassBean = (ByNowClassBean) data;
                if (byNowClassBean.getCode() == 1) {
                    tvName.setText(byNowClassBean.getData().getOrderInfo().getAddress().getName());
                    tvPhone.setText(byNowClassBean.getData().getOrderInfo().getAddress().getPhone());
                    tvAddress.setText(byNowClassBean.getData().getOrderInfo().getAddress().getRegion().getProvince() + byNowClassBean.getData().getOrderInfo().getAddress().getRegion().getCity()
                            + byNowClassBean.getData().getOrderInfo().getAddress().getRegion().getRegion() + byNowClassBean.getData().getOrderInfo().getAddress().getDetail());
                    Glide.with(AcknowledgementOrderActivity.this).load(byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getGoods_image()).centerCrop().into(ivShop);
                    tvTitle.setText(byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getGoods_name());
                    tvMoney.setText("¥" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getGoods_price());
                    tvNum.setText("x" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getTotal_num());
                    tvDeliveryFee.setText("¥" + byNowClassBean.getData().getOrderInfo().getExpress_price());

                    tvTime.setText("共" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getTotal_num() + "件商品，合计:");
                    tvAllMoney.setText("¥" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getTotal_price());

                    tvNumOne.setText("共" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getTotal_num() + "件商品，合计:");
                    tvAllMoneyOne.setText("¥" + byNowClassBean.getData().getOrderInfo().getGoods_list().get(0).getTotal_price());

                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.iv_select, R.id.iv_select1, R.id.iv_select2, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                buyPay();
                break;
            case R.id.iv_select:
                ivSelect.setImageResource(R.mipmap.select);
                ivSelect1.setImageResource(R.mipmap.unselect);
                ivSelect2.setImageResource(R.mipmap.unselect);
                break;
            case R.id.iv_select1:
                ivSelect.setImageResource(R.mipmap.unselect);
                ivSelect1.setImageResource(R.mipmap.select);
                ivSelect2.setImageResource(R.mipmap.unselect);
                break;
            case R.id.iv_select2:
                ivSelect.setImageResource(R.mipmap.unselect);
                ivSelect1.setImageResource(R.mipmap.unselect);
                ivSelect2.setImageResource(R.mipmap.select);
                break;
            case R.id.iv_right:
                ActivityUtils.startActivityForResult(this, AddressActivity.class, 1001);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 1001) {
            buyNow();
        }
    }

    private void buyPay() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_num", "1");
        map.put("goods_sku_id", getIntent().getStringExtra("sku_id"));
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("delivery", "10");
        map.put("shop_id", FastData.getShopId());
        map.put("pay_type", "30");
        dataRepository.buyPay(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AcknowledgementOrderActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AcknowledgementOrderActivity.this);
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
                PayTask alipay = new PayTask(AcknowledgementOrderActivity.this);
                Map<String, String> result = alipay.payV2(payment, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
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
                case SDK_PAY_FLAG: {
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
                        Intent intent = new Intent(AcknowledgementOrderActivity.this, PaySuccessActivity.class);
                        intent.putExtra("pos", "2");
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