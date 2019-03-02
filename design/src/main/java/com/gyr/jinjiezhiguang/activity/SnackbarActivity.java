package com.gyr.jinjiezhiguang.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gyr.jinjiezhiguang.R;

public class SnackbarActivity extends AppCompatActivity {
    ConstraintLayout activity_main;
    private FloatingActionButton fab;
    Button bt_snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        activity_main=findViewById(R.id.activity_main);
        fab=findViewById(R.id.fab);
        bt_snackbar=findViewById(R.id.bt);
        bt_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showSnackbar();
            }
        });
    }

    private void showSnackbar(){
        Snackbar sb=Snackbar.make(activity_main,"睿哥",Snackbar.LENGTH_LONG);
        sb.setAction("点击看看", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackbarActivity.this,"Toast",Toast.LENGTH_SHORT).show();
            }
        });
        sb.setDuration(Snackbar.LENGTH_LONG);
        sb.show();
    }
}
