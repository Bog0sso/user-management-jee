USE users_jee_db;

/****** Object:  Table user    Script Date: 28/11/2022 00:28:00 UTC ******/
DROP TABLE if exists users;

CREATE TABLE users(
	userId SERIAL,
	login varchar(40),
	name varchar(40),
	lastName varchar(40),
	password varchar(40),
	CONSTRAINT pk_userId PRIMARY KEY (userId)
);

