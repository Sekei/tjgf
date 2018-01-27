package com.ms.tjgf.mvp.curriculum.master.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.MasterData;
import com.ms.tjgf.bean.OutDoorData;

import java.util.List;


public interface IMasterView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<MasterData> newsList);
}
