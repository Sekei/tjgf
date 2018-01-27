package com.ms.tjgf.mvp.curriculum.privateschool.persenter;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.bean.PrivateSchoolBean;
import com.ms.tjgf.bean.PrivateSchoolData;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.curriculum.privateschool.model.PEListInteractor;
import com.ms.tjgf.mvp.curriculum.privateschool.view.IPEListView;
import com.ms.tjgf.mvp.tjcircle.dynamic.model.DynamicListInteractor;
import com.ms.tjgf.mvp.tjcircle.dynamic.view.IDynamicListView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class PEListPresenter extends BasePresenter<IPEListView, RespBean<PrivateSchoolBean>> implements IPEListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private PEListInteractor iPEListInteractor;
    private List<PrivateSchoolData> newsList = new ArrayList<>();

    public PEListPresenter(IPEListView mView) {
        super(mView);
        iPEListInteractor = new PEListInteractor();
    }

    /**
     * true表示刷新重新请求，type表示招式和套路的切换
     *
     * @param isRefresh
     * @param type
     */
    @Override
    public void requestNewsList(boolean isRefresh, String type) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iPEListInteractor.requestPEList(new HttpApiPE(page, type), "pe", this);
    }

    @Override
    public void onSuccess(RespBean<PrivateSchoolBean> data, String reqTag) {
        super.onSuccess(data, reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
