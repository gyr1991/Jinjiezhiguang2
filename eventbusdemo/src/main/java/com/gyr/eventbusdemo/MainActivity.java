package com.gyr.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.squareup.otto.Bus;
//import com.squareup.otto.Subscribe;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView tv_message;
    private Button bt_message;
    private Button bt_subscription;
//private Bus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = findViewById(R.id.tv_message);
        bt_message = findViewById(R.id.bt_message);
        bt_subscription = findViewById(R.id.bt_subscription);
        tv_message.setText("MainActivity");
        bt_message.setText("跳转到SecondActivity");
        bt_subscription.setText("注册事件");
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        bt_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bus.register(MainActivity.this);
                EventBus.getDefault().register(MainActivity.this);
            }
        });
//bus=OttoBus.getInstance();

//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
//        bus.unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMoonEvent(MessageEvent messageEvent) {
        tv_message.setText(messageEvent.getMessage());
    }

//        @Subscribe
//    public void onBus(BusData busData) {
//        tv_message.setText(busData.getMessage());
//    }
}
