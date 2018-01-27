package com.ms.tjgf.mvp.tjcircle.match.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.match.persenter.MatchListPresenter;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;

/**
 * Created by MissSekei on 2018/1/23.
 */

public interface IMatchListInteractor {
    void requestMatchList(HttpListBean object, String reqTag, MatchListPresenter callback);
}
