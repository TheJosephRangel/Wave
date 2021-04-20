package com.example.wave;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.net.URL;
import java.util.regex.Pattern;

public class eventCheckIn extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_check_in);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);
        ImageView profileButton = findViewById(R.id.profileButton);

        Button btnQR = findViewById(R.id.btnQR);
        Button btnLocation = findViewById(R.id.btnLocation);

        checkinButton.setColorFilter(Color.argb(255, 227, 208, 185));


        homeButton.setOnClickListener(this);
        pointsButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        calendarButton.setOnClickListener(this);
        checkinButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);

        btnQR.setOnClickListener(this);
        btnLocation.setOnClickListener(this);

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
                Intent intent4 = new Intent(this, eventCheckIn.class);
                startActivity(intent4);
                break;
            case R.id.profileButton:
                Intent intent5 = new Intent(this, profile.class);
                startActivity(intent5);
                break;
            case R.id.btnQR:
                IntentIntegrator intInt = new IntentIntegrator(eventCheckIn.this);
                intInt.setPrompt("Use Volume Up Key for Flash");
                intInt.setBeepEnabled(true);
                intInt.setOrientationLocked(true);
                intInt.setCaptureActivity(Capture.class);
                intInt.initiateScan();
                break;
            case R.id.btnLocation:
                Intent intent6 = new Intent(this, location.class);
                startActivity(intent6);
                break;
        }
    }
    // function to check if QR result is a link
    public static boolean checkURL(CharSequence input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(input).matches();
        if (!isURL) {
            String urlString = input + "";
            if (URLUtil.isNetworkUrl(urlString)) {
                try {
                    new URL(urlString);
                    isURL = true;
                } catch (Exception e) {
                }
            }
        }
        return isURL;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intRes = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(intRes.getContents() != null)
        {
            checkURL(intRes.getContents());
            AlertDialog.Builder builder = new AlertDialog.Builder(eventCheckIn.this);
            builder.setTitle("Result");
            builder.setMessage(intRes.getContents());
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Oops...Didn't get a solid read on that, buddy", Toast.LENGTH_SHORT).show();
        }

    }
}