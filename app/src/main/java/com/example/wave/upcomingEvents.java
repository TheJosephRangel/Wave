package com.example.wave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class upcomingEvents extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);
        ImageView profileButton = findViewById(R.id.profileButton);
        final CustomCalendar calendar = findViewById(R.id.calendarBox);

        //calendar stuff
        HashMap<Object, Property> descHash = new HashMap<>();
        Property defaultProperty = new Property();
        defaultProperty.layoutResource = R.layout.default_view;
        defaultProperty.dateTextViewResource = R.id.calendarText;
        descHash.put("default", defaultProperty);

        //for current date
        Property currentProperty = new Property();
        currentProperty.layoutResource = R.layout.current_view;
        currentProperty.dateTextViewResource = R.id.calendarText;
        descHash.put("current", currentProperty);

        //for event date
        Property presentProperty = new Property();
        presentProperty.layoutResource = R.layout.present_view;
        presentProperty.dateTextViewResource = R.id.calendarText;
        descHash.put("event", presentProperty);
        descHash.put("event1", presentProperty);
        descHash.put("event2", presentProperty);

        //set hash variables in calendar
        calendar.setMapDescToProp(descHash);

        final HashMap<Integer, Object> dateHash = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        dateHash.put(cal.get(Calendar.DAY_OF_MONTH), "current");
        dateHash.put(30, "event");
        dateHash.put(22, "event1");
        dateHash.put(12, "event2");
        calendar.setDate(cal, dateHash);

        calendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {

                if(desc == dateHash.get(30))
                {
                    String eventDesc = "Islanders Baseball game at Chapman Field. 6:00 PM";
                    AlertDialog.Builder builder = new AlertDialog.Builder(upcomingEvents.this);
                    builder.setTitle("Event Description");
                    builder.setMessage(eventDesc);
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
                else if(desc == dateHash.get(22))
                {
                    String eventDesc1 = "Earth Day? More like Logan's Birthday";
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(upcomingEvents.this);
                    builder1.setTitle("Event Description");
                    builder1.setMessage(eventDesc1);
                    builder1.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder1.show();
                }
                else if(desc == dateHash.get(12))
                {
                    String eventDesc2 = "Battle of the Bands on East Lawn. 3:00 PM - 8:00 PM";
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(upcomingEvents.this);
                    builder2.setTitle("Event Description");
                    builder2.setMessage(eventDesc2);
                    builder2.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder2.show();
                }
                else
                {
                    Toast.makeText(upcomingEvents.this, "Nothing to see here", Toast.LENGTH_SHORT).show();
                }

            }
        });


        calendarButton.setColorFilter(Color.argb(255, 227, 208, 185));


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
                Intent intent4 = new Intent(this, eventCheckIn.class);
                startActivity(intent4);
                break;
            case R.id.profileButton:
                Intent intent5 = new Intent(this, profile.class);
                startActivity(intent5);
                break;
        }
    }
}