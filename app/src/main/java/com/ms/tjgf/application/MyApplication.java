package com.ms.tjgf.application;

import android.app.Application;
import android.util.DisplayMetrics;

import com.baidu.mapapi.SDKInitializer;
import com.ms.tjgf.network.bean.UserBean;

/**
 * Created by Administrator on 2018/1/15.
 */
public class MyApplication extends Application {
    //应用实例
    private static MyApplication instance;
    private static UserBean mUser;
    // 获取屏幕分辨率
    private DisplayMetrics mDisplay = new DisplayMetrics();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mDisplay = this.getResources().getDisplayMetrics();
        //百度地图初始化
        SDKInitializer.initialize(getApplicationContext());
    }

    //获得实例
    public static MyApplication getInstance() {
        return instance;
    }

    public float getDisplayDensity() {
        return mDisplay.density;
    }

    public int dp2px(int dp) {
        return (int) (dp * getDisplayDensity() + 0.5f);
    }

    public int px2dp(int px) {
        return (int) (px / getDisplayDensity() + 0.5f);
    }

    public int pxToSp(int px) {
        return (int) (px / mDisplay.scaledDensity);
    }

    public int spToPx(int sp) {
        return (int) (sp * mDisplay.scaledDensity);
    }

    public static UserBean getUser() {
        return mUser;
    }

    /**
     * 获取 屏幕像素 px
     *
     * @return Integer[高度，宽度]
     */
    public int[] getDisplayHightAndWightPx() {
        return new int[]{mDisplay.heightPixels, mDisplay.widthPixels};
    }

}
