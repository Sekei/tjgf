package com.ms.tjgf.mvp.tjcircle.match.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.MatchBean;
import com.ms.tjgf.bean.MatchListBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MatchAdapter extends QuickAdapter<MatchListBean> {

    public MatchAdapter(Context context, int layoutResId, List<MatchListBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final MatchListBean item) {
        helper.setImageUrl(R.id.mathc_thumb, item.getThumb());
        helper.setText(R.id.mathc_name, item.getName());
        helper.setText(R.id.mathc_timer, item.getHold_time());
        helper.setText(R.id.hold_company, item.getHold_company());
    }

}
