package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView category_listview;
    String [] topics;
    int [] imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category_listview = (ListView) findViewById(R.id.main_listview);
        topics = new String[]{"food","technology"};
        imgs = new int[]{R.drawable.food,R.drawable.tech};

        category_adapter adapter = new category_adapter(this,topics,imgs);
        category_listview.setAdapter(adapter);
        category_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent category_activity =  new Intent(getApplicationContext(),CategoryActivity.class);
                category_activity.putExtra("CATEGORY",topics[position]);
                startActivity(category_activity);
            }
        });

        Button addbtn = (Button)findViewById(R.id.button_add);
        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(add);
            }
        });

        Button searchbtn = (Button)findViewById(R.id.button_search);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent search = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(search);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.game:
                Intent game = new Intent(getApplicationContext(),Game.class);
                startActivity(game);
                break;
            case R.id.setting:
                Intent setting = new Intent(getApplicationContext(),Settings.class);
                startActivity(setting);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
