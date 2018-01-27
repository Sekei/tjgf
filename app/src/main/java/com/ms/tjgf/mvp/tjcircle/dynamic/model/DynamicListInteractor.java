package com.ms.tjgf.mvp.tjcircle.dynamic.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.dynamic.persenter.DynamicListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/22.
 */

public class DynamicListInteractor implements IDynamicListInteractor {
    @Override
    public void requestDynamicList(HttpListBean object, String reqTag, DynamicListPresenter callback) {
        NetWorks.getInstance().getDynamic(object, reqTag, callback);
    }
}
