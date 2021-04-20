package com.example.wave;

public class RewardsHelper {
    String RewardName;
    int RewardID, RewardLocationLatitude, RewardLocationLongitude, RewardValue;

    public RewardsHelper() {
    }

    public RewardsHelper(String rewardName, int rewardID, int rewardLocationLatitude, int rewardLocationLongitude, int rewardValue) {
        RewardName = rewardName;
        RewardID = rewardID;
        RewardLocationLatitude = rewardLocationLatitude;
        RewardLocationLongitude = rewardLocationLongitude;
        RewardValue = rewardValue;
    }

    public String getRewardName() {
        return RewardName;
    }

    public void setRewardName(String rewardName) {
        RewardName = rewardName;
    }

    public int getRewardID() {
        return RewardID;
    }

    public void setRewardID(int rewardID) {
        RewardID = rewardID;
    }

    public int getRewardLocationLatitude() {
        return RewardLocationLatitude;
    }

    public void setRewardLocationLatitude(int rewardLocationLatitude) {
        RewardLocationLatitude = rewardLocationLatitude;
    }

    public int getRewardLocationLongitude() {
        return RewardLocationLongitude;
    }

    public void setRewardLocationLongitude(int rewardLocationLongitude) {
        RewardLocationLongitude = rewardLocationLongitude;
    }

    public int getRewardValue() {
        return RewardValue;
    }

    public void setRewardValue(int rewardValue) {
        RewardValue = rewardValue;
    }
}
