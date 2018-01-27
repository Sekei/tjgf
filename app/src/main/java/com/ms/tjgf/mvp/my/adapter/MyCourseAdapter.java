package com.ms.tjgf.mvp.my.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;

import java.util.Arrays;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MyCourseAdapter extends QuickAdapter<String> {

    public MyCourseAdapter(Context context, int layoutResId) {
        super(context, layoutResId, Arrays.asList("", "", "", "", "", "", "", "", ""));
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final String item) {
        //helper.setImageUrl(R.id.course_image, item.getImage());
        helper.setText(R.id.course_name, "太极推手 - 王天琦");
        helper.setText(R.id.course_timer, "12-25 15:00");
        helper.setText(R.id.course_price, "￥50");
        helper.setText(R.id.course_loaction, "浦东新区张杨路888号");
    }

}
