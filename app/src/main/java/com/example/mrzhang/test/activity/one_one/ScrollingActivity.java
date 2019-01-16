package com.example.mrzhang.test.activity.one_one;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.example.mrzhang.test.R;
import com.example.mrzhang.test.adapter.OneOne1Adapter;
import com.example.mrzhang.test.bean.MyDataBean;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;


import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    private RecyclerView mRcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRcv = findViewById(R.id.rcv);
        mRcv.setLayoutManager(new LinearLayoutManager(ScrollingActivity.this));

        JSONObject object1= new JSONObject();
        ArrayList<JSONObject> arrayList1 = new ArrayList<JSONObject>();
        for (int j = 0; j < 6; j++) {
            JSONObject object = new JSONObject();
            char aa = 'A';
            ArrayList<String> arrayList = new ArrayList<String>();
            int random = (int) (1 + Math.random() * 6);
            for (int i = 0; i < random; i++) {
                arrayList.add(String.valueOf(aa++));
            }
            object.put("title", ""+(j+1));
            object.put("subdata", arrayList);
            arrayList1.add(object);
        }
        object1.put("data",arrayList1);
        Logger.e(object1.toString());

        MyDataBean myDataBean = object1.toJavaObject(MyDataBean.class);
        OneOne1Adapter oneOne1Adapter = new OneOne1Adapter(this,myDataBean);
        mRcv.setAdapter(oneOne1Adapter);

    }
}
