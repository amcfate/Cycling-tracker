package com.techelevator.controller;

import com.techelevator.dao.GearDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
public class GearController{

    @Autowired
    private GearDao gearDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/gear", method = RequestMethod.GET)
    public Gear getGearByUserId(Principal principal) {
        return gearDao.getGearByUserId(userDao.findIdByUsername(principal.getName()));
    }
}
