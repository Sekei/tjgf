package com.ms.tjgf.mvp.tjcircle.match.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.MatchListBean;
import com.ms.tjgf.bean.VideoListBean;

import java.util.List;


public interface IMatchListView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<MatchListBean> newsList);
}
