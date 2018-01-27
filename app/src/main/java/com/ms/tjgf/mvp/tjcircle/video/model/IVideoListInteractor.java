package com.ms.tjgf.mvp.tjcircle.video.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;

/**
 * Created by MissSekei on 2018/1/23.
 */

public interface IVideoListInteractor {
    void requestVideoList(HttpListBean object, String reqTag, VideoListPresenter callback);
}
