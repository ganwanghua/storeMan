package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.PurchaseRecordsAdapter;
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
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

public class PurchaseRecordsActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    private int page = 1;
    private DataRepository dataRepository;
    private PurchaseRecordsAdapter purchaseRecordsAdapter;
    private List<OrderBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_records);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        purchaseRecordsAdapter = new PurchaseRecordsAdapter(this);
        recycleView.setAdapter(purchaseRecordsAdapter);

        order(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    private void order(int page) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("shop_id", FastData.getShopId());
        map.put("page", page + "");
        map.put("status", "all");
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        dataRepository.orderList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(PurchaseRecordsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(PurchaseRecordsActivity.this);
                refresh.finishRefresh();
                OrderBean orderBean = (OrderBean) data;
                if (orderBean.getCode() == 1) {
                    if (orderBean.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        refresh.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        refresh.setVisibility(View.VISIBLE);
                        if (orderBean.getData().getList().getCurrent_page() == orderBean.getData().getList().getLast_page()) {
                            refresh.finishLoadMoreWithNoMoreData();
                        } else {
                            refresh.finishLoadMore();
                        }
                        dataBeanList.addAll(orderBean.getData().getList().getData());
                        purchaseRecordsAdapter.setData(dataBeanList);
                    }
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        order(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        order(page);
    }
}