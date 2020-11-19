package com.pinnoocle.storeman.home;

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
import com.pinnoocle.storeman.home.fragment.PayFragment;
import com.pinnoocle.storeman.home.fragment.PaymentFragment;
import com.pinnoocle.storeman.home.fragment.ReceivedFragment;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentRecordActivity extends BaseActivity {

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
        setContentView(R.layout.activity_payment_record);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("微信支付");
        titles.add("支付宝支付");
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new PayFragment(""));
            } else if (i == 1) {
                fragments.add(new PayFragment("WECHAT"));
            } else if (i == 2) {
                fragments.add(new PayFragment("ALIPAY"));
            }
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(3);
        //将TabLayout和ViewPager关联起来。
        xTablayout.setupWithViewPager(viewPager);
        if(getIntent().getIntExtra("pos",-1) == 1){
            viewPager.setCurrentItem(0);
        }else if(getIntent().getIntExtra("pos",-1) == 2){
            viewPager.setCurrentItem(1);
        }else if(getIntent().getIntExtra("pos",-1) == 3){
            viewPager.setCurrentItem(2);
        }
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}