BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('bob', 'bob', 'ROLE_USER');

COMMIT TRANSACTION;

BEGIN TRANSACTION; 

INSERT INTO users(username, password_hash, role) VALUES
('Bob', 'bikeMan3000', 'ROLE_USER');

INSERT INTO user_bikes (type, bike_name, user_id, bike_weight, bike_description) VALUES
('gravel', 'Pinarello Grevel F EKAR', 3, 19.5, 'Eat dirt');



INSERT INTO user_profile (user_id, username, cycling_team, user_weight, user_age) VALUES (3, 'bob', 'Avg. Joes', 180, 30);


INSERT INTO user_gear (user_id, misc_gear)
	VALUES (3, 'Shoes: Giro Empire');

INSERT INTO user_gear (user_id, misc_gear)
 	VALUES (3, 'CPU: Wahoo Bolt');

INSERT INTO user_gear (user_id, misc_gear)
 	VALUES (3, 'Saddle: Fi zik Aireon');


INSERT INTO user_profile (user_id, cycling_team, user_weight, user_age) VALUES
(3,'OSU', 600, 63);

INSERT INTO user_gear (user_id, misc_gear) VALUES
(3, 'Shimano RX8, Size 16');


COMMIT TRANSACTION;