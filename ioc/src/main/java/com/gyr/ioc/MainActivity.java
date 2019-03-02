package com.gyr.ioc;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {
    @BindViews({R.id.tv1,R.id.tv2})
    List<TextView> tvs;
    @Nullable
    @BindView(R.id.et)
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvs.get(0).setText("111");
        tvs.get(1).setText("222");

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
