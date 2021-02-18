package com.zeasn.zero0.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lolinico.technical.open.parent.BaseFragment;
import com.zeasn.zero0.R;
import com.zeasn.zero0.databinding.FragmentZeroBinding;

public class ZeroFragment extends BaseFragment {

    FragmentZeroBinding binding;


    @Override
    public View setContent(LayoutInflater inflater, ViewGroup... container) {
        binding = FragmentZeroBinding.inflate(
                inflater,
                container[0],
                false);
        return binding.getRoot();
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void requestDataAction() {

    }
}