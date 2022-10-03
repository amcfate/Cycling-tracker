package com.techelevator.model;

import java.math.BigDecimal;

public class Route {

    private int routeId;
    private String routeName;
    private String description;
    private double distanceMiles;
    private double elevation;
    private double ascent;

    public Route() { }

    public Route(int routeId, String routeName, String description, double distanceMiles, double elevation, double ascent) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.description = description;
        this.distanceMiles = distanceMiles;
        this.elevation = elevation; //What is this? So first waypoint ok
        this.ascent = ascent; //Is it the same as this?
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistanceMiles() {
        return distanceMiles;
    }

    public void setDistanceMiles(double distanceMiles) {
        this.distanceMiles = distanceMiles;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getAscent() {
        return ascent;
    }

    public void setAscent(double ascent) {
        this.ascent = ascent;
    }
}
