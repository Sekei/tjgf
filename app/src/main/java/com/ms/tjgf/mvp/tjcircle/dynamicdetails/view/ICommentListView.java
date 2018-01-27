package com.ms.tjgf.mvp.tjcircle.dynamicdetails.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.CommentListBean;
import com.ms.tjgf.bean.VideoListBean;

import java.util.List;


public interface ICommentListView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<CommentListBean> newsList);
}
