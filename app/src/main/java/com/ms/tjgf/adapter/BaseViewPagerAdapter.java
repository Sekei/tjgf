package com.ms.tjgf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/27.
 */

public class BaseViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private String[] mTitles;

    public BaseViewPagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.mList = list;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
