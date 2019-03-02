package com.gyr.ioc;

import android.util.Log;

import javax.inject.Inject;

public class Watch2 {

    @Inject
    public Watch2() {
    }

    public void work(){
        Log.e("dagger2","work2");
    }
}
