package com.ms.tjgf.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.JSON;
import com.ms.tjgf.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * 最底层基础activity，用于定义一些跳转传参之类的
 */
public class BaseActivity extends AppCompatActivity {

    //状态栏颜色
    protected int getStatusBarTintResource() {
        return R.drawable.app_theme_bg;
    }

    /**
     * 4.0以上状态栏变色
     */
    protected void applyKitKatTranslucency() {// KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setStatusBarTintResource(getStatusBarTintResource());//通知栏所需颜色
        }
    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    //状态栏透视效果
    protected void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.BLACK);//实体按钮在内部
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 无参activity跳转
     *
     * @param cls
     */
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    /**
     * 带参执行activity之间跳转
     * 参数分别以逗号分隔
     * arg0,arg1,arg2
     *
     * @param cls
     * @param objects
     */
    public void startActivity(Class<?> cls, Object... objects) {
        Intent intent = new Intent(this, cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivity(intent);
    }

    /**
     * activity无参数返回方法
     *
     * @param cls
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, requestCode);
    }

    /**
     * activity带参返回方法
     *
     * @param cls
     * @param requestCode
     * @param objects
     */
    public void startActivityForResult(Class<?> cls, int requestCode, Object... objects) {
        Intent intent = new Intent(this, cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 获取对应上一个activity传来对象值
     *
     * @param cls 传入对应的类型，int、String
     * @return
     */
    public Object[] getIntentObjects(Class<?>... cls) {
        Object[] objs = new Object[cls.length];
        Intent intent = getIntent();
        for (int i = 0; i < objs.length; i++) {
            objs[i] = JSON.parseObject(intent.getStringExtra("data_" + i), cls[i]);
        }
        return objs;
    }

    /**
     * 默认获取传入的第一个参数
     *
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T getIntentObject(Class<T> cls) {
        return getIntentObject(cls, 0);
    }

    /**
     * 获取对应上一个activity传来的值,分别出入下标0,1,2
     *
     * @param cls
     * @param positon
     * @param <T>
     * @return
     */
    public <T> T getIntentObject(Class<T> cls, int positon) {
        String st = getIntent().getStringExtra("data_" + positon);
        if (st == null) {
            return null;
        }
        return JSON.parseObject(st, cls);
    }
}
