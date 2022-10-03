BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('bob', 'bob', 'ROLE_USER');

COMMIT TRANSACTION;

BEGIN TRANSACTION; 

INSERT INTO users(username, password_hash, role) VALUES
('Bob', 'bikeMan3000', 'ROLE_USER');

INSERT INTO user_bikes (type, bike_name, user_id, bike_weight, bike_description) VALUES
('gravel', 'Pinarello Grevel F EKAR', 3, 19.5, 'I am too slow to deserve a bike like this');

INSERT INTO user_profile (user_id, username, cycling_team, user_weight, user_age) VALUES (3, 'bob', 'Avg. Joes', 180, 30);
INSERT INTO activity();

INSERT INTO user_profile ( ) VALUES
( );

INSERT INTO user_gear (user_id, misc_gear)
	VALUES (3, 'Shoes: Giro Empire');

INSERT INTO user_gear (user_id, misc_gear)
 	VALUES (3, 'CPU: Wahoo Bolt');

INSERT INTO user_gear (user_id, misc_gear)
 	VALUES (3, 'Saddle: Fi zik Aireon');


COMMIT TRANSACTION;