package com.example.mrzhang.test.fragment.fivepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.adapter.HomeSubFragmentAdapter;
import com.example.mrzhang.test.fragment.BaseFragment;
import com.example.mrzhang.test.fragment.fourpage.SubFourFragment;
import com.example.mrzhang.test.fragment.fourpage.SubOneFragment;
import com.example.mrzhang.test.fragment.fourpage.SubThreeFragment;
import com.example.mrzhang.test.fragment.fourpage.SubTwoFragment;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.ArrayList;

/**
 *
 */
public class OneFragment extends BaseFragment {

    private TextView tv;
    private View view;
    private NavigationTabStrip mNtsTop;
    private ViewPager mVp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.home_fragment, container, false);
        initView(inflate, null);
        initListener();
        initData();
        return inflate;

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mNtsTop = (NavigationTabStrip) view.findViewById(R.id.nts_top);
        mVp = (ViewPager) view.findViewById(R.id.vp);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        mVp.setOffscreenPageLimit(4);
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new SubOneFragment());
        fragments.add(new SubTwoFragment());
        fragments.add(new SubThreeFragment());
        fragments.add(new SubFourFragment());
        HomeSubFragmentAdapter subFragmentAdapter = new HomeSubFragmentAdapter(getChildFragmentManager(),fragments);
        mVp.setAdapter(subFragmentAdapter);

        mNtsTop.setViewPager(mVp,0);
        mNtsTop.setStripType(NavigationTabStrip.StripType.LINE);
        mNtsTop.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
        mNtsTop.setTabIndex(0, true);
    }
}
