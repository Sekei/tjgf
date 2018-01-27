package com.ms.tjgf.mvp.tjcircle.video.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class VideoListInteractor implements IVideoListInteractor {
    @Override
    public void requestVideoList(HttpListBean object, String reqTag, VideoListPresenter callback) {
        NetWorks.getInstance().getVideo(object, reqTag, callback);
    }
}
