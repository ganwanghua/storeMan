package com.pinnoocle.storeman.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

    @OnClick({R.id.iv_back, R.id.tv_quit})
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
        }
    }
}