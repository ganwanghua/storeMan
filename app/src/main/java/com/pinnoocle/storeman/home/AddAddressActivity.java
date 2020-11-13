package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.AddressPicker;

public class AddAddressActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.ed_area)
    TextView edArea;
    @BindView(R.id.ed_address)
    EditText edAddress;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private DataRepository dataRepository;
    private String provinces = "北京市", citys = "北京市", countys = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        if (getIntent().getStringExtra("mark").equals("2")) {
            tvTitle.setText("修改收货地址");
            edName.setText(getIntent().getStringExtra("name"));
            edPhone.setText(getIntent().getStringExtra("phone"));
            edAddress.setText(getIntent().getStringExtra("detail"));
            edArea.setText(getIntent().getStringExtra("region").replaceAll(",", ""));
        } else {
            tvTitle.setText("新建收货地址");
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right:
                setWorkArea();
                break;
            case R.id.tv_sure:
                if (edName.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入收货人姓名");
                } else if (edPhone.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入收货人联系电话");
                } else if (edArea.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请选择省市区");
                } else if (edAddress.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入街道小区楼层");
                } else {
                    String telRegex = "[1][3456789]\\d{9}";
                    boolean matches = edPhone.getText().toString().matches(telRegex);
                    if (matches == false) {
                        ToastUtils.showToast("手机号码格式不正确");
                    } else {
                        if (getIntent().getStringExtra("mark").equals("2")) {
                            edit();
                        } else {
                            add();
                        }
                    }
                }
                break;
        }
    }

    private void edit() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("address_id", getIntent().getStringExtra("address_id"));
        map.put("name", edName.getText().toString());
        map.put("phone", edPhone.getText().toString());
        map.put("region", provinces + "," + citys + "," + countys);
        map.put("detail", edAddress.getText().toString());
        map.put("shop_id", FastData.getShopId());
        dataRepository.edit(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddAddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddAddressActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast("修改成功");
                    setResult(1002);
                    finish();
                }
            }
        });
    }

    private void add() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("name", edName.getText().toString());
        map.put("phone", edPhone.getText().toString());
        map.put("region", provinces + "," + citys + "," + countys);
        map.put("detail", edAddress.getText().toString());
        map.put("shop_id", FastData.getShopId());
        dataRepository.add(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddAddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddAddressActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast("添加成功");
                    setResult(1001);
                    finish();
                }
            }
        });
    }

    private void setWorkArea() {
        AddressPicker picker1 = new AddressPicker(this, getArea());
        picker1.setHideProvince(false);
        picker1.setHideCounty(false);
        picker1.setSubmitTextColor(0xff374459);
        picker1.setCancelTextColor(0xff979DA8);
        picker1.setTextColor(0xff374459);
        picker1.setDividerColor(0xffE6EAF0);
        picker1.setTopLineColor(0xffE6EAF0);
        picker1.setCancelable(false);
        picker1.setCanceledOnTouchOutside(false);
        picker1.setCycleDisable(true);
        picker1.setColumnWeight(2 / 8.0f, 3 / 8.0f, 3 / 8.0f);//省级、地级和县级的比例为2:3:3

        picker1.setSelectedItem(provinces, citys, countys);
        picker1.setOnAddressPickListener(new AddressPicker.OnAddressPickListener() {
            @Override
            public void onAddressPicked(Province province, City city, County county) {
                provinces = province.getAreaName();
                citys = city.getAreaName();
                countys = county.getAreaName();
                edArea.setText(provinces + citys + countys);
                if (county.getAreaName().equals("")) {
                    citys = province.getAreaName();
                    countys = city.getAreaName();
                } else {
                    citys = city.getAreaName();
                    countys = county.getAreaName();
                }
            }
        });
        picker1.show();
    }

    private ArrayList<Province> getArea() {
        ArrayList<Province> data = new ArrayList<>();
        String json = Util.getTextFromAssets(this, "city.json");
        data.addAll(JSON.parseArray(json, Province.class));
        return data;
    }
}