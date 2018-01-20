package com.ms.tjgf.mvp.tjcircle.ranking.adapter;

import android.content.Context;

import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.tjcircle.match.bean.MatchBean;
import com.ms.tjgf.mvp.tjcircle.ranking.bean.RankingBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class RankingAdapter extends QuickAdapter<RankingBean> {

    public RankingAdapter(Context context, int layoutResId, List<RankingBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final RankingBean item) {

    }

}
