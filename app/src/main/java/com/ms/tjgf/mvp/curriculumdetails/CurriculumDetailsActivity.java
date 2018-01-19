package com.ms.tjgf.mvp.curriculumdetails;

import android.graphics.Rect;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.ms.tjgf.R;
import com.ms.tjgf.application.MyApplication;
import com.ms.tjgf.base.ActionBarActivity;
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

public class CurriculumDetailsActivity extends ActionBarActivity implements View.OnFocusChangeListener, XTabLayout.OnTabSelectedListener {
    private XTabLayout tabLayout;
    private String[] titles = {"详情", "评论"};
    private CustomViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private MyAdapter adapter;
    //评论区域
    private RelativeLayout mCourseRegion;
    private LinearLayout mStarll;//评星发送
    //评论输入框
    private EditText mCommentInput;

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
        mCommentInput = findViewById(R.id.comment_input);
        mCommentInput.setOnFocusChangeListener(this);
        viewPager.setScanScroll(false);//禁止左右滑动
        list.add(new CourseDetailsFragment());
        list.add(new CommentFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);//绑定
        tabLayout.setOnTabSelectedListener(this);
        mStarll = findViewById(R.id.star_ll);
        controlKeyboardLayout(findViewById(R.id.curriculum_details), mCourseRegion);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {// 获得焦点
            mStarll.setVisibility(View.VISIBLE);
        } else {// 失去焦点
            mStarll.setVisibility(View.GONE);
        }

    }

    //选中
    @Override
    public void onTabSelected(XTabLayout.Tab tab) {
        if (tab.getText().equals("评论")) {
            mCourseRegion.setVisibility(View.VISIBLE);//显示评论区域
            viewPager.setCurrentItem(1);
        } else {
            mCourseRegion.setVisibility(View.GONE);//隐藏评论区域
            viewPager.setCurrentItem(0);
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

        }
    }

    /**
     * 解决在页面底部置输入框，输入法弹出遮挡部分输入框的问题
     *
     * @param root       页面根元素
     * @param editLayout 被软键盘遮挡的输入框
     */
    public void controlKeyboardLayout(final View root, final View editLayout) {
        // TODO Auto-generated method stub
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                Rect rect = new Rect();
                //获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                //获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
                int rootInVisibleHeigh = root.getRootView().getHeight() - rect.bottom;
                //若不可视区域高度大于100，则键盘显示
                if (rootInVisibleHeigh > 100) {
                    int[] location = new int[2];
                    //获取editLayout在窗体的坐标
                    editLayout.getLocationInWindow(location);
                    //计算root滚动高度，使editLayout在可见区域()
                    int srollHeight = (location[1] + editLayout.getHeight()) - rect.bottom;
                    root.scrollTo(0, srollHeight);
                } else {
                    root.scrollTo(0, 0);
                }
            }
        });
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
