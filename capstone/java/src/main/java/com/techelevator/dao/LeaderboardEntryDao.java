package com.techelevator.dao;

import com.techelevator.model.LeaderboardEntry;

import java.util.List;

public interface LeaderboardEntryDao {

    List<LeaderboardEntry> getLeaderboardList();
}
