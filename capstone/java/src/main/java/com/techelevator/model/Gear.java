package com.techelevator.model;

public class Gear {

    private int userId;
    private String miscGear;

    public Gear(){};

    public Gear(int userId, String miscGear) {
        this.userId = userId;
        this.miscGear = miscGear;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMiscGear() {
        return miscGear;
    }

    public void setMiscGear(String miscGear) {
        this.miscGear = miscGear;
    }
}
