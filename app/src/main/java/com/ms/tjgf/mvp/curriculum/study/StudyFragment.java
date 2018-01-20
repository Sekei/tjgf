package com.ms.tjgf.mvp.curriculum.study;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.widget.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.PopupWindow.OnDismissListener;

/**
 * 太极自修课
 * Created by MissSekei on 2018/1/12.
 */

public class StudyFragment extends BaseFragment implements OnDismissListener, OnItemClickListener, View.OnClickListener {
    private SpinerPopWindow<String> mSpinerPopWindow;
    private List<String> list;
    private Button mStudyName, mStudyCoach;
    private Button mStudyTricks;
    private int index = 0;//记录当前选中的

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mStudyName = view.findViewById(R.id.study_series);
        mStudyName.setOnClickListener(this);
        mStudyTricks = view.findViewById(R.id.study_tricks);
        mStudyTricks.setOnClickListener(this);
        mStudyCoach = view.findViewById(R.id.study_coach);
        mStudyCoach.setOnClickListener(this);

        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("test:" + i);
        }
        mSpinerPopWindow = new SpinerPopWindow<>(getActivity(), list, this);
        mSpinerPopWindow.setOnDismissListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.study_series:
                index = 0;
                mStudyName.setBackgroundResource(R.drawable.btn_rect_22_top_434351);
                mSpinerPopWindow.setWidth(mStudyName.getWidth());
                mSpinerPopWindow.showAsDropDown(mStudyName);
                setTextImage(R.drawable.icon_up);
                break;
            case R.id.study_tricks:
                index = 1;
                mStudyTricks.setBackgroundResource(R.drawable.btn_rect_22_top_434351);
                mSpinerPopWindow.setWidth(mStudyTricks.getWidth());
                mSpinerPopWindow.showAsDropDown(mStudyTricks);
                setTextImage(R.drawable.icon_up);
                break;
            case R.id.study_coach:
                index = 2;
                mStudyCoach.setBackgroundResource(R.drawable.btn_rect_22_top_434351);
                mSpinerPopWindow.setWidth(mStudyCoach.getWidth());
                mSpinerPopWindow.showAsDropDown(mStudyCoach);
                setTextImage(R.drawable.icon_up);
                break;
        }
    }

    /**
     * 监听popupwindow取消
     */
    @Override
    public void onDismiss() {
        if (index == 0) {
            mStudyName.setBackgroundResource(R.drawable.btn_rect_43_434351);
        } else if (index == 1) {
            mStudyTricks.setBackgroundResource(R.drawable.btn_rect_43_434351);
        } else {
            mStudyCoach.setBackgroundResource(R.drawable.btn_rect_43_434351);
        }
        setTextImage(R.drawable.icon_down);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mSpinerPopWindow.dismiss();
        if (index == 0) {
            mStudyName.setText(list.get(position));
        } else if (index == 1) {
            mStudyTricks.setText(list.get(position));
        } else {
            mStudyCoach.setText(list.get(position));
        }
    }

    /**
     * 给TextView右边设置图片
     *
     * @param resId
     */
    private void setTextImage(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        if (index == 0) {
            mStudyName.setCompoundDrawables(null, null, drawable, null);
        } else if (index == 1) {
            mStudyTricks.setCompoundDrawables(null, null, drawable, null);
        } else {
            mStudyCoach.setCompoundDrawables(null, null, drawable, null);
        }
    }
}
