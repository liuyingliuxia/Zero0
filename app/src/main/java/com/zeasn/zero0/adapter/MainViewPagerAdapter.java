package com.zeasn.zero0.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zeasn.zero0.fragment.MessageFragment;
import com.zeasn.zero0.fragment.MyFragment;
import com.zeasn.zero0.fragment.TopicFragment;
import com.zeasn.zero0.fragment.ZeroFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    Fragment zeroF = new ZeroFragment();
    Fragment topicF = new TopicFragment();
    Fragment messageF = new MessageFragment();
    Fragment myF = new MyFragment();

    ArrayList<Fragment> mainFragmentList = new ArrayList(Arrays.asList(zeroF, topicF, messageF, myF));

    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mainFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mainFragmentList.size();
    }
}