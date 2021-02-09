package com.lolinico.technical.open.parent;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Rico on 2017/8/4.
 */
public abstract class BaseFragment extends Fragment {
    public View view;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = setContent(inflater);
        unbinder = initBinder(view);
        initView(view);
        requestDataAction();
        return view;
    }

    Unbinder initBinder(View view) {
        return ButterKnife.bind(this, view);
    }

    /**
     * 设置view
     **/
    public abstract View setContent(LayoutInflater inflater);

    /**
     * 初始化界面
     **/
    public abstract void initView(View view);

    /**
     * 相关网络请求
     */
    public abstract void requestDataAction();

    @Override
    public void onDestroyView() {
        if (unbinder != null)
            unbinder.unbind();
        super.onDestroyView();
    }
}
