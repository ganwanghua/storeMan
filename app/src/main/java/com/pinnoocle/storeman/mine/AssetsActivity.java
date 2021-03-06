package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.MyMoneyAdapter;
import com.pinnoocle.storeman.bean.MyMoneyBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.ActivityUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssetsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_aliPay_money)
    TextView tvAliPayMoney;
    @BindView(R.id.tv_balancePay_money)
    TextView tvBalancePayMoney;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.ll_balancePay_money)
    LinearLayout llBalancePayMoney;
    private DataRepository dataRepository;
    private MyMoneyAdapter myMoneyAdapter;
    private Calendar selectedDate;
    private List<MyMoneyBean.DataBeanXX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite1();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        selectedDate = Calendar.getInstance();
        dataRepository = Injection.dataRepository(this);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        Date date = new Date(System.currentTimeMillis());
        tvTime.setText(simpleDateFormat.format(date));

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM");
        myMoney(simpleDateFormat1.format(date));

        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myMoneyAdapter = new MyMoneyAdapter(this);
        recycleView.setAdapter(myMoneyAdapter);
    }

    private void myMoney(String time) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<String, String>();
        map.put("shop_id", FastData.getShopId());
        map.put("date", time);
        dataRepository.myMoney(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AssetsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AssetsActivity.this);
                MyMoneyBean myMoneyBean = (MyMoneyBean) data;
                if (myMoneyBean.getCode() == 1) {
                    tvTotalMoney.setText("¥" + myMoneyBean.getData().getData().getOrder_money());
                    tvAliPayMoney.setText("¥" + myMoneyBean.getData().getData().getRefund_money());
                    tvBalancePayMoney.setText("¥" + myMoneyBean.getData().getData().getCommission());

                    dataBeanList.addAll(myMoneyBean.getData().getList().getData());
                    myMoneyAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_time, R.id.ll_balancePay_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_balancePay_money:
                ActivityUtils.startActivity(AssetsActivity.this, CommissionDetailsActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_time:
                Calendar startDate = Calendar.getInstance();
                Calendar endDate = Calendar.getInstance();
                //正确设置方式 原因：注意事项有说明
                startDate.set(2000, 0, 1);
                endDate.set(2100, 11, 31);

                new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
                        tvTime.setText(simpleDateFormat.format(date));
                        selectedDate.setTime(date);
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM");
                        myMoney(simpleDateFormat1.format(date));
                    }
                })
                        .setType(new boolean[]{true, true, false, false, false, false})// 默认全部显示
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
        }
    }
}