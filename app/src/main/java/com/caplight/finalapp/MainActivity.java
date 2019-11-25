package com.caplight.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private   Button main_button;
    private Button shopcar_button;
    private Button me_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_button=findViewById(R.id.main_button);
        shopcar_button=findViewById(R.id.shopcar_button);
        me_button=findViewById(R.id.me_button);
        main_button.setOnClickListener(this);
        shopcar_button.setOnClickListener(this);
        me_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.main_button:
                main_button.setActivated(true);
                shopcar_button.setActivated(false);
                me_button.setActivated(false);

                break;
            case R.id.shopcar_button:
                shopcar_button.setActivated(true);
                me_button.setActivated(false);
                main_button.setActivated(false);
                break;
            case R.id.me_button:
                me_button.setActivated(true);
                shopcar_button.setActivated(false);
                main_button.setActivated(false);
                break;
        }
    }
}
