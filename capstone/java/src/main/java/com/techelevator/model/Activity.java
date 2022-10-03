package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;


public class Activity {

    private int routeId;
    private int userId;
    private int activityId;

    private String activityName;
    private boolean isPublic;
    private String photos;
    private String description;
    private Date activityDate;
    private Time startTime;
    private Time endTime;

    public Activity(){}

    //constructor w/ no image
    public Activity(/*int routeId,*/ int userId,  String activityName,
                    boolean isPublic, String description,
                    Date activityDate, Time startTime, Time endTime) {
       /* this.routeId = routeId;*/
        this.userId = userId;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //constructor to make activity w/ all properties
    public Activity(int routeId, int userId, int activityId,  String activityName,
                    boolean isPublic, String photos, String description,
                    Date activityDate, Time startTime, Time endTime) {
        this.routeId = routeId;
        this.userId = userId;
        this.activityId = activityId;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.photos = photos;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Activity(int routeId, int userId, int activityId,  String activityName,
                    boolean isPublic, String description,
                    Date activityDate, Time startTime, Time endTime) {
        this.routeId = routeId;
        this.userId = userId;
        this.activityId = activityId;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }



    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
