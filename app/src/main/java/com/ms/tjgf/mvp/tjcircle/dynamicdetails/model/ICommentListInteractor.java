package com.ms.tjgf.mvp.tjcircle.dynamicdetails.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.HttpApiComment;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.persenter.CommentListPresenter;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;

/**
 * Created by MissSekei on 2018/1/23.
 */

public interface ICommentListInteractor {
    void requestCommentList(String id, HttpApiComment object, String reqTag, CommentListPresenter callback);
}
