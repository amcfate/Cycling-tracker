package com.techelevator.dao;

import com.techelevator.model.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcActivityDao implements ActivityDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Activity> getActivitiesByUserId(int userId) {
        String sql = "SELECT * FROM activity WHERE user_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Activity> activityList = new ArrayList<>();
        while (results.next()){
            Activity activity = mapRowToActivity(results);
            activityList.add(activity);
        }
        return activityList;
    }

    @Override
    public void addNewActivity(Activity activity) {
        String sql = "INSERT INTO activity (route_id, user_id, activity_name, " +
                "is_public, description, activity_date, start_time, end_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, activity.getRouteId(), activity.getUserId(),
                activity.getActivityName(), activity.isPublic(),
                activity.getDescription(), activity.getActivityDate(),
                activity.getStartTime(), activity.getEndTime());
    }

    @Override
    public Activity getActivityByRouteId(int routeId) {
        return null;
    }

    private Activity mapRowToActivity(SqlRowSet rs){
        Activity activity = new Activity();
        activity.setRouteId(rs.getInt("route_id"));
        activity.setUserId(rs.getInt("user_id"));
        activity.setActivityName(rs.getString("activity_name"));
        activity.setActivityId(rs.getInt("activity_id"));
        activity.setPublic(rs.getBoolean("is_public"));
        activity.setPhotos(rs.getString("photos"));
        activity.setDescription(rs.getString("description"));
        activity.setActivityDate(rs.getDate("activity_date"));
        activity.setStartTime(rs.getTime("start_time").toLocalTime());
        activity.setEndTime(rs.getTime("end_time").toLocalTime());
        return activity;
    }
}
