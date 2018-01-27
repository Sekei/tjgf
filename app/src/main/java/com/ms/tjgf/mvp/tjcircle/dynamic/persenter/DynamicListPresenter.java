package com.ms.tjgf.mvp.tjcircle.dynamic.persenter;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.dynamic.model.DynamicListInteractor;
import com.ms.tjgf.mvp.tjcircle.dynamic.view.IDynamicListView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class DynamicListPresenter extends BasePresenter<IDynamicListView, RespBean<DynamicBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private DynamicListInteractor iDynamicListInteractor;
    private List<DynamicData> newsList = new ArrayList<>();

    public DynamicListPresenter(IDynamicListView mView) {
        super(mView);
        iDynamicListInteractor = new DynamicListInteractor();
    }

    @Override
    public void requestNewsList(boolean isRefresh) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iDynamicListInteractor.requestDynamicList(new HttpListBean(page, ""), "1", this);
    }

    @Override
    public void onSuccess(RespBean<DynamicBean> data,String reqTag) {
        super.onSuccess(data,reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
