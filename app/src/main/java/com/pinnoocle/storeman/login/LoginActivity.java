package com.pinnoocle.storeman.login;

import android.Manifest;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.tbruyelle.rxpermissions3.RxPermissions;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    DataRepository dataRepository;
    String phone, password;

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
        dataRepository = Injection.dataRepository(this);
        etPhone.setText(FastData.getPhone());
        etPassword.setText(FastData.getPwd());
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

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        phone = etPhone.getText().toString();
        password = etPassword.getText().toString();
        String telRegex = "[1][3456789]\\d{9}";
        boolean matches = phone.matches(telRegex);
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showToast("请输入手机号码");
        } else if (matches == false) {
            ToastUtils.showToast("请输入正确的手机号码");
        } else {
            //进行登录的网络请求
            login(phone, password);
        }
    }

    private void login(String phone, String password) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        map.put("password", password);
        map.put("registrationid", JPushInterface.getRegistrationID(this));
        dataRepository.login(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(LoginActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(LoginActivity.this);
                NewUserLogin newUserLogin = (NewUserLogin) data;
                if (newUserLogin.getCode() == 1) {
                    FastData.setPhone(phone);
                    FastData.setPwd(password);
                    FastData.setStoreName(newUserLogin.getData().getShop().getShop_name());
                    FastData.setShopId(newUserLogin.getData().getShop().getShop_id() + "");
                    FastData.setWxAppId(newUserLogin.getData().getShop().getWxapp_id() + "");
                    FastData.setFirstLogin("1");
                    ActivityUtils.startActivity(LoginActivity.this, MainActivity.class);
                    finish();
                } else {
                    ToastUtils.showToast(newUserLogin.getMsg());
                }
            }
        });
    }

}