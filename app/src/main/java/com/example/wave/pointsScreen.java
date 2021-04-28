package com.example.wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class pointsScreen extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rewardsRecycler;
    private List<Rewards> mRewards;
    //TextView RewardsCount = (TextView) findViewById(R.id.AvailRewardsValueTextValue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_screen);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);
        ImageView profileButton = findViewById(R.id.profileButton);

        pointsButton.setColorFilter(Color.argb(255, 225, 188, 145));

        homeButton.setOnClickListener(this);
        pointsButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        calendarButton.setOnClickListener(this);
        checkinButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);

        rewardsRecycler = (RecyclerView) findViewById(R.id.recyclerViewRewards);
        rewardsRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRewards = new ArrayList<>();

        Rewards rewards = new Rewards();
        rewards.setRewardName("Library Visit");
        rewards.setRewardLocation("Mary and Jeff Bell Library");
        rewards.setRewardValue("5");
        mRewards.add(rewards);

        Rewards rewards1 = new Rewards();
        rewards1.setRewardName("PAC Visit");
        rewards1.setRewardLocation("Performing Arts Center");
        rewards1.setRewardValue("10");
        mRewards.add(rewards1);

        Rewards rewards2 = new Rewards();
        rewards2.setRewardName("Advisor Visit");
        rewards2.setRewardLocation("University Center");
        rewards2.setRewardValue("25");
        mRewards.add(rewards2);

        Rewards rewards3 = new Rewards();
        rewards3.setRewardName("Chick-Fil-A");
        rewards3.setRewardLocation("University Center");
        rewards3.setRewardValue("15");
        mRewards.add(rewards3);

        Rewards rewards4 = new Rewards();
        rewards4.setRewardName("Center for Instruction Visit");
        rewards4.setRewardLocation("Center for Instruction");
        rewards4.setRewardValue("10");
        mRewards.add(rewards4);

        Rewards rewards5 = new Rewards();
        rewards5.setRewardName("Starbucks Visit");
        rewards5.setRewardLocation("Starbucks");
        rewards5.setRewardValue("20");
        mRewards.add(rewards5);

        Rewards rewards6 = new Rewards();
        rewards6.setRewardName("Dining Hall Visit");
        rewards6.setRewardLocation("Dining Hall");
        rewards6.setRewardValue("30");
        mRewards.add(rewards6);

        Rewards rewards7 = new Rewards();
        rewards7.setRewardName("Bay Hall Visit");
        rewards7.setRewardLocation("Bay Hall");
        rewards7.setRewardValue("10");
        mRewards.add(rewards7);

        Rewards rewards8 = new Rewards();
        rewards8.setRewardName("Welcome Center Visit");
        rewards8.setRewardLocation("Welcome Center");
        rewards8.setRewardValue("25");
        mRewards.add(rewards8);

        Rewards rewards9 = new Rewards();
        rewards9.setRewardName("Rec Center Visit");
        rewards9.setRewardLocation("Recreation Center");
        rewards9.setRewardValue("35");
        mRewards.add(rewards9);

        Rewards rewards10 = new Rewards();
        rewards10.setRewardName("Island Hall Visit");
        rewards10.setRewardLocation("Island Hall");
        rewards10.setRewardValue("10");
        mRewards.add(rewards10);

        Rewards rewards11 = new Rewards();
        rewards11.setRewardName("Student Services Center Visit");
        rewards11.setRewardLocation("Student Services Center");
        rewards11.setRewardValue("5");
        mRewards.add(rewards11);

        rewardsRecycler.setAdapter(new RewardAdapter(mRewards));

        String ListCountSize = String.valueOf(mRewards.size());
        System.out.println(ListCountSize);
        //RewardsCount.setText(ListCountSize);
    }

    class RewardAdapter extends RecyclerView.Adapter<RewardViewHolder>{
        List<Rewards> mRewards;
        public RewardAdapter(List<Rewards> rewards) {
            super();
            this.mRewards = rewards;
        }

        @NonNull
        @Override
        public RewardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RewardViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RewardViewHolder holder, int position) {
            holder.bind(this.mRewards.get(position));
        }

        @Override
        public int getItemCount() {
            return this.mRewards.size();
        }
    }

    class RewardViewHolder extends RecyclerView.ViewHolder{
        private TextView RewardName;
        private TextView RewardLocation;
        private TextView RewardValue;
        public RewardViewHolder(ViewGroup container){
            super(LayoutInflater.from(pointsScreen.this).inflate(R.layout.reward_tile, container, false));
            RewardName = (TextView) itemView.findViewById(R.id.RewardsTitle);
            RewardLocation = (TextView) itemView.findViewById(R.id.RewardsLocation);
            RewardValue = (TextView) itemView.findViewById(R.id.RewardValue);
        }
        public void bind(Rewards reward){
            RewardName.setText(reward.getRewardName());
            RewardLocation.setText(reward.getRewardLocation());
            RewardValue.setText(reward.getRewardValue());
        }
    }

    class Rewards{
        private String rewardName, rewardLocation;
        private String rewardValue;

        public String getRewardName() {
            return rewardName;
        }

        public void setRewardName(String rewardName) {
            this.rewardName = rewardName;
        }

        public String getRewardLocation() {
            return rewardLocation;
        }

        public void setRewardLocation(String rewardLocation) {
            this.rewardLocation = rewardLocation;
        }

        public String getRewardValue() {
            return rewardValue;
        }

        public void setRewardValue(String rewardValue) {
            this.rewardValue = rewardValue;
        }
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