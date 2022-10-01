BEGIN TRANSACTION;

INSERT INTO route (route_name, description, distance_miles, elevation, ascent) VALUES 
('Highline Canal Trail: Eisenhower Park to East Orchard Road', 'There are beautiful trees on one side of the trail and gorgeous houses on the other side. This trail starts in Denver, heads south through Cherry Hills and Greenwood Villages, and back north. There is another trailhead at the south end of the route off of Orchard Road.

Accessibility: There are 3 designated accessible spaces in the paved parking lot off of East Dartmouth Avenue at the north end of the trail. All of them are van-accessible with striped access aisles. The trail surface is pavement (with railings at bridges) or packed gravel and typically at least 5 to 8 feet wide. The estimated grade is mostly gentle (5% or less). All-terrain tires or motorized equipment may be needed for the unpaved sections. There are benches and picnic tables along the route for resting. ', '7.7', 5472, 124);

INSERT INTO route (route_name, description, distance_miles, elevation, ascent) VALUES 
('This is a test route', 'Trying to add trackpoints through Postman', '20', 200, 2000);

INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES
(1, 39.65967000, -104.938010, 1676.0);

INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES
(1, 39.64824000, -104.943390, 1676.0
);

INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES
(1, 39.63401000, -104.933960, 1678.0);

INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES
(1, 39.61702000, -104.930650, 1681.0);

INSERT INTO trackpoint (route_id, latitude, longitude, elevation) VALUES
(1, 39.60996000, -104.941380, 1680.0);

COMMIT TRANSACTION;