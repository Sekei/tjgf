package com.ms.tjgf.mvp.tjcircle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.androidkun.xtablayout.XTabLayout;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.study.StudyFragment;
import com.ms.tjgf.mvp.tjcircle.dynamic.DynamicFragment;
import com.ms.tjgf.mvp.tjcircle.inherit.InheritFragment;
import com.ms.tjgf.mvp.tjcircle.match.MatchFragment;
import com.ms.tjgf.mvp.tjcircle.ranking.RankingFragment;
import com.ms.tjgf.mvp.tjcircle.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class TJCircleFragment extends BaseFragment {
    private XTabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private MyAdapter adapter;
    private String[] titles = {"动态", "视频", "赛事", "传承", "排行榜"};


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tjcircle;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        //实例化
        viewPager = view.findViewById(R.id.tjcircle_viewpager);
        tabLayout = view.findViewById(R.id.tjcircle_xtablayout);
        list.add(new DynamicFragment());//动态
        list.add(new VideoFragment());//视频
        list.add(new MatchFragment());//赛事
        list.add(new InheritFragment());//传承
        list.add(new RankingFragment());//排行榜
        //ViewPager的适配器
        adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
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
