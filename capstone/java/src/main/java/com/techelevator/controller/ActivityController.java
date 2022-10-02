package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import com.techelevator.model.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/activity", method = RequestMethod.GET)
    public List<Activity> getActivitiesByUserId(Principal principal){
        return activityDao.getActivitiesByUserId(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/addActivity", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewGear(@RequestBody Activity newActivity) {
        activityDao.addNewActivity(newActivity);
    }

}
