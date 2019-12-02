package com.caplight.finalapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.caplight.finalapp.connectTool.DBOpenHelper;

import org.json.JSONObject;


public class LoginActivity extends Fragment implements View.OnClickListener {

    private TextView winter_temp;
    private TextView winter_condition;
    private TextView winter_update;
    private TextView winter_Dir;
    private Boolean flag=false;
    private String condition="";
    private String temp="";
    private String update="";
    private String Dir="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_login,container,false);
        initLayout(view);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = DBOpenHelper.get("/winter/getWinter");
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONObject cityObjece=jsonObject.getJSONObject("data");
                    JSONObject conditionJson=cityObjece.getJSONObject("condition");
                    Log.e("json",conditionJson.toString());
                    condition=conditionJson.get("condition").toString();
                    temp=conditionJson.get("temp").toString();
                    update=conditionJson.get("updatetime").toString();
                    Dir=conditionJson.getString("windDir")+(String)conditionJson.get("windLevel")+"级";
                    Log.e("mes",condition+temp+update+Dir);
                    flag=true;
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        while (true){
            if (flag==true){
                    winter_condition.setText(condition);
                    winter_temp.setText(temp+"°");
                    winter_Dir.setText(Dir);
                    winter_update.setText("更新时间："+update);
                break;
            }
        }
        return view;
    }

    public void initLayout(View view){
        winter_temp=view.findViewById(R.id.winter_temp);
        winter_condition=view.findViewById(R.id.winter_condition);
        winter_update=view.findViewById(R.id.winter_update);
        winter_Dir=view.findViewById(R.id.winter_Dir);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
