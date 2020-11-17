package com.pinnoocle.storeman.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.lling.photopicker.PhotoPickerActivity;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.MainActivity;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.bean.UploadModel;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.common.Constant;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.pinnoocle.storeman.common.Constant.REQUEST_CODE_SCAN;

public class InformationActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ll_business_license)
    RelativeLayout llBusinessLicense;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.ll_business)
    LinearLayout llBusiness;
    @BindView(R.id.pic_iv)
    ImageView picIv;
    @BindView(R.id.pic_delete)
    ImageView picDelete;
    @BindView(R.id.rl_business)
    RelativeLayout rlBusiness;
    @BindView(R.id.ed_company_name)
    EditText edCompanyName;
    @BindView(R.id.ed_legal_person)
    EditText edLegalPerson;
    @BindView(R.id.ed_organization_code)
    EditText edOrganizationCode;
    @BindView(R.id.ed_enterprise_type)
    EditText edEnterpriseType;
    @BindView(R.id.ed_registration_time)
    EditText edRegistrationTime;
    @BindView(R.id.ed_business_status)
    EditText edBusinessStatus;
    @BindView(R.id.ed_official_website)
    TextView edOfficialWebsite;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.tv_recommender)
    TextView tvRecommender;
    @BindView(R.id.iv_sao)
    ImageView ivSao;
    private DataRepository dataRepository;
    private String path = "";
    private String file_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
    }

    @OnClick({R.id.iv_back, R.id.ll_business_license, R.id.tv_buy, R.id.pic_delete, R.id.iv_sao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.ll_business_license:
                Intent intent = new Intent(this, PhotoPickerActivity.class);
                intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, true); // 是否显示相机
                intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, PhotoPickerActivity.MODE_SINGLE); // 选择模式（默认多选模式）
                intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, PhotoPickerActivity.MODE_MULTI); // 最大照片张数
                startActivityForResult(intent, Constant.PICK_PHOTO);
                break;
            case R.id.tv_buy:
                if (path.equals("")) {
                    ToastUtils.showToast("请上传营业执照");
                } else if (TextUtils.isEmpty(edCompanyName.getText().toString())) {
                    ToastUtils.showToast("请输入企业名称");
                } else if (TextUtils.isEmpty(edLegalPerson.getText().toString())) {
                    ToastUtils.showToast("请输入企业法人");
                } else if (TextUtils.isEmpty(edOrganizationCode.getText().toString())) {
                    ToastUtils.showToast("请输入组织机构代码");
                } else if (TextUtils.isEmpty(edEnterpriseType.getText().toString())) {
                    ToastUtils.showToast("请输入企业类型");
                } else if (TextUtils.isEmpty(edRegistrationTime.getText().toString())) {
                    ToastUtils.showToast("请输入注册时间");
                } else if (TextUtils.isEmpty(edBusinessStatus.getText().toString())) {
                    ToastUtils.showToast("请输入经营状态");
                } else if (TextUtils.isEmpty(edOfficialWebsite.getText().toString())) {
                    ToastUtils.showToast("请扫码获取推荐人ID");
                } else if (TextUtils.isEmpty(edName.getText().toString())) {
                    ToastUtils.showToast("请输入联系人姓名");
                } else if (TextUtils.isEmpty(edPhone.getText().toString())) {
                    ToastUtils.showToast("请输入联系人电话");
                } else {
                    apply();
                }
                break;
            case R.id.pic_delete:
                rlBusiness.setVisibility(View.GONE);
                llBusiness.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_sao:
                Intent intent1 = new Intent(this, CaptureActivity.class);
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
                intent1.putExtra(com.yzq.zxinglibrary.common.Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent1, REQUEST_CODE_SCAN);
                break;
        }
    }

    private void apply() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("user_id", getIntent().getStringExtra("user_id"));
        map.put("image_id", file_id);
        map.put("shop_name", edCompanyName.getText().toString());
        map.put("name", edLegalPerson.getText().toString());
        map.put("number", edOrganizationCode.getText().toString());
        map.put("type", edEnterpriseType.getText().toString());
        map.put("reg_time", edRegistrationTime.getText().toString());
        map.put("jingyin_status", edBusinessStatus.getText().toString());
        map.put("real_name", edName.getText().toString());
        map.put("mobile", edPhone.getText().toString());
        map.put("shanglv_id", edOfficialWebsite.getText().toString());
        dataRepository.apply(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(InformationActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(InformationActivity.this);
                StatusBean statusBean = (StatusBean) data;
                if (statusBean.getCode() == 1) {
                    ToastUtils.showToast(statusBean.getMsg());
                    Intent intent = new Intent(InformationActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else {
                    ToastUtils.showToast(statusBean.getMsg());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constant.PICK_PHOTO:
                    path = data.getStringArrayListExtra(PhotoPickerActivity.KEY_RESULT).get(0);
                    // 图片选择成功
                    rlBusiness.setVisibility(View.VISIBLE);
                    llBusiness.setVisibility(View.GONE);
                    Glide.with(this).load(path).centerCrop().into(picIv);
                    upUserHead(path);
                    break;
                case REQUEST_CODE_SCAN:
                    if (data != null) {
                        String content = data.getStringExtra(com.yzq.zxinglibrary.common.Constant.CODED_CONTENT);
                        String s = content.substring(content.lastIndexOf("/") + 1, content.length());
                        edOfficialWebsite.setText(s);
                    }
                    break;
            }
        }
    }

    private void upUserHead(String path) {
        File file = new File(path);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("iFile", file.getName(), fileBody);
        Map<String, String> map = new HashMap<>();

        map.put("wxapp_id", FastData.getWxAppId());
//        map.put("iFile", file + "");
        map.put("name", "" + file.getName());
        dataRepository.upUserHead(map, body, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                UploadModel uploadModel = (UploadModel) data;
                if (uploadModel.getCode() == 1) {
                    file_id = uploadModel.getData().getFile_id();
                } else {
                    ToastUtils.showToast(uploadModel.getmsg());
                }
            }
        });
    }
}