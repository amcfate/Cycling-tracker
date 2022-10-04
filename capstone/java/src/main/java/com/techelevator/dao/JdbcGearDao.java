package com.techelevator.dao;

import com.techelevator.model.Gear;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGearDao implements GearDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGearDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Gear> getGearByUserId(int userId) {
        String sql = "SELECT * FROM user_gear WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Gear> gearList = new ArrayList<>();
        while (results.next()){
            gearList.add(mapRowToGear(results));
        }
        return gearList;
    }

    @Override
    public void addNewGear(Gear gear) {
        String sql = "INSERT INTO user_gear (user_id, misc_gear) VALUES (?, ?)";
        jdbcTemplate.update(sql, gear.getUserId(), gear.getMiscGear());
    }

    private Gear mapRowToGear(SqlRowSet rs){
        Gear gear = new Gear();
        gear.setUserId(rs.getInt("user_id"));
        gear.setMiscGear(rs.getString("misc_gear"));
        return gear;
    }
}
