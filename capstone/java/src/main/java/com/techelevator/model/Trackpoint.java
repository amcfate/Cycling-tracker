package com.techelevator.model;

import java.math.BigDecimal;

public class Trackpoint {

    private int routeId;
    private int trackpointId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private double elevation;

    public Trackpoint() {}

    public Trackpoint(int routeId, int trackpointId, BigDecimal latitude, BigDecimal longitude, double elevation){
        this.routeId = routeId;
        this.trackpointId = trackpointId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getTrackpointId() {
        return trackpointId;
    }

    public void setTrackpointId(int trackpointId) {
        this.trackpointId = trackpointId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    //do I need a toString method?
}
