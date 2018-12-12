package com.example.mrzhang.test.activity.one_one;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.activity.BaseActivity;
import com.example.mrzhang.test.adapter.OneOneAdapter;
import com.example.mrzhang.test.utils.DividerGridItemDecoration;
import com.example.mrzhang.test.utils.MyDecoration;

import java.util.ArrayList;
import java.util.List;

public class MyRvActivity extends BaseActivity implements View.OnClickListener, OneOneAdapter.ClikeListion {

    private RecyclerView mRcv;
    /**
     * 切换为Linner
     */
    private Button mLinnerBtn;
    /**
     * 切换为grid
     */
    private Button mGridBtn;
    /**
     * 切换为瀑布流
     */
    private Button mStaBtn;
    private MyDecoration myDecoration;
    private DividerGridItemDecoration dividerGridItemDecoration;
    private RecyclerView.ItemDecoration lastdecor;
    private EditText edt;
    private OneOneAdapter oneOneAdapter;


    @Override
    protected void createView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_rv);
    }

    @Override
    protected void initView() {

        mRcv = (RecyclerView) findViewById(R.id.rcv);
        mLinnerBtn = (Button) findViewById(R.id.linner_btn);
        mLinnerBtn.setOnClickListener(this);
        mGridBtn = (Button) findViewById(R.id.grid_btn);
        mGridBtn.setOnClickListener(this);
        mStaBtn = (Button) findViewById(R.id.sta_btn);
        mStaBtn.setOnClickListener(this);
        edt = findViewById(R.id.edt);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        List mData = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mData.add("孟晚舟");
            mData.add("在");
            mData.add("加拿大");
            mData.add("被");
            mData.add("逮捕");
        }

        myDecoration = new MyDecoration(this, MyDecoration.VERTICAL_LIST);
        dividerGridItemDecoration = new DividerGridItemDecoration(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcv.setLayoutManager(gridLayoutManager);
        mRcv.addItemDecoration(dividerGridItemDecoration);

        oneOneAdapter = new OneOneAdapter(this, mData);
        mRcv.setAdapter(oneOneAdapter);
        oneOneAdapter.setClikeListion(this);
        mRcv.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            default:
                break;
            case R.id.linner_btn:
                mRcv.removeItemDecoration(lastdecor);
                mRcv.addItemDecoration(myDecoration);
                lastdecor = myDecoration;
                mRcv.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.grid_btn:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRcv.removeItemDecoration(lastdecor);
                mRcv.addItemDecoration(dividerGridItemDecoration);
                lastdecor = dividerGridItemDecoration;
                mRcv.setLayoutManager(gridLayoutManager);
                break;
            case R.id.sta_btn:
                StaggeredGridLayoutManager staLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
                mRcv.removeItemDecoration(lastdecor);
                mRcv.addItemDecoration(dividerGridItemDecoration);
                lastdecor = dividerGridItemDecoration;
                mRcv.setLayoutManager(staLayoutManager);
                break;
        }
    }

    //单击增加数据
    @Override
    public void onClikeListion(View view, int position) {
        String addData = edt.getText().toString().trim();
        if(TextUtils.isEmpty(addData)){
            Toast.makeText(this,"请输入要增加的内容",Toast.LENGTH_SHORT).show();
            return;
        }
        oneOneAdapter.addData(addData,position);
    }
    //长按删除数据
    @Override
    public void onLongClikeListion(View view, int position) {
        oneOneAdapter.removeData(position);
    }
}
