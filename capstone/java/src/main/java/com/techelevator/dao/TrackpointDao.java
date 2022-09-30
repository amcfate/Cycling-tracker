package com.techelevator.dao;

import com.techelevator.model.Trackpoint;

import java.math.BigDecimal;
import java.util.List;

public interface TrackpointDao {

    List<Trackpoint> findAllTrackpoints(); //would we ever really need this? If we want to display
    //all routes? would that mess up the routes?

   List<Trackpoint> findTrackpointsByRouteId(int routeId);

   Trackpoint getTrackpointById(int trackpointId);

    boolean create(int routeId, BigDecimal latitude, BigDecimal longitude, double elevation);
    //to create a new route, you'll need to create a series of new trackpoints with the same route ID
    //not sure how to handle that, maybe when you create a route it calls this and gives all
    //the trackpoints created the same route id?

}
