package com.techelevator.dao;

import com.techelevator.model.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
        String sql = "SELECT * FROM route WHERE route_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        while (results.next()){
            route = mapRowToRoute(results);
        }
        return route;
    }

    @Override
    public Route addRoute(Route newRoute) {
       String sql = "INSERT INTO route (route_id, route_name, description, distance_miles, elevation, ascent) VALUES (?, ?, ?, ?, ?, ?)";
       int newRouteId = getNextRouteId();
       String routeName = newRoute.getRouteName();
       String routeDescription = newRoute.getDescription();
       double distanceMiles = newRoute.getDistanceMiles();
       double elevation = newRoute.getElevation();
       double ascent = newRoute.getAscent();

        jdbcTemplate.update(sql, newRouteId, routeName, routeDescription, distanceMiles, elevation, ascent);

   return findRouteById(newRouteId);

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
        route.setAscent(rs.getDouble("ascent"));
        return route;
    }
    private int getNextRouteId(){
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_route_id')");
        if(nextIdResult.next()) {
            return nextIdResult.getInt(1); //I don't want it to start at 1 though if I have
            //hard-coded data in there... should I have hard-coded data  in there?
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new route");
        }
    }

}

