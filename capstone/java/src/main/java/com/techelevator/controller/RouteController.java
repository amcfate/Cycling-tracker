package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.TrackpointDao;
import com.techelevator.model.NewTrackpointDTO;
import com.techelevator.model.Trackpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin



@PreAuthorize("isAuthenticated()")

public class RouteController {

    @Autowired
    private TrackpointDao trackpointDao;
    private RouteDao routeDao;

    //GET methods

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

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/savetrackpoint", method = RequestMethod.POST)
    public Trackpoint createTrackpoint(@Valid @RequestBody NewTrackpointDTO newTrackpointDTO){ //what does Valid do here, or what would lack of Valid do
        Trackpoint newTrackpoint = buildTrackpointFromTrackpointDTO(newTrackpointDTO);
        //create savetrackpoint method in Trackpoint DTO
        return newTrackpoint;
    }

   //Other methods

    private Trackpoint buildTrackpointFromTrackpointDTO(NewTrackpointDTO trackpointDTO){
        return new Trackpoint(trackpointDTO.getRouteId(),
                              trackpointDTO.getTrackpointId(),
                              trackpointDTO.getLatitude(),
                              trackpointDTO.getLongitude(),
                              trackpointDTO.getElevation());
    }


 }




