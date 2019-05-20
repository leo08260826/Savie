package com.example.savie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class article_adapter extends BaseAdapter {
    LayoutInflater inflater;
    String [] names;
    int [] imgs;

    public article_adapter(Context c, String [] t, int [] i){
        names = t;
        imgs = i;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.article_listview,null);
        TextView topicView = (TextView)v.findViewById(R.id.atricle_listview_text);
        ImageView imgView = (ImageView)v.findViewById(R.id.article_listview_img);

        topicView.setText(names[position]);
        imgView.setImageResource(imgs[position]);

        return v;
    }
}
