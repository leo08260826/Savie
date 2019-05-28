package com.example.savie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Intent in = getIntent();
        String add_name = in.getStringExtra("ARTICLENAME");
        if(add_name!=null){
            showToast("Finishing adding " + add_name);
        }

        ImageButton btn = (ImageButton)findViewById(R.id.feedback);
        btn.setImageResource(R.drawable.feedback);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
            }
        });
    }

    public void showToast(String text){
        Toast.makeText(FeedbackActivity.this,text,Toast.LENGTH_LONG).show();
    }
}
