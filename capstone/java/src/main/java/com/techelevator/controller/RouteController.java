package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.TrackpointDao;
import com.techelevator.model.Trackpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class RouteController {

    @Autowired
    private TrackpointDao trackpointDao;
    private RouteDao routeDao;

    //where do I want to route a trackpoint? you don't actually ever wants to get a trackpoint
    //by itself probably.... or do you you
    //but maybe build this method just to test that I can get a trackpoint since getRoute will
    //have to call get trackpoint? No one is ever going to know a trackpoint id or route id,
    //but if they click on a route, do I want it to give them the lat/long/elev

    @RequestMapping(value = "/gettrackpoint/{id}", method = RequestMethod.GET)
    public Trackpoint getTrackpointById (@PathVariable int id){
        return trackpointDao.getTrackpointById(id);
    }


 }


