package com.caplight.finalapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.caplight.finalapp.connectTool.DBOpenHelper;

import org.json.JSONArray;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = DBOpenHelper.get("/product/findAll");
                Log.e("product",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    Log.e("json",""+jsonArray.get(0).toString());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
