BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_profile, user_gear, user_bikes, activity, route, trackpoint CASCADE;

DROP SEQUENCE IF EXISTS seq_trackpoint_id, seq_route_id;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE user_profile (
	user_id int NOT NULL,
	username varchar(50),
	cycling_team varchar,
	user_weight int,
	user_age int,
	photo varchar,
	CONSTRAINT FK_user_profile FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_profile_username FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE user_gear (
    gear_id SERIAL NOT NULL,
	user_id int NOT NULL,
	misc_gear varchar,
	CONSTRAINT PK_gear_id PRIMARY KEY (gear_id),
	CONSTRAINT FK_user_gear FOREIGN KEY (user_id) REFERENCES users (user_id)
	
);

CREATE TABLE user_bikes (
	bike_id SERIAL NOT NULL,
	user_id int,
	type varchar,
	bike_name varchar,
	bike_weight decimal,
	bike_description varchar,
	CONSTRAINT PK_bike PRIMARY KEY (bike_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE SEQUENCE seq_route_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE route (
	route_id SERIAL,
	route_name varchar,
	description varchar,
	distance_miles decimal,
	elevation int,
	ascent decimal,
	CONSTRAINT PK_route PRIMARY KEY (route_id) 
);

CREATE SEQUENCE seq_trackpoint_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;
  
CREATE TABLE trackpoint (
	route_id int,
	trackpoint_id SERIAL,
	latitude decimal,
	longitude decimal,
	elevation decimal,
	CONSTRAINT PK_trackpoint PRIMARY KEY (trackpoint_id), 
	CONSTRAINT FK_route_id FOREIGN KEY (route_id) REFERENCES route (route_id)
);

CREATE TABLE activity (
    activity_id SERIAL NOT NULL,
	route_id int,
	user_id int,
	activity_name varchar,
	is_public boolean,
	photos varchar,
	description varchar,
	activity_date date DEFAULT CURRENT_DATE,
	start_time time,
	end_time time,

    CONSTRAINT PK_activity PRIMARY KEY (activity_id),

	CONSTRAINT FK_activity_route FOREIGN KEY (route_id) REFERENCES route (route_id),
	CONSTRAINT FK_activity_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
