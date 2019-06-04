package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    GridView article_listview;
    String [] names;
    int [] img_shows;
    List<Item> items;

    String search_name;
    String search_topicname;
    String search_tag;

    EditText nameInput;
    RadioGroup topicnameInput;
    EditText tagInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        article_listview = (GridView) findViewById(R.id.search_result);
        AritcleItem DBitem = new AritcleItem(getApplicationContext());
        if(DBitem.getCount()==0){
            DBitem.sample();
        }
        items =DBitem.getAll();

//        set default
        Item last_item = items.get(items.size()-1);
        search_name = last_item.getName();
        search_topicname = last_item.getTopicname();
        search_tag = last_item.getTag1();
        nameInput = (EditText)findViewById(R.id.search_name);
        topicnameInput = (RadioGroup)findViewById(R.id.search_topicname);
        tagInput = (EditText)findViewById(R.id.search_tag);
        nameInput.setText(search_name);
        tagInput.setText(search_tag);
        RadioButton food_btn = (RadioButton)findViewById(R.id.search_food);
        RadioButton tech_btn = (RadioButton)findViewById(R.id.search_tech);
        if(last_item.getTopicname().equals("food")){
            food_btn.setChecked(true);
            tech_btn.setChecked(false);
        }
        else{
            tech_btn.setChecked(true);
            food_btn.setChecked(false);
        }

        changeSearchResult();

        nameInput.addTextChangedListener(new  TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search_name = nameInput.getText().toString();
                changeSearchResult();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        tagInput.addTextChangedListener(new  TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search_tag = tagInput.getText().toString();
                changeSearchResult();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        topicnameInput.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(topicnameInput.getCheckedRadioButtonId()){
                    case R.id.search_food:
                        search_topicname ="food";
                        break;
                    case R.id.search_tech:
                        search_topicname = "technology";
                        break;
                }
                changeSearchResult();
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("Search");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public  void changeSearchResult(){
        String pre_names[] = new String[items.size()];
        int pre_img_shows[] = new int[items.size()];
        int k=0;
        for(int i =0;i<items.size();i++){
            Item temp_item = items.get(i);
            if(
                    (temp_item.getName().equals(search_name) || search_name.equals(""))
                    && temp_item.getTopicname().equals(search_topicname)
                    && (temp_item.getTag1().equals(search_tag) || temp_item.getTag2().equals(search_tag) || search_tag.equals(""))
            ) {
                pre_names[k] = items.get(i).getName();
                pre_img_shows[k] = (int) items.get(i).getImgshow();
                k++;
            }
        }

        names = new String[k];
        img_shows = new int[k];
        for(int i=0;i<k;i++){
            names[i] = pre_names[i];
            img_shows[i] = pre_img_shows[i];
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

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
