package com.techelevator.dao;

import com.techelevator.model.Trackpoint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTrackpointDao implements TrackpointDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTrackpointDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Trackpoint> findAllTrackpoints() {
        List<Trackpoint> allTrackpoints = new ArrayList<>();
        String sql = "SELECT * from trackpoint";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Trackpoint trackpoint = mapRowToTrackpoint(results);
            allTrackpoints.add(trackpoint);
        }
        return allTrackpoints;
    }

    @Override
    public List<Trackpoint> findTrackpointsByRouteId(int routeId) {
        List<Trackpoint> getTrackpointsByRouteId = new ArrayList<>();
        String sql = "SELECT * from trackpoint WHERE route_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        while (results.next()) {
            Trackpoint trackpoint = mapRowToTrackpoint(results);
            getTrackpointsByRouteId.add(trackpoint);
        }

        return getTrackpointsByRouteId;
    }

    @Override
    public Trackpoint getTrackpointById(int trackpointId) {

        Trackpoint trackpoint = null;
        String sql = "SELECT * FROM trackpoint WHERE trackpoint_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trackpointId);
        while  (results.next()){
            trackpoint = mapRowToTrackpoint(results);

        } return trackpoint;

    }

    @Override
    public void addTrackpoint(Trackpoint newTrackpoint) {
        String sql = "INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES ((SELECT MAX(route_id) FROM route), ?, ?, ?)";
       /* int routeId = newTrackpoint.getRouteId(); //Substitute for routeId FK*/
        BigDecimal latitude = newTrackpoint.getLatitude();
        BigDecimal longitude = newTrackpoint.getLongitude();
        double elevation = newTrackpoint.getElevation();

        int newTrackpointId = jdbcTemplate.update(sql, latitude, longitude, elevation);
    }

    @Override
    public boolean create(int routeId, BigDecimal latitude, BigDecimal longitude, double elevation) {
        return false;
    }

    private Trackpoint mapRowToTrackpoint(SqlRowSet rs) {
        Trackpoint trackpoint = new Trackpoint();
        trackpoint.setRouteId(rs.getInt("route_id"));
        trackpoint.setTrackpointId(rs.getInt("trackpoint_id"));
        trackpoint.setLatitude(rs.getBigDecimal("latitude"));
        trackpoint.setLongitude(rs.getBigDecimal("longitude"));
        trackpoint.setElevation(rs.getDouble("elevation"));
        return trackpoint;
    }

    private int getNextTrackpointId(){
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_trackpoint_id')");
        if(nextIdResult.next()) {
            return nextIdResult.getInt(1);
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new transfer");
        }
    }


    }

