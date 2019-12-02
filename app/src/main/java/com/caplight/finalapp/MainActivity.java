package com.caplight.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private   Button main_button;
    private Button me_button;

    private FragmentManager mFragmentMan;
    private FragmentTransaction transaction ;
    private Fragment mContent;
    private Fragment indexFragment,loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //Fragment初始化
        indexFragment=new IndexActivity();
        loginFragment=new LoginActivity();
        mFragmentMan=getSupportFragmentManager();
        transaction = mFragmentMan.beginTransaction();
        mContent=mFragmentMan.findFragmentById(R.id.Fragment1);
        transaction.add(R.id.Fragment1,indexFragment,"indexFragment");
        transaction.add(R.id.Fragment1,loginFragment,"loginFragment");
        transaction.show(indexFragment);
        transaction.hide(loginFragment);
        transaction.commit();
        main_button=findViewById(R.id.main_button);
        me_button=findViewById(R.id.me_button);
        main_button.setActivated(true);
        main_button.setOnClickListener(this);
        me_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
     /*   fragmentTransaction.add(ViewId,fragment);// 或者fragmentTransaction.replace(ViewId,fragment);
        fragmentTransaction.commit();*/
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.main_button:
                main_button.setActivated(true);
                me_button.setActivated(false);
               switchContent(loginFragment,indexFragment);
                break;
            case R.id.me_button:
                me_button.setActivated(true);
                main_button.setActivated(false);
                switchContent(indexFragment,loginFragment);
                break;
        }
    }
    //跳转Fragment
    public void switchContent(Fragment from, Fragment to) {
        transaction = mFragmentMan.beginTransaction();
        transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个

    }

}
