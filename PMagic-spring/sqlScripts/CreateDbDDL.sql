create schema pmagicdb;
use pmagicdb;


-- users_tab create
CREATE TABLE users_tab (
  `empId` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `isSuperCEO` bit NOT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE Employee_tbl (
  `empId` BIGINT(20) NOT NULL,
  `firstName` varchar(30),
  `lastName` varchar(30),
  `hourRate` DECIMAL(5,2) NOT NULL, -- maxWage = 999.99
  `hiredWhen` DATETIME DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;