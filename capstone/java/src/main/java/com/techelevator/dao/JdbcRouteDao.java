package com.techelevator.dao;

import com.techelevator.model.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRouteDao implements RouteDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRouteDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Route> findAllRoutes() {
    List<Route> allRoutes = new ArrayList<>();
    String sql = "SELECT * FROM route";

    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
    while (results.next()) {
        Route route = mapRowToRoute(results);
        allRoutes.add(route);
    }
        return allRoutes;
    }

    @Override
    public Route findRouteById(int routeId) {
        Route route = null;
        return null;
    }

    @Override
    public Route addRoute(Route newRoute) {
        return null;
    }

    @Override
    public boolean create(int routeId, String routeName, String description, double distanceMiles, double elevation, double ascent) {
        return false;
    }

    private Route mapRowToRoute(SqlRowSet rs) {
        Route route = new Route();
        route.setRouteId(rs.getInt("route_id"));
        route.setRouteName(rs.getString("route_name"));
        route.setDescription(rs.getString("description"));
        route.setDistanceMiles(rs.getDouble("distance_miles"));
        route.setElevation(rs.getDouble("elevation"));
        route.setAscent(rs.getInt("ascent"));
        return route;
    }
    private int getNextRouteId(){
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_route_id')");
        if(nextIdResult.next()) {
            return nextIdResult.getInt(1);
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new transfer");
        }
    }

}

