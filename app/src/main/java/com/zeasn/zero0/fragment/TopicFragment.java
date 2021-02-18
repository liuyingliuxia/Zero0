package com.zeasn.zero0.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lolinico.technical.open.parent.BaseFragment;
import com.zeasn.zero0.R;

public class TopicFragment extends BaseFragment {

    @Override
    public View setContent(LayoutInflater inflater, ViewGroup... container) {
        return inflater.inflate(R.layout.fragment_topic, null);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void requestDataAction() {

    }
}