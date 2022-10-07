package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;


public class Activity {

    private String routeName;
    private int userId;
    private String bikeName;
    private int activityId;

    private String activityName;
    private boolean isPublic;
    private String photos;
    private String description;
    private Date activityDate;
   // @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm")
    private LocalTime startTime;
   // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    private LocalTime endTime;

    public Activity(){}


    //constructor w/ no image
    public Activity(/*int routeId,*/ int userId, String activityName,
                    boolean isPublic, String description,
                    Date activityDate, LocalTime startTime, LocalTime endTime) {
       /* this.routeId = routeId;*/
        this.userId = userId;
       // this.bikeId = bikeId;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //constructor w/ no image
    public Activity(/*int routeId,*/ int userId, String bikeName, String activityName,
                                     boolean isPublic, String description,
                                     Date activityDate, LocalTime startTime, LocalTime endTime) {
        /* this.routeId = routeId;*/
        this.userId = userId;
        this.bikeName = bikeName;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //constructor to make activity w/ all properties
    public Activity(String routeName, int userId, int activityId, String bikeName, String activityName,
                    boolean isPublic, String photos, String description,
                    Date activityDate, LocalTime startTime, LocalTime endTime) {
        this.routeName = routeName;
        this.userId = userId;

        this.activityId = activityId;
        this.bikeName = bikeName;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.photos = photos;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Activity(String routeName, int userId, int activityId, String bikeName, String activityName,
                    boolean isPublic, String description,
                    Date activityDate, LocalTime startTime, LocalTime endTime) {
        this.routeName = routeName;
        this.userId = userId;
        this.activityId = activityId;
        this.bikeName = bikeName;
        this.activityName = activityName;
        this.isPublic = isPublic;
        this.description = description;
        this.activityDate = activityDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
