package com.pinnoocle.storeman.home.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.ClassListAdapter;
import com.pinnoocle.storeman.adapter.ScanListAdapter;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.bean.ScanBean;
import com.pinnoocle.storeman.home.ClassDetailsActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.weight.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayFragment extends Fragment implements OnRefreshLoadMoreListener, View.OnClickListener {

    private String status;
    private TextView tv_start_time, tv_end_time;
    private ImageView iv_down, iv_down1, iv_search;
    private SmartRefreshLayout refresh;
    private RecyclerView recycleView;
    private int page = 1;
    private DataRepository dataRepository;
    private ScanListAdapter scanListAdapter;
    private List<ScanBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private Calendar selectedDate, selectedDate1;

    public PayFragment(String s) {
        status = s;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pay, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        tv_start_time = v.findViewById(R.id.tv_start_time);
        tv_end_time = v.findViewById(R.id.tv_end_time);
        iv_down = v.findViewById(R.id.iv_down);
        iv_down1 = v.findViewById(R.id.iv_down1);
        iv_search = v.findViewById(R.id.iv_search);
        refresh = v.findViewById(R.id.refresh);
        recycleView = v.findViewById(R.id.recycleView);

        selectedDate = Calendar.getInstance();
        selectedDate1 = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tv_start_time.setText(simpleDateFormat.format(date));
        tv_end_time.setText(simpleDateFormat.format(date));

        iv_down.setOnClickListener(this);
        iv_down1.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        dataRepository = Injection.dataRepository(getContext());
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white1), 15));
        scanListAdapter = new ScanListAdapter(getContext());
        recycleView.setAdapter(scanListAdapter);

        ScanList(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void ScanList(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("paytype", status);
//        map.put("start_time", tv_start_time.getText().toString());
//        map.put("end_time", tv_end_time.getText().toString());
        map.put("page", page + "");
        dataRepository.ScanList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ScanBean scanBean = (ScanBean) data;
                if (scanBean.getCode() == 1) {
                    if (scanBean.getData().getList().getCurrent_page() == scanBean.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(scanBean.getData().getList().getData());
                    scanListAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        ScanList(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        ScanList(page);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_down:
                Calendar startDate = Calendar.getInstance();
                Calendar endDate = Calendar.getInstance();
                //正确设置方式 原因：注意事项有说明
                startDate.set(2000, 0, 1);
                endDate.set(2100, 11, 31);

                new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        selectedDate.setTime(date);
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        tv_start_time.setText(simpleDateFormat1.format(date));
                    }
                })
                        .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                        .isCyclic(false)//是否循环滚动
                        .setSubmitColor(getResources().getColor(R.color.blue))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.grey))//取消按钮文字颜色
                        .setBgColor(0xFFffffff)//滚轮背景颜色 Night mode
                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                        .setRangDate(startDate, endDate)//起始终止年月日设定
                        .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .isDialog(true)//是否显示为对话框样式
                        .build().show();
                break;
            case R.id.iv_down1:
                Calendar startDate1 = Calendar.getInstance();
                Calendar endDate1 = Calendar.getInstance();
                //正确设置方式 原因：注意事项有说明
                startDate1.set(2000, 0, 1);
                endDate1.set(2100, 11, 31);

                new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        selectedDate1.setTime(date);
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        tv_end_time.setText(simpleDateFormat1.format(date));
                    }
                })
                        .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                        .isCyclic(false)//是否循环滚动
                        .setSubmitColor(getResources().getColor(R.color.blue))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.grey))//取消按钮文字颜色
                        .setBgColor(0xFFffffff)//滚轮背景颜色 Night mode
                        .setDate(selectedDate1)// 如果不设置的话，默认是系统时间*/
                        .setRangDate(startDate1, endDate1)//起始终止年月日设定
                        .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .isDialog(true)//是否显示为对话框样式
                        .build().show();
                break;
            case R.id.iv_search:
                if (getTimeCompareSize(tv_start_time.getText().toString(), tv_end_time.getText().toString()) == 1) {
                    ToastUtils.showToast("开始时间不能大于结束时间");
                } else {
                    page = 1;
                    dataBeanList.clear();
                    ScanList(page);
                }
                break;
        }
    }

    public static int getTimeCompareSize(String startTime, String endTime) {
        int i = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//年-月-日 时-分
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(endTime);//结束时间
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime() < date1.getTime()) {
                i = 1;
            } else if (date2.getTime() == date1.getTime()) {
                i = 2;
            } else if (date2.getTime() > date1.getTime()) {
                //正常情况下的逻辑操作.
                i = 3;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return i;
    }
}