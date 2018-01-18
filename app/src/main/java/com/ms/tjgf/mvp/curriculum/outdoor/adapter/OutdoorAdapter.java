package com.ms.tjgf.mvp.curriculum.outdoor.adapter;

import android.content.Context;

import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class OutdoorAdapter extends QuickAdapter<PrivateSchoolBean> {

    public OutdoorAdapter(Context context, int layoutResId, List<PrivateSchoolBean> mData) {
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
