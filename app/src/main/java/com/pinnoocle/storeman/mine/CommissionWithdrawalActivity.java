package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.CommissionBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommissionWithdrawalActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.iv_ali_pay)
    ImageView ivAliPay;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.tv_withdrawal)
    TextView tvWithdrawal;
    private DataRepository dataRepository;
    private EditText ed_name, ed_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission_withdrawal);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        tvMoney.setText(getIntent().getStringExtra("money"));
    }

    @OnClick({R.id.iv_back, R.id.tv_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_withdrawal:
                if (TextUtils.isEmpty(edMoney.getText().toString())) {
                    ToastUtils.showToast("请输入提现金额");
                } else {
                    showPay();
                }
                break;
        }
    }

    private void showPay() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_zhifubao)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.ed_name, R.id.ed_count, R.id.tv_quit, R.id.tv_cancel)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        ed_name = viewHolder.itemView.findViewById(R.id.ed_name);
                        ed_count = viewHolder.itemView.findViewById(R.id.ed_count);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_quit:
                                if (TextUtils.isEmpty(ed_name.getText().toString())) {
                                    ToastUtils.showToast("请输入支付宝名称");
                                } else if (TextUtils.isEmpty(ed_count.getText().toString())) {
                                    ToastUtils.showToast("请输入支付宝账号");
                                } else {
                                    withdraw(ed_name.getText().toString(), ed_count.getText().toString());
                                    tDialog.dismiss();
                                }
                                break;
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void withdraw(String alipay_name, String alipay_account) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<String, String>();
        map.put("shop_id", FastData.getShopId());
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("money", edMoney.getText().toString());
        map.put("alipay_name", alipay_name);
        map.put("alipay_account", alipay_account);
        dataRepository.withdraw(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(CommissionWithdrawalActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(CommissionWithdrawalActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast("提现成功");
                    EventBus.getDefault().post("3");
                } else {
                    ToastUtils.showToast(statusBean.getMsg());
                }
            }
        });
    }
}