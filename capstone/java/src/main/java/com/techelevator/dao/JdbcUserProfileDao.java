package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.UserProfile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    private UserProfile mapRowToUserProfile(SqlRowSet rs) {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(rs.getInt("user_id"));
        userProfile.setCyclingTeam(rs.getString("cyclingTeam"));
        userProfile.setUserWeight(rs.getDouble("userWeight"));
        userProfile.setUserAge(rs.getInt("userAge"));
        return userProfile;
    }
}
