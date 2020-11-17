package com.pinnoocle.storeman.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.ApplyInfoBean;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.bean.SearchBean;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;

import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    EditText etPhone;
    Button btn_search;
    CircleImageView iv_avatar;
    TextView tv_name;
    DataRepository dataRepository;
    LinearLayout ll_message;
    private String user_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        dataRepository = Injection.dataRepository(getContext());
        etPhone = v.findViewById(R.id.et_phone);
        btn_search = v.findViewById(R.id.btn_search);
        tv_name = v.findViewById(R.id.tv_name);
        iv_avatar = v.findViewById(R.id.iv_avatar);
        ll_message = v.findViewById(R.id.ll_message);

        btn_search.setOnClickListener(this);
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String telRegex = "[1][3456789]\\d{9}";
                boolean matches = s.toString().matches(telRegex);
                if (matches) {
                    //进行登录的网络请求
                    search(s.toString());
                } else {
                    ll_message.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        applyInfo(user_id);
    }

    private void search(String phone) {
        ViewLoading.show(getActivity());
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        dataRepository.search(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getActivity());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getActivity());
                SearchBean searchBean = (SearchBean) data;
                if (searchBean.getCode() == 1) {
                    ll_message.setVisibility(View.VISIBLE);
                    user_id = searchBean.getData().getUser().getUser_id() + "";
                    tv_name.setText(searchBean.getData().getUser().getNickName());
                    Glide.with(getActivity()).load(searchBean.getData().getUser().getAvatarUrl()).centerCrop().into(iv_avatar);
                } else {
                    ll_message.setVisibility(View.GONE);
                    ToastUtils.showToast("请先去小程序授权登录！");
                }
            }
        });
    }

    private void applyInfo(String user_id) {
        ViewLoading.show(getActivity());
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user_id);
        dataRepository.applyInfo(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getActivity());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getActivity());
                ApplyInfoBean applyInfoBean = (ApplyInfoBean) data;
                if (applyInfoBean.getCode() == 1) {
                    if (applyInfoBean.getData().getInfo().getIs_pay() == 0) {
                        Intent intent = new Intent(getActivity(), MerchantsEnteringActivity.class);
                        intent.putExtra("money", applyInfoBean.getData().getInfo().getShop_price());
                        intent.putExtra("user_id", user_id);
                        intent.putExtra("mark", "1");
                        startActivity(intent);
                    } else {
                        if (applyInfoBean.getData().getInfo().getIs_apply() == 0) {
                            Intent intent = new Intent(getActivity(), InformationActivity.class);
                            intent.putExtra("shanglv_id", applyInfoBean.getData().getInfo().getInfo().getShanglv_id() + "");
                            intent.putExtra("user_id", user_id);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getActivity(), MerchantsEnteringActivity.class);
                            intent.putExtra("mark", "2");
                            intent.putExtra("status", applyInfoBean.getData().getInfo().getInfo().getStatus());
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}