package com.ms.tjgf.mvp.tjcircle.match.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.match.persenter.MatchListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class MatchListInteractor implements IMatchListInteractor{
    @Override
    public void requestMatchList(HttpListBean object, String reqTag, MatchListPresenter callback) {
        NetWorks.getInstance().getMatch(object, reqTag, callback);
    }
}
