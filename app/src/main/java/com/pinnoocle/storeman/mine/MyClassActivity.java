package com.pinnoocle.storeman.mine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.ClassListAdapter;
import com.pinnoocle.storeman.adapter.MyClassAdapter;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.bean.MyClassBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.OrderDetailsActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.CommItemDecoration;
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

public class MyClassActivity extends BaseActivity implements OnRefreshLoadMoreListener, MyClassAdapter.OnItemClickListener {

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
    private MyClassAdapter myClassAdapter;
    private List<MyClassBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_class);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myClassAdapter = new MyClassAdapter(this);
        recycleView.setAdapter(myClassAdapter);
        myClassAdapter.setOnItemClickListener(this);

        order(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void order(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("order_type", "3");
        map.put("dataType", "all");
        map.put("page", page + "");
        dataRepository.order(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                MyClassBean myClassBean = (MyClassBean) data;
                if (myClassBean.getCode() == 1) {
                    if (myClassBean.getData().getList().getCurrent_page() == myClassBean.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(myClassBean.getData().getList().getData());
                    myClassAdapter.setData(dataBeanList);
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, MyClassDetailsActivity.class);
        intent.putExtra("order_name", dataBeanList.get(position).getGoods().get(0).getGoods_name());
        intent.putExtra("order_id", dataBeanList.get(position).getOrder_id() + "");
        startActivity(intent);
    }
}