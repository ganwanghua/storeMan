package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.bean.ClassBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.AfterSaleFragment;
import com.pinnoocle.storeman.home.fragment.AllFragment;
import com.pinnoocle.storeman.home.fragment.ClassFragment;
import com.pinnoocle.storeman.home.fragment.CommentFragment;
import com.pinnoocle.storeman.home.fragment.DeliveryFragment;
import com.pinnoocle.storeman.home.fragment.PaymentFragment;
import com.pinnoocle.storeman.home.fragment.ReceivedFragment;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<String> titles = new ArrayList<>();
        dataRepository = Injection.dataRepository(this);
        dataRepository.classIndex(new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                ClassBean classBean = (ClassBean) data;
                if (classBean.getCode() == 1) {
                    for (int i = 0; i < classBean.getData().getGoods_category().size(); i++) {
                        titles.add(classBean.getData().getGoods_category().get(i).getName());
                    }
                    for (int i = 0; i < titles.size(); i++) {
                        fragments.add(new ClassFragment(classBean.getData().getGoods_category().get(i).getCategory_id()));
                    }
                    FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
                    viewPager.setAdapter(adatper);
                    viewPager.setOffscreenPageLimit(fragments.size());
                    //将TabLayout和ViewPager关联起来。
                    xTablayout.setupWithViewPager(viewPager);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}