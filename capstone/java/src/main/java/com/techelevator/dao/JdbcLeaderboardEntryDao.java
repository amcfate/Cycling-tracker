package com.techelevator.dao;

import com.techelevator.model.LeaderboardEntry;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcLeaderboardEntryDao implements LeaderboardEntryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcLeaderboardEntryDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<LeaderboardEntry> getLeaderboardList() {
        //need to find each users activities
        //add together their total mileage from all their activities
        //return their username and total mileage, ordered by total mileage descending
        //is this too much for sql?

        return null;
    }
}
