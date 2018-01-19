package com.ms.tjgf.mvp.curriculum.study.adapter;

import android.content.Context;
import android.view.View;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.friendinfo.bean.FriendInfoBean;
import com.ms.tjgf.widget.NineGridTestLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class IndicatorAdapter extends QuickAdapter<String> {
    private View mIndicator01, mIndicator02;

    public IndicatorAdapter(Context context, int layoutResId, List<String> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final String item) {
        helper.setText(R.id.indicator_title, item);
        mIndicator01 = helper.getView(R.id.indicator_line01);
        mIndicator02 = helper.getView(R.id.indicator_line02);
        if (helper.getPosition() == 0) {//一系列判断
            mIndicator01.setVisibility(View.INVISIBLE);
            mIndicator02.setVisibility(View.VISIBLE);
        } else if (helper.getPosition() == 2) {
            mIndicator01.setVisibility(View.VISIBLE);
            mIndicator02.setVisibility(View.INVISIBLE);
        }
    }

}
