package com.example.latestmoviesampleapp;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by piubips on 08/03/2017.
 */

public class MainApplication extends Application {
        public static RefWatcher getRefWatcher(Context context){
            MainApplication application=(MainApplication)context.getApplicationContext();
            return application.refWatcher;
        }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        refWatcher =LeakCanary.install(this);
    }
}
