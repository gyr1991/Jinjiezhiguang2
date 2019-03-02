package com.gyr.myhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestBody formBody=new FormBody.Builder().add("ip","59.108.54.37").build();
        Request request=new Request.Builder().url("http://www.baidu.com").post(formBody).build();
        OkHttpClient okHttpClient=new OkHttpClient();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("msg",call.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("msg",response.body().string());
            }
        });

    }
}
