package com.example.mrzhang.test.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mrzhang.test.fragment.BaseFragment;

import java.util.List;

/**
 *
 */
public class HomeSubFragmentAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fragments;

    public HomeSubFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments) {
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
