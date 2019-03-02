package com.gyr.ioc;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    Dagger2ActivityComponent activityComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        activityComponent=DaggerDagger2ActivityComponent.builder()
                .swordsmanComponent(DaggerSwordsmanComponent.builder().build()).build();
    }

    public static App get(Context context){
        return (App) context.getApplicationContext();
    }

    public Dagger2ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
