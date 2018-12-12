package com.example.mrzhang.test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.adapter.MyFragmentAdapter;
import com.example.mrzhang.test.fragment.BaseFragment;
import com.example.mrzhang.test.fragment.fivepage.FiveFragment;
import com.example.mrzhang.test.fragment.fivepage.FourFragment;
import com.example.mrzhang.test.fragment.fivepage.OneFragment;
import com.example.mrzhang.test.fragment.fivepage.ThreeFragment;
import com.example.mrzhang.test.fragment.fivepage.TwoFragment;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private NavigationTabBar mNtbHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mNtbHorizontal = (NavigationTabBar) findViewById(R.id.ntb_horizontal);

        ArrayList<BaseFragment> fragments = new ArrayList<BaseFragment>();
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        FourFragment fourFragment = new FourFragment();
        FiveFragment fiveFragment = new FiveFragment();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        fragments.add(threeFragment);
        fragments.add(fourFragment);
        fragments.add(fiveFragment);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(this,getSupportFragmentManager(),fragments);
        mVp.setAdapter(myFragmentAdapter);

        final String[] colors = getResources().getStringArray(R.array.default_preview);
        ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(new NavigationTabBar.Model.Builder(
                getResources().getDrawable(R.drawable.ic_dashboard_black_24dp)
                ,Color.parseColor(colors[0]))
//                .selectedIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp))
                .title("one")
                .badgeTitle("11")
                .build()
        );
        models.add(new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_home_black_24dp)
                        ,Color.parseColor(colors[1]))
//                .selectedIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp))
                        .title("two")
                        .badgeTitle("22")
                        .build()
        );
        models.add(new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_notifications_black_24dp)
                        ,Color.parseColor(colors[2]))
//                .selectedIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp))
                        .title("three")
                        .badgeTitle("33")
                        .build()
        );
        models.add(new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_dashboard_black_24dp)
                        ,Color.parseColor(colors[3]))
//                .selectedIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp))
                        .title("four")
                        .badgeTitle("44")
                        .build()
        );
        models.add(new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_home_black_24dp)
                        ,Color.parseColor(colors[4]))
//                .selectedIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp))
                        .title("five")
                        .badgeTitle("55")
                        .build()
        );

        mNtbHorizontal.setModels(models);
        mNtbHorizontal.setViewPager(mVp,0);

        mNtbHorizontal.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                mNtbHorizontal.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        mNtbHorizontal.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mNtbHorizontal.getModels().size(); i++) {
                    final NavigationTabBar.Model model = mNtbHorizontal.getModels().get(i);
                    mNtbHorizontal.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }
}
