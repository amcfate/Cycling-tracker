package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.TrackpointDao;
import com.techelevator.model.Trackpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/gettrackpoint/{id}", method = RequestMethod.GET)
    public Trackpoint getTrackpointById (@PathVariable int id){
        return trackpointDao.getTrackpointById(id);
    }

    @RequestMapping(value = "gettrackpoint/route/{id}", method = RequestMethod.GET)
    public List <Trackpoint> getTrackpointsByRouteId(@PathVariable int id) {
        return trackpointDao.findTrackpointsByRouteId(id);
    }

    @RequestMapping(value = "/gettrackpoint", method = RequestMethod.GET)
    public List <Trackpoint> getAllTrackpoints(){
        return trackpointDao.findAllTrackpoints();
    }

    //POST methods



 }




