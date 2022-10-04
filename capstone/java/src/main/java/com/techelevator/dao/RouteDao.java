package com.techelevator.dao;

import com.techelevator.model.Route;

import java.util.List;

public interface RouteDao {

    List<Route> findAllRoutes();

    Route findRouteById(int routeId);

    Route addRoute (Route newRoute);

    boolean delete(int routeId);


}
