package com.ms.tjgf.mvp.tjcircle.match;


import android.view.View;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.MatchListBean;
import com.ms.tjgf.bean.VideoListBean;
import com.ms.tjgf.mvp.tjcircle.match.adapter.MatchAdapter;
import com.ms.tjgf.bean.MatchBean;
import com.ms.tjgf.mvp.tjcircle.match.persenter.MatchListPresenter;
import com.ms.tjgf.mvp.tjcircle.match.view.IMatchListView;
import com.ms.tjgf.mvp.tjcircle.video.view.IVideoListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MatchFragment extends BaseFragment implements IMatchListView {
    private ListView mMatchList;
    private MatchAdapter mMatchAdapter;
    private List<MatchListBean> newsList = new ArrayList<>();
    private IBaseListPresenter iMatchListPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_match;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mMatchList = view.findViewById(R.id.match_list);
        iMatchListPresenter = new MatchListPresenter(this);
        iMatchListPresenter.requestNewsList(true);
        mMatchAdapter = new MatchAdapter(getActivity(), R.layout.item_match_list, newsList);
        mMatchList.setAdapter(mMatchAdapter);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<MatchListBean> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mMatchAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iMatchListPresenter.onDestroy();
    }
}
