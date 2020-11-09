package com.pinnoocle.storeman.mine;

import android.os.Bundle;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.util.StatusBarUtil;

public class AssetsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets);
    }
}