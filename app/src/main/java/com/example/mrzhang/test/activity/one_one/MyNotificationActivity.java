package com.example.mrzhang.test.activity.one_one;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mrzhang.test.R;
import com.example.mrzhang.test.activity.BaseActivity;

//任务栏通知
public class MyNotificationActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 普通Notification
     */
    private Button mBtn1;
    /**
     * 折叠Notification
     */
    private Button mBtn2;
    /**
     * 悬挂式Notification
     */
    private Button mBtn3;

    @Override
    protected void createView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_notification);

    }

    @Override
    protected void initView() {

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
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
            case R.id.btn1:
                // 获取通知服务对象NotificationManager
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // 创建Notification对象
                Notification.Builder builder = new Notification.Builder(this);
                Intent intent = new Intent(this, MyRvActivity.class);
                intent.putExtra("hehe","你收到了什么");
                PendingIntent pendingIntent = PendingIntent.getActivity(this,
                        0,//请求码
                        intent,//意图对象
                        PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setContentIntent(pendingIntent);
                builder.setContentInfo("Info...");  //
                builder.setTicker("Ticker");            // 通知弹出时状态栏的提示文本

                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                builder.setContentTitle("普通通知");// 通知标题
                builder.setContentText("通知的内容，通知的内容，通知的内容");// 通知内容
                builder.setDefaults(Notification.DEFAULT_SOUND);    // 设置声音/震动等
                // 设置通知的点击行为：自动取消/跳转等
                builder.setAutoCancel(true);
                Notification notification = builder.build();
                // 通过NotificationManager发送通知
                notificationManager.notify(1,notification);
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
        }
    }
}
