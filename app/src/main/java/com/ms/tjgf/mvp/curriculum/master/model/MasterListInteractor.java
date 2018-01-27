package com.ms.tjgf.mvp.curriculum.master.model;

import com.ms.tjgf.mvp.curriculum.master.HttpApiMaster;
import com.ms.tjgf.mvp.curriculum.master.persenter.MasterListPresenter;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/22.
 */

public class MasterListInteractor implements IMasterListInteractor {
    @Override
    public void requestMasterList(HttpApiMaster object, String reqTag, MasterListPresenter callback) {
        NetWorks.getInstance().getMaster(object, reqTag, callback);
    }
}
