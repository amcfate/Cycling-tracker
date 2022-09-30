package com.techelevator.model;

import java.math.BigDecimal;

public class NewTrackpointDTO {

    //are there any constraints that should go here
    private int routeId;
    private int trackpointId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private double elevation;

    //isValidTrackpointType?

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
}
