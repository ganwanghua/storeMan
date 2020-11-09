package com.pinnoocle.storeman.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.QrCodeBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.SaveImageUtils;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionCodeActivity extends BaseActivity {
    DataRepository dataRepository;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.iv_qrCode)
    ImageView ivQrCode;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.cardView)
    RelativeLayout cardView;
    @BindView(R.id.iv_qr_code)
    ImageView ivQrCode1;
    @BindView(R.id.rl_code)
    RelativeLayout rlCode;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_code);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        getPayCode();

        ivQrCode1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showSaveCode();
                return false;
            }
        });
    }

    private void showSaveCode() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_code)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure, R.id.tv_content)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确定保存二维码图片？");
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
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            final Bitmap myBitmap = Glide.with(CollectionCodeActivity.this)//上下文
                                                    .asBitmap() //必须
                                                    .load(url)//url
                                                    .centerCrop()
                                                    .into(500, 500)
                                                    .get();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SaveImageUtils.saveImageToGallerys(CollectionCodeActivity.this, myBitmap);
                                                }
                                            });

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void getPayCode() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("shop_id", FastData.getShopId());
        dataRepository.getPayCode(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(CollectionCodeActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(CollectionCodeActivity.this);
                QrCodeBean qrCodeBean = (QrCodeBean) data;
                if (qrCodeBean.getCode() == 1) {
                    url = qrCodeBean.getData().getQrcode();
                    Glide.with(CollectionCodeActivity.this).load(qrCodeBean.getData().getQrcode()).centerCrop().into(ivQrCode1);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}