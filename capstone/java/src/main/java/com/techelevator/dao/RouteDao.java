package com.techelevator.dao;

import com.techelevator.model.Route;

import java.util.List;

public interface RouteDao {

    List<Route> findAllRoutes();

    Route findRouteById(int routeId);

    Route addRoute (Route newRoute);

    boolean create(int routeId, String routeName, String description, double distanceMiles, double elevation, double ascent);


}
