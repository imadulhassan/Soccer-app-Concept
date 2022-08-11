package com.soccer.application;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.facebook.FacebookSdk;
import com.soccer.network.RetrofitClientt;


public class MyApp extends Application {

    public static RetrofitClientt server;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        server= RetrofitClientt.getInstance();

    }


    @Override
    public ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
    }
}
