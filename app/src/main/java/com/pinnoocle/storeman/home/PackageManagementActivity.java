package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.PackageManagementAdapter;
import com.pinnoocle.storeman.bean.PackageManagerBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.CommItemDecoration;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PackageManagementActivity extends BaseActivity implements PackageManagementAdapter.OnItemClickListener {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private PackageManagementAdapter packageManagementAdapter;
    private DataRepository dataRepository;
    private List<PackageManagerBean.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private TDialog tDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_management);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white1), 15));
        packageManagementAdapter = new PackageManagementAdapter(this);
        recycleView.setAdapter(packageManagementAdapter);
        packageManagementAdapter.setOnItemClickListener(this);

        goodsList();
    }

    private void goodsList() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/shop/api.goods/goodsList");
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("type", "2");
        map.put("shop_id", FastData.getShopId());
        dataRepository.goodsList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(PackageManagementActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(PackageManagementActivity.this);
                PackageManagerBean packageManagerBean = (PackageManagerBean) data;
                if (packageManagerBean.getCode() == 1) {
                    tvNum.setText("共" + packageManagerBean.getData().getList().getTotal() + "个套餐商品");
                    dataBeanList.addAll(packageManagerBean.getData().getList().getData());
                    packageManagementAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onItemClick(int position, View v) {
        switch (v.getId()) {
            case R.id.tv_state:
                if (dataBeanList.get(position).getGoods_status().getValue() == 10) {
                    showStatus(position, "下架", "20");
                } else {
                    showStatus(position, "上架", "10");
                }
                break;
            case R.id.tv_purchase:
                Intent intent = new Intent(PackageManagementActivity.this, PurchaseRecordsActivity.class);
                intent.putExtra("goods_id", dataBeanList.get(position).getGoods_id()+"");
                startActivity(intent);
                break;
        }
    }

//    @Override
//    public void onItemClicks(int position, boolean v) {
//        if(v){
//            goodsStatus("10", dataBeanList.get(position).getGoods_id());
//        }else {
//            goodsStatus("20", dataBeanList.get(position).getGoods_id());
//        }
//    }

    private void showStatus(int pos, String status, String value) {
        tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_status)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure, R.id.tv_content)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("当前商品为" + dataBeanList.get(pos).getGoods_status().getText() + "状态,确定" + status + "?");
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                goodsStatus(value, dataBeanList.get(pos).getGoods_id());
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void goodsStatus(String value, int id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("status", value);
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("shop_id", FastData.getShopId());
        map.put("goods_id", id + "");
        dataRepository.goodsStatus(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.show(PackageManagementActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.show(PackageManagementActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast("修改成功");
                    dataBeanList.clear();
                    goodsList();
                } else {
                    ToastUtils.showToast("修改失败");
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}