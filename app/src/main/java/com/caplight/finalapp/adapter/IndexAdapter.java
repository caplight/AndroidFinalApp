package com.caplight.finalapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.caplight.finalapp.R;
import com.caplight.finalapp.pojo.Product;

import java.util.List;

public class IndexAdapter extends BaseAdapter{
     private LayoutInflater mInflater;
     private List<Product> mDatas;
     private ViewHoder viewHoder=null;
     private List<Bitmap> bitmapList;
     private InnerItemOnclickListener mListener;
    //MyAdapter需要一个Context，通过Context获得Layout.inflater，然后通过inflater加载item的布局
             public IndexAdapter(Context context, List<Product> datas,List<Bitmap> bimages) {
                 this.mInflater = LayoutInflater.from(context);
                 this.mDatas = datas;
                 this.bitmapList=bimages;
             }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
                    //初始化viewHoder
                    convertView=mInflater.inflate(R.layout.listview_leftandright,parent,false);
                    viewHoder=new ViewHoder();
                    viewHoder.listView_proimg=convertView.findViewById(R.id.listView_proimg);
                    viewHoder.listView_proname=convertView.findViewById(R.id.listView_proname);
                    viewHoder.listView_proprice=convertView.findViewById(R.id.listView_proprice);
                    convertView.setTag(viewHoder);
                    Product product=mDatas.get(position);
                    viewHoder.listView_proimg.setImageBitmap(bitmapList.get(position));
                    viewHoder.listView_proprice.setText("￥"+product.getProPrice());
                    viewHoder.listView_proname.setText(""+product.getProName());
                    viewHoder.listView_proimg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mListener.itemClick(position);
                        }
                    });
                    return convertView;
             }
    private class ViewHoder{
                 ImageView listView_proimg;
                 TextView listView_proname;
                 TextView listView_proprice;
    }

    public interface InnerItemOnclickListener {
        void itemClick(int position);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }

}
