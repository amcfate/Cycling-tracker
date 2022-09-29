package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.TrackpointDao;
import com.techelevator.model.Trackpoint;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class RouteController {

    private TrackpointDao trackpointDao;
    private RouteDao routeDao;

    //where do I want to route a trackpoint? you don't actually ever wants to get a trackpoint
    //by itself probably.... or do you you
    //but maybe build this method just to test that I can get a trackpoint since getRoute will
    //have to call get trackpoint? No one is ever going to know a trackpoint id or route id,
    //but if they click on a route, do I want it to give them the lat/long/elev

//    @RequestMapping(value = "/getTrackpoint/{id}", method = RequestMethod.GET)
//    public

}
