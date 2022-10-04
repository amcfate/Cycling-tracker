package com.techelevator.controller;

import com.techelevator.dao.GearDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class GearController{

    @Autowired
    private GearDao gearDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/gear", method = RequestMethod.GET)
    public List<Gear> getGearByUserId(Principal principal) {
        return gearDao.getGearByUserId(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/addGear", method = RequestMethod.POST)
   // @ResponseStatus(HttpStatus.CREATED)
    public void addNewGear(@RequestBody Gear newGear, Principal principal) {
        newGear.setUserId(userDao.findIdByUsername(principal.getName()));
        gearDao.addNewGear(newGear);
    }
}
