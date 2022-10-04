package com.techelevator.model;

public class UserBike {
    private int bikeId;
    private int userId;
    private String type;
    private String bikeName;
    private double bikeWeight;
    private String bikeDescription;

    public UserBike(){};

    public UserBike(int bikeId, int userId, String type,
                    String bikeName, double bikeWeight, String bikeDescription) {
        this.bikeId = bikeId;
        this.userId = userId;
        this.type = type;
        this.bikeName = bikeName;
        this.bikeWeight = bikeWeight;
        this.bikeDescription = bikeDescription;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBikeDescription() {
        return bikeDescription;
    }

    public void setBikeDescription(String bikeDescription) {
        this.bikeDescription = bikeDescription;
    }

    public double getBikeWeight() {
        return bikeWeight;
    }

    public void setBikeWeight(double bikeWeight) {
        this.bikeWeight = bikeWeight;
    }
}
