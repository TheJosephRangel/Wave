package com.example.wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ValueEventListener {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();

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

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        //Android Firebase Realtime database - Basic Read & Write Operation: 13 minutes in
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}