package com.example.savie;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class category_adapter extends BaseAdapter {
    LayoutInflater inflater;
    String [] topics;
    int [] imgs;

    public category_adapter(Context c, String [] t,int [] i){
        topics = t;
        imgs = i;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return topics.length;
    }

    @Override
    public Object getItem(int position) {
        return topics[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.category_listview,null);
        TextView topicView = (TextView)v.findViewById(R.id.category_listview_topic);
        ImageView imgView = (ImageView)v.findViewById(R.id.category_listview_img);
        ImageView pawView = (ImageView)v.findViewById(R.id.category_listview_paw);
        ImageView set1View = (ImageView)v.findViewById(R.id.category_listview_set1);
        ImageView set2View = (ImageView)v.findViewById(R.id.category_listview_set2);
        ImageView set3View = (ImageView)v.findViewById(R.id.category_listview_set3);

        topicView.setText(topics[position]);
        imgView.setImageResource(imgs[position]);
        pawView.setImageResource(R.drawable.paw);
        set1View.setImageResource(R.drawable.pencil);
        set2View.setImageResource(R.drawable.recycle);
        set3View.setImageResource(R.drawable.garbage);

        return v;
    }
}
