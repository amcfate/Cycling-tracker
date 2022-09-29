package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserProfileDao;
import com.techelevator.model.UserProfile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserProfileController {

    private UserProfileDao userProfileDao;
    private UserDao userDao;
/*
    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public UserProfile getProfile(Principal principal){
        return userProfileDao.getProfileById(userDao.findIdByUsername(principal.getName()));
    }*/

}
