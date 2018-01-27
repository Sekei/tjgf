package com.ms.tjgf.base;

import com.ms.tjgf.retrofit.callback.RequestCallback;

import org.reactivestreams.Subscription;


/**
 * MissSekei 基于mvp
 * 2018-1-22
 */
public class BasePresenter<V extends IBaseView, T> implements RequestCallback<T> {
    protected Subscription mSubscription;
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void onDestroy() {
//        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
//            mSubscription.unsubscribe();
//        }
        mView = null;
    }

    @Override
    public void onBefore() {
        mView.showProgress();
    }

    @Override
    public void onCompleted() {
        mView.hideProgress();
    }

    @Override
    public void onSuccess(T data,String reqTag) {
        mView.hideProgress();
    }

    /**
     * onError统一在这里处理
     */
    @Override
    public void onError(Throwable throwable) {
//        if (throwable instanceof HttpException) {
//            try {
//                ResponseBody responseBody = ((HttpException) throwable).response().errorBody();
//                String errorbody = responseBody.string();
//                if (!TextUtils.isEmpty(errorbody)) {
//                    // TODO: 这里处理放在errorbody中的错误信息
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
