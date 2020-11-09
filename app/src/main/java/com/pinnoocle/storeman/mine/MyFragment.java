package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.PersonalBean;
import com.pinnoocle.storeman.bean.QrCodeBean;
import com.pinnoocle.storeman.home.CollectionCodeActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends Fragment implements View.OnClickListener {
    private DataRepository dataRepository;
    private CircleImageView circleImageView;
    private TextView tv_name, tv_phone;
    private RelativeLayout rl_assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        circleImageView = v.findViewById(R.id.iv_avatar_one);
        tv_name = v.findViewById(R.id.tv_name);
        tv_phone = v.findViewById(R.id.tv_phone);
        rl_assets = v.findViewById(R.id.rl_assets);
        dataRepository = Injection.dataRepository(getContext());
        shop();

        rl_assets.setOnClickListener(this);
    }

    private void shop() {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        dataRepository.shop(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                PersonalBean personalBean = (PersonalBean) data;
                if (personalBean.getCode() == 1) {
                    Glide.with(getActivity()).load(personalBean.getData().getShop().getLogo()).centerCrop().into(circleImageView);
                    tv_name.setText(personalBean.getData().getShop().getShop_name());
                    if (!TextUtils.isEmpty(personalBean.getData().getShop().getPhone()) && personalBean.getData().getShop().getPhone().length() > 6) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < personalBean.getData().getShop().getPhone().length(); i++) {
                            char c = personalBean.getData().getShop().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tv_phone.setText(sb.toString());
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        ActivityUtils.startActivity(getActivity(), AssetsActivity.class);
    }
}