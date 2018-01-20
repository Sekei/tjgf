package com.ms.tjgf.mvp.tjcircle.match.adapter;

import android.content.Context;

import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.tjcircle.match.bean.MatchBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MatchAdapter extends QuickAdapter<MatchBean> {

    public MatchAdapter(Context context, int layoutResId, List<MatchBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final MatchBean item) {

    }

}
