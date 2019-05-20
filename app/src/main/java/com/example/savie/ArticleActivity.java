package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    String [] names;
    int [] imgs;
    String [] contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent in = getIntent();
        int index = in.getIntExtra("ARTICLE_ID",-1);

        names = new String[]{"fruit","pancake","cake"};
        imgs = new int[]{R.drawable.friut,R.drawable.pancake,R.drawable.cake};
        contents = new String[]{"Kiwi is a great fruit!!!!","Pancake forever!!!","Cake is too sweet."};

        TextView topicView = (TextView)findViewById(R.id.article_text);
        ImageView imgView = (ImageView)findViewById(R.id.article_img);

        topicView.setText(contents[index]);
        imgView.setImageResource(imgs[index]);


        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle(names[index]);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
