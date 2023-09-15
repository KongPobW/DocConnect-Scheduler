DROP DATABASE IF EXISTS `doc_connect`;
CREATE DATABASE `doc_connect`;

USE `doc_connect`;

DROP TABLE IF EXISTS `doc_connect`.`patient`;
CREATE TABLE `doc_connect`.`patient` (
  `UserName` VARCHAR(15) NOT NULL,
  `PatPass` VARCHAR(15) NOT NULL,
  `PatName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserName`)
);
INSERT INTO `patient` VALUES ('admin', 'admin12345', 'admin');

DROP TABLE IF EXISTS `doc_connect`.`department`;
CREATE TABLE `doc_connect`.`department` (
  `idDept` INT NOT NULL AUTO_INCREMENT,
  `Dname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDept`)
);
INSERT INTO `department` (`Dname`) VALUES ('Medicine'), ('Heart'), ('Respiratory'), ('Brain'), ('Bone'), ('Obstetric'), ('Skin'), ('Digestive');

DROP TABLE IF EXISTS `doc_connect`.`appointment`;
CREATE TABLE `doc_connect`.`appointment` (
  `AppID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Time` TIME NOT NULL,
  `UserName` VARCHAR(15),
  `Pnumber` CHAR(10) NOT NULL,
  `idDept` INT,
  PRIMARY KEY (`AppID`),
  FOREIGN KEY (`UserName`) REFERENCES `doc_connect`.`patient`(`UserName`), FOREIGN KEY (`idDept`) REFERENCES `doc_connect`.`department`(`idDept`)
);

ALTER TABLE `appointment` AUTO_INCREMENT = 1000;