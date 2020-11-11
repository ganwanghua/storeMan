package com.pinnoocle.storeman.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.ClassListAdapter;
import com.pinnoocle.storeman.adapter.OrderAdapter;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.home.ClassDetailsActivity;
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

public class ClassFragment extends Fragment implements OnRefreshLoadMoreListener, ClassListAdapter.OnItemClickListener {
    private int category_id;
    RecyclerView recycleView;
    private DataRepository dataRepository;
    SmartRefreshLayout refresh;
    private int page = 1;
    private ClassListAdapter classListAdapter;
    private List<ClassListBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    public ClassFragment(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        recycleView = v.findViewById(R.id.recycleView);
        refresh = v.findViewById(R.id.refresh);
        dataRepository = Injection.dataRepository(getContext());
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        classListAdapter = new ClassListAdapter(getContext());
        recycleView.setAdapter(classListAdapter);
        classListAdapter.setOnItemClickListener(this);

        classList(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void classList(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("category_id", category_id + "");
        map.put("type", "3");
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
                    classListAdapter.setData(dataBeanList);
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
        Intent intent = new Intent(getActivity(), ClassDetailsActivity.class);
        intent.putExtra("goods_id", dataBeanList.get(position).getGoods_id() + "");
        intent.putExtra("goods_name", dataBeanList.get(position).getGoods_name());
        startActivity(intent);
    }
}