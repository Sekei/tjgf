package com.ms.tjgf.mvp.friendinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.commit451.nativestackblur.NativeStackBlur;
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.friendinfo.adapter.FriendInfoAdapter;
import com.ms.tjgf.mvp.friendinfo.bean.FriendInfoBean;
import com.ms.tjgf.widget.CustomListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class FriendInfoActivity extends ActionBarActivity implements AbsListView.OnScrollListener {

    private ImageView mFriendTopImgBg;
    private ListView mListView;
    private FriendInfoAdapter mFriendInfoAdapter;

    private int headerHeight = 0;

    private View vHead;

    //修改顶部颜色值
    @Override
    protected int getStatusBarTintResource() {
        return R.color.color_0000;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;//透明top
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_friendinfo;
    }

    @Override
    protected void initView() {
        super.initView();
        mListView = findViewById(R.id.friendinfo_list);
        mListView.setOnScrollListener(this);
        vHead = View.inflate(this, R.layout.header_friendinfo_list, null);
        mFriendTopImgBg = vHead.findViewById(R.id.friend_top_img);
        Bitmap source = BitmapFactory.decodeResource(getResources(), R.drawable.user_img);
        //对Bitmap进行模糊化处理，第一个参数代表原始Bitmap，第二个参数代表模糊半径
        //半径越大，处理后的图片就越模糊
        Bitmap bm = NativeStackBlur.process(source, 65);
        mFriendTopImgBg.setImageBitmap(bm);
        //头布局放入listView中
        mListView.addHeaderView(vHead);
        List<FriendInfoBean> arr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arr.add(new FriendInfoBean("你猜"));
        }
        mFriendInfoAdapter = new FriendInfoAdapter(this, R.layout.item_friendinfo_list, arr);
        mListView.setAdapter(mFriendInfoAdapter);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE://空闲状态
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_FLING://滚动状态
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://触摸后滚动
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        View sview = mListView.getChildAt(0);
        if (null != sview) {
            int top = -(sview.getTop());
            headerHeight = sview.getHeight() - 270;
            if (top > 0 && top <= headerHeight && firstVisibleItem == 1) {
                float scale = (float) top / headerHeight;
                float alpha = (255 * scale);
                // rlTitle.getBackground().setAlpha((int) alpha);
            } else if (top == 0) {
                // rlTitle.getBackground().setAlpha(0);
            } else if (firstVisibleItem > 1) {
                // rlTitle.getBackground().setAlpha(255);
            }
        }
    }
}
