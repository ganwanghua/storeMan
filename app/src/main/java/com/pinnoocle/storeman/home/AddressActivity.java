package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.AddressAdapter;
import com.pinnoocle.storeman.bean.AddressBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.CommItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity implements AddressAdapter.OnItemClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    private AddressAdapter addressAdapter;
    private DataRepository dataRepository;
    private List<AddressBean.DataBean.ListBean> dataBeanList = new ArrayList<>();
    private int position;
    private String mark = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white1), 15));
        addressAdapter = new AddressAdapter(this);
        recycleView.setAdapter(addressAdapter);
        addressAdapter.setOnItemClickListener(this);

        lists();
    }

    private void lists() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        dataRepository.lists(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                AddressBean addressBean = (AddressBean) data;
                if (addressBean.getCode() == 1) {
                    for (int i = 0; i < addressBean.getData().getList().size(); i++) {
                        if (addressBean.getData().getDefault_id() == addressBean.getData().getList().get(i).getAddress_id()) {
                            position = i;
                        }
                    }
                    dataBeanList.addAll(addressBean.getData().getList());
                    addressAdapter.setData(dataBeanList, position);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mark.equals("1")){
            setResult(1001);
        }
        finish();
    }

    @OnClick({R.id.iv_back, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if(mark.equals("1")){
                    setResult(1001);
                }
                finish();
                break;
            case R.id.iv_add:
                Intent intent = new Intent(this, AddAddressActivity.class);
                intent.putExtra("mark", "1");
                startActivityForResult(intent, 1001);
                break;
        }
    }

    private void delete(int position) {
        Map<String, String> map = new HashMap<>();
        map.put("address_id", dataBeanList.get(position).getAddress_id() + "");
        map.put("shop_id", FastData.getShopId());
        dataRepository.delete(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast("删除成功");
                    dataBeanList.clear();
                    lists();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 1001) {
            dataBeanList.clear();
            lists();
        } else if (requestCode == 1002 && resultCode == 1002) {
            dataBeanList.clear();
            lists();
        }
    }

    @Override
    public void onItemClick(int position1, View v) {
        switch (v.getId()) {
            case R.id.iv_select:
                mark = "1";
                setDefault(position1);
                break;
            case R.id.ll_edit:
                Intent intent = new Intent(this, AddAddressActivity.class);
                intent.putExtra("mark", "2");
                intent.putExtra("address_id", dataBeanList.get(position1).getAddress_id() + "");
                intent.putExtra("name", dataBeanList.get(position1).getName());
                intent.putExtra("phone", dataBeanList.get(position1).getPhone());
                intent.putExtra("detail", dataBeanList.get(position1).getDetail());
                intent.putExtra("region", dataBeanList.get(position1).getRegion().getProvince() + "," + dataBeanList.get(position1).getRegion().getCity() + "," + dataBeanList.get(position1).getRegion().getRegion());
                startActivityForResult(intent, 1002);
                break;
            case R.id.ll_delete:
                delete(position1);
                break;
            case R.id.ll_address:
                if(position == position1){
                    setResult(1001);
                    finish();
                }else {
                    mark = "2";
                    setDefault(position);
                }
                break;
        }
    }

    private void setDefault(int position) {
        Map<String, String> map = new HashMap<>();
        map.put("address_id", dataBeanList.get(position).getAddress_id() + "");
        map.put("shop_id", FastData.getShopId());
        dataRepository.setDefault(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    if (mark.equals("1")) {
                        ToastUtils.showToast("设置成功");
                        dataBeanList.clear();
                        lists();
                    }else {
                        dataBeanList.clear();
                        lists();
                        setResult(1001);
                        finish();
                    }
                }
            }
        });
    }
}