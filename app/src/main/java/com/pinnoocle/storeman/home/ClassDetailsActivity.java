package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.bean.ByNowClassBean;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.CourseCatalogueFragment;
import com.pinnoocle.storeman.home.fragment.CourseIntroductionFragment;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.mine.MyClassDetailsActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.WrapContentHeightViewPager;

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
    WrapContentHeightViewPager viewPager;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    private DataRepository dataRepository;
    List<Fragment> fragments = new ArrayList<>();
    ClassDetailBean.DataBean.DetailBean classDetail;

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
                    classDetail = classDetailBean.getData().getDetail();
                    Glide.with(ClassDetailsActivity.this).load(classDetailBean.getData().getDetail().getGoods_image()).into(ivPicture);
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
                        } else {
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

    @OnClick({R.id.iv_back, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                Intent intent = new Intent(this, AcknowledgementOrderActivity.class);
                intent.putExtra("goods_id", classDetail.getGoods_id() + "");
                intent.putExtra("sku_id", classDetail.getGoods_sku().getSpec_sku_id());
                startActivity(intent);
                break;
        }
    }
}