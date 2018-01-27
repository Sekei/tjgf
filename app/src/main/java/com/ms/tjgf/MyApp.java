package com.ms.tjgf;

import android.app.Application;
import android.util.DisplayMetrics;

import com.baidu.mapapi.SDKInitializer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2018/1/15.
 */
public class MyApp extends Application {
    //应用实例
    private static MyApp instance;
    //private static UserBean mUser;
    // 获取屏幕分辨率
    private DisplayMetrics mDisplay = new DisplayMetrics();
    private String access_token="$2y$13$H1seWZ5zjdWkbTC6LE6KheDxqlYutoJUr1nL3TGDX75cU3UMEF7Xq";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mDisplay = this.getResources().getDisplayMetrics();
        SDKInitializer.initialize(getApplicationContext());//百度地图初始化
        initImageLoader();//imageloader框架初始化
    }

    private void initImageLoader() {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }

    //获得实例
    public static MyApp getInstance() {
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

//    public static UserBean getUser() {
//        return mUser;
//    }

    public String getToken() {
        return access_token;
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
