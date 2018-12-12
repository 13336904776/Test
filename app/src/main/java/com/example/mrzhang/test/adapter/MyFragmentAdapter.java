package com.example.mrzhang.test.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mrzhang.test.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MyFragmentAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> fragments;
    public MyFragmentAdapter(Context context,FragmentManager fm,ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public BaseFragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
