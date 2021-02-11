
package com.zeasn.zero0.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lolinico.technical.open.parent.BaseActivity;
import com.lolinico.technical.open.parent.BaseFragment;
import com.lolinico.technical.open.parent.RootView;
import com.zeasn.zero0.MyApplication;
import com.zeasn.zero0.R;
import com.zeasn.zero0.adapter.MainViewPagerAdapter;
import com.zeasn.zero0.bean.Type;
import com.zeasn.zero0.util.RLog;
import com.zeasn.zero0.view.MainView;
import com.zeasn.zero0.widget.NoScrollViewPager;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    public static FragmentManager supportFragmentManager;

    @BindView(R.id.vp2Main)
    NoScrollViewPager vp2Main;

    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportFragmentManager = this.getSupportFragmentManager();
    }

    @Override
    public RootView bindRootChild() {
        return new MainView(this);
    }


}