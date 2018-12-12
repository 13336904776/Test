package com.example.mrzhang.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 *
 */
public abstract class BaseFragment extends Fragment {
    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initData();
}
