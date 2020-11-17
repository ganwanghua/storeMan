package com.pinnoocle.storeman.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TravelCardDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_concessional_rate)
    TextView tvConcessionalRate;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    private DataRepository dataRepository;
    ClassDetailBean.DataBean.DetailBean classDetail;
    private TextView et_shop_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        struct();
        setContentView(R.layout.activity_travel_card_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        dataRepository = Injection.dataRepository(this);
        tvTitle.setText(getIntent().getStringExtra("goods_name"));

        classDetail(getIntent().getStringExtra("goods_id"));
    }

    public static void struct() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork() // or
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects() // 探测SQLite数据库操作
                .penaltyLog() // 打印logcat
                .penaltyDeath().build());
    }

    private void classDetail(String id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("goods_id", id);
        map.put("shop_id", FastData.getShopId());
        dataRepository.classDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(TravelCardDetailsActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(TravelCardDetailsActivity.this);
                ClassDetailBean classDetailBean = (ClassDetailBean) data;
                if (classDetailBean.getCode() == 1) {
                    classDetail = classDetailBean.getData().getDetail();
                    Glide.with(TravelCardDetailsActivity.this).load(classDetailBean.getData().getDetail().getGoods_image()).into(ivPicture);
                    tvMoney.setText(classDetailBean.getData().getDetail().getGoods_sku().getGoods_price());
                    tvConcessionalRate.setText("价值:" + classDetailBean.getData().getDetail().getGoods_sku().getLine_price() + "元充值卡");
                    tvNum.setText("还剩" + classDetailBean.getData().getDetail().getGoods_stock() + "份");
                    tvName.setText(classDetailBean.getData().getDetail().getGoods_name());
                    tvContent.setText(Html.fromHtml(classDetailBean.getData().getDetail().getContent(), imgGetter, null));
                }
            }
        });
    }

    Html.ImageGetter imgGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            Log.i("RG", "source---?>>>" + source);
            Drawable drawable = null;
            URL url;
            try {
                url = new URL(source);
                Log.i("RG", "url---?>>>" + url);
                drawable = Drawable.createFromStream(url.openStream(), ""); // 获取网路图片
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            Log.i("RG", "url---?>>>" + url);
            return drawable;
        }
    };

    @OnClick({R.id.iv_back, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                SelectNum();
                break;
        }
    }

    private void SelectNum() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_num_select)
                .setScreenWidthAspect(TravelCardDetailsActivity.this, 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.ic_close, R.id.tv_sure, R.id.rl_shop_delete, R.id.rl_shop_insert, R.id.et_shop_num)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        ImageView iv_shop = viewHolder.itemView.findViewById(R.id.iv_shop);
                        TextView tv_title = viewHolder.itemView.findViewById(R.id.tv_title);
                        TextView tv_money = viewHolder.itemView.findViewById(R.id.tv_money);
                        TextView tv_stork = viewHolder.itemView.findViewById(R.id.tv_stork);
                        et_shop_num = viewHolder.itemView.findViewById(R.id.et_shop_num);
                        Glide.with(TravelCardDetailsActivity.this).load(classDetail.getGoods_image()).into(iv_shop);
                        tv_title.setText(classDetail.getGoods_name());
                        tv_money.setText("¥" + classDetail.getGoods_sku().getGoods_price());
                        tv_stork.setText("库存：" + classDetail.getGoods_sku().getStock_num());
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.ic_close:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                if (Integer.parseInt(et_shop_num.getText().toString()) > classDetail.getGoods_sku().getStock_num()) {
                                    ToastUtils.showToast("您购买的数量超出库存总数！");
                                } else {
                                    Intent intent = new Intent(TravelCardDetailsActivity.this, AcknowledgementOrderActivity.class);
                                    intent.putExtra("goods_id", classDetail.getGoods_id() + "");
                                    intent.putExtra("sku_id", classDetail.getGoods_sku().getSpec_sku_id());
                                    intent.putExtra("num", et_shop_num.getText().toString());
                                    startActivity(intent);
                                }
                                tDialog.dismiss();
                                break;
                            case R.id.rl_shop_delete:
                                int s = Integer.parseInt(et_shop_num.getText().toString());
                                if (s <= 1) {

                                } else {
                                    s = s - 1;
                                    et_shop_num.setText(s + "");
                                }
                                break;
                            case R.id.rl_shop_insert:
                                int s1 = Integer.parseInt(et_shop_num.getText().toString());
                                s1 = s1 + 1;
                                et_shop_num.setText(s1 + "");
                                break;
                        }
                    }
                })
                .create()
                .show();
    }
}