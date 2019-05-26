package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    EditText nameInput;
    RadioGroup topicnameInput;
    EditText linkInput;
    EditText tag1Input;
    EditText tag2Input;

    String link_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent in = getIntent();
        String receiveAction = in.getAction();
        link_ = "https://default.com";
        if(receiveAction.equals(Intent.ACTION_SEND)){
            String receivedText = in.getStringExtra(Intent.EXTRA_TEXT);
            if(receivedText != null){
                link_ = receivedText;
            }
        }

        nameInput = (EditText)findViewById(R.id.input_name);
        topicnameInput = (RadioGroup)findViewById(R.id.input_topicname);
        linkInput = (EditText)findViewById(R.id.input_link);
        tag1Input = (EditText)findViewById(R.id.input_tag1);
        tag2Input = (EditText)findViewById(R.id.input_tag2);

        linkInput.setText(link_);

        Button submitButton = (Button)findViewById(R.id.input_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String link = linkInput.getText().toString();
                String tag1 = tag1Input.getText().toString();
                String tag2 = tag2Input.getText().toString();
                String topicname = "";
                switch(topicnameInput.getCheckedRadioButtonId()){
                    case R.id.input_food:
                        topicname ="food";
                        break;
                    case R.id.input_tech:
                        topicname = "technology";
                        break;
                }

                AritcleItem DBitem = new AritcleItem(getApplicationContext());
                List<Item> items =DBitem.getAll();
                Item item = new Item(0,name,topicname,link,
                        R.drawable.new2,R.drawable.new1,"#33B5E5",tag1,tag2,"This is my new article!");
                item = DBitem.insert(item);
                items.add(item);

                Intent main = new Intent(getApplicationContext(),MainActivity.class);
                main.putExtra("ARTICLENAME",name);
                startActivity(main);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("Adding Article");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
