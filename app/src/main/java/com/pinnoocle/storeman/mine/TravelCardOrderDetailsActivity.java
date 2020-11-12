package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.MyClassDetailsBean;
import com.pinnoocle.storeman.bean.OrderDetailBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.OrderDetailsActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TravelCardOrderDetailsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_wallet)
    ImageView ivWallet;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.iv_deliver_goods)
    ImageView ivDeliverGoods;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.iv_receiving_goods)
    ImageView ivReceivingGoods;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.iv_message_fill)
    ImageView ivMessageFill;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_deliver_goods)
    TextView tvDeliverGoods;
    @BindView(R.id.tv_receiving_goods)
    TextView tvReceivingGoods;
    @BindView(R.id.tv_message_fill)
    TextView tvMessageFill;
    @BindView(R.id.tv_hint)
    TextView tvHint;
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
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_all_money)
    TextView tvAllMoney;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.tv_total_merchandise)
    TextView tvTotalMerchandise;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_card_order_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);

        MyOrderDetail();
    }

    private void MyOrderDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/shop/api.user/orderDetail");
        map.put("order_id", getIntent().getStringExtra("order_id"));
        map.put("shop_id", FastData.getShopId());
        dataRepository.MyOrderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(TravelCardOrderDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(TravelCardOrderDetailsActivity.this);
                MyClassDetailsBean orderDetailBean = (MyClassDetailsBean) data;
                if (orderDetailBean.getCode() == 1) {
                    if (orderDetailBean.getData().getOrder().getState_text().equals("已取消")) {
                        llOrderState.setVisibility(View.GONE);
                    } else if (orderDetailBean.getData().getOrder().getState_text().equals("待付款")) {
                        view.setBackgroundResource(R.color.light_blue);
                        view1.setBackgroundResource(R.color.light_blue);
                        view2.setBackgroundResource(R.color.light_blue);
                        ivDeliverGoods.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivDeliverGoods.setImageResource(R.mipmap.deliver_goods_no);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvDeliverGoods.setTextColor(0x99ffffff);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已提交，请在2小时内完成支付~");
                    } else if (orderDetailBean.getData().getOrder().getState_text().equals("已付款，待发货")) {
                        view1.setBackgroundResource(R.color.light_blue);
                        view2.setBackgroundResource(R.color.light_blue);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单正在备货中~");
                    } else if (orderDetailBean.getData().getOrder().getState_text().equals("已发货，待收货")) {
                        view2.setBackgroundResource(R.color.light_blue);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_blue_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已发货，请这注意查收~");
                    } else if (orderDetailBean.getData().getOrder().getState_text().equals("已完成")) {
                        tvHint.setText("您的订单已完成，期待您的好评~");
                    }
//                    tvName.setText(orderDetailBean.getData().getOrder().getUser().getNickName());
//                    if (!TextUtils.isEmpty(orderDetailBean.getData().getOrder().getUser().getPhone()) && orderDetailBean.getData().getDetail().getUser().getPhone().length() > 6) {
//                        StringBuilder sb = new StringBuilder();
//                        for (int i = 0; i < orderDetailBean.getData().getOrder().getUser().getPhone().length(); i++) {
//                            char c = orderDetailBean.getData().getOrder().getUser().getPhone().charAt(i);
//                            if (i >= 3 && i <= 6) {
//                                sb.append('*');
//                            } else {
//                                sb.append(c);
//                            }
//                        }
//                        tvPhone.setText(sb.toString());
//                    }
//                    tvAddress.setText(orderDetailBean.getData().getDetail().getShop().getAddress());
//                    Glide.with(OrderDetailsActivity.this).load(orderDetailBean.getData().getDetail().getGoods().get(0).getImage().getFile_path()).centerCrop().into(ivShop);
//                    tvTitle.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_name());
//
//                    if (orderDetailBean.getData().getDetail().getPoints_exchange_num() > 0) {
//                        if (Double.parseDouble(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money()) > 0) {
//                            tvMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分+¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_money());
//                        } else {
//                            tvMoney.setText(orderDetailBean.getData().getDetail().getGoods().get(0).getExchange_points_num() + "积分");
//                        }
//                    } else {
//                        tvMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getGoods_price());
//                    }
//                    tvNum.setText("x" + orderDetailBean.getData().getDetail().getGoods().get(0).getTotal_num());
//                    tvTime.setText("共" + orderDetailBean.getData().getDetail().getGoods().get(0).getTotal_num() + "件商品，合计:");
//                    tvAllMoney.setText("¥" + orderDetailBean.getData().getDetail().getGoods().get(0).getTotal_price());
//                    tvTotalMoney.setText("¥" + orderDetailBean.getData().getDetail().getTotal_price());
//                    tvDeliveryFee.setText("¥" + orderDetailBean.getData().getDetail().getExpress_price());
//                    tvTotalMerchandise.setText("¥" + orderDetailBean.getData().getDetail().getOrder_price());
//                    tvOrder.setText(orderDetailBean.getData().getDetail().getOrder_no());
//                    tvUpdateTime.setText(orderDetailBean.getData().getDetail().getCreate_time());
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}