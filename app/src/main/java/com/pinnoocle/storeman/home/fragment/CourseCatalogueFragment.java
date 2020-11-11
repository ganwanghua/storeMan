package com.pinnoocle.storeman.home.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.CourseCatalogueAdapter;
import com.pinnoocle.storeman.adapter.OrderAdapter;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.home.OrderDetailsActivity;
import com.pinnoocle.storeman.home.VideoActivity;
import com.pinnoocle.storeman.weight.CommItemDecoration;

import java.util.List;

public class CourseCatalogueFragment extends Fragment implements CourseCatalogueAdapter.OnItemClickListener {
    private List<ClassDetailBean.DataBean.VideoListBean> videoList;
    private RecyclerView recycleView;
    private CourseCatalogueAdapter courseCatalogueAdapter;

    public CourseCatalogueFragment(List<ClassDetailBean.DataBean.VideoListBean> videoList) {
        this.videoList = videoList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_catalogue, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        recycleView = v.findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        courseCatalogueAdapter = new CourseCatalogueAdapter(getContext(), videoList);
        recycleView.setAdapter(courseCatalogueAdapter);
        courseCatalogueAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        if (videoList.get(position).getFree() == 1) {
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            intent.putExtra("url", videoList.get(position).getVideo_url());
            startActivity(intent);
        }else {
            ToastUtils.showToast("购买之后才能观看哟");
        }
    }
}