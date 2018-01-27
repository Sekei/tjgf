package com.ms.tjgf.mvp.tjcircle.dynamicdetails;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.commit451.nativestackblur.NativeStackBlur;
import com.donkingliang.labels.LabelsView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.CommentBean;
import com.ms.tjgf.bean.CommentListBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.mvp.friendinfo.adapter.FriendInfoAdapter;
import com.ms.tjgf.mvp.friendinfo.bean.FriendInfoBean;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.adapter.CommentListAdapter;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.persenter.CommentListPresenter;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.view.ICommentListView;
import com.ms.tjgf.widget.CustomListView;
import com.ms.tjgf.widget.NineGridTestLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class DynamicDetailsActivity extends ActionBarActivity implements ICommentListView {
    private DynamicData mData;
    private CustomListView mCommentList;
    private CommentListAdapter mCommentListAdapter;
    private List<CommentListBean> newsList = new ArrayList<>();
    private IBaseListPresenter iCommentListPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dynamicdetails;
    }

    @Override
    protected void initView() {
        super.initView();
        mData = getIntentObject(DynamicData.class);
        mCommentList = findViewById(R.id.comment_list);
        iCommentListPresenter = new CommentListPresenter(this, mData.getId());
        iCommentListPresenter.requestNewsList(true);
        mCommentListAdapter = new CommentListAdapter(this, R.layout.item_comment_list, newsList);
        mCommentList.setAdapter(mCommentListAdapter);
        initData();
    }

    //数据绑定
    private void initData() {
        RoundedImageView user_img = findViewById(R.id.user_img);
        Glide.with(this).load(mData.getAvatar()).into(user_img);
        TextView mNickName = findViewById(R.id.nickname);
        mNickName.setText(mData.getNickname());
        TextView mCreatedAt = findViewById(R.id.created_at);
        mCreatedAt.setText(mData.getCreated_at());
        TextView mBody = findViewById(R.id.body);
        mBody.setText(mData.getBody());
        NineGridTestLayout mNine = findViewById(R.id.layout_nine_grid);
        if (mData.getPics().length != 0) {
            mNine.setVisibility(View.VISIBLE);
            mNine.setUrlList(Arrays.asList(mData.getPics()));
        } else
            mNine.setVisibility(View.GONE);
        //标签加载
        LabelsView mLabels = findViewById(R.id.dynamic_labels);
        if (mData.getLabels_str().size() != 0 && mData.getLabels_str() != null) {
            mLabels.setVisibility(View.VISIBLE);
            mLabels.setLabels(mData.getLabels_str());
        } else
            mLabels.setVisibility(View.GONE);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<CommentListBean> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mCommentListAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iCommentListPresenter.onDestroy();
    }
}
