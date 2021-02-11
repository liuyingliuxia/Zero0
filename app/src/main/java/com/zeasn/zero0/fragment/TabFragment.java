package com.zeasn.zero0.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.lolinico.technical.open.parent.BaseFragment;
import butterknife.BindView;

/**
 * 内容形式都差不多时使用TabFragment
 */
public class TabFragment extends BaseFragment {
    int tabType = -1;
    final static String tabKey = "tabType";
//    @BindView(R.id.exhibition_layout)
//    public ExhibitionLayout mExhibitionLayout;

    public static TabFragment newInstance(int tabType) {
       TabFragment subTabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(tabKey, tabType);
        subTabFragment.setArguments(bundle);
        return subTabFragment;
    }

//    @Override
//    public void getInstanceBundle(Bundle bundle) {
//        super.getInstanceBundle(bundle);
//        tabType = bundle.getInt(tabKey);
//    }

    @Override
    public View setContent(LayoutInflater inflater) {
        return null;
    }

    @Override
    public void initView(View view) {
//        mExhibitionLayout.setPlayList(tabType);
        registerPauseListener();
    }

    @Override
    public void requestDataAction() {

    }

//    @Override
//    public void onFragmentSelected() {
//        super.onFragmentSelected();
//        if (isInitView) {
//            mExhibitionLayout.getExhibitionBannerView().startTimerTask();
//            checkNetworkData();
//        }
//    }

//    @Override
//    public void onDismissSelected() {
//        super.onDismissSelected();
//        if (isInitView)
//            mExhibitionLayout.getExhibitionBannerView().stopBannerTask();
//    }

    /**
     * 检查各控件数据情况
     */
    public void checkNetworkData() {
//        mExhibitionLayout.checkNetworkData();
    }

    /**
     * 注册生命周期
     */
    void registerPauseListener() {
//        ((MainActivity) getActivity()).setOnPauseListener(isOnPaused -> {
//            mExhibitionLayout.getExhibitionBannerView().onActivityPause(isOnPaused);
//        });
    }

    /**
     * findFocus
     *
     * @return
     */
    public boolean findFocus() {
//        if (isInitView && mExhibitionLayout != null) {
//            mExhibitionLayout.requestChildFocus();
//            return true;
//        }
        return false;
    }

    /**
     * 栏目强制向下聚焦
     */
    public void requestChildFocus() {
//        if (mExhibitionLayout != null)
//            mExhibitionLayout.requestChildFocus();
    }

    /***
     * 顶部菜单栏聚焦
     */
    public void tabNormalFocus() {
//        if (mExhibitionLayout != null)
//            mExhibitionLayout.tabNormalFocus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
