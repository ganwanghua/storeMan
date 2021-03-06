package com.pinnoocle.storeman.mine.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.pinnoocle.storeman.home.TravelCardActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.mine.AssetsActivity;
import com.pinnoocle.storeman.mine.MyClassActivity;
import com.pinnoocle.storeman.mine.SettingActivity;
import com.pinnoocle.storeman.mine.TravelCardOrderActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends Fragment implements View.OnClickListener {
    private DataRepository dataRepository;
    private CircleImageView circleImageView;
    private TextView tv_name, tv_phone;
    private RelativeLayout rl_assets, rl_my_class, rl_travel_card;
    private ImageView iv_setting;

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String message) {
        if (message.equals("1")) {
            shop();
        }
    }

    private void initView(View v) {
        EventBus.getDefault().register(this);
        circleImageView = v.findViewById(R.id.iv_avatar_one);
        tv_name = v.findViewById(R.id.tv_name);
        tv_phone = v.findViewById(R.id.tv_phone);
        rl_assets = v.findViewById(R.id.rl_assets);
        rl_my_class = v.findViewById(R.id.rl_my_class);
        iv_setting = v.findViewById(R.id.iv_setting);
        rl_travel_card = v.findViewById(R.id.rl_travel_card);
        dataRepository = Injection.dataRepository(getContext());
        shop();

        rl_assets.setOnClickListener(this);
        rl_my_class.setOnClickListener(this);
        iv_setting.setOnClickListener(this);
        rl_travel_card.setOnClickListener(this);
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
                    FastData.setCan_notice(personalBean.getData().getShop().getCan_notice() + "");
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
        switch (v.getId()) {
            case R.id.rl_my_class:
                ActivityUtils.startActivity(getActivity(), MyClassActivity.class);
                break;
            case R.id.rl_assets:
                ActivityUtils.startActivity(getActivity(), AssetsActivity.class);
                break;
            case R.id.iv_setting:
                ActivityUtils.startActivity(getActivity(), SettingActivity.class);
                break;
            case R.id.rl_travel_card:
                ActivityUtils.startActivity(getActivity(), TravelCardOrderActivity.class);
                break;
        }
    }
}