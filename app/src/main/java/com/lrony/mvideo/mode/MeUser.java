package com.lrony.mvideo.mode;

import cn.bmob.v3.BmobUser;

/**
 * Created by pengyang on 18-2-24.
 */
public class MeUser extends BmobUser {

    private boolean vip;

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
