package com.example.rathana.notification_demo;

import android.app.Application;

import com.example.rathana.notification_demo.util.NotificationHelper;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationHelper.createNotificationChannel(this);
    }
}
