package com.pinnoocle.storeman.home.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.ClassAdapter;
import com.pinnoocle.storeman.adapter.TravelAdapter;
import com.pinnoocle.storeman.bean.HomeModel;
import com.pinnoocle.storeman.home.ClassActivity;
import com.pinnoocle.storeman.home.ClassDetailsActivity;
import com.pinnoocle.storeman.home.CollectionCodeActivity;
import com.pinnoocle.storeman.home.OrderActivity;
import com.pinnoocle.storeman.home.PackageManagementActivity;
import com.pinnoocle.storeman.home.TravelCardActivity;
import com.pinnoocle.storeman.home.TravelCardDetailsActivity;
import com.pinnoocle.storeman.home.UserManagementActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment implements OnRefreshListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private GridView gridView;
    private int[] icon = {R.mipmap.package_management, R.mipmap.user_management, R.mipmap.order_management, R.mipmap.qr_code};
    private String[] iconName = {"套餐管理", "用户管理", "订单管理", "收款码"};
    private SimpleAdapter sim_adapter;
    private ArrayList<Map<String, Object>> data_list;
    private DataRepository dataRepository;
    private TextView tv_store_name, tv_total_money, tv_wxPay_money, tv_aliPay_money, tv_balancePay_money, tv_pay_num, tv_indent_num, tv_indfh_num, tv_zt_num;
    private SmartRefreshLayout refreshLayout;
    private PowerSpinnerView powerSpinnerView;
    private int position;
    private RecyclerView recyclerView, recyclerView1;
    private ClassAdapter classAdapter;
    private TravelAdapter travelAdapter;
    private List<HomeModel.DataBean.ClassBean> dataBeanList = new ArrayList<>();
    private List<HomeModel.DataBean.TravelBean> travelBeans = new ArrayList<>();
    private LinearLayout ll_class_more, ll_travel_card_more;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        dataRepository = Injection.dataRepository(getContext());
        gridView = v.findViewById(R.id.gridView);
        tv_store_name = v.findViewById(R.id.tv_store_name);
        tv_total_money = v.findViewById(R.id.tv_total_money);
        tv_wxPay_money = v.findViewById(R.id.tv_wxPay_money);
        tv_aliPay_money = v.findViewById(R.id.tv_aliPay_money);
        tv_balancePay_money = v.findViewById(R.id.tv_balancePay_money);
        tv_pay_num = v.findViewById(R.id.tv_pay_num);
        tv_indent_num = v.findViewById(R.id.tv_indent_num);
        tv_indfh_num = v.findViewById(R.id.tv_indfh_num);
        tv_zt_num = v.findViewById(R.id.tv_zt_num);
        refreshLayout = v.findViewById(R.id.refresh);
        powerSpinnerView = v.findViewById(R.id.popSpinner);
        recyclerView = v.findViewById(R.id.recycleView);
        recyclerView1 = v.findViewById(R.id.recycleView1);
        ll_class_more = v.findViewById(R.id.ll_class_more);
        ll_travel_card_more = v.findViewById(R.id.ll_travel_card_more);

        ll_class_more.setOnClickListener(this);
        ll_travel_card_more.setOnClickListener(this);
        tv_store_name.setText(FastData.getStoreName());
        grid();
        home("day");
        refreshLayout.setOnRefreshListener(this);
        gridView.setOnItemClickListener(this);
        powerSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                position = i;
                dataBeanList.clear();
                travelBeans.clear();
                if (i == 0) {
                    home("day");
                } else if (i == 1) {
                    home("week");
                } else if (i == 2) {
                    home("month");
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        classAdapter = new ClassAdapter(getContext());
        recyclerView.setAdapter(classAdapter);
        classAdapter.setOnItemClickListener(new ClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ClassDetailsActivity.class);
                intent.putExtra("goods_id", dataBeanList.get(position).getGoods_id() + "");
                intent.putExtra("goods_name", dataBeanList.get(position).getGoods_name());
                startActivity(intent);
            }
        });

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        travelAdapter = new TravelAdapter(getContext());
        recyclerView1.setAdapter(travelAdapter);
        travelAdapter.setOnItemClickListener(new TravelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), TravelCardDetailsActivity.class);
                intent.putExtra("goods_id", travelBeans.get(position).getGoods_id() + "");
                intent.putExtra("goods_name", travelBeans.get(position).getGoods_name());
                startActivity(intent);
            }
        });
    }

    private void home(String achievement) {
        ViewLoading.show(getActivity());
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("type", achievement);
        dataRepository.indexNew(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refreshLayout.finishRefresh();
                ViewLoading.dismiss(getActivity());
            }

            @Override
            public void onSuccess(Object data) {
                refreshLayout.finishRefresh();
                ViewLoading.dismiss(getActivity());
                HomeModel homeModel = (HomeModel) data;
                if (homeModel.getCode() == 1) {
                    HomeModel.DataBean datalist = homeModel.getData();
                    HomeModel.DataBean.ListBean defaultdataList = datalist.getList();
                    if (defaultdataList != null) {
                        tv_total_money.setText(defaultdataList.getToday_total() + "");
                        tv_wxPay_money.setText(defaultdataList.getTotal_wechat() + "");
                        tv_aliPay_money.setText(defaultdataList.getTotal_alipay() + "");
                        tv_balancePay_money.setText(defaultdataList.getTotal_all() + "");
                        tv_pay_num.setText(defaultdataList.getScan_order_num() + "");
                        tv_indent_num.setText(defaultdataList.getPay_order_num() + "");
                        tv_indfh_num.setText(defaultdataList.getDf_order_num() + "");
                        tv_zt_num.setText(defaultdataList.getDt_order_num() + "");
                    }

                    dataBeanList.addAll(homeModel.getData().getClassX());
                    classAdapter.setData(dataBeanList);

                    travelBeans.addAll(homeModel.getData().getTravel());
                    travelAdapter.setData(travelBeans);
                }
            }
        });
    }

    private void grid() {
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.item, from, to);
        //配置适配器
        gridView.setAdapter(sim_adapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        dataBeanList.clear();
        travelBeans.clear();
        if (position == 0) {
            home("day");
        } else if (position == 1) {
            home("week");
        } else if (position == 2) {
            home("month");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            ActivityUtils.startActivity(getActivity(), PackageManagementActivity.class);
        } else if (position == 1) {
            ActivityUtils.startActivity(getActivity(), UserManagementActivity.class);
        } else if (position == 2) {
            ActivityUtils.startActivity(getActivity(), OrderActivity.class);
        } else if (position == 3) {
            ActivityUtils.startActivity(getActivity(), CollectionCodeActivity.class);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_class_more:
                ActivityUtils.startActivity(getActivity(), ClassActivity.class);
                break;

            case R.id.ll_travel_card_more:
                ActivityUtils.startActivity(getActivity(), TravelCardActivity.class);
                break;
        }
    }
}