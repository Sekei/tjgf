package com.ms.tjgf.mvp.tjcircle.video.persenter;

import android.provider.MediaStore;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.VideoBean;
import com.ms.tjgf.bean.VideoListBean;
import com.ms.tjgf.mvp.tjcircle.dynamic.model.DynamicListInteractor;
import com.ms.tjgf.mvp.tjcircle.dynamic.view.IDynamicListView;
import com.ms.tjgf.mvp.tjcircle.video.model.VideoListInteractor;
import com.ms.tjgf.mvp.tjcircle.video.view.IVideoListView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class VideoListPresenter extends BasePresenter<IVideoListView, RespBean<VideoBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private VideoListInteractor iVideoListInteractor;
    private List<VideoListBean> newsList = new ArrayList<>();

    public VideoListPresenter(IVideoListView mView) {
        super(mView);
        iVideoListInteractor = new VideoListInteractor();
    }

    @Override
    public void requestNewsList(boolean isRefresh) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iVideoListInteractor.requestVideoList(new HttpListBean(page, ""), "1", this);
    }

    @Override
    public void onSuccess(RespBean<VideoBean> data,String reqTag) {
        super.onSuccess(data,reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
