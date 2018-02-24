package com.lrony.mvideo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lrony.mvideo.R;
import com.lrony.mvideo.base.PlayerBaseActivity;
import com.lrony.mvideo.player.VideoPlayerStandard;
import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

public class PlayerActivity extends PlayerBaseActivity {

    private static final String TAG = "PlayerActivity";

    private VideoPlayerStandard videoPlayer;

    private String m_videoImg;
    private String m_video;
    private String m_videoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        m_videoImg = intent.getStringExtra("videoImg");
        m_video = intent.getStringExtra("video");
        m_videoTitle = intent.getStringExtra("videoTitle");

        initView();
    }

    private void initView() {
        videoPlayer = findViewById(R.id.videoplayer);
        videoPlayer.setUp(m_video, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, m_videoTitle);
        Picasso.with(this)
                .load(m_videoImg)
                .into(videoPlayer.thumbImageView);
    }
}
