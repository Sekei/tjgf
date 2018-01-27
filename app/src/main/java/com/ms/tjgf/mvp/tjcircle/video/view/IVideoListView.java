package com.ms.tjgf.mvp.tjcircle.video.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.VideoListBean;

import java.util.List;


public interface IVideoListView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<VideoListBean> newsList);
}
