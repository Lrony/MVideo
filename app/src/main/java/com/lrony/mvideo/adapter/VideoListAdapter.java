package com.lrony.mvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lrony.mvideo.R;
import com.lrony.mvideo.mode.VideoInfo;
import com.lrony.mvideo.player.VideoPlayerStandard;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by lrony on 2018/2/24.
 */
public class VideoListAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<VideoInfo> mData = new ArrayList<VideoInfo>();

    public VideoListAdapter(Context context, ArrayList<VideoInfo> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (null == view) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            view = mInflater.inflate(R.layout.item_video_details, null);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.videoPlayer = view.findViewById(R.id.videoplayer);
        viewHolder.videoPlayer.setUp(
                mData.get(i).getVideo(), JZVideoPlayer.SCREEN_WINDOW_LIST,
                mData.get(i).getTitle());
        Picasso.with(view.getContext())
                .load(mData.get(i).getImg())
                .into(viewHolder.videoPlayer.thumbImageView);
        viewHolder.videoPlayer.positionInList = i;
        return view;
    }

    class ViewHolder {
        VideoPlayerStandard videoPlayer;
    }
}
