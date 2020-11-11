package com.pinnoocle.storeman.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.common.BaseActivity;
import com.pinnoocle.storeman.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends BaseActivity {

    @BindView(R.id.public_videoView)
    VideoView publicVideoView;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.prb)
    ProgressBar prb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        publicVideoView.setVideoPath(getIntent().getStringExtra("url"));
        publicVideoView.setMediaController(new MediaController(this));
        //这里用相对布局包裹videoview 实现视频全屏播放
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        publicVideoView.setLayoutParams(layoutParams);
        publicVideoView.start();
        publicVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                prb.setVisibility(View.GONE);
            }
        });
        publicVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
                publicVideoView.stopPlayback();
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
        publicVideoView.stopPlayback();
    }

    @Override
    public void onBackPressed() {
        finish();
        publicVideoView.stopPlayback();
    }
}