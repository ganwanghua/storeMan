package com.pinnoocle.storeman.home.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.util.ImageGetterUtils;

public class CourseIntroductionFragment extends Fragment {
    private String content;
    private TextView tv_content;
    public CourseIntroductionFragment(String content) {
        this.content = content;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_introduction, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        tv_content = v.findViewById(R.id.tv_content);
        tv_content.setText(Html.fromHtml(content,new ImageGetterUtils.MyImageGetter(getActivity(),tv_content),null));
    }
}