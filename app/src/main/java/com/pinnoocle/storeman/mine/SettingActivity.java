package com.pinnoocle.storeman.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.AppManager;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.titan.versionupdata.VersionUpdata;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.ielse.view.SwitchView;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_quit)
    TextView tvQuit;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.switch_button_wxpay)
    SwitchView switchButtonWxpay;
    @BindView(R.id.rl_assets)
    RelativeLayout rlAssets;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.rl_version)
    RelativeLayout rlVersion;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tv_bind)
    TextView tvBind;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.ll_bind)
    LinearLayout llBind;
    private DataRepository dataRepository;
    private EditText ed_imei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        if (FastData.getIMei().equals("")) {
            tvBind.setText("去绑定");
            ivRight.setVisibility(View.VISIBLE);
            llBind.setEnabled(true);
        } else {
            tvBind.setText("已绑定");
            ivRight.setVisibility(View.GONE);
            llBind.setEnabled(false);
        }
        if (FastData.getCan_notice().equals("1")) {
            switchButtonWxpay.setOpened(true);
        } else {
            switchButtonWxpay.setOpened(false);
        }

        switchButtonWxpay.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                view.setOpened(true);
                setBroadcast();
            }

            @Override
            public void toggleToOff(SwitchView view) {
                view.setOpened(false);
                setBroadcast();
            }
        });

        tvVersion.setText(getPackageInfo(this).versionName);
    }

    /**
     * 版本信息
     */
    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }

    private void setBroadcast() {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        if (switchButtonWxpay.isOpened()) {
            map.put("can_notice", "1");
        } else {
            map.put("can_notice", "0");
        }
        dataRepository.switchNotice(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    if (switchButtonWxpay.isOpened()) {
                        ToastUtils.showToast("已开启");
                    } else {
                        ToastUtils.showToast("已关闭");
                    }
                    EventBus.getDefault().post("1");
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_quit, R.id.rl_version, R.id.ll_bind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_quit:
                FastData.setFirstLogin("0");
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                AppManager.getInstance().killAllActivity();
                break;
            case R.id.rl_version:
                versionCheck();
                break;
            case R.id.ll_bind:
                showImei();
                break;
        }
    }

    private void showImei() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_imei)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.ed_imei, R.id.tv_quit, R.id.tv_cancel)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        ed_imei = viewHolder.itemView.findViewById(R.id.ed_imei);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_quit:
                                if (ed_imei.getText().toString().length() > 0) {
                                    updateImei();
                                    tDialog.dismiss();
                                } else {
                                    ToastUtils.showToast("请输入IMei号");
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

    private void updateImei() {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("imei", ed_imei.getText().toString());
        dataRepository.updateImei(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    FastData.setIMei("已绑定");
                    tvBind.setText("已绑定");
                    ivRight.setVisibility(View.GONE);
                } else {
                    ToastUtils.showToast(statusBean.getMsg());
                }
            }
        });
    }

    private void versionCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = getResources().getString(R.string.versionurl);
                boolean flag = new VersionUpdata(SettingActivity.this).checkVersion(url);
                if (!flag) {
                    Looper.prepare();
                    ToastUtils.showToast("当前版本已是最新版本");
                    Looper.loop();
                }
            }
        }).start();
    }
}