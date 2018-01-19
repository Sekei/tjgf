package com.ms.tjgf.network;


import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Yang on 2018/1/19.
 */

public class RfResultHandler {
    public static Observable.Transformer<Object,RespBean> transformer = new Observable.Transformer() {
        @Override
        public Observable call(Object o) {
            return ((Observable) o)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };

    public static  <T> Observable.Transformer<RespBean, T> handleRespResult(){
        Observable.Transformer<RespBean, T> transformer = new Observable.Transformer<RespBean, T>() {
            @Override
            public Observable<T> call(Observable<RespBean> respBeanObservable) {
                return ((Observable) respBeanObservable).flatMap(new Func1<RespBean<T>, Observable<RespBean<T>>>(){
                    @Override
                    public Observable<RespBean<T>> call(RespBean<T> tRespBean) {
                        return createResp(tRespBean);
                    }
                });
            }
        };
        return transformer;
    }

    public static <T> Observable<RespBean<T>> createResp(RespBean<T> response) {
        return Observable.create(new Observable.OnSubscribe<RespBean<T>>() {
            @Override
            public void call(Subscriber<? super RespBean<T>> subscriber) {
                try {
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    public static <T> Observable.Transformer<RespBean<T>, T> handleRespDataResult() {
        return new Observable.Transformer<RespBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<RespBean<T>> respBeanObservable) {
                return ((Observable) respBeanObservable).flatMap(new Func1<RespBean<T>,Observable<T>>() {
                    @Override
                    public Observable<T> call(RespBean<T> tRespBean) {
                        return createRespData(tRespBean.getData());
                    }
                });
            }
        };
    }

    public static  <T> Observable<T> createRespData(T respBean){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(respBean);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
