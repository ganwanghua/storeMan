package com.pinnoocle.storeman.login;

import android.Manifest;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.ClassFragment;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.tbruyelle.rxpermissions3.RxPermissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initBlue();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        rxPermissionTest();
        if (FastData.getFirstLogin().equals("1")) {
            ActivityUtils.startActivity(LoginActivity.this, MainActivity.class);
            finish();
        }
        titles.add("登录");
        titles.add("注册");
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new LoginFragment());
            }else {
                fragments.add(new RegisterFragment());
            }
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(fragments.size());
        //将TabLayout和ViewPager关联起来。
        xTablayout.setupWithViewPager(viewPager);
    }

    private void rxPermissionTest() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CAMERA, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.RECORD_AUDIO, Manifest.permission.MODIFY_AUDIO_SETTINGS, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        // I can control the camera now
                    } else {
                        // Oups permission denied
                    }
                });
    }
}