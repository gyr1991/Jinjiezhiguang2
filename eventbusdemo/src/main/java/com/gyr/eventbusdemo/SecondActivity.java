package com.gyr.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.squareup.otto.Bus;
//import com.squareup.otto.Produce;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_message;
    private Button bt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_message=findViewById(R.id.tv_message);
        tv_message.setText("SecondActivity");
        bt_message=findViewById(R.id.bt_message);
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("骨头来看看bbb"));
                EventBus.getDefault().post(new MessageEvent("骨头来看看aaa"));
//                OttoBus.getInstance().post(new BusData("骨头来看看2"));
                finish();
            }
        });
//        bus=OttoBus.getInstance();
//        bus.register(this);
    }

//    @Produce
//    public BusData set(){
//        return new BusData("sda");
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        bus.unregister(this);
    }

//    private Bus bus;
}
