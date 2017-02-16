package com.bwei.newstitlewuxingyu.application;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by hp on 2017/2/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);// 优化Xutils 3.0
        x.Ext.setDebug(BuildConfig.DEBUG);


    }
}
