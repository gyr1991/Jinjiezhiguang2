package com.gyr.jinjiezhiguang.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gyr.jinjiezhiguang.R;

public class TextinputlayoutActivity extends AppCompatActivity {
private TextInputLayout tl_username,tl_password;
private EditText et_password;
private Button bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);
        tl_username=findViewById(R.id.tl_username);
        tl_password=findViewById(R.id.tl_password);
        et_password=findViewById(R.id.et_password);
        bt_login=findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        String username=tl_username.getEditText().getText().toString();
        String password=et_password.getText().toString();
        if(!validateUsername(username)){
tl_username.setErrorEnabled(true);
tl_username.setError("用户名太短");
        }else if(!validateUsername(password)){
            tl_username.setErrorEnabled(false);
            tl_password.setErrorEnabled(true);
            tl_password.setError("密码太短");
        }else{
            tl_username.setErrorEnabled(false);
            tl_password.setErrorEnabled(false);
        }
    }

    private boolean validatePassword(String password){
        return password.length()>6;
    }

    private boolean validateUsername(String username){
        return username.length()>6;
    }
}
