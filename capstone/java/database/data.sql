BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION; 

INSERT INTO users(username, password_hash, role) VALUES
('Bob', 'bikeMan3000', 'ROLE_USER');

INSERT INTO user_bikes (type, bike_name, user_id, bike_weight, bike_description) VALUES
('gravel', 'Pinarello Grevel F EKAR', 3, 19.5, 'Eat dirt');

INSERT INTO activity(route_id, user_id, activity_name, activity_id, is_public, photos, description, activity_date, start_time, end_time) VALUES
(1, 3, 'pre-beer ride', 1, true, '', 'Fun ride', '09/20/2002', '07:00:00', '08:00:00');

INSERT INTO user_profile (user_id, activities, cycling_team, user_weight, user_age) VALUES
(3, 1, 'OSU', 600, 63);

INSERT INTO user_gear (user_id, misc_gear) VALUES
(3, 'Shimano RX8, Size 16');

COMMIT TRANSACTION;