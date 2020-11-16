package com.pinnoocle.storeman.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alipay.sdk.app.PayTask;
import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.dialog.select.CustomSelectDialog;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.ByNowClassBean;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.bean.PayResult;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.CourseCatalogueFragment;
import com.pinnoocle.storeman.home.fragment.CourseIntroductionFragment;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.mine.MyClassDetailsActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.WrapContentHeightViewPager;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_money_one)
    TextView tvMoneyOne;
    @BindView(R.id.tv_concessional_rate)
    TextView tvConcessionalRate;
    @BindView(R.id.tv_sales_volume)
    TextView tvSalesVolume;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    WrapContentHeightViewPager viewPager;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    private DataRepository dataRepository;
    List<Fragment> fragments = new ArrayList<>();
    ClassDetailBean.DataBean.DetailBean classDetail;
    private EditText et_shop_num;
    private static final int SDK_PAY_FLAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        tvTitle.setText(getIntent().getStringExtra("goods_name"));

        classDetail(getIntent().getStringExtra("goods_id"));
    }

    private void classDetail(String id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", id);
        map.put("shop_id", FastData.getShopId());
        dataRepository.classDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
                ClassDetailBean classDetailBean = (ClassDetailBean) data;
                if (classDetailBean.getCode() == 1) {
                    classDetail = classDetailBean.getData().getDetail();
                    Glide.with(ClassDetailsActivity.this).load(classDetailBean.getData().getDetail().getGoods_image()).into(ivPicture);
                    tvName.setText(classDetailBean.getData().getDetail().getGoods_name());
                    tvMoneyOne.setText(classDetailBean.getData().getDetail().getGoods_sku().getGoods_price());
                    tvConcessionalRate.setText("¥" + classDetailBean.getData().getDetail().getGoods_sku().getLine_price());
                    tvSalesVolume.setText("销量:" + classDetailBean.getData().getDetail().getGoods_sku().getStock_num());

                    List<String> titles = new ArrayList<>();
                    titles.add("课程介绍");
                    titles.add("课程目录");
                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new CourseIntroductionFragment(classDetailBean.getData().getDetail().getContent()));
                        } else {
                            fragments.add(new CourseCatalogueFragment(classDetailBean.getData().getVideoList()));
                        }
                    }
                    FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
                    viewPager.setAdapter(adatper);
                    viewPager.setOffscreenPageLimit(fragments.size());
                    //将TabLayout和ViewPager关联起来。
                    xTablayout.setupWithViewPager(viewPager);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                SelectNum();
                break;
        }
    }

    private void SelectNum() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_num_select)
                .setScreenWidthAspect(ClassDetailsActivity.this, 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.ic_close, R.id.tv_sure, R.id.rl_shop_delete, R.id.rl_shop_insert, R.id.et_shop_num)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        ImageView iv_shop = viewHolder.itemView.findViewById(R.id.iv_shop);
                        TextView tv_title = viewHolder.itemView.findViewById(R.id.tv_title);
                        TextView tv_money = viewHolder.itemView.findViewById(R.id.tv_money);
                        TextView tv_stork = viewHolder.itemView.findViewById(R.id.tv_stork);
                        et_shop_num = viewHolder.itemView.findViewById(R.id.et_shop_num);
                        Glide.with(ClassDetailsActivity.this).load(classDetail.getGoods_image()).into(iv_shop);
                        tv_title.setText(classDetail.getGoods_name());
                        tv_money.setText("¥" + classDetail.getGoods_sku().getGoods_price());
                        tv_stork.setText("库存：" + classDetail.getGoods_sku().getStock_num());
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.ic_close:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                if (Integer.parseInt(et_shop_num.getText().toString()) > classDetail.getGoods_sku().getStock_num()) {
                                    ToastUtils.showToast("您购买的数量超出库存总数！");
                                } else {
                                    showCustomDialog();
                                }
                                break;
                            case R.id.rl_shop_delete:
                                int s = Integer.parseInt(et_shop_num.getText().toString());
                                if (s <= 1) {

                                } else {
                                    s = s - 1;
                                    et_shop_num.setText(s + "");
                                }
                                break;
                            case R.id.rl_shop_insert:
                                int s1 = Integer.parseInt(et_shop_num.getText().toString());
                                s1 = s1 + 1;
                                et_shop_num.setText(s1 + "");
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void showCustomDialog() {
        final List<String> names = new ArrayList<>();
        names.add("微信");
        names.add("支付宝");
        names.add("余额");
        showDialog(new CustomSelectDialog.SelectDialogListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0) {

                } else if (position == 1) {
                    buyPay();
                } else {

                }
            }
        }, names);
    }

    private CustomSelectDialog showDialog(CustomSelectDialog.SelectDialogListener listener,
                                          List<String> names) {
        CustomSelectDialog dialog = new CustomSelectDialog(this,
                R.style.transparentFrameWindowStyle, listener, names);
        dialog.setItemColor(R.color.grey, R.color.blue);
        //判断activity是否finish
        if (!this.isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    private void buyPay() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", classDetail.getGoods_id() + "");
        map.put("goods_num", et_shop_num.getText().toString());
        map.put("goods_sku_id", classDetail.getGoods_sku().getSpec_sku_id());
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("delivery", "10");
        map.put("shop_id", FastData.getShopId());
        map.put("pay_type", "30");
        dataRepository.buyPay(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
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
                PayTask alipay = new PayTask(ClassDetailsActivity.this);
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
                        Intent intent = new Intent(ClassDetailsActivity.this, PaySuccessActivity.class);
                        intent.putExtra("pos", "1");
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