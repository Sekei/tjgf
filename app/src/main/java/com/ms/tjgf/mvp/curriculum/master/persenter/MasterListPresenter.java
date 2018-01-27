package com.ms.tjgf.mvp.curriculum.master.persenter;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.MasterBean;
import com.ms.tjgf.bean.MasterData;
import com.ms.tjgf.bean.OutDoorBean;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.curriculum.master.HttpApiMaster;
import com.ms.tjgf.mvp.curriculum.master.model.MasterListInteractor;
import com.ms.tjgf.mvp.curriculum.master.view.IMasterView;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.model.OutDoorListInteractor;
import com.ms.tjgf.mvp.curriculum.outdoor.view.IOutDoorView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class MasterListPresenter extends BasePresenter<IMasterView, RespBean<MasterBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private MasterListInteractor iMasterListInteractor;
    private List<MasterData> newsList = new ArrayList<>();

    public MasterListPresenter(IMasterView mView) {
        super(mView);
        iMasterListInteractor = new MasterListInteractor();
    }

    /**
     * true表示刷新重新请求
     *
     * @param isRefresh
     */
    @Override
    public void requestNewsList(boolean isRefresh) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iMasterListInteractor.requestMasterList(new HttpApiMaster(page), "master", this);
    }

    @Override
    public void onSuccess(RespBean<MasterBean> data, String reqTag) {
        super.onSuccess(data, reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
