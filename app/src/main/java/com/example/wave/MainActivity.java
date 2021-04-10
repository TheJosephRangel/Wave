package com.example.wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Test comment
    Connection connect;
    String ConnectionResults = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);
        ImageView profileButton = findViewById(R.id.profileButton);

        homeButton.setColorFilter(Color.argb(255, 227, 208, 185));


        homeButton.setOnClickListener(this);
        pointsButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        calendarButton.setOnClickListener(this);
        checkinButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeButton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pointsButton:
                Intent intent1 = new Intent(this, pointsScreen.class);
                startActivity(intent1);
                break;
            case R.id.chatButton:
                Intent intent2 = new Intent(this, chatScreen.class);
                startActivity(intent2);
                break;
            case R.id.calendarButton:
                Intent intent3 = new Intent(this, upcomingEvents.class);
                startActivity(intent3);
                break;
            case R.id.checkinButton:
                Intent intent4 = new Intent(this, location.class);
                startActivity(intent4);
                break;
            case R.id.profileButton:
                Intent intent5 = new Intent(this, profile.class);
                startActivity(intent5);
                break;
        }
    }

    //@Override
    public void TestSQLData(View v)
    {
        TextView homePageText = (TextView) findViewById(R.id.textView3);

        try {
            SQLConnection connectionHelper = new SQLConnection();
            connect = connectionHelper.CONN();
            if(connect!=null)
            {
                String query = "Select * from Rewards";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next())
                {
                    homePageText.setText(rs.getString(1));
                }
            }
        }
        catch (Exception e){

        }
    }



}