package com.techelevator.dao;

import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.UserProfile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcUserProfileDao implements UserProfileDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserProfile getProfileById(int userId) {
        String sql = "SELECT * FROM user_profile WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToUserProfile(results);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public boolean create(int id, String username) {
        String sql = "INSERT INTO user_profile(user_id, username) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql, id, username) == 1;
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        String sql = " UPDATE user_profile SET cycling_team = ?, user_age = ?, photo = ?" +
                "WHERE user_id = ?";
        jdbcTemplate.update(sql, userProfile.getCyclingTeam(), userProfile.getUserAge(),
                userProfile.getPhoto(), userProfile.getUserId());
    }

    private UserProfile mapRowToUserProfile(SqlRowSet rs) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(rs.getInt("user_id"));
        userProfile.setUsername(rs.getString("username"));
        userProfile.setCyclingTeam(rs.getString("cycling_team"));
        userProfile.setUserWeight(rs.getDouble("user_weight"));
        userProfile.setUserAge(rs.getInt("user_age"));
        userProfile.setPhoto(rs.getString("photo"));
        return userProfile;
    }
}
