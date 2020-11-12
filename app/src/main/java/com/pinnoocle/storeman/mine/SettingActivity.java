package com.pinnoocle.storeman.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.common.AppManager;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_quit)
    TextView tvQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
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
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                AppManager.getInstance().killAllActivity();
                break;
        }
    }
}