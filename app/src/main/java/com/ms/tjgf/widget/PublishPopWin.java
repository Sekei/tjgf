package com.ms.tjgf.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.ms.tjgf.R;
import com.ms.tjgf.mvp.tjcircle.dynamic.activity.ArticleActivity;
import com.ms.tjgf.mvp.tjcircle.dynamic.activity.ReleaseImgTextActivity;
import com.ms.tjgf.mvp.tjcircle.dynamic.activity.ReleaseVideoActivity;

/**
 * Created by MissSekei on 2018/1/20.
 */

public class PublishPopWin extends PopupWindow implements View.OnTouchListener, RadioGroup.OnCheckedChangeListener {
    private Context mContext;
    private View view;
    private RadioGroup mRadioGroup;

    public PublishPopWin(Context mContext) {
        this.mContext = mContext;
        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_publish, null);
        mRadioGroup = view.findViewById(R.id.pop_layout);
        mRadioGroup.setOnCheckedChangeListener(this);
        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(this);
        //设置弹出窗口特征
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.pop_anim);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.radio_imgtext:
                startActivity(ReleaseImgTextActivity.class);
                break;
            case R.id.radio_article:
                startActivity(ArticleActivity.class);
                break;
            case R.id.radio_video:
                startActivity(ReleaseVideoActivity.class);
                break;

        }
        this.dismiss();//关闭popWin
    }

    //activity 跳转
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        mContext.startActivity(intent);
    }

    public boolean onTouch(View v, MotionEvent event) {
        int height = view.findViewById(R.id.pop_layout).getTop();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (y < height) {
                dismiss();
            }
        }
        return true;
    }
}
