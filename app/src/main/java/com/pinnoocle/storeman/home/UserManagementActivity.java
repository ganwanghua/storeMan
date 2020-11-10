package com.pinnoocle.storeman.home;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.adapter.UserManagementAdapter;
import com.pinnoocle.storeman.bean.UserManagerBean;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.nets.DataRepository;
import com.pinnoocle.storeman.nets.Injection;
import com.pinnoocle.storeman.nets.RemotDataSource;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserManagementActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    private DataRepository dataRepository;
    private UserManagementAdapter userManagementAdapter;
    private List<UserManagerBean.DataBeanX.UserBean.DataBean> dataBeanList = new ArrayList<>();
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userManagementAdapter = new UserManagementAdapter(this);
        recycleView.setAdapter(userManagementAdapter);

        myTeam(page);

        refresh.setOnRefreshLoadMoreListener(this);

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivCancel.setVisibility(View.VISIBLE);
                }else {
                    ivCancel.setVisibility(View.GONE);
                    page = 1;
                    dataBeanList.clear();
                    myTeam(page);
                }
            }
        });

        edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    ((InputMethodManager) edSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    if (edSearch.getText().toString().equals("")) {
                        ToastUtils.showToast("搜索内容不能为空");
                    } else {
                        page = 1;
                        dataBeanList.clear();
                        myTeam(page);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void myTeam(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", FastData.getWxAppId());
        map.put("shop_id", FastData.getShopId());
        map.put("nickName", edSearch.getText().toString());
        map.put("page", page + "");
        dataRepository.myTeam(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMoreWithNoMoreData();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                refresh.finishLoadMoreWithNoMoreData();
                UserManagerBean userManagerBean = (UserManagerBean) data;
                if (userManagerBean.getCode() == 1) {
                    dataBeanList.addAll(userManagerBean.getData().getUser().getData());
                    userManagementAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        myTeam(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        myTeam(page);
    }

    @OnClick({R.id.iv_back, R.id.iv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_cancel:
                edSearch.setText("");
                break;
        }
    }
}