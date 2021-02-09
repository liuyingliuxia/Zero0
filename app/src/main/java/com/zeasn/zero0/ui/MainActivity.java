package com.zeasn.zero0.ui;

import android.os.Bundle;

import com.lolinico.technical.open.parent.BaseActivity;
import com.lolinico.technical.open.parent.RootView;
import com.zeasn.zero0.MyApplication;
import com.zeasn.zero0.R;
import com.zeasn.zero0.view.MainView;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public RootView bindRootChild() {
        return new MainView(this);
    }


}