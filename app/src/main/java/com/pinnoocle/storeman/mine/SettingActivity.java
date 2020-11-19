package com.pinnoocle.storeman.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
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
    private DataRepository dataRepository;

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

    @OnClick({R.id.iv_back, R.id.tv_quit,R.id.rl_version})
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
        }
    }

    private void versionCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = getResources().getString(R.string.versionurl);
                new VersionUpdata(SettingActivity.this).checkVersion(url);
            }
        }).start();
    }
}