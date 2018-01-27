package com.ms.tjgf.mvp.tjcircle.match.persenter;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.bean.MatchBean;
import com.ms.tjgf.bean.MatchListBean;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.VideoBean;
import com.ms.tjgf.bean.VideoListBean;
import com.ms.tjgf.mvp.tjcircle.match.model.MatchListInteractor;
import com.ms.tjgf.mvp.tjcircle.match.view.IMatchListView;
import com.ms.tjgf.mvp.tjcircle.video.model.VideoListInteractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class MatchListPresenter extends BasePresenter<IMatchListView, RespBean<MatchBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private MatchListInteractor iMatchListInteractor;
    private List<MatchListBean> newsList = new ArrayList<>();

    public MatchListPresenter(IMatchListView mView) {
        super(mView);
        iMatchListInteractor = new MatchListInteractor();
    }

    @Override
    public void requestNewsList(boolean isRefresh) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iMatchListInteractor.requestMatchList(new HttpListBean(page, ""), "1", this);
    }

    @Override
    public void onSuccess(RespBean<MatchBean> data,String reqTag) {
        super.onSuccess(data,reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
