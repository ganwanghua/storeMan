package com.pinnoocle.storeman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.adapter.FragmentTabAdapter;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.common.AppManager;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.home.fragment.HomeFragment;
import com.pinnoocle.storeman.login.LoginActivity;
import com.pinnoocle.storeman.mine.fragment.MyFragment;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.titan.versionupdata.VersionUpdata;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.pinnoocle.storeman.common.Constant.REQUEST_CODE_SCAN;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    @BindView(R.id.iv_tab_one)
    ImageView ivTabOne;
    @BindView(R.id.tv_tab_one)
    TextView tvTabOne;
    @BindView(R.id.ll_tab_one)
    LinearLayout llTabOne;
    @BindView(R.id.iv_tab_two)
    ImageView ivTabTwo;
    @BindView(R.id.tv_tab_two)
    TextView tvTabTwo;
    @BindView(R.id.ll_tab_two)
    LinearLayout llTabTwo;
    @BindView(R.id.iv_tab_three)
    ImageView ivTabThree;
    @BindView(R.id.tv_tab_three)
    TextView tvTabThree;
    @BindView(R.id.ll_tab_three)
    LinearLayout llTabThree;
    @BindView(R.id.lin)
    LinearLayout lin;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentTabAdapter tabAdapter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initBlue1();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        AppManager.getInstance().addActivity(this);
        dataRepository = Injection.dataRepository(this);
        fragments.add(new HomeFragment());
        fragments.add(new MyFragment());
        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fl_layout);
        initListener();
        versionCheck();
    }

    private void versionCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = getResources().getString(R.string.versionurl);
                new VersionUpdata(MainActivity.this).checkVersion(url);
            }
        }).start();
    }

    @OnClick({R.id.ll_tab_one, R.id.ll_tab_two, R.id.ll_tab_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_one:
                tabAdapter.setCurrentFragment(0);
                initBlue1();
                StatusBarUtil.StatusBarLightMode(this);
                break;
            case R.id.ll_tab_two:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                /*ZxingConfig 是配置类
                 *可以设置是否显示底部布局，闪光灯，相册，
                 * 是否播放提示音  震动
                 * 设置扫描框颜色等
                 * 也可以不传这个参数
                 * */
                ZxingConfig config = new ZxingConfig();
                config.setPlayBeep(true);//是否播放扫描声音 默认为 true
                config.setShake(true);//是否震动  默认为 true
                config.setDecodeBarCode(true);//是否扫描条形码 默认为 true
                config.setReactColor(R.color.blue);//设置扫描框四个角的颜色 默认为白色
                config.setFrameLineColor(R.color.blue);//设置扫描框边框颜色 默认无色
                config.setScanLineColor(R.color.blue);//设置扫描线的颜色 默认白色
                config.setFullScreenScan(false);//是否全屏扫描  默认为 true  设为 false 则只会在扫描框中扫描
                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
                break;
            case R.id.ll_tab_three:
                tabAdapter.setCurrentFragment(1);
                initBlue();
                StatusBarUtil.StatusBarLightMode(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                String s = content.substring(content.lastIndexOf("/") + 1, content.length());
                Map<String, String> map = new HashMap<String, String>();
                map.put("wxapp_id", FastData.getWxAppId());
                map.put("shop_id", FastData.getShopId());
                map.put("order_id", s);
                dataRepository.extract(map, new RemotDataSource.getCallback() {
                    @Override
                    public void onFailure(String info) {

                    }

                    @Override
                    public void onSuccess(Object data) {
                        StatusBean statusBean = (StatusBean) data;
                        if (statusBean.getCode() == 1) {
                            ToastUtils.showToast(statusBean.getMsg());
                        } else {
                            ToastUtils.showToast("核销失败");
                        }
                    }
                });
            }
        }
    }

    protected void initListener() {
        tabAdapter.setOnTabChangeListener(new FragmentTabAdapter.OnTabChangeListener() {
            @Override
            public void OnTabChanged(int index) {
                tvTabOne.setTextColor(getResources().getColor(R.color.grey));
                tvTabTwo.setTextColor(getResources().getColor(R.color.grey));
                tvTabThree.setTextColor(getResources().getColor(R.color.grey));

                ivTabOne.setImageResource(R.mipmap.index_home_unselect);
                ivTabTwo.setImageResource(R.mipmap.qrcode);
                ivTabThree.setImageResource(R.mipmap.index_tab_my_unselect);

                switch (index) {
                    case 0:
                        tvTabOne.setTextColor(getResources().getColor(R.color.blue));
                        ivTabOne.setImageResource(R.mipmap.index_home_select);
                        break;
//                    case 1:
//                        tvTabTwo.setTextColor(getResources().getColor(R.color.blue));
//                        ivTabTwo.setImageResource(R.mipmap.qrcode);
//                        break;
                    case 1:
                        tvTabThree.setTextColor(getResources().getColor(R.color.blue));
                        ivTabThree.setImageResource(R.mipmap.index_tab_my_select);
                        break;
                }
            }
        });
    }

    /**
     * 手机返回键监听
     */
    long firstTime = 0;

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 800) { // 两次点击间隔大于800毫秒，不退出
            ToastUtils.showToast("再按一次退出程序");
            firstTime = secondTime; // 更新firstTime
        } else {
            finish();
        }
    }
}