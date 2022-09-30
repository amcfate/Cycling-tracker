package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.TrackpointDao;
import com.techelevator.model.NewRouteDTO;
import com.techelevator.model.NewTrackpointDTO;
import com.techelevator.model.Route;
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
    @Autowired
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

    @RequestMapping(value = "/getalltrackpoints", method = RequestMethod.GET)
    public List <Trackpoint> getAllTrackpoints(){
        return trackpointDao.findAllTrackpoints();
    }

    @RequestMapping(value = "/getallroutes", method = RequestMethod.GET)
    public List <Route> getAllRoutes(){
        return routeDao.findAllRoutes(); //getting a null pointer exception in IntelliJ when I try to get in postman
    }

    @RequestMapping(value = "/getroute/{id}", method = RequestMethod.GET)
    public Route getRouteById(@PathVariable int id) {
        return routeDao.findRouteById(id);
    }

    //POST methods

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/savetrackpoint", method = RequestMethod.POST)
    public Trackpoint createTrackpoint(@Valid @RequestBody NewTrackpointDTO newTrackpointDTO){ //what does Valid do here, or what would lack of Valid do
        Trackpoint newTrackpoint = buildTrackpointFromTrackpointDTO(newTrackpointDTO);
        newTrackpoint = trackpointDao.addTrackpoint(newTrackpoint);
        return newTrackpoint;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/saveroute", method = RequestMethod.POST)
    public Route createRoute(@Valid @RequestBody NewRouteDTO newRouteDTO){
        Route newRoute =buildRouteFromRouteDTO(newRouteDTO);
        newRoute = routeDao.addRoute(newRoute);
        return newRoute;
    }

   //Other methods

    private Trackpoint buildTrackpointFromTrackpointDTO(NewTrackpointDTO trackpointDTO){
        return new Trackpoint(trackpointDTO.getRouteId(),
                              trackpointDTO.getTrackpointId(),
                              trackpointDTO.getLatitude(),
                              trackpointDTO.getLongitude(),
                              trackpointDTO.getElevation());
    }

    private Route buildRouteFromRouteDTO(NewRouteDTO routeDTO){
        return new Route(routeDTO.getRouteId(), routeDTO.getRouteName(), routeDTO.getDescription(),
                routeDTO.getDistanceMiles(), routeDTO.getElevation(), routeDTO.getAscent());
    }


 }




