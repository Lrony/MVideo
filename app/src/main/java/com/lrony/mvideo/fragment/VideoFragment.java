package com.lrony.mvideo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.lrony.mvideo.R;
import com.lrony.mvideo.adapter.VideoListAdapter;
import com.lrony.mvideo.adapter.VideoRecyclerAdapter;
import com.lrony.mvideo.mode.VideoInfo;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayer;

public class VideoFragment extends Fragment {

    private View root;
    private Context mContext;

    public static ListView listView;

    private VideoListAdapter mAdapter;

    private ArrayList<VideoInfo> mData = new ArrayList<VideoInfo>();

    public VideoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_video, container, false);
        mContext = getContext();

        VideoInfo info = new VideoInfo("http://a.aq-cn.com:88/3v57+350", "http://lolhunter.cn/player/girl.mp4", "Video", true);
        mData.add(info);
        mData.add(info);
        mData.add(info);
        mData.add(info);
        mData.add(info);
        mData.add(info);
        mData.add(info);

        initView();
        return root;
    }

    private void initView() {
        listView = root.findViewById(R.id.list_video);
        mAdapter = new VideoListAdapter(mContext, mData);
        listView.setAdapter(mAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                JZVideoPlayer.onScrollReleaseAllVideos(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });
    }

    public static void setListScrollPosition(int position){
        if (null != listView){
            listView.smoothScrollToPosition(position);
        }
    }

}
