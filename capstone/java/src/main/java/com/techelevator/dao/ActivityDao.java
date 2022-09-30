package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    List<Activity> getActivitiesByUserId(int userId);

    Activity getActivityByRouteId(int routeId);

}
