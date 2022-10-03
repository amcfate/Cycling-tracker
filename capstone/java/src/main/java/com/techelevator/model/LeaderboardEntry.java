package com.techelevator.model;

public class LeaderboardEntry {

    private String username;
    private double milesTotal;

    public LeaderboardEntry(String username, double milesTotal) {
        this.username = username;
        this.milesTotal = milesTotal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMilesTotal() {
        return milesTotal;
    }

    public void setMilesTotal(double milesTotal) {
        this.milesTotal = milesTotal;
    }

    //ordered list will show who is 1st etc
    //the list is going to need to display in descending order

}
