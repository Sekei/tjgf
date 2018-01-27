package com.ms.tjgf.mvp.my.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.VideoListBean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MyGridAdapter extends QuickAdapter<String> {

    int img[] = {R.drawable.icon_kc_bg, R.drawable.icon_xc_bg, R.drawable.icon_sc_bg, R.drawable.icon_qb_bg, R.drawable.icon_cg_bg, R.drawable.icon_sz_bg, R.drawable.icon_wsjl_bg, R.drawable.icon_qk_bg, R.drawable.icon_qk_bg};

    public MyGridAdapter(Context context, int layoutResId) {
        super(context, layoutResId, Arrays.asList("", "", "", "", "", "", "", "", ""));
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final String item) {
        if (helper.getPosition() < 8) {
            helper.setImageBackground(R.id.my_img, img[helper.getPosition()]);
        } else {
            helper.setBackgroundColor(R.id.my_img, R.color.color_32323C);
        }
    }

}
