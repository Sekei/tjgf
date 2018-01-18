package com.ms.tjgf.base;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ms.tjgf.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;


public abstract class AppActionBarActivity extends BaseActivity implements View.OnClickListener {
    //界面view
    protected abstract int getLayoutId();

    //界面样式风格
    public static final int ACTIONBAR_WHITE = 1;

    protected int getActionBarType() {
        return ACTIONBAR_WHITE;
    }

    //状态栏颜色
    protected int getStatusBarTintResource() {
        return R.drawable.app_theme_bg;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        initView();
    }

    // view初始化
    protected void initActionBar() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(getLayoutId());
        applyKitKatTranslucency();//将状态栏设置为主题色
    }


    // 操作
    protected void initView() {

    }

    //生命周期,主要用于数据统计分析，如页面停留时间，打开次数等
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
