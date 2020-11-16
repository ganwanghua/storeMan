package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.mine.MyClassActivity;
import com.pinnoocle.storeman.mine.TravelCardOrderActivity;
import com.pinnoocle.storeman.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySuccessActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_success)
    TextView tvSuccess;
    @BindView(R.id.tv_go_home)
    TextView tvGoHome;
    @BindView(R.id.tv_go_class)
    TextView tvGoClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        ButterKnife.bind(this);
        if (getIntent().getStringExtra("pos").equals("1")) {
            tvGoClass.setText("查看我的课程");
        }else {
            tvGoClass.setText("查看我的旅行卡");
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_go_home, R.id.tv_go_class})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_go_home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_go_class:
                if (getIntent().getStringExtra("pos").equals("1")) {
                    Intent intent1 = new Intent(this, MyClassActivity.class);
                    startActivity(intent1);
                    finish();
                }else {
                    Intent intent1 = new Intent(this, TravelCardOrderActivity.class);
                    startActivity(intent1);
                    finish();
                }

                break;
        }
    }
}