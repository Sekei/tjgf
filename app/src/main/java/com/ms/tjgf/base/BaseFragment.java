package com.ms.tjgf.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.ms.tjgf.utils.ToastUtils;
import com.ms.tjgf.widget.LoadingView;

public abstract class BaseFragment extends Fragment implements IBaseView {
    protected View view;
    private LoadingView loadingView = new LoadingView();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
            initView(view);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    protected void initView(View view) {

    }

    protected abstract int getLayoutId();

    protected View getRootView() {
        return view;
    }

    @Override
    public void showProgress() {
        loadingView.showLoading(getRootView());
    }

    @Override
    public void hideProgress() {
        loadingView.hideLoading();
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }

    public void startActivity(Class<?> cls, Object... objects) {
        Intent intent = new Intent(getActivity(), cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(getActivity(), cls);
        startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Class<?> cls, int requestCode, Object... objects) {
        Intent intent = new Intent(getActivity(), cls);
        for (int i = 0; i < objects.length; i++) {
            intent.putExtra("data_" + i, JSON.toJSONString(objects[i]));
        }
        startActivityForResult(intent, requestCode);
    }

    // 这个方法是用来取消网络请求时用的
    public Object getTAG() {
        return this;
    }

    @Override
    public void onDestroyView() {
        //HttpRequest.cancel(getTAG());// 取消网络请求
        super.onDestroyView();
    }


}
