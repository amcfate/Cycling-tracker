package com.techelevator.dao;

import com.techelevator.model.Gear;

import java.util.List;

public interface GearDao {

    List<Gear> getGearByUserId(int userId);

    void addNewGear(Gear gear);
}
