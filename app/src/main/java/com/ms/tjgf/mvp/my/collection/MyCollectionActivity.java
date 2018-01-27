package com.ms.tjgf.mvp.my.collection;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.ms.tjgf.R;
import com.ms.tjgf.adapter.BaseViewPagerAdapter;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.my.collection.fragment.TeacherFragment;
import com.ms.tjgf.mvp.my.course.fragment.CourseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的收藏
 * Created by MissSekei on 2018/1/27.
 */

public class MyCollectionActivity extends ActionBarActivity {
    private XTabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titles = {"名师", "课程", "场馆", "视频", "图文"};
    private BaseViewPagerAdapter adapter;
    private List<Fragment> list = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mycollection;
    }

    @Override
    protected void initView() {
        super.initView();
        tabLayout = findViewById(R.id.mycourse_xtab);
        viewPager = findViewById(R.id.mycourse_viewpager);
        list.add(new TeacherFragment());
        list.add(new TeacherFragment());
        list.add(new TeacherFragment());
        list.add(new TeacherFragment());
        list.add(new TeacherFragment());
        //ViewPager的适配器
        adapter = new BaseViewPagerAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);  //绑定
    }
}
