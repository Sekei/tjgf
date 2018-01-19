package com.ms.tjgf.mvp.curriculumdetails.adapter;

import android.content.Context;

import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.curriculumdetails.bean.CommentBean;
import com.ms.tjgf.mvp.curriculumdetails.bean.CourseDetailsBean;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class CourseDetailsAdapter extends QuickAdapter<CourseDetailsBean> {

    public CourseDetailsAdapter(Context context, int layoutResId, List<CourseDetailsBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final CourseDetailsBean item) {
//        helper.setText(R.id.userName, item.getUserName());
//        helper.setText(R.id.prizeTime, item.getPrizeTime());
//        ImageView userImg = helper.getView(R.id.user_img);
//        GlideImageUtils.with(context, AppPublicUtil.getUserUrl(item.getUserId()), userImg, true);
    }

}
