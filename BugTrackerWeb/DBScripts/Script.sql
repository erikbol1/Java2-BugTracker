
GRANT ALL PRIVILEGES ON *.* TO bugtracker@localhost IDENTIFIED BY 'bugtracker'
WITH GRANT OPTION;


CREATE DATABASE IF NOT EXISTS bugtracker;

USE bugtracker;

DROP TABLE IF EXISTS bugs;
CREATE TABLE bugs(
	ID int NOT NULL AUTO_INCREMENT,
	Summary VARCHAR(250),
	Description VARCHAR(4000),
	Assignee int,
	Priority int,
	Status int,
	CreatedDate date,
	LastUpdateDate date,
	PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	ID int NOT NULL AUTO_INCREMENT,
	UserName VARCHAR(40) NOT NULL UNIQUE,
	Email VARCHAR(200),
	PasswordHash VARCHAR(256) NOT NULL,
	PRIMARY KEY (ID)
);



DROP TRIGGER IF EXISTS bug_creation_trigger;
CREATE TRIGGER bug_creation_trigger BEFORE INSERT ON bugs
FOR EACH ROW
UPDATE bugs SET NEW.CreatedDate = NOW(), NEW.LastUpdateDate = NOW();

DROP TRIGGER IF EXISTS bug_update_trigger;
CREATE TRIGGER bug_update_trigger BEFORE UPDATE ON bugs
FOR EACH ROW
UPDATE bugs SET NEW.LastUpdateDate = NOW();

DROP TABLE IF EXISTS priority;
CREATE TABLE priority(
	ID int NOT NULL,
	priority VARCHAR(20)
);


INSERT INTO priority (ID, priority) VALUES (1, 'LOW');
INSERT INTO priority (ID, priority) VALUES (2, 'MEDIUM');
INSERT INTO priority (ID, priority) VALUES (3, 'HIGH');


DROP TABLE IF EXISTS status;
CREATE TABLE status(
	ID int NOT NULL,
	status VARCHAR(20)
);


INSERT INTO status (ID, status) VALUES (1, 'OPEN');
INSERT INTO status (ID, status) VALUES (2, 'IN PROGRESS');
INSERT INTO status (ID, status) VALUES (3, 'CLOSE');
