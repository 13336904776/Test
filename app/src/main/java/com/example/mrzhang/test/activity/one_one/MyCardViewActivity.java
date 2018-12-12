package com.example.mrzhang.test.activity.one_one;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.activity.BaseActivity;
import com.example.mrzhang.test.utils.MyToast;

public class MyCardViewActivity extends BaseActivity {

    private ImageView mIv;
    /**
     * 圆角大小
     */
    private TextView mTv1;
    private AppCompatSeekBar mSeekbar1;
    /**
     * 阴影大小
     */
    private TextView mTv2;
    private AppCompatSeekBar mSeekbar2;
    /**
     * 间距大小
     */
    private TextView mTv3;
    private AppCompatSeekBar mSeekbar3;
    /**
     * 圆角半径
     */
    private TextView mTv4;
    private AppCompatSeekBar mSeekbar4;
    /**
     * 阴影半径
     */
    private TextView mTv5;
    private AppCompatSeekBar mSeekbar5;
    private FloatingActionButton mFab;
    private CardView mCardview;



    @Override
    protected void createView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MyToast.show(MyCardViewActivity.this, "呵呵");
                            }
                        }).show();
            }
        });
    }

    @Override
    protected void initView() {

        mIv = (ImageView) findViewById(R.id.iv);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mSeekbar1 = (AppCompatSeekBar) findViewById(R.id.seekbar1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mSeekbar2 = (AppCompatSeekBar) findViewById(R.id.seekbar2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mSeekbar3 = (AppCompatSeekBar) findViewById(R.id.seekbar3);
        mTv4 = (TextView) findViewById(R.id.tv4);
        mSeekbar4 = (AppCompatSeekBar) findViewById(R.id.seekbar4);
        mTv5 = (TextView) findViewById(R.id.tv5);
        mSeekbar5 = (AppCompatSeekBar) findViewById(R.id.seekbar5);
        mCardview = (CardView) findViewById(R.id.cardview);
    }

    @Override
    protected void initListener() {
        mSeekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardview.setRadius(progress);
                mTv1.setText("圆角大小"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardview.setCardElevation(progress);
                mTv2.setText("阴影大小"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardview.setContentPadding(progress,progress,progress,progress);
                mTv3.setText("图片间距"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekbar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                mCardview.setcar(progress);
//                mTv4.setText("圆角半径"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekbar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                mCardview.setRadius(progress);
//                mTv1.setText("圆角大小"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void initData() {

    }


}
