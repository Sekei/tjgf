package com.ms.tjgf.mvp.tjcircle.dynamicdetails.persenter;

import com.ms.tjgf.MyApp;
import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.CommentBean;
import com.ms.tjgf.bean.CommentListBean;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.HttpApiComment;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.model.CommentListInteractor;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.view.ICommentListView;

import java.util.ArrayList;
import java.util.List;

/**
 * MissSekei 2018-1-22
 */
public class CommentListPresenter extends BasePresenter<ICommentListView, RespBean<CommentBean>> implements IBaseListPresenter {
    private int page = 0;
    private boolean isRefresh;
    private CommentListInteractor iCommentListInteractor;
    private List<CommentListBean> newsList = new ArrayList<>();
    private String mDynamicId;

    public CommentListPresenter(ICommentListView mView, String dynamicId) {
        super(mView);
        iCommentListInteractor = new CommentListInteractor();
        this.mDynamicId = dynamicId;
    }

    @Override
    public void requestNewsList(boolean isRefresh) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        //这里有取消请求的操作----未完待续mSubscription =
        iCommentListInteractor.requestCommentList(mDynamicId, new HttpApiComment(page, MyApp.getInstance().getToken()), "1", this);
    }

    @Override
    public void onSuccess(RespBean<CommentBean> data,String reqTag) {
        super.onSuccess(data,reqTag);
        mView.dismissRefreshView();
        if (data.getData().getList() == null || data.getData().getList().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(data.getData().getList());
        mView.updateNewsList(this.newsList);
    }
}
