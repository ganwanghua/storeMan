package com.pinnoocle.storeman.mine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.CourseCatalogueAdapter;
import com.pinnoocle.storeman.adapter.FragmentAdapter;
import com.pinnoocle.storeman.adapter.MyClassDetailsAdapter;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.bean.MyClassDetailsBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.ClassDetailsActivity;
import com.pinnoocle.storeman.home.VideoActivity;
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

public class MyClassDetailsActivity extends BaseActivity implements MyClassDetailsAdapter.OnItemClickListener {

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
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private DataRepository dataRepository;
    private List<MyClassDetailsBean.DataBean.OrderBean.VideoListBean> videoList = new ArrayList<>();
    private MyClassDetailsAdapter myClassDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_class_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        tvTitle.setText(getIntent().getStringExtra("order_name"));

        MyOrderDetail(getIntent().getStringExtra("order_id"));

        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myClassDetailsAdapter = new MyClassDetailsAdapter(this);
        recycleView.setAdapter(myClassDetailsAdapter);
        myClassDetailsAdapter.setOnItemClickListener(this);
    }

    private void MyOrderDetail(String id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/shop/api.user/orderDetail");
        map.put("order_id", id);
        map.put("shop_id", FastData.getShopId());
        dataRepository.MyOrderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(MyClassDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(MyClassDetailsActivity.this);
                MyClassDetailsBean classDetailBean = (MyClassDetailsBean) data;
                if (classDetailBean.getCode() == 1) {
                    Glide.with(MyClassDetailsActivity.this).load(classDetailBean.getData().getOrder().getGoods().get(0).getImage().getFile_path()).into(ivPicture);
                    tvName.setText(classDetailBean.getData().getOrder().getGoods().get(0).getGoods().getGoods_name());
                    tvContent.setText(classDetailBean.getData().getOrder().getGoods().get(0).getGoods().getSelling_point());
                    videoList.addAll(classDetailBean.getData().getOrder().getVideo_list());
                    myClassDetailsAdapter.setData(videoList);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(int position) {
        if (videoList.get(position).getFree() == 1) {
            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra("url", videoList.get(position).getFile().getFile_path());
            startActivity(intent);
        }else {
            ToastUtils.showToast("购买之后才能观看哟");
        }

    }
}