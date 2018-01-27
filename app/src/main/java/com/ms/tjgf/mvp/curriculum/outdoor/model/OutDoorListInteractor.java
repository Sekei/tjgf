package com.ms.tjgf.mvp.curriculum.outdoor.model;

import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.PEListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/22.
 */

public class OutDoorListInteractor implements IOutDoorListInteractor {
    @Override
    public void requestOutDoorList(HttpApiOutDoor object, String reqTag, OutDoorListPresenter callback) {
        NetWorks.getInstance().getOutDoor(object, reqTag, callback);
    }
}
