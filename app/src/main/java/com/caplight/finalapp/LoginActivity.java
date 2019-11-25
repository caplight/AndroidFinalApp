package com.caplight.finalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
   // private LoginTool loginTool;
    private  TextView userName;
    private   TextView passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //loginTool=new LoginTool();
        super.onCreate(savedInstanceState);
        //Log.e("Create","!");
        setContentView(R.layout.activity_login);
        Button loginSelect=findViewById(R.id.loginSelect);
        loginSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginSelect:{


            }
        }
    }
}
