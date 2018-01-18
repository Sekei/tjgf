package com.ms.tjgf.mvp.news;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.news.fistfriend.FistFriendFragment;
import com.ms.tjgf.mvp.news.newslist.NewsListFragment;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class NewsFragment extends BaseFragment implements View.OnClickListener {
    private Button title_left_btn, title_right_btn;
    /**
     * Fragment管理器
     */
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    /**
     * 两个Fragment
     */
    private NewsListFragment mLFragment;
    private FistFriendFragment mRFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        title_left_btn = view.findViewById(R.id.newslist_btn);
        title_left_btn.setOnClickListener(this);
        title_right_btn = view.findViewById(R.id.fistfriend_btn);
        title_right_btn.setOnClickListener(this);
        mFragmentManager = getFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mLFragment = new NewsListFragment();
        mTransaction.replace(R.id.news_content, mLFragment);
        mTransaction.commit();
        title_left_btn.performClick();//模拟点击事件，使左边按钮被点击
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newslist_btn:
                if (title_left_btn.isEnabled()) {
                    title_left_btn.setEnabled(false);
                    title_right_btn.setEnabled(true);
                }
                mFragmentManager = getFragmentManager();
                mTransaction = mFragmentManager.beginTransaction();
                if (mLFragment == null) {
                    mLFragment = new NewsListFragment();

                }
                mTransaction.replace(R.id.news_content, mLFragment);
                mTransaction.commit();
                break;

            case R.id.fistfriend_btn:
                if (title_right_btn.isEnabled()) {
                    title_left_btn.setEnabled(true);
                    title_right_btn.setEnabled(false);
                }
                mFragmentManager = getFragmentManager();
                mTransaction = mFragmentManager.beginTransaction();
                if (mRFragment == null) {
                    mRFragment = new FistFriendFragment();
                }
                mTransaction.replace(R.id.news_content, mRFragment);
                mTransaction.commit();
                break;
        }
    }
}
