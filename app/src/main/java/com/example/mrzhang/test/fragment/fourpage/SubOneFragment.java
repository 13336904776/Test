package com.example.mrzhang.test.fragment.fourpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.activity.one_one.MyCardViewActivity;
import com.example.mrzhang.test.activity.one_one.MyNotificationActivity;
import com.example.mrzhang.test.activity.one_one.MyRvActivity;
import com.example.mrzhang.test.activity.one_one.ScrollingActivity;
import com.example.mrzhang.test.fragment.BaseFragment;

/**
 *
 */
public class SubOneFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    /**
     * 第一个🎧页面
     */
    private TextView mTv;
    /**
     * 2.cardview
     */
    private TextView mCardviewTv;
    /**
     * 3.RecyclerView
     */
    private TextView mTv3;
    /**
     * 4.RecyclerView
     */
    private TextView mTv4;
    /**
     * 5.RecyclerView
     */
    private TextView mTv5;
    /**
     * 6.RecyclerView
     */
    private TextView mTv6;
    /**
     * 7.RecyclerView
     */
    private TextView mTv7;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sub_onepage, container, false);
        initView(view, null);
        initListener();
        initData();
        return view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mTv = (TextView) view.findViewById(R.id.tv);
        mTv.setOnClickListener(this);
        mCardviewTv = (TextView) view.findViewById(R.id.cardview_tv);
        mCardviewTv.setOnClickListener(this);
        mTv3 = (TextView) view.findViewById(R.id.tv3);
        mTv3.setOnClickListener(this);
        mTv4 = (TextView) view.findViewById(R.id.tv4);
        mTv4.setOnClickListener(this);
        mTv5 = (TextView) view.findViewById(R.id.tv5);
        mTv5.setOnClickListener(this);
        mTv6 = (TextView) view.findViewById(R.id.tv6);
        mTv6.setOnClickListener(this);
        mTv7 = (TextView) view.findViewById(R.id.tv7);
        mTv7.setOnClickListener(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv:
                startActivity(new Intent(getContext(), MyRvActivity.class));
                break;
            case R.id.cardview_tv:
                startActivity(new Intent(getContext(), MyCardViewActivity.class));
                break;
            case R.id.tv3:
                startActivity(new Intent(getContext(), MyNotificationActivity.class));
                break;
            case R.id.tv4:
                startActivity(new Intent(getContext(), ScrollingActivity.class));
                break;
            case R.id.tv5:
                break;
            case R.id.tv6:
                break;
            case R.id.tv7:
                break;
        }
    }
}
