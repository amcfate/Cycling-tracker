package com.techelevator.dao;

import com.techelevator.model.UserBike;

import java.util.List;

public interface UserBikeDao {

    List<UserBike> getBikesByUserId(int userId);

    void addNewBike(UserBike userBike);
}
