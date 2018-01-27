package com.ms.tjgf.mvp.curriculum;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.map.MapActivity;
import com.ms.tjgf.mvp.curriculum.master.MasterFragment;
import com.ms.tjgf.mvp.curriculum.outdoor.OutdoorFragment;
import com.ms.tjgf.mvp.curriculum.privateschool.PrivateSchoolFragment;
import com.ms.tjgf.mvp.curriculum.study.StudyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class CurriculumFragment extends BaseFragment implements View.OnClickListener {
    private XTabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private MyAdapter adapter;
    private String[] titles = {"太极自修课", "私教", "室外", "大师课"};
    private TextView mNearbyBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_curriculum;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        //实例化
        viewPager = view.findViewById(R.id.curriculum_viewpager);
        tabLayout = view.findViewById(R.id.curriculum_xtablayout);
        mNearbyBtn = view.findViewById(R.id.nearby_btn);
        mNearbyBtn.setOnClickListener(this);
        //页面，数据源
        list.add(new StudyFragment());
        list.add(new PrivateSchoolFragment());
        list.add(new OutdoorFragment());
        list.add(new MasterFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);  //绑定
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nearby_btn:
                startActivity(MapActivity.class);
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
