package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.ClassListAdapter;
import com.pinnoocle.storeman.adapter.TravelCardAdapter;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TravelCardActivity extends BaseActivity implements TravelCardAdapter.OnItemClickListener, OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private int page = 1;
    private DataRepository dataRepository;
    private TravelCardAdapter travelCardAdapter;
    private List<ClassListBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_card);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        travelCardAdapter = new TravelCardAdapter(this);
        recycleView.setAdapter(travelCardAdapter);
        travelCardAdapter.setOnItemClickListener(this);

        classList(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    private void classList(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("type", "1");
        map.put("page", page + "");
        dataRepository.classList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ClassListBean classListBean = (ClassListBean) data;
                if (classListBean.getCode() == 1) {
                    if (classListBean.getData().getList().getCurrent_page() == classListBean.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(classListBean.getData().getList().getData());
                    travelCardAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        classList(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        classList(page);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, TravelCardDetailsActivity.class);
        intent.putExtra("goods_id", dataBeanList.get(position).getGoods_id() + "");
        intent.putExtra("goods_name", dataBeanList.get(position).getGoods_name());
        startActivity(intent);
    }
}