package com.zeasn.zero0.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.R;
import com.zeasn.zero0.presenter.WelcomePresenter;
import com.zeasn.zero0.ui.MainActivity;
import com.zeasn.zero0.ui.MainNavActivity;

public class WelcomeView extends RootView {
    public WelcomeView(Context context) {
        super(context);
    }

    @Override
    public RxPresenter bindPresenter() {
        return new WelcomePresenter(this);
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
        ((WelcomePresenter) mPresenter).getMainPost();
    }

    public void jumpToMainActivity(){
        mContext.startActivity(new Intent(mContext , MainNavActivity.class));
        ((Activity) mContext).finish();
    }
}
