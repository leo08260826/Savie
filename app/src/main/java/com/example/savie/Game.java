package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ImageView;
import java.util.List;

public class Game extends AppCompatActivity {
    ImageView A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        AritcleItem DBitem = new AritcleItem(getApplicationContext());
//        List <Item> items = DBitem.getAll();

        A = (ImageView) findViewById(R.id.ThePudding);

        A.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                A.setY(1500);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("Game");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
