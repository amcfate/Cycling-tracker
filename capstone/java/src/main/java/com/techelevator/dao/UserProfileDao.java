package com.techelevator.dao;

import com.techelevator.model.UserProfile;

public interface UserProfileDao {

    UserProfile getProfileById(int userId);

}
