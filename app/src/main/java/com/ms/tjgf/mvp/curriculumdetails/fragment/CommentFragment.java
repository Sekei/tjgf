package com.ms.tjgf.mvp.curriculumdetails.fragment;


import android.view.View;
import android.widget.RelativeLayout;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculumdetails.adapter.CommentAdapter;
import com.ms.tjgf.mvp.curriculumdetails.bean.CommentBean;
import com.ms.tjgf.widget.CustomListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论相关
 * Created by MissSekei on 2018/1/12.
 */

public class CommentFragment extends BaseFragment {

    private CustomListView mCustomListView;
    private CommentAdapter mCommentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        List<CommentBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new CommentBean("11"));
        }
        mCustomListView = view.findViewById(R.id.comment_list);
        mCommentAdapter = new CommentAdapter(getActivity(), R.layout.item_comment_list, data);
        mCustomListView.setAdapter(mCommentAdapter);
    }

}
