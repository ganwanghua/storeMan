package com.pinnoocle.storeman.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;

import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;

public class LoginFragment extends Fragment implements View.OnClickListener {
    EditText etPhone, etPassword;
    Button btn_login;
    String phone, password;
    DataRepository dataRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        dataRepository = Injection.dataRepository(getContext());
        etPhone = v.findViewById(R.id.et_phone);
        etPassword = v.findViewById(R.id.et_password);
        btn_login = v.findViewById(R.id.btn_login);

        etPhone.setText(FastData.getPhone());
        etPassword.setText(FastData.getPwd());

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
        ViewLoading.show(getActivity());
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        map.put("password", password);
        map.put("registrationid", JPushInterface.getRegistrationID(getActivity()));
        dataRepository.login(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getActivity());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getActivity());
                NewUserLogin newUserLogin = (NewUserLogin) data;
                if (newUserLogin.getCode() == 1) {
                    FastData.setPhone(phone);
                    FastData.setPwd(password);
                    FastData.setStoreName(newUserLogin.getData().getShop().getShop_name());
                    FastData.setShopId(newUserLogin.getData().getShop().getShop_id() + "");
                    FastData.setWxAppId(newUserLogin.getData().getShop().getWxapp_id() + "");
                    FastData.setFirstLogin("1");
                    ActivityUtils.startActivity(getActivity(), MainActivity.class);
                    getActivity().finish();
                } else {
                    ToastUtils.showToast(newUserLogin.getMsg());
                }
            }
        });
    }
}