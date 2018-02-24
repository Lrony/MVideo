package com.lrony.mvideo.mode;

/**
 * Created by pengyang on 18-2-24.
 */
public class VideoInfo {

    private String img;
    private String video;
    private String title;
    private boolean vip;

    public VideoInfo(String img, String video, String title, boolean vip) {
        this.img = img;
        this.video = video;
        this.title = title;
        this.vip = vip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
