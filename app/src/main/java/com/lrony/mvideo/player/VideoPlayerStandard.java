package com.lrony.mvideo.player;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.lrony.mvideo.R;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by pengyang on 18-2-24.
 */
public class VideoPlayerStandard extends JZVideoPlayerStandard {

    private static final String TAG = "VideoPlayerStandard";


    public VideoPlayerStandard(Context context) {
        super(context);
    }

    public VideoPlayerStandard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 这是播放控件初始化的时候最先调用的
     *
     * @param context
     */
    @Override
    public void init(Context context) {
        super.init(context);
        Log.d(TAG, "init");
    }

    /**
     * 这是控件里所有控件的onClick响应函数，比如监听开始按钮的点击，全屏按钮的点击，空白的点击，retry按钮的点击
     * ，等。如果你想拦截这些点击的响应或者继承这些点击的响应，那么复写此函数
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        Log.d(TAG, "onClick");
    }

    /**
     * 在JCVideoPlayer中此函数主要响应了全屏之后的手势控制音量和进度
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (id == R.id.surface_container) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    if (mChangePosition) {
                        //...
                    }
                    break;
            }
        }
        return super.onTouch(v, event);
    }

    /**
     * 用户触发的视频开始播放
     */
    @Override
    public void startVideo() {
        super.startVideo();
        Log.d(TAG, "startVideo");
    }

    /**
     * 控件进入普通的未播放状态
     */
    @Override
    public void onStateNormal() {
        super.onStateNormal();
        Log.d(TAG, "onStateNormal");
    }

    /**
     * 进入preparing状态，正在初始化视频
     */
    @Override
    public void onStatePreparing() {
        super.onStatePreparing();
        Log.d(TAG, "onStatePreparing");
    }

    /**
     * preparing之后进入播放状态
     */
    @Override
    public void onStatePlaying() {
        super.onStatePlaying();
        Log.d(TAG, "onStatePlaying");
    }

    /**
     * 暂停视频，进入暂停状态
     */
    @Override
    public void onStatePause() {
        super.onStatePause();
        Log.d(TAG, "onStatePause");
    }

    /**
     * 进入错误状态
     */
    @Override
    public void onStateError() {
        super.onStateError();
        Log.d(TAG, "onStateError");
    }

    /**
     * 进入视频自动播放完成状态
     */
    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        Log.d(TAG, "onStateAutoComplete");
    }

    /**
     * 进入全屏
     */
    @Override
    public void startWindowFullscreen() {
        super.startWindowFullscreen();
        Log.d(TAG, "startWindowFullscreen");
    }

    /**
     * 退出全屏
     */
    @Override
    public void startWindowTiny() {
        super.startWindowTiny();
        Log.d(TAG, "startWindowTiny");
    }
}
