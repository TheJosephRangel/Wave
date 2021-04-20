package com.example.wave;

public class UserHelper {
    String FirstName, LastName, Password, UserName;
    int RewardPointsAcquired;

    public UserHelper() {
    }

    public UserHelper(String firstName, String lastName, String password, String userName, int rewardPointsAcquired) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        UserName = userName;
        RewardPointsAcquired = rewardPointsAcquired;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getRewardPointsAcquired() {
        return RewardPointsAcquired;
    }

    public void setRewardPointsAcquired(int rewardPointsAcquired) {
        RewardPointsAcquired = rewardPointsAcquired;
    }
}
