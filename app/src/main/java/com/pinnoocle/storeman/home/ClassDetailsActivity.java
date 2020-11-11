package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.CourseCatalogueFragment;
import com.pinnoocle.storeman.home.fragment.CourseIntroductionFragment;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_money_one)
    TextView tvMoneyOne;
    @BindView(R.id.tv_concessional_rate)
    TextView tvConcessionalRate;
    @BindView(R.id.tv_sales_volume)
    TextView tvSalesVolume;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private DataRepository dataRepository;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        tvTitle.setText(getIntent().getStringExtra("goods_name"));

        classDetail(getIntent().getStringExtra("goods_id"));
    }

    private void classDetail(String id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", id);
        map.put("shop_id", FastData.getShopId());
        dataRepository.classDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ClassDetailsActivity.this);
                ClassDetailBean classDetailBean = (ClassDetailBean) data;
                if (classDetailBean.getCode() == 1) {
                    Glide.with(ClassDetailsActivity.this).load(classDetailBean.getData().getDetail().getGoods_image()).centerCrop().into(ivPicture);
                    tvName.setText(classDetailBean.getData().getDetail().getGoods_name());
                    tvMoneyOne.setText(classDetailBean.getData().getDetail().getGoods_sku().getGoods_price());
                    tvConcessionalRate.setText("¥" + classDetailBean.getData().getDetail().getGoods_sku().getLine_price());
                    tvSalesVolume.setText("销量:" + classDetailBean.getData().getDetail().getGoods_sku().getStock_num());

                    List<String> titles = new ArrayList<>();
                    titles.add("课程介绍");
                    titles.add("课程目录");
                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new CourseIntroductionFragment(classDetailBean.getData().getDetail().getContent()));
                        }else {
                            fragments.add(new CourseCatalogueFragment(classDetailBean.getData().getVideoList()));
                        }
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