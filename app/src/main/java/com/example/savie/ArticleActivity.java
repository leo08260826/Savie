package com.example.savie;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArticleActivity extends AppCompatActivity {
    String topic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent in = getIntent();
        String article = in.getStringExtra("ARTICLE");

        AritcleItem DBitem = new AritcleItem(getApplicationContext());
        if(DBitem.getCount()==0){
            DBitem.sample();
        }
        List<Item> items =DBitem.getAll();
        for(int i =0;i<items.size();i++){
            if(items.get(i).getName().equals(article)){
                Item item = items.get(i);
                topic=item.getTopicname();
                TextView nameView = (TextView)findViewById(R.id.article_name);
                TextView topicView = (TextView)findViewById(R.id.article_text);
                ImageView imgView = (ImageView)findViewById(R.id.article_img);
                TextView tag1View = (TextView)findViewById(R.id.article_tag1);
                TextView tag2View = (TextView)findViewById(R.id.article_tag2);

                nameView.setText(item.getName());
                topicView.setText(item.getContent());
                imgView.setImageResource((int)item.getImg());
                tag1View.setText("#"+item.getTag1());
                tag2View.setText("#"+item.getTag2());

            }
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle(topic);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.other_toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
}
