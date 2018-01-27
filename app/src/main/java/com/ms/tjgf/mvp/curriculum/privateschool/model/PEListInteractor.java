package com.ms.tjgf.mvp.curriculum.privateschool.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.PEListPresenter;
import com.ms.tjgf.mvp.tjcircle.dynamic.persenter.DynamicListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/22.
 */

public class PEListInteractor implements IPEListInteractor {
    @Override
    public void requestPEList(HttpApiPE object, String reqTag, PEListPresenter callback) {
        NetWorks.getInstance().getPE(object, reqTag, callback);
    }
}
