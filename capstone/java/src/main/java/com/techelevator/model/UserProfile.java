package com.techelevator.model;

public class UserProfile {

    private int id;
    private String cyclingTeam;
    private double userWeight;
    private int userAge;

    public UserProfile(){}

    public UserProfile(int id) {
        this.id = id;
    }

    public UserProfile(int id, String cyclingTeam, double userWeight, int userAge) {
        this.id = id;
        this.cyclingTeam = cyclingTeam;
        this.userWeight = userWeight;
        this.userAge = userAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCyclingTeam() {
        return cyclingTeam;
    }

    public void setCyclingTeam(String cyclingTeam) {
        this.cyclingTeam = cyclingTeam;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
