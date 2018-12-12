package com.example.mrzhang.test.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

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
public class SubNavigationTabStrip extends BaseActivity {

    private NavigationTabStrip mNtsTop;
    private ViewPager mVp;

    @Override
    protected void createView(Bundle savedInstanceState) {
        setContentView(R.layout.home_fragment);

    }

    @Override
    protected void initView() {

        mNtsTop = (NavigationTabStrip) findViewById(R.id.nts_top);
        mVp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mVp.setOffscreenPageLimit(1);
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new SubOneFragment());
        fragments.add(new SubTwoFragment());
        fragments.add(new SubThreeFragment());
        fragments.add(new SubFourFragment());
        HomeSubFragmentAdapter subFragmentAdapter = new HomeSubFragmentAdapter(this.getSupportFragmentManager(),fragments);
        mVp.setAdapter(subFragmentAdapter);

        mNtsTop.setViewPager(mVp,0);
        mNtsTop.setStripType(NavigationTabStrip.StripType.LINE);
        mNtsTop.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
        mNtsTop.setTabIndex(0, true);
    }

}
