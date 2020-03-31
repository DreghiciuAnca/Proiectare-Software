CREATE DATABASE `temaPS2`;
use `temaPS2`;

CREATE TABLE `Employee` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Product` (
	`produsId` INT NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`produsId`)
);

CREATE TABLE `Bug` (
	`BugId` INT NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`details` VARCHAR(255) NOT NULL,
	`progress` VARCHAR(255),
	`status` VARCHAR(255),
    `screenshot` binary DEFAULT NULL,
	`assignedTo` INT NOT NULL,
	`priority` INT,
	`idThread` INT NOT NULL,
	`idEmployee` INT NOT NULL,
	`idProduct` INT NOT NULL,
	PRIMARY KEY (`BugId`)
);

CREATE TABLE `BugThread` (
	`id` INT NOT NULL,
	`comment` VARCHAR(255),
	`idEmployee` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Bug` ADD CONSTRAINT `Bug_fk0` FOREIGN KEY (`idThread`) REFERENCES `BugThread`(`id`);

ALTER TABLE `Bug` ADD CONSTRAINT `Bug_fk1` FOREIGN KEY (`idEmployee`) REFERENCES `Employee`(`id`);

ALTER TABLE `Bug` ADD CONSTRAINT `Bug_fk2` FOREIGN KEY (`idProduct`) REFERENCES `Product`(`produsId`);

ALTER TABLE `BugThread` ADD CONSTRAINT `BugThread_fk0` FOREIGN KEY (`idEmployee`) REFERENCES `Employee`(`id`);

INSERT INTO `Employee` VALUES (1,'first','first@email.com','pass1'),(2,'second','second@email.com','pass2');
 
INSERT INTO `Product` VALUES (1,'product1'),(2,'product2');

INSERT INTO `Bug` VALUES (1,'bug1','dsadf','almost done', 'status', NULL, 1, 5, 1, 1,1),(2,'bug2','fjkss','ready', 'status', NULL, 2, 3, 2, 2,1);

INSERT INTO `BugThread` VALUES (1,'comment1',1),(2,'comment2',2);

