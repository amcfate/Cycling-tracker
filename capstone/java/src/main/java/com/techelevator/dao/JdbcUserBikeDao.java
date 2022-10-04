package com.techelevator.dao;

import com.techelevator.model.Activity;
import com.techelevator.model.UserBike;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserBikeDao implements UserBikeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserBikeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserBike> getBikesByUserId(int userId) {
        String sql = "SELECT * FROM user_bikes WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<UserBike> userBikeList = new ArrayList<>();
        while (results.next()){
            UserBike userBike = mapRowToUserBike(results);
            userBikeList.add(userBike);
        }
        return userBikeList;
    }

    @Override
    public void addNewBike(UserBike userBike) {
        String sql = "INSERT INTO user_bikes (user_id, type," +
                " bike_name, bike_weight, bike_description) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userBike.getUserId(), userBike.getType(),
                userBike.getBikeName(), userBike.getBikeWeight(),
                userBike.getBikeDescription());
    }

    private UserBike mapRowToUserBike(SqlRowSet rs){
        UserBike userBike = new UserBike();
        userBike.setBikeId(rs.getInt("bike_id"));
        userBike.setUserId(rs.getInt("user_id"));
        userBike.setType(rs.getString("type"));
        userBike.setBikeName(rs.getString("bike_name"));
        userBike.setBikeWeight(rs.getDouble("bike_weight"));
        userBike.setBikeDescription(rs.getString("bike_description"));
        return userBike;
    }
}
