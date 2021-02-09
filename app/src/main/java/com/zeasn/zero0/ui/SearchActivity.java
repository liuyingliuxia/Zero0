package com.zeasn.zero0.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lolinico.technical.open.parent.BaseActivity;
import com.lolinico.technical.open.parent.RootView;
import com.zeasn.zero0.R;
public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public RootView bindRootChild() {
        return null;
    }
}