package com.techelevator.dao;

import com.techelevator.model.Gear;

public interface GearDao {

    Gear getGearByUserId(int userId);
}
