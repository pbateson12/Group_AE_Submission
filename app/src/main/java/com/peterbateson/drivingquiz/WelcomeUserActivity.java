package com.peterbateson.drivingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class WelcomeUserActivity extends AppCompatActivity {

    private Button mStartButton;
    private Button mSignOutButton;
    private String mPreviousScore;
    private TextView mPreviousScoreTextView;
    private TextView mHighScoreView;
    private int mUserHighScore;

    private void showHighScores(){
        mPreviousScoreTextView = (TextView)findViewById(R.id.previous_score);
        mPreviousScoreTextView.setText(mPreviousScore);

        mHighScoreView = (TextView)findViewById(R.id.highScoreTextView);
        mHighScoreView.setText(Integer.toString(mUserHighScore));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        mPreviousScore = getIntent().getStringExtra("previousScore");
        mUserHighScore = getIntent().getIntExtra("highScore", 0);

        String username = getIntent().getStringExtra("Username");
        TextView welcomeUsername = (TextView)findViewById(R.id.welcomeUsername);
        welcomeUsername.setText(username);


        mStartButton =(Button)findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Start = new Intent(WelcomeUserActivity.this, QuizActivity.class);
                startActivity(Start);
            }
        });

        mSignOutButton =(Button)findViewById(R.id.sign_out_button);
        mSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignOut = new Intent(WelcomeUserActivity.this, WelcomeActivity.class);
                startActivity(SignOut);
            }
        });

        showHighScores();

    }

}
