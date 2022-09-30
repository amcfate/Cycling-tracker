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
    public Trackpoint addTrackpoint(Trackpoint newTrackpoint) {
        
        return null;
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
}
