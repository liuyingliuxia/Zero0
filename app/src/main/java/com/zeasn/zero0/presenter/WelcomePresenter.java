package com.zeasn.zero0.presenter;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.util.RLog;
import com.zeasn.zero0.view.WelcomeView;

public class WelcomePresenter extends RxPresenter {
    public WelcomePresenter(RootView rootView) {
        super(rootView);
    }

    public void getMainPost() {
        mRootView.postDelayed(() -> ((WelcomeView) mRootView).jumpToMainActivity(), 1000);
        RLog.v("WelcomePresenter =====> 启动MainActivity");
    }
}
