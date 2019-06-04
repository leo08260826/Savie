package com.example.savie;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    ImageView[] puddings;
    int now;
    TextView Score;
    TextView Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ImageView pudding = (ImageView) findViewById(R.id.ThePudding);
        Score = findViewById(R.id.ScoreText);
        Number = findViewById(R.id.PuddingNumber);
        now = 0;
        puddings = new ImageView[5];
        puddings[0] = (ImageView)findViewById(R.id.pudding0);
        puddings[1] = (ImageView)findViewById(R.id.pudding1);
        puddings[2] = (ImageView)findViewById(R.id.pudding2);
        puddings[3] = (ImageView)findViewById(R.id.pudding3);
        puddings[4] = (ImageView)findViewById(R.id.pudding4);

        Button play = (Button)findViewById(R.id.play_btn);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(now <=4) {
                    puddings[now].setY(2000 - now * 60 * 2);
                    Score.setText(""+((now+1)*100));
                    Number.setText(""+ (5-now-1));
                    now++;
                }
                if(now == 5 ){
                    pudding.setVisibility(View.INVISIBLE);
                }
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
