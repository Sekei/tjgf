package com.ms.tjgf.mvp.curriculum.study.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.StudyFactionBean;
import com.ms.tjgf.bean.StudyStyle;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class SpinerTricksAdapter extends QuickAdapter<StudyStyle> {

    public SpinerTricksAdapter(Context context, int layoutResId, List<StudyStyle> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final StudyStyle item) {
        helper.setText(R.id.tv_name, item.getName());
    }

}
