package com.ms.tjgf.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.ms.tjgf.R;
import com.ms.tjgf.bean.StudyFactionBean;
import com.ms.tjgf.mvp.curriculum.study.adapter.SpinerCoachAdapter;
import com.ms.tjgf.mvp.curriculum.study.adapter.SpinerSeriesAdapter;
import com.ms.tjgf.mvp.curriculum.study.adapter.SpinerTricksAdapter;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/19.
 */

public class SpinerPopWindow extends PopupWindow {
    private LayoutInflater inflater;
    private ListView mListView;
    private List<StudyFactionBean> newsList;
    private SpinerSeriesAdapter mSpinerPopAdapter;
    private SpinerCoachAdapter mSpinerCoachAdapter;
    private SpinerTricksAdapter mSpinerTricksAdapter;
    private Button mPrompt;
    private Context mContext;
    private int mPosition;
    private AdapterView.OnItemClickListener mClickListener;

    public SpinerPopWindow(Context context, List<StudyFactionBean> newsList, AdapterView.OnItemClickListener clickListener) {
        super(context);
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
        this.newsList = newsList;
        this.mClickListener = clickListener;
        initView();
    }

    private void initView() {
        View view = inflater.inflate(R.layout.spiner_window_layout, null);
        setContentView(view);
        mPrompt = view.findViewById(R.id.prompt);
        //设定弹出窗口容器的属性
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        // setAnimationStyle(R.style.PopupAnimation);
        mListView = view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(mClickListener);
    }

    //课程系列
    public void getStudySeries() {
        mPrompt.setText("请选择系列");
        mSpinerPopAdapter = new SpinerSeriesAdapter(mContext, R.layout.spiner_item_layout, newsList);
        mListView.setAdapter(mSpinerPopAdapter);
    }

    //课程套路
    public void getStudyTricks(int mPosition) {
        mPrompt.setText("请选择套路");
        mSpinerTricksAdapter = new SpinerTricksAdapter(mContext, R.layout.spiner_item_layout, newsList.get(mPosition).getStyle());
        mListView.setAdapter(mSpinerTricksAdapter);
        this.mPosition = mPosition;
    }

    //课程教练
    public void getStudyCoach(int position) {
        mPrompt.setText("请选择教练");
        mSpinerCoachAdapter = new SpinerCoachAdapter(mContext, R.layout.spiner_item_layout, newsList.get(mPosition).getStyle().get(position).getTeacher());
        mListView.setAdapter(mSpinerCoachAdapter);
    }

}
