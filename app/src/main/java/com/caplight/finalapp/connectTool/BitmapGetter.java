package com.caplight.finalapp.connectTool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BitmapGetter {
    public BitmapGetter() {
    }
    //图片获取
    public Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        Log.e("url",url);
        try {
            URL aURL = new URL("http://101.201.66.127/androidImg/"+url);
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
}
