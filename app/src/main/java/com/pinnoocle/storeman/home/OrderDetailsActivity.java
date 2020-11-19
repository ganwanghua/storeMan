package com.pinnoocle.storeman.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.OrderDetailsAdapter;
import com.pinnoocle.storeman.bean.OrderDetailBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.pinnoocle.storeman.weight.CommItemDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailsActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_Status)
    ImageView ivStatus;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.ll_order_state)
    LinearLayout llOrderState;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.iv_line)
    ImageView ivLine;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.tv_order_total_money)
    TextView tvOrderTotalMoney;
    @BindView(R.id.tv_current_money)
    TextView tvCurrentMoney;
    @BindView(R.id.tv_pay_mode)
    TextView tvPayMode;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    @BindView(R.id.tv_pay_time)
    TextView tvPayTime;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.rl_current_money)
    RelativeLayout rlCurrentMoney;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.rl_pay_mode)
    RelativeLayout rlPayMode;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.ll_pay_time)
    LinearLayout llPayTime;
    private DataRepository dataRepository;
    private OrderDetailsAdapter orderDetailsAdapter;
    private List<OrderDetailBean.DataBean.DetailBean.GoodsBean> dataBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white), 15));
        orderDetailsAdapter = new OrderDetailsAdapter(this);
        recyclerView.setAdapter(orderDetailsAdapter);

        orderDetail();
    }

    private void orderDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<String, String>();
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("order_id", getIntent().getStringExtra("order_id"));
        dataRepository.orderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(OrderDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(OrderDetailsActivity.this);
                OrderDetailBean orderDetailBean = (OrderDetailBean) data;
                if (orderDetailBean.getCode() == 1) {
                    if (orderDetailBean.getData().getDetail().getState_text().equals("已取消")) {
                        ivStatus.setImageResource(R.mipmap.deliver);
                        tvStatus.setText("已取消");
                        view1.setVisibility(View.GONE);
                        view2.setVisibility(View.GONE);
                        view3.setVisibility(View.GONE);
                        rlCurrentMoney.setVisibility(View.GONE);
                        rlPayMode.setVisibility(View.GONE);
                        llPayTime.setVisibility(View.GONE);
                    } else if (orderDetailBean.getData().getDetail().getState_text().equals("待付款")) {
                        ivStatus.setImageResource(R.mipmap.deliver);
                        tvStatus.setText("待付款");
                    } else if (orderDetailBean.getData().getDetail().getState_text().equals("已付款，待发货")) {
                        ivStatus.setImageResource(R.mipmap.deliver);
                        tvStatus.setText("已付款，待发货");
                    } else if (orderDetailBean.getData().getDetail().getState_text().equals("已发货，待收货")) {
                        ivStatus.setImageResource(R.mipmap.deliver);
                        tvStatus.setText("已发货，待收货");
                    } else if (orderDetailBean.getData().getDetail().getState_text().equals("已完成")) {
                        ivStatus.setImageResource(R.mipmap.check);
                        tvStatus.setText("已完成");
                    }
                    tvOrderNum.setText("订单编号：" + orderDetailBean.getData().getDetail().getOrder_no());
                    tvName.setText(orderDetailBean.getData().getDetail().getUser().getNickName());
                    if (!TextUtils.isEmpty(orderDetailBean.getData().getDetail().getUser().getPhone()) && orderDetailBean.getData().getDetail().getUser().getPhone().length() > 6) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < orderDetailBean.getData().getDetail().getUser().getPhone().length(); i++) {
                            char c = orderDetailBean.getData().getDetail().getUser().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tvPhone.setText(sb.toString());
                    }
                    tvAddress.setText(orderDetailBean.getData().getDetail().getShop().getAddress());

                    dataBeanList.addAll(orderDetailBean.getData().getDetail().getGoods());
                    orderDetailsAdapter.setData(dataBeanList, orderDetailBean.getData().getDetail().getPoints_exchange_num());

                    if (orderDetailBean.getData().getDetail().getPoints_exchange_num() > 0) {
                        if (Double.parseDouble(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money()) > 0) {
                            tvMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分+¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money());
                            tvTotalMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分+¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money());
                            tvOrderTotalMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分+¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money());
                            tvCurrentMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分+¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money());
                        } else {
                            tvMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分");
                            tvTotalMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分");
                            tvOrderTotalMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分");
                            tvCurrentMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分");
                        }
                    } else {
                        tvMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_price());
                        tvTotalMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_price());
                        tvOrderTotalMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_price());
                        tvCurrentMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_price());
                    }

                    tvNum.setText("共" + orderDetailBean.getData().getDetail().getGoods().get(0).getTotal_num() + "件商品，合计：");
                    tvDeliveryFee.setText(orderDetailBean.getData().getDetail().getExpress_price());
                    tvCoupon.setText("-" + orderDetailBean.getData().getDetail().getCoupon_money());
                    tvPayMode.setText(orderDetailBean.getData().getDetail().getDelivery_type().getText());
                    tvUpdateTime.setText(orderDetailBean.getData().getDetail().getCreate_time());
                    tvPayTime.setText(getDateToString((long) orderDetailBean.getData().getDetail().getPay_time() * 1000, "yyyy-MM-dd HH:mm:ss"));
                }
            }
        });
    }

    public static String getDateToString(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}