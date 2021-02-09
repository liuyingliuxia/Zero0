package com.zeasn.zero0.view;

import android.content.Context;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.R;

public class WelcomeView extends RootView {
    public WelcomeView(Context context) {
        super(context);
    }

    @Override
    public RxPresenter bindPresenter() {
        return null;
    }

    @Override
    public int setContentId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

    }

    @Override
    public void requestDataAction() {

    }
}
