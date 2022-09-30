package com.techelevator.dao;

import com.techelevator.model.Gear;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcGearDao implements GearDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGearDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Gear getGearByUserId(int userId) {
        String sql = "SELECT * FROM user_gear WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()){
            return mapRowToGear(results);
        } else {
            return null;
        }
    }
    private Gear mapRowToGear(SqlRowSet rs){
        Gear gear = new Gear();
        gear.setUserId(rs.getInt("user_id"));
        gear.setMiscGear(rs.getString("misc_gear"));
        return gear;
    }
}
