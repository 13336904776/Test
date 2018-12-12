package com.example.mrzhang.test.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrzhang.test.R;


public class MyToast {

    /**
     * 展示toast==LENGTH_SHORT
     *
     * @param msg
     */
    Context mContext;
//    public static void show(Context mContext,String msg) {
//        show(mContext,msg, Toast.LENGTH_SHORT);
//    }

    public static void show(Context mContext,String msg) {
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示toast==LENGTH_LONG
     *
     * @param msg
     */
    public static void showLong(Context mContext,String msg) {
        show(mContext,msg, Toast.LENGTH_LONG);
    }


    private static void show(Context mContext,String massage, int show_length) {
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(mContext).inflate(R.layout.mytoast_layout, null);
        //获取TextView
        TextView title =  view.findViewById(R.id.message_tv);
        //设置显示的内容
        title.setText(massage);
        Toast toast = new Toast(mContext);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 70);
        //设置显示时间
        toast.setDuration(show_length);

        toast.setView(view);
        toast.show();
    }
}
