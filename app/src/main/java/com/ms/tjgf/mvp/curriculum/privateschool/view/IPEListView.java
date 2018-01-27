package com.ms.tjgf.mvp.curriculum.privateschool.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.PrivateSchoolData;

import java.util.List;


public interface IPEListView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<PrivateSchoolData> newsList);
}
