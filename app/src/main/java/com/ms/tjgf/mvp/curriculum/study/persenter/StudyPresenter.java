package com.ms.tjgf.mvp.curriculum.study.persenter;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.OutDoorBean;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.StudyBean;
import com.ms.tjgf.bean.StudyFactionBean;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.model.OutDoorListInteractor;
import com.ms.tjgf.mvp.curriculum.outdoor.view.IOutDoorView;
import com.ms.tjgf.mvp.curriculum.study.model.StudyInteractor;
import com.ms.tjgf.mvp.curriculum.study.view.IStudyView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class StudyPresenter extends BasePresenter<IStudyView, RespBean<StudyBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private StudyInteractor iStudyInteractor;
    private List<StudyFactionBean> newsList = new ArrayList<>();

    public StudyPresenter(IStudyView mView) {
        super(mView);
        iStudyInteractor = new StudyInteractor();
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
        iStudyInteractor.requestStudyList("study", this);
    }

    @Override
    public void onSuccess(RespBean<StudyBean> data, String reqTag) {
        super.onSuccess(data, reqTag);
        mView.dismissRefreshView();
        if (data.getData().getFaction() == null || data.getData().getFaction().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getFaction());
        mView.updateNewsList(this.newsList);
    }
}
