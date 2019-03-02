package com.gyr.ioc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;

public class Dagger3Activity extends AppCompatActivity {
    @BindViews({R.id.tv1,R.id.tv2})
    List<TextView> tvs;
    @Nullable
    @BindView(R.id.et)
    EditText et;
    @Inject
    Watch watch;
    @Inject
    Watch2 watch2;
    @Inject
    Gson gson;
    @Inject
    Gson gson2;
    @Inject
    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);
        tvs.get(0).setText("111");
        tvs.get(1).setText("222");
        App.get(this).getActivityComponent().inject(this);
        watch.work();
        watch2.work();
        String jsonData="{'name':'gyr','age':331}";
        Person person=gson.fromJson(jsonData,Person.class);
        Log.e("dagger2","222:"+person.getName()+" "+person.getAge());
        Log.e("dagger2","333:"+car.run());
        Log.e("dagger2","比较:"+gson.hashCode()+"__"+gson2.hashCode());
    }
    @OnClick(R.id.tv1)
    public void tt1(){
        Toast.makeText(this,"11",Toast.LENGTH_SHORT).show();
    }
    @OnLongClick(R.id.tv2)
    public boolean tt2(){
        Toast.makeText(this,"22",Toast.LENGTH_SHORT).show();
        return true;
    }

    @OnTextChanged(value = R.id.et,callback =   OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void etChange(Editable s){
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show();
    }
}
