package com.ms.tjgf.mvp.tjcircle.dynamicdetails.model;

import com.ms.tjgf.mvp.tjcircle.dynamicdetails.HttpApiComment;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.persenter.CommentListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class CommentListInteractor implements ICommentListInteractor{
    @Override
    public void requestCommentList(String id,HttpApiComment object, String reqTag, CommentListPresenter callback) {
        NetWorks.getInstance().getComment(id,object, reqTag, callback);
    }
}
