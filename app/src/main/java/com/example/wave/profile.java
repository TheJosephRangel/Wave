package com.example.wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class profile extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backHome = findViewById(R.id.backHome);
        Button friends = findViewById(R.id.friends);
        Button settings = findViewById(R.id.settings);

        backHome.setOnClickListener(this);
        friends.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backHome:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.friends:
                Intent intent1 = new Intent(this, friends.class);
                startActivity(intent1);
                break;
            case R.id.settings:
                Intent intent2 = new Intent(this, settings.class);
                startActivity(intent2);
                break;
        }

    }
}