package com.ms.tjgf.mvp.curriculumdetails;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.curriculum.fragment.StudyFragment;
import com.ms.tjgf.mvp.curriculumdetails.fragment.CommentFragment;
import com.ms.tjgf.mvp.curriculumdetails.fragment.CourseDetailsFragment;
import com.ms.tjgf.utils.ToastUtils;
import com.ms.tjgf.widget.CustomViewPager;
import com.ms.tjgf.widget.PileLayout;
import com.ms.tjgf.widget.roundimage.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class CurriculumDetailsActivity extends ActionBarActivity implements XTabLayout.OnTabSelectedListener {
    private XTabLayout tabLayout;
    private String[] titles = {"详情", "评论"};
    private CustomViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;
    //评论区域
    private RelativeLayout mCourseRegion;

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
        return R.layout.activity_curriculumdetails;
    }

    @Override
    protected void initView() {
        super.initView();
        tabLayout = findViewById(R.id.details_xtablayout);
        viewPager = findViewById(R.id.details_viewpager);
        mCourseRegion = findViewById(R.id.course_region);

        viewPager.setScanScroll(false);//禁止左右滑动
        list = new ArrayList<>();   //页面，数据源
        list.add(new CourseDetailsFragment());
        list.add(new CommentFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);//绑定
        tabLayout.setOnTabSelectedListener(this);
    }


    //选中
    @Override
    public void onTabSelected(XTabLayout.Tab tab) {
        if (tab.getText().equals("评论")) {
            mCourseRegion.setVisibility(View.VISIBLE);//显示评论区域
        } else {
            mCourseRegion.setVisibility(View.GONE);//隐藏评论区域
        }
    }

    //未选中
    @Override
    public void onTabUnselected(XTabLayout.Tab tab) {
    }

    //复选的
    @Override
    public void onTabReselected(XTabLayout.Tab tab) {
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.details_xtablayout:
                int position = (int) view.getTag();
                if (position == 0 && tabLayout.getTabAt(position).isSelected() == true) {
                    ToastUtils.show("111");
                } else {
                    ToastUtils.show("222");
                }
                break;
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
