package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.AfterSaleFragment;
import com.pinnoocle.storeman.home.fragment.AllFragment;
import com.pinnoocle.storeman.home.fragment.CommentFragment;
import com.pinnoocle.storeman.home.fragment.DeliveryFragment;
import com.pinnoocle.storeman.home.fragment.PaymentFragment;
import com.pinnoocle.storeman.home.fragment.ReceivedFragment;
import com.pinnoocle.storeman.mine.fragment.TravelCardFragment;
import com.pinnoocle.storeman.mine.fragment.TravelCodeAllFragment;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TravelCardOrderActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_card_order);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("待付款");
        titles.add("待发货");
        titles.add("待收货");
        titles.add("已完成");
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new TravelCodeAllFragment("all"));
            } else if (i == 1) {
                fragments.add(new TravelCodeAllFragment("payment"));
            } else if (i == 2) {
                fragments.add(new TravelCodeAllFragment("delivery"));
            } else if (i == 3) {
                fragments.add(new TravelCodeAllFragment("received"));
            } else if (i == 4) {
                fragments.add(new TravelCardFragment("comment"));
            }
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(5);
        //将TabLayout和ViewPager关联起来。
        xTablayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}