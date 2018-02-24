package com.lrony.mvideo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lrony.mvideo.R;
import com.lrony.mvideo.mode.VideoInfo;
import com.lrony.mvideo.player.VideoPlayerStandard;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by pengyang on 18-2-24.
 */
public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder> {

    private ArrayList<VideoInfo> mData = new ArrayList<VideoInfo>();

    public VideoRecyclerAdapter(ArrayList<VideoInfo> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<VideoInfo> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_details
                , parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.video.setUp(
                mData.get(position).getVideo(), JZVideoPlayer.SCREEN_WINDOW_LIST, mData.get(position).getTitle());
        Picasso.with(holder.video.getContext())
                .load(mData.get(position).getImg())
                .into(holder.video.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        VideoPlayerStandard video;

        public ViewHolder(View itemView) {
            super(itemView);
            video = itemView.findViewById(R.id.videoplayer);
        }
    }
}
