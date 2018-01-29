package com.ms.tjgf.mvp.curriculum.study.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.StudyFactionBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class SpinerSeriesAdapter extends QuickAdapter<StudyFactionBean> {

    public SpinerSeriesAdapter(Context context, int layoutResId, List<StudyFactionBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final StudyFactionBean item) {
        helper.setText(R.id.tv_name, item.getName());
    }

}