package com.zeasn.zero0.view;

import android.content.Context;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.R;
import com.zeasn.zero0.presenter.MainPresenter;

public class MainView extends RootView {
    public MainView(Context context) {
        super(context);
    }

    @Override
    public RxPresenter bindPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int setContentId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void requestDataAction() {

    }
}
