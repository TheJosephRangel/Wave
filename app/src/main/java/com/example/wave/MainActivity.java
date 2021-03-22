package com.example.wave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Test comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);


        homeButton.setOnClickListener(this);
        pointsButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        calendarButton.setOnClickListener(this);
        checkinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.homeButton:
                setContentView(R.layout.activity_main_view);
                break;
            case R.id.pointsButton:
                setContentView(R.layout.activity_points_screen);
                break;
            case R.id.chatButton:
                setContentView(R.layout.activity_chat_screen);
                break;
            case R.id.calendarButton:
                setContentView(R.layout.activity_upcoming_events);
                break;
            case R.id.checkinButton:
                setContentView(R.layout.activity_event_check_in);
                break;
        }
    }

}