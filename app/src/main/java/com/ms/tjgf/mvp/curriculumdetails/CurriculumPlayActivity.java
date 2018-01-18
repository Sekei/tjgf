package com.ms.tjgf.mvp.curriculumdetails;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.curriculumdetails.fragment.CommentFragment;
import com.ms.tjgf.mvp.curriculumdetails.fragment.CourseDetailsFragment;
import com.ms.tjgf.utils.ToastUtils;
import com.ms.tjgf.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class CurriculumPlayActivity extends ActionBarActivity {


    //修改顶部颜色值
    @Override
    protected int getStatusBarTintResource() {
        return R.color.color_0000;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;//透明top
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_curriculumplay;
    }

    @Override
    protected void initView() {
        super.initView();

    }
}
