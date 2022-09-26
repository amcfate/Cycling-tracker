BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_profile;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE user_profile (
	user_id int NOT NULL,
	activities varchar,
	cycling_team varchar,
	user_weight int,
	user_age int,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id)
);

COMMIT TRANSACTION;
