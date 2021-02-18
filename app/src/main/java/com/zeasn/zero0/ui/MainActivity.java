
package com.zeasn.zero0.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
import com.zeasn.zero0.databinding.ActivityMainBinding;
import com.zeasn.zero0.util.RLog;
import com.zeasn.zero0.view.MainView;
import com.zeasn.zero0.widget.NoScrollViewPager;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager supportFragmentManager;
    private ActivityMainBinding binding;
    //    @BindView(R.id.vp2Main)
    NoScrollViewPager vp2Main;

    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportFragmentManager = this.getSupportFragmentManager();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.ivAdd.setOnClickListener(v -> {
            RLog.v("You click ivAdd!!!");
        });
        binding.rbMessage.setOnClickListener(v -> {
            RLog.v("rbMessage was Clicked");
        });

        binding.rbMy.setOnClickListener(v -> {
            RLog.v("rbMy was Clicked");
        });

        binding.rbStory.setOnClickListener(v -> {
            RLog.v("rbStory was Clicked");
        });

        binding.rbTopic.setOnClickListener(v -> {
            RLog.v("rbTopic was Clicked");
        });
    }


//    @Override
//    public RootView bindRootChild() {
//        return new MainView(this);
//    }


}