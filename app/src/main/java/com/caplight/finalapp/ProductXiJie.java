package com.caplight.finalapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductXiJie extends AppCompatActivity {
    private String proImg="";
    private String proName="";
    private Integer proPrice=0;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_xi_jie);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("mes");
        proName=(String) bundle.get("proName");
        proPrice=(Integer) bundle.get("proPrice");
        byte[] bis = intent.getByteArrayExtra("proImg");
        bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
        ImageView product_img=findViewById(R.id.product_img);
        TextView product_name=findViewById(R.id.product_name);
        TextView product_price=findViewById(R.id.product_price);
        product_img.setImageBitmap(bitmap);
        product_name.setText(""+proName);
        product_price.setText(""+proPrice);
    }

}
