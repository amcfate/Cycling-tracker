package com.techelevator.controller;

import com.techelevator.dao.UserBikeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.UserBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class UserBikeController {

    @Autowired
    private UserBikeDao userBikeDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/bikes", method = RequestMethod.GET)
    public List<UserBike> getBikesByUserId(Principal principal) {
        return userBikeDao.getBikesByUserId(userDao.findIdByUsername(principal.getName()));
    }
}
