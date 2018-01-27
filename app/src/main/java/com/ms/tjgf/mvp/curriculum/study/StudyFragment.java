package com.ms.tjgf.mvp.curriculum.study;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.StudyFactionBean;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.mvp.curriculum.study.persenter.StudyPresenter;
import com.ms.tjgf.mvp.curriculum.study.view.IStudyView;
import com.ms.tjgf.utils.ToastUtils;
import com.ms.tjgf.widget.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/**
 * 太极自修课
 * Created by MissSekei on 2018/1/12.
 */

public class StudyFragment extends BaseFragment implements IStudyView, OnDismissListener, OnItemClickListener, View.OnClickListener {
    private SpinerPopWindow mSpinerPopWindow;
    private Button mStudyName, mStudyCoach, mStudyTricks;
    private View mSpinerPopSeries, mSpinerPopTricks, mSpinerPopCoach, indicator_line, indicator_linetwo;
    private int index = 0;//记录当前选中的
    private List<StudyFactionBean> newsList = new ArrayList<>();
    private IBaseListPresenter iStudyPresenter;
    private TextView mSecondSteps, mThirdSteps;
    private RecordSelectionBean mSelection = new RecordSelectionBean();


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
        mSpinerPopSeries = view.findViewById(R.id.spiner_pop_series);
        mSpinerPopTricks = view.findViewById(R.id.spiner_pop_tricks);
        mSpinerPopCoach = view.findViewById(R.id.spiner_pop_coach);
        mSecondSteps = view.findViewById(R.id.second_steps);//第二步
        indicator_line = view.findViewById(R.id.indicator_line);
        mThirdSteps = view.findViewById(R.id.third_steps);//第三步
        indicator_linetwo = view.findViewById(R.id.indicator_linetwo);
        iStudyPresenter = new StudyPresenter(this);
        iStudyPresenter.requestNewsList(true);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<StudyFactionBean> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mSpinerPopWindow = new SpinerPopWindow(getActivity(), newsList, this);
        mSpinerPopWindow.setOnDismissListener(this);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iStudyPresenter.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.study_series:
                index = 0;
                if (newsList.size() != 0) {
                    mSpinerPopWindow.setWidth(mStudyName.getWidth());
                    mSpinerPopWindow.showAsDropDown(mSpinerPopSeries);
                    mSpinerPopWindow.getStudySeries();
                    //重新选择套路/选择教练（且不可点击）
                    mStudyTricks.setText("请选择套路");
                    mStudyCoach.setText("请选择教练");
                    mStudyCoach.setEnabled(false);
                }
                break;
            case R.id.study_tricks:
                index = 1;
                if (newsList.get(mSelection.getSeriesposition()).getStyle().size() != 0) {
                    mSpinerPopWindow.setWidth(mStudyName.getWidth());
                    mSpinerPopWindow.showAsDropDown(mSpinerPopTricks);
                    mSpinerPopWindow.getStudyTricks(mSelection.getSeriesposition());
                    //重新赋值，请选择教练
                    mStudyCoach.setText("请选择教练");
                } else {
                    ToastUtils.show("暂无对应套路");
                }
                break;
            case R.id.study_coach:
                index = 2;
                if (newsList.get(mSelection.getSeriesposition()).getStyle().get(mSelection.getTricksposition()).getTeacher().size() != 0) {
                    mSpinerPopWindow.setWidth(mStudyName.getWidth());
                    mSpinerPopWindow.showAsDropDown(mSpinerPopCoach);
                    mSpinerPopWindow.getStudyCoach(mSelection.getTricksposition());
                } else {
                    ToastUtils.show("暂无对应教练");
                }
                break;
        }
    }

    /**
     * 监听popupwindow取消
     */
    @Override
    public void onDismiss() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mSpinerPopWindow.dismiss();
        if (index == 0) {
            //记录当前选中item下标
            mSelection.setSeriesposition(position);
            mStudyName.setText(newsList.get(position).getName());
            //线变色，且套路可以选择
            mSecondSteps.setTextColor(getResources().getColor(R.color.colorWhite));
            mSecondSteps.setBackgroundResource(R.drawable.bg_rect_ffbe1a);
            indicator_line.setBackgroundColor(getResources().getColor(R.color.color_FFBE1A));
            mStudyTricks.setEnabled(true);
            mStudyTricks.setTextColor(getResources().getColor(R.color.color_EAEAEA));
        } else if (index == 1) {
            mSelection.setTricksposition(position);
            mStudyTricks.setText(newsList.get(mSelection.getSeriesposition()).getStyle().get(position).getName());
            //线变色，第三步可以选择
            mThirdSteps.setTextColor(getResources().getColor(R.color.colorWhite));
            mThirdSteps.setBackgroundResource(R.drawable.bg_rect_ffbe1a);
            indicator_linetwo.setBackgroundColor(getResources().getColor(R.color.color_FFBE1A));
            mStudyCoach.setEnabled(true);
            mStudyCoach.setTextColor(getResources().getColor(R.color.color_EAEAEA));
        } else {
            mSelection.setCoachposition(position);
            mStudyCoach.setText(newsList.get(mSelection.getSeriesposition()).getStyle().get(mSelection.getTricksposition()).getTeacher().get(position).getName());
        }
    }
}
