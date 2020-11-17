package com.pinnoocle.storeman.login;

import android.os.Bundle;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.common.BaseActivity;

public class ApplyShopActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initBlue();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_shop);
    }
}