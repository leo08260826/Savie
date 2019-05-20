package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {

    GridView article_listview;
    String [] names;
    int [] imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        article_listview = (GridView) findViewById(R.id.cate_listview);
        names = new String[]{"fruit","pancake","cake"};
        imgs = new int[]{R.drawable.friut,R.drawable.pancake,R.drawable.cake};

        article_adapter adapter = new article_adapter(this,names,imgs);
        article_listview.setAdapter(adapter);
        article_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent article_activity =  new Intent(getApplicationContext(),ArticleActivity.class);
                article_activity.putExtra("ARTICLE_ID",position);
                startActivity(article_activity);
            }
        });



        Intent in = getIntent();
        int index = in.getIntExtra("CATEGORY_ID",-1);
        names = new String[]{"food","technology"};

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
