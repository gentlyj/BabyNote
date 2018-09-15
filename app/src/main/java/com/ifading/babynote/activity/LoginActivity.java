package com.ifading.babynote.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ifading.babynote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_btn_login)
    protected Button mBtnLogin;
    @BindView(R.id.login_btn_register)
    protected Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_btn_login,R.id.login_btn_register})
    protected void onclick(View v){
        if (v == mBtnLogin){

        }else{
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }
    }
}
