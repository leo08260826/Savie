package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    GridView article_listview;
    String [] names;
    int [] img_shows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent in = getIntent();
        String topic = in.getStringExtra("CATEGORY");

        article_listview = (GridView) findViewById(R.id.cate_listview);
        AritcleItem DBitem = new AritcleItem(getApplicationContext());
        if(DBitem.getCount()==0){
            DBitem.sample();
        }

        List<Item> items =DBitem.getAll();

        names = new String[50];
        img_shows = new int[50];
        int k=0;
        for(int i =0;i<items.size();i++){
            if(items.get(i).getTopicname().equals(topic)){
                names[k] = items.get(i).getName();
                img_shows[k] = (int)items.get(i).getImgshow();
                k++;
            }
        }

        article_adapter adapter = new article_adapter(this,names,img_shows);
        article_listview.setAdapter(adapter);
        article_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent article_activity =  new Intent(getApplicationContext(),ArticleActivity.class);
                article_activity.putExtra("ARTICLE",names[position]);
                startActivity(article_activity);
            }
        });


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
