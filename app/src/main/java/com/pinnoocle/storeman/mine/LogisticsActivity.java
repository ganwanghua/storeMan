package com.pinnoocle.storeman.mine;

import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.TraceListAdapter;
import com.pinnoocle.storeman.bean.MyClassBean;
import com.pinnoocle.storeman.bean.TraceBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogisticsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_logistics)
    TextView tvLogistics;
    @BindView(R.id.lvTrace)
    ListView lvTrace;
    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);
        ButterKnife.bind(this);

        dataRepository = Injection.dataRepository(this);
        adapter = new TraceListAdapter(this);
        lvTrace.setAdapter(adapter);
        express();
    }

    private void express() {
        Map<String, String> map = new HashMap<>();
        map.put("shop_id", FastData.getShopId());
        map.put("order_id", getIntent().getStringExtra("order_id"));
//        map.put("shop_id", "10040");
//        map.put("order_id", "14571");
        dataRepository.express(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                TraceBean traceBean = (TraceBean) data;
                if (traceBean.getCode() == 0) {
                    adapter.setData(traceBean.getData().getExpress().getList());
                    Glide.with(LogisticsActivity.this).load(getIntent().getStringExtra("image")).centerCrop().into(ivPicture);
                    tvStatus.setText(traceBean.getData().getExpress().getList().get(0).getStatus());
                    tvLogistics.setText(traceBean.getData().getExpress().getExpress_name() + ": " + traceBean.getData().getExpress().getExpress_no());
                }
            }
        });
    }
}