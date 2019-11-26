package com.caplight.finalapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.caplight.finalapp.adapter.IndexAdapter;
import com.caplight.finalapp.connectTool.DBOpenHelper;
import com.caplight.finalapp.pojo.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends Fragment implements IndexAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener
         {
    private ListView listViewLeft;
    private ListView listViewRight;
    private List<Product> productList=new ArrayList<Product>();
    private IndexAdapter indexAdapter;
    private Boolean flag=false;
    //图片Obj
    private Bitmap bimage;
    private List<Bitmap> bitmaps=new ArrayList<Bitmap>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_index,null);
         listViewLeft=view.findViewById(R.id.listViewLeft);
        listViewRight=view.findViewById(R.id.listViewRight);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = DBOpenHelper.get("/product/findAll");
                // Log.e("product",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        Product product=new Product(jsonObject.optInt("id"),jsonObject.optString("proName"),jsonObject.optInt("proPrice"),jsonObject.optString("proImg"));
                        String url="http://101.201.66.127/androidImg/"+product.getProImg();
                        bimage=getImageBitmap(url);
                        bitmaps.add(bimage);
                        productList.add(product);
                        flag=true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (true){
            if (flag==true){
                initAdapter();
                break;
            }
        }
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("id1",""+view.getId());

    }

    @Override
    public void itemClick(View v) {
        Log.d("id",""+v.getId());

    }

    //图片获取
    private  Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        Log.e("url",url);
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("TAG", "Error getting bitmap", e);
        }
        return bm;
    }
    private void initAdapter(){
        indexAdapter=new IndexAdapter(getContext(),productList,bitmaps);
        //Log.e("product","List="+productList.get(0).getProName());
        listViewLeft.setAdapter(indexAdapter);
        listViewLeft.setOnItemClickListener(this);
        listViewRight.setOnItemClickListener(this);
        listViewRight.setAdapter(indexAdapter);
    }

}
