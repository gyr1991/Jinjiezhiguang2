package com.gyr.viewstudy;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.gyr.viewstudy.myview.CustomView;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity {
    CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        customView=findViewById(R.id.testcu);
//        customView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
//        ObjectAnimator.ofFloat(customView,"translationX",0,300).setDuration(1000).start();
//        customView.smoothScrollTo(-400,-400);
    }

    class MyAyn extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }

    }
}
