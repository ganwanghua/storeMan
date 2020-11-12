package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.AddressAdapter;
import com.pinnoocle.storeman.bean.AddressBean;
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

public class AddressActivity extends BaseActivity {

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

    @OnClick({R.id.iv_back, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                
                break;
        }
    }
}