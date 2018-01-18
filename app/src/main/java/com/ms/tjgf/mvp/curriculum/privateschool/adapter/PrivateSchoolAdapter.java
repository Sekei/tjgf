package com.ms.tjgf.mvp.curriculum.privateschool.adapter;

import android.content.Context;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;
import com.ms.tjgf.mvp.tjcircle.dynamic.bean.DynamicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class PrivateSchoolAdapter extends QuickAdapter<PrivateSchoolBean> {

    public PrivateSchoolAdapter(Context context, int layoutResId, List<PrivateSchoolBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final PrivateSchoolBean item) {
//        helper.setText(R.id.userName, item.getUserName());
//        helper.setText(R.id.prizeTime, item.getPrizeTime());
//        ImageView userImg = helper.getView(R.id.user_img);
//        GlideImageUtils.with(context, AppPublicUtil.getUserUrl(item.getUserId()), userImg, true);
    }

}
