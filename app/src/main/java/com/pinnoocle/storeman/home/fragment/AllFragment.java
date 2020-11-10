package com.pinnoocle.storeman.home.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.OrderAdapter;
import com.pinnoocle.storeman.adapter.UserManagementAdapter;
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.bean.UserManagerBean;
import com.pinnoocle.storeman.home.OrderDetailsActivity;
import com.pinnoocle.storeman.home.PackageManagementActivity;
import com.pinnoocle.storeman.home.PurchaseRecordsActivity;
import com.pinnoocle.storeman.home.UserManagementActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.weight.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllFragment extends Fragment implements OnRefreshLoadMoreListener, OrderAdapter.OnItemClickListener {
    RecyclerView recycleView;
    private DataRepository dataRepository;
    SmartRefreshLayout refresh;
    private int page = 1;
    private OrderAdapter orderAdapter;
    private List<OrderBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        recycleView = v.findViewById(R.id.recycleView);
        refresh = v.findViewById(R.id.refresh);
        dataRepository = Injection.dataRepository(getContext());
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white1), 15));
        orderAdapter = new OrderAdapter(getContext());
        recycleView.setAdapter(orderAdapter);
        orderAdapter.setOnItemClickListener(this);

        order(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void order(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("shop_id", FastData.getShopId());
        map.put("page", page + "");
        map.put("status", "all");
        dataRepository.orderList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                OrderBean orderBean = (OrderBean) data;
                if (orderBean.getCode() == 1) {
                    if (orderBean.getData().getList().getCurrent_page() == orderBean.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(orderBean.getData().getList().getData());
                    orderAdapter.setData(dataBeanList);
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

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
        intent.putExtra("order_id", dataBeanList.get(position).getOrder_id() + "");
        startActivity(intent);
    }
}