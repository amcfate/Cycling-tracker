package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserProfileDao;
import com.techelevator.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserProfileController {

    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public UserProfile getProfile(Principal principal){
        return userProfileDao.getProfileById(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/updateProfile", method = RequestMethod.POST)
    public void updateUserProfile(@RequestBody UserProfile userProfile, Principal principal) {
        userProfile.setUserId(userDao.findIdByUsername(principal.getName()));
        userProfileDao.updateUserProfile(userProfile);
    }

}
