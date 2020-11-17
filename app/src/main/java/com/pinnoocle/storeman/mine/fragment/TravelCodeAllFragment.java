package com.pinnoocle.storeman.mine.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipay.sdk.app.PayTask;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.dialog.select.CustomSelectDialog;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.OrderAdapter;
import com.pinnoocle.storeman.adapter.TravelCodeOrderAdapter;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.MyClassBean;
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.bean.PayResult;
import com.pinnoocle.storeman.home.ClassDetailsActivity;
import com.pinnoocle.storeman.home.OrderDetailsActivity;
import com.pinnoocle.storeman.home.PaySuccessActivity;
import com.pinnoocle.storeman.mine.LogisticsActivity;
import com.pinnoocle.storeman.mine.TravelCardOrderDetailsActivity;
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

public class TravelCodeAllFragment extends Fragment implements TravelCodeOrderAdapter.OnItemClickListener, OnRefreshLoadMoreListener {
    RecyclerView recycleView;
    private DataRepository dataRepository;
    SmartRefreshLayout refresh;
    private int page = 1;
    private TextView tv_empty;
    private String all;
    private TravelCodeOrderAdapter orderAdapter;
    private List<MyClassBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    public TravelCodeAllFragment(String all) {
        this.all = all;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel_code_all, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        recycleView = v.findViewById(R.id.recycleView);
        refresh = v.findViewById(R.id.refresh);
        tv_empty = v.findViewById(R.id.tv_empty);
        dataRepository = Injection.dataRepository(getContext());
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white1), 15));
        orderAdapter = new TravelCodeOrderAdapter(getContext());
        recycleView.setAdapter(orderAdapter);
        orderAdapter.setOnItemClickListener(this);

        order(page);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    private void order(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("order_type", "1");
        map.put("dataType", all);
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
                MyClassBean orderBean = (MyClassBean) data;
                if (orderBean.getCode() == 1) {
                    if (orderBean.getData().getList().getData().size() == 0) {
                        tv_empty.setVisibility(View.VISIBLE);
                        refresh.setVisibility(View.GONE);
                    } else {
                        tv_empty.setVisibility(View.GONE);
                        refresh.setVisibility(View.VISIBLE);
                        if (orderBean.getData().getList().getCurrent_page() == orderBean.getData().getList().getLast_page()) {
                            refresh.finishLoadMoreWithNoMoreData();
                        } else {
                            refresh.finishLoadMore();
                        }
                        dataBeanList.addAll(orderBean.getData().getList().getData());
                        orderAdapter.setData(dataBeanList);
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

    @Override
    public void onItemClick(int position, View v) {
        switch (v.getId()) {
            case R.id.ll_order:
                Intent intent = new Intent(getActivity(), TravelCardOrderDetailsActivity.class);
                intent.putExtra("order_id", dataBeanList.get(position).getOrder_id() + "");
                startActivity(intent);
                break;
            case R.id.tv_pay:
//                showCustomDialog(position);
                buyPay(position);
                break;
            case R.id.tv_logistics:
                Intent intent1 = new Intent(getActivity(), LogisticsActivity.class);
                intent1.putExtra("order_id", dataBeanList.get(position).getOrder_id() + "");
                intent1.putExtra("image", dataBeanList.get(position).getGoods().get(0).getImage().getFile_path());
                startActivity(intent1);
                break;
        }
    }

    private void showCustomDialog(int position) {
        final List<String> names = new ArrayList<>();
        names.add("微信");
        names.add("支付宝");
        names.add("余额");
        showDialog(new CustomSelectDialog.SelectDialogListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0) {

                } else if (position == 1) {
                    buyPay(position);
                } else {

                }
            }
        }, names);
    }

    private CustomSelectDialog showDialog(CustomSelectDialog.SelectDialogListener listener,
                                          List<String> names) {
        CustomSelectDialog dialog = new CustomSelectDialog(getActivity(),
                R.style.transparentFrameWindowStyle, listener, names);
        dialog.setItemColor(R.color.grey, R.color.blue);
        //判断activity是否finish
        if (!getActivity().isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    private void buyPay(int position) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("order_id", dataBeanList.get(position).getOrder_id() + "");
        map.put("pay_type", "30");
        dataRepository.pay(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getActivity());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getActivity());
                AliPayBean aliPayBean = (AliPayBean) data;
                if (aliPayBean.getCode() == 1) {
                    alipay(aliPayBean.getData().getPayment());
                }
            }
        });
    }

    private void alipay(String payment) {
        final Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(getActivity());
                Map<String, String> result = alipay.payV2(payment, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showToast("支付成功");
                        Intent intent = new Intent(getActivity(), PaySuccessActivity.class);
                        intent.putExtra("pos", "2");
                        startActivity(intent);
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            ToastUtils.showToast("支付结果确认中");
                        } else if (TextUtils.equals(resultStatus, "6001")) { //用户中途取消
                            ToastUtils.showToast("取消支付");
                        } else {
                            // 其他值就可以判断为支付失败
                            ToastUtils.showToast("支付失败");
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };
}