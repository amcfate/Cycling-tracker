package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
