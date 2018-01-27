package com.ms.tjgf.mvp.curriculum.outdoor.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.PrivateSchoolData;

import java.util.List;


public interface IOutDoorView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<OutDoorData> newsList);
}
