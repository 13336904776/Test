package com.example.mrzhang.test.fragment.fourpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.fragment.BaseFragment;

/**
 *
 */
public class SubThreeFragment extends BaseFragment {

    private View view;
    /**
     * 第一个🎧页面
     */
    private TextView mTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sub_threepage, container, false);
        initView(view, null);
        initListener();
        initData();
        return view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mTv = (TextView) view.findViewById(R.id.tv);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }
}
