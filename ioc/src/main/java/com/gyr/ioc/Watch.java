package com.gyr.ioc;

import android.util.Log;

import javax.inject.Inject;

public class Watch {

    @Inject
    public Watch() {
    }

    public void work(){
        Log.e("dagger2","work");
    }
}
