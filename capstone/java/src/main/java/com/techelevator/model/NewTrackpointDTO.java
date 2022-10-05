package com.techelevator.model;

import java.math.BigDecimal;

public class NewTrackpointDTO {

    //are there any constraints that should go here
    private int routeId;
    private int trackpointId;
    private BigDecimal lat;
    private BigDecimal lng;
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

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }
}
