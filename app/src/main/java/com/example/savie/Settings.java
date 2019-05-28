package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.List;

public class Settings extends AppCompatActivity {

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this,  "baba!")
            .setSmallIcon(R.drawable.savieicon)
            .setContentTitle("Savie Reminder")
            .setContentText("Hey, there's is a article you must look back!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ListView listView = (ListView)findViewById(R.id.settings_listview);
        String []list = new String[]{"Notification","Game Setting","Language","Privacy","Terms","Delete All Info"};
        ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,list);
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("Settings");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.button_notify);


        button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {


                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(1, builder.build());
            }
        });

    }
}
