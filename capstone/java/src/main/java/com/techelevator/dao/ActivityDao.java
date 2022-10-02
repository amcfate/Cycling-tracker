package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    List<Activity> getActivitiesByUserId(int userId);

    void addNewActivity(Activity activity);

    Activity getActivityByRouteId(int routeId);

}
