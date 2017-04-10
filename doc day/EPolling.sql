-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.49-1ubuntu8.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema EPolling
--

CREATE DATABASE IF NOT EXISTS EPolling;
USE EPolling;

--
-- Definition of table `EPolling`.`AreaMaster`
--

DROP TABLE IF EXISTS `EPolling`.`AreaMaster`;
CREATE TABLE  `EPolling`.`AreaMaster` (
  `AreaId` int(11) NOT NULL AUTO_INCREMENT,
  `AreaName` varchar(30) NOT NULL,
  `SubWardId` int(11) NOT NULL,
  PRIMARY KEY (`AreaId`),
  KEY `FK_AreaMaster_SubWardId` (`SubWardId`),
  CONSTRAINT `constraint_subwardmaster_fk` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`),
  CONSTRAINT `FK_AreaMaster_SubWardId` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`AreaMaster`
--

/*!40000 ALTER TABLE `AreaMaster` DISABLE KEYS */;
LOCK TABLES `AreaMaster` WRITE;
INSERT INTO `EPolling`.`AreaMaster` VALUES  (1,'Yogichowk',2),
 (2,'Chikuwadi',2),
 (3,'Chowpati',2),
 (4,'FULPADA',4),
 (5,'PURVI',4),
 (6,'katar area',6);
UNLOCK TABLES;
/*!40000 ALTER TABLE `AreaMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`CandidateMaster`
--

DROP TABLE IF EXISTS `EPolling`.`CandidateMaster`;
CREATE TABLE  `EPolling`.`CandidateMaster` (
  `CandidateId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `Sex` bit(1) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `PhoneNo` varchar(20) NOT NULL,
  `ZoneId` int(11) DEFAULT NULL,
  `WardId` int(11) DEFAULT NULL,
  `SubWardId` int(11) DEFAULT NULL,
  `PartyId` int(11) DEFAULT NULL,
  `AreaId` int(11) DEFAULT NULL,
  `Image` varchar(300) NOT NULL,
  `isActive` bit(1) NOT NULL,
  PRIMARY KEY (`CandidateId`),
  KEY `FK_CandidateMaster_PartyId` (`PartyId`),
  KEY `FK_CandidateMaster_WardId` (`WardId`),
  KEY `FK_CandidateMaster_AreaId` (`AreaId`),
  KEY `FK_CandidateMaster_SubWardId` (`SubWardId`),
  KEY `FK_CandidateMaster_ZoneId` (`ZoneId`),
  CONSTRAINT `constraint_areamaster_candidate_fk` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_partymaster_candidate_fk` FOREIGN KEY (`PartyId`) REFERENCES `PartyMaster` (`PartyId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_subwardmaster_candidate_fk` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_wardmaster_candidate_fk` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_zonemaster_candidate_fk` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_CandidateMaster_AreaId` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`),
  CONSTRAINT `FK_CandidateMaster_PartyId` FOREIGN KEY (`PartyId`) REFERENCES `PartyMaster` (`PartyId`),
  CONSTRAINT `FK_CandidateMaster_SubWardId` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`),
  CONSTRAINT `FK_CandidateMaster_WardId` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`),
  CONSTRAINT `FK_CandidateMaster_ZoneId` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`CandidateMaster`
--

/*!40000 ALTER TABLE `CandidateMaster` DISABLE KEYS */;
LOCK TABLES `CandidateMaster` WRITE;
INSERT INTO `EPolling`.`CandidateMaster` VALUES  (5,'Milan','Mendpara','milan@yahoo.com','2011-06-01','INDIAN',0x01,'Surat','8000046176',2,1,2,2,3,'2page-img1_51924.jpg',0x01),
 (6,'Rahul','Solanki','rahul@yahoo.com','2011-06-02','INDIAN',0x01,'Surat','9909509800',2,1,2,1,3,'2page-img1_51924.jpg',0x01),
 (7,'Vivek','Sarvaiya','vivek@yahoo.com','2011-06-21','INDIAN',0x01,'Surat','9898989898',2,1,2,1,3,'2page-img1_51924.jpg',0x01),
 (8,'chintan','sarvaiya','chintan@yahoo.com','1990-05-07','INDIAN',0x01,'Surat','9925399999',2,1,2,2,3,'2page-img1_51924.jpg',0x01),
 (9,'jisan','polara','jisan@yahoo.com','1990-07-07','INDIAN',0x01,'Surat','9323234545',2,1,2,2,3,'2page-img1_51924.jpg',0x01),
 (10,'raj','tamakuwala','raj@yahoo.com','1990-02-14','INDIAN',0x01,'Surat','9121212121',2,1,2,3,3,'2page-img1_51924.jpg',0x01),
 (11,'anuja','vaidya','anuja@yahoo.com','2011-01-05','INDIAN',0x01,'Surat','9898989897',2,1,2,4,3,'2page-img1_51924.jpg',0x01),
 (12,'sonu','trapasiya','sonu@yahoo.com','2011-05-14','INDIAN',0x00,'Surat','9898989897',2,1,2,3,3,'2page-img1_51924.jpg',0x01),
 (13,'krinjal','navsariwala','krinity@yahoo.com','1990-05-11','INDIAN',0x00,'Surat','9909664264',2,1,2,3,3,'2page-img1_51924.jpg',0x01),
 (14,'Jasmin','Zanzmera','jasmin@yahoo.com','1990-05-02','INDIAN',0x01,'Surat','1212121212',2,1,2,1,3,'2page-img1_51924.jpg',0x01);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CandidateMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`CitizenMaster`
--

DROP TABLE IF EXISTS `EPolling`.`CitizenMaster`;
CREATE TABLE  `EPolling`.`CitizenMaster` (
  `UserId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ContactNo` varchar(20) NOT NULL,
  `ThumbImage` varchar(300) NOT NULL,
  `VoterCardImage` varchar(300) NOT NULL,
  `FaceImage` varchar(300) NOT NULL,
  `SignatureImage` varchar(300) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `ZoneId` int(11) DEFAULT NULL,
  `WardId` int(11) DEFAULT NULL,
  `SubWardId` int(11) DEFAULT NULL,
  `AreaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  KEY `FK_CitizenMaster_AreaId` (`AreaId`),
  KEY `FK_CitizenMaster_SubWardId` (`SubWardId`),
  KEY `FK_CitizenMaster_WardId` (`WardId`),
  KEY `FK_CitizenMaster_ZoneId` (`ZoneId`),
  CONSTRAINT `constraint_areamaster_citizen_fk` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_loginmaster_citizen_fk` FOREIGN KEY (`UserId`) REFERENCES `LoginMaster` (`UserId`),
  CONSTRAINT `constraint_subwardmaster_citizen_fk` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_wardmaster_citizen_fk` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_zonemaster_citizen_fk` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_CitizenMaster_AreaId` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`),
  CONSTRAINT `FK_CitizenMaster_SubWardId` FOREIGN KEY (`SubWardId`) REFERENCES `SubWardMaster` (`SubWardId`),
  CONSTRAINT `FK_CitizenMaster_UserId` FOREIGN KEY (`UserId`) REFERENCES `LoginMaster` (`UserId`),
  CONSTRAINT `FK_CitizenMaster_WardId` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`),
  CONSTRAINT `FK_CitizenMaster_ZoneId` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`CitizenMaster`
--

/*!40000 ALTER TABLE `CitizenMaster` DISABLE KEYS */;
LOCK TABLES `CitizenMaster` WRITE;
INSERT INTO `EPolling`.`CitizenMaster` VALUES  (1,'Ankur M Trapasiya','Surat','9998849799','hsm1_38564_35574.jpg','hsm1_38564_35574.jpg','hsm1_38564_35574.jpg','hsm1_38564_35574.jpg','1990-02-02',2,1,2,3),
 (6,'x','jhj','111','hsm1_38564_56418.jpg','hsm1_38564_56416.jpg','hsm1_38564_56419.jpg','hsm1_38564_56417.jpg','2011-06-01',1,5,6,6),
 (7,'Shashank','Adajan,Surat','9909664264','hsm1_38564_56418.jpg','hsm1_38564_56416.jpg','hsm1_38564_56419.jpg','hsm1_38564_56417.jpg','1990-01-01',1,5,6,6);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CitizenMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`CityMaster`
--

DROP TABLE IF EXISTS `EPolling`.`CityMaster`;
CREATE TABLE  `EPolling`.`CityMaster` (
  `CityId` int(11) NOT NULL AUTO_INCREMENT,
  `CityName` varchar(30) NOT NULL,
  `StateId` int(11) NOT NULL,
  `CountryId` int(11) NOT NULL,
  PRIMARY KEY (`CityId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`CityMaster`
--

/*!40000 ALTER TABLE `CityMaster` DISABLE KEYS */;
LOCK TABLES `CityMaster` WRITE;
INSERT INTO `EPolling`.`CityMaster` VALUES  (1,'surat',1,1),
 (2,'ahmedabad',1,1),
 (3,'Baroda',1,1),
 (4,'mumbai',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CityMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`ElectionCandidateMaster`
--

DROP TABLE IF EXISTS `EPolling`.`ElectionCandidateMaster`;
CREATE TABLE  `EPolling`.`ElectionCandidateMaster` (
  `ElectionId` int(11) NOT NULL,
  `CandidateId` int(11) NOT NULL,
  KEY `FK_ElectionCandidateMaster_CandidateId` (`CandidateId`),
  KEY `FK_ElectionCandidateMaster_ElectionId` (`ElectionId`),
  CONSTRAINT `FK_ElectionCandidateMaster_CandidateId` FOREIGN KEY (`CandidateId`) REFERENCES `CandidateMaster` (`CandidateId`),
  CONSTRAINT `FK_ElectionCandidateMaster_ElectionId` FOREIGN KEY (`ElectionId`) REFERENCES `ElectionMaster` (`ElectionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`ElectionCandidateMaster`
--

/*!40000 ALTER TABLE `ElectionCandidateMaster` DISABLE KEYS */;
LOCK TABLES `ElectionCandidateMaster` WRITE;
INSERT INTO `EPolling`.`ElectionCandidateMaster` VALUES  (1,5),
 (2,6),
 (3,6),
 (3,8),
 (3,10),
 (4,6),
 (4,8),
 (4,10),
 (5,6),
 (5,8),
 (5,10),
 (5,13),
 (7,5),
 (7,6),
 (8,6),
 (8,7),
 (9,6),
 (9,7),
 (9,9),
 (10,6),
 (10,7),
 (10,9),
 (10,10),
 (11,6),
 (11,7),
 (11,9),
 (11,10),
 (11,13),
 (12,6),
 (12,7),
 (12,9),
 (12,10),
 (12,13),
 (13,5),
 (13,6),
 (13,7),
 (13,8),
 (13,9),
 (13,10),
 (13,11),
 (13,12),
 (13,13),
 (13,14);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ElectionCandidateMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`ElectionMaster`
--

DROP TABLE IF EXISTS `EPolling`.`ElectionMaster`;
CREATE TABLE  `EPolling`.`ElectionMaster` (
  `ElectionId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `FinalDate` date NOT NULL,
  `StartTime` time NOT NULL,
  `EndTime` time NOT NULL,
  `ElectionTypeId` int(11) DEFAULT NULL,
  `isActive` bit(1) NOT NULL,
  PRIMARY KEY (`ElectionId`),
  KEY `FK_ElectionMaster_ElectionTypeId` (`ElectionTypeId`),
  CONSTRAINT `constraint_electiontypemaster_election_fk` FOREIGN KEY (`ElectionTypeId`) REFERENCES `ElectionTypeMaster` (`ElectionTypeId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_ElectionMaster_ElectionTypeId` FOREIGN KEY (`ElectionTypeId`) REFERENCES `ElectionTypeMaster` (`ElectionTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`ElectionMaster`
--

/*!40000 ALTER TABLE `ElectionMaster` DISABLE KEYS */;
LOCK TABLES `ElectionMaster` WRITE;
INSERT INTO `EPolling`.`ElectionMaster` VALUES  (1,'sdfd1','2011-06-23','01:00:00','01:03:00',1,0x00),
 (2,'sdfdf2','2011-06-23','01:00:00','01:03:00',1,0x00),
 (3,'sdfd3s','2011-06-23','01:00:00','01:03:00',1,0x00),
 (4,'sdfdf4','2011-06-23','01:00:00','01:03:00',1,0x00),
 (5,'sdf5fs','2011-06-23','01:00:00','01:03:00',1,0x00),
 (6,'x','2011-06-23','15:00:00','15:03:00',1,0x00),
 (7,'x2','2011-06-23','01:16:00','01:19:00',1,0x00),
 (8,'x3','2011-06-23','01:23:00','01:25:00',1,0x00),
 (9,'x4','2011-06-23','01:29:00','01:31:00',1,0x00),
 (10,'x4','2011-06-23','01:34:00','01:36:00',1,0x00),
 (11,'x5','2011-06-23','01:41:00','01:43:00',1,0x00),
 (12,'x6','2011-06-23','01:46:00','01:48:00',1,0x00),
 (13,'test','2011-06-19','03:15:00','06:30:00',1,0x00);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ElectionMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`ElectionTypeMaster`
--

DROP TABLE IF EXISTS `EPolling`.`ElectionTypeMaster`;
CREATE TABLE  `EPolling`.`ElectionTypeMaster` (
  `ElectionTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(30) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`ElectionTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`ElectionTypeMaster`
--

/*!40000 ALTER TABLE `ElectionTypeMaster` DISABLE KEYS */;
LOCK TABLES `ElectionTypeMaster` WRITE;
INSERT INTO `EPolling`.`ElectionTypeMaster` VALUES  (1,'CorporaterElection','election for corporator in various wards of zone');
UNLOCK TABLES;
/*!40000 ALTER TABLE `ElectionTypeMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`GroupMaster`
--

DROP TABLE IF EXISTS `EPolling`.`GroupMaster`;
CREATE TABLE  `EPolling`.`GroupMaster` (
  `GroupName` varchar(30) NOT NULL,
  `Description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`GroupName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`GroupMaster`
--

/*!40000 ALTER TABLE `GroupMaster` DISABLE KEYS */;
LOCK TABLES `GroupMaster` WRITE;
INSERT INTO `EPolling`.`GroupMaster` VALUES  ('admin','for Administrators of the system'),
 ('citizen','for citizens');
UNLOCK TABLES;
/*!40000 ALTER TABLE `GroupMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`LoginMaster`
--

DROP TABLE IF EXISTS `EPolling`.`LoginMaster`;
CREATE TABLE  `EPolling`.`LoginMaster` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(500) NOT NULL,
  `UserType` varchar(10) NOT NULL,
  `isActive` bit(1) NOT NULL,
  PRIMARY KEY (`UserId`) USING BTREE,
  UNIQUE KEY `loginmaster_username_unique` (`Username`),
  UNIQUE KEY `UNQ_LoginMaster_0` (`Username`),
  KEY `IX_LoginMaster_UNQ_LoginMaster_0` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`LoginMaster`
--

/*!40000 ALTER TABLE `LoginMaster` DISABLE KEYS */;
LOCK TABLES `LoginMaster` WRITE;
INSERT INTO `EPolling`.`LoginMaster` VALUES  (1,'ankur','0cc175b9c0f1b6a831c399e269772661','citizen',0x01),
 (2,'milan','0cc175b9c0f1b6a831c399e269772661','admin',0x01),
 (3,'s','0cc175b9c0f1b6a831c399e269772661','citizen',0x01),
 (6,'j','0cc175b9c0f1b6a831c399e269772661','citizen',0x01),
 (7,'sempatel','0cc175b9c0f1b6a831c399e269772661','citizen',0x01);
UNLOCK TABLES;
/*!40000 ALTER TABLE `LoginMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`PartyMaster`
--

DROP TABLE IF EXISTS `EPolling`.`PartyMaster`;
CREATE TABLE  `EPolling`.`PartyMaster` (
  `PartyId` int(11) NOT NULL AUTO_INCREMENT,
  `PartyName` varchar(30) NOT NULL,
  `PartyLogo` varchar(300) NOT NULL,
  `PartySlogan` varchar(300) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`PartyId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`PartyMaster`
--

/*!40000 ALTER TABLE `PartyMaster` DISABLE KEYS */;
LOCK TABLES `PartyMaster` WRITE;
INSERT INTO `EPolling`.`PartyMaster` VALUES  (1,'BJP','hsm1_38564_35574.jpg','Jay Jawan Jay Kisan','Bhartiya Janta Party'),
 (2,'Congress','hsm1_38564_35574.jpg','One India One People','The National Voice ....'),
 (3,'Samajwadi','hsm1_38564_35574.jpg','The System For Common People','Samajwadi party'),
 (4,'No Party','hsm1_38564_35574.jpg','Independent Candidate','No party'),
 (5,'sdsd','hsm1_38564_35574.jpg','dsds','sdsd'),
 (6,'p','hsm1_38564_35574.jpg','p','p'),
 (7,'fffff','hsm1_38564_35574.jpg','ssyyyy','ssvvvlll');
UNLOCK TABLES;
/*!40000 ALTER TABLE `PartyMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`SecurityMaster`
--

DROP TABLE IF EXISTS `EPolling`.`SecurityMaster`;
CREATE TABLE  `EPolling`.`SecurityMaster` (
  `SecurityId` int(11) NOT NULL AUTO_INCREMENT,
  `SecurityName` varchar(50) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `isActive` bit(1) NOT NULL,
  PRIMARY KEY (`SecurityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`SecurityMaster`
--

/*!40000 ALTER TABLE `SecurityMaster` DISABLE KEYS */;
LOCK TABLES `SecurityMaster` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `SecurityMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`SubWardMaster`
--

DROP TABLE IF EXISTS `EPolling`.`SubWardMaster`;
CREATE TABLE  `EPolling`.`SubWardMaster` (
  `SubWardId` int(11) NOT NULL AUTO_INCREMENT,
  `SubWardName` varchar(30) NOT NULL,
  `WardId` int(11) DEFAULT NULL,
  PRIMARY KEY (`SubWardId`),
  KEY `FK_SubWardMaster_WardId` (`WardId`),
  CONSTRAINT `constraint_wardmaster_fk` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_SubWardMaster_WardId` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`SubWardMaster`
--

/*!40000 ALTER TABLE `SubWardMaster` DISABLE KEYS */;
LOCK TABLES `SubWardMaster` WRITE;
INSERT INTO `EPolling`.`SubWardMaster` VALUES  (1,'Kapodra',1),
 (2,'Nana Varachha',1),
 (3,'Hirabaug',1),
 (4,'Baroda',1),
 (5,'MiniBazar',1),
 (6,'katar sw',5);
UNLOCK TABLES;
/*!40000 ALTER TABLE `SubWardMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`UserGroupMaster`
--

DROP TABLE IF EXISTS `EPolling`.`UserGroupMaster`;
CREATE TABLE  `EPolling`.`UserGroupMaster` (
  `UserId` int(11) NOT NULL,
  `GroupName` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  PRIMARY KEY (`UserId`,`GroupName`),
  KEY `FK_UserGroupMaster_GroupName` (`GroupName`),
  CONSTRAINT `constraint_groupmaster_usergroup_fk` FOREIGN KEY (`GroupName`) REFERENCES `GroupMaster` (`GroupName`),
  CONSTRAINT `constraint_loginmaster_usergroup_fk` FOREIGN KEY (`UserId`) REFERENCES `LoginMaster` (`UserId`),
  CONSTRAINT `FK_UserGroupMaster_GroupName` FOREIGN KEY (`GroupName`) REFERENCES `GroupMaster` (`GroupName`),
  CONSTRAINT `FK_UserGroupMaster_UserId` FOREIGN KEY (`UserId`) REFERENCES `LoginMaster` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`UserGroupMaster`
--

/*!40000 ALTER TABLE `UserGroupMaster` DISABLE KEYS */;
LOCK TABLES `UserGroupMaster` WRITE;
INSERT INTO `EPolling`.`UserGroupMaster` VALUES  (1,'citizen','ankur'),
 (2,'admin','milan'),
 (3,'citizen','s'),
 (6,'citizen','j'),
 (7,'citizen','sempatel');
UNLOCK TABLES;
/*!40000 ALTER TABLE `UserGroupMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`VoteMaster`
--

DROP TABLE IF EXISTS `EPolling`.`VoteMaster`;
CREATE TABLE  `EPolling`.`VoteMaster` (
  `VoteId` int(11) NOT NULL AUTO_INCREMENT,
  `CandidateId` int(11) DEFAULT NULL,
  `VoteDateTime` datetime NOT NULL,
  `ElectionId` int(11) DEFAULT NULL,
  `ZoneId` int(11) DEFAULT NULL,
  `WardId` int(11) DEFAULT NULL,
  `SubwardId` int(11) DEFAULT NULL,
  `AreaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`VoteId`),
  KEY `FK_VoteMaster_ElectionId` (`ElectionId`),
  KEY `FK_VoteMaster_CandidateId` (`CandidateId`),
  KEY `FK_VoteMaster_SubwardId` (`SubwardId`),
  KEY `FK_VoteMaster_AreaId` (`AreaId`),
  KEY `FK_VoteMaster_WardId` (`WardId`),
  KEY `FK_VoteMaster_ZoneId` (`ZoneId`),
  CONSTRAINT `constraint_areamaster_vote_fk` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_candidatemaster_vote_fk` FOREIGN KEY (`CandidateId`) REFERENCES `CandidateMaster` (`CandidateId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_electionmaster_vote_fk` FOREIGN KEY (`ElectionId`) REFERENCES `ElectionMaster` (`ElectionId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_subwardmaster_vote_fk` FOREIGN KEY (`SubwardId`) REFERENCES `SubWardMaster` (`SubWardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_wardmaster_vote_fk` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `constraint_zonemaster_vote_fk` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_VoteMaster_AreaId` FOREIGN KEY (`AreaId`) REFERENCES `AreaMaster` (`AreaId`),
  CONSTRAINT `FK_VoteMaster_CandidateId` FOREIGN KEY (`CandidateId`) REFERENCES `CandidateMaster` (`CandidateId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_VoteMaster_ElectionId` FOREIGN KEY (`ElectionId`) REFERENCES `ElectionMaster` (`ElectionId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_VoteMaster_SubwardId` FOREIGN KEY (`SubwardId`) REFERENCES `SubWardMaster` (`SubWardId`),
  CONSTRAINT `FK_VoteMaster_WardId` FOREIGN KEY (`WardId`) REFERENCES `WardMaster` (`WardId`),
  CONSTRAINT `FK_VoteMaster_ZoneId` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`VoteMaster`
--

/*!40000 ALTER TABLE `VoteMaster` DISABLE KEYS */;
LOCK TABLES `VoteMaster` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `VoteMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`WardMaster`
--

DROP TABLE IF EXISTS `EPolling`.`WardMaster`;
CREATE TABLE  `EPolling`.`WardMaster` (
  `WardId` int(11) NOT NULL AUTO_INCREMENT,
  `WardName` varchar(30) NOT NULL,
  `ZoneId` int(11) DEFAULT NULL,
  PRIMARY KEY (`WardId`),
  KEY `FK_WardMaster_ZoneId` (`ZoneId`),
  CONSTRAINT `constraint_zonemaster_fk` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_WardMaster_ZoneId` FOREIGN KEY (`ZoneId`) REFERENCES `ZoneMaster` (`ZoneId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`WardMaster`
--

/*!40000 ALTER TABLE `WardMaster` DISABLE KEYS */;
LOCK TABLES `WardMaster` WRITE;
INSERT INTO `EPolling`.`WardMaster` VALUES  (1,'Varachha',2),
 (2,'Sarthana',16),
 (3,'AKRoad',4),
 (4,'Mota Varachha',2),
 (5,'Katargam',1),
 (6,'Ved Road',4),
 (7,'Bopal ',16),
 (9,'Gorav',1),
 (10,'pAVAI ',2),
 (11,'pINAK',4),
 (12,'l.H ROAD',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `WardMaster` ENABLE KEYS */;


--
-- Definition of table `EPolling`.`ZoneMaster`
--

DROP TABLE IF EXISTS `EPolling`.`ZoneMaster`;
CREATE TABLE  `EPolling`.`ZoneMaster` (
  `ZoneId` int(11) NOT NULL AUTO_INCREMENT,
  `ZoneName` varchar(30) NOT NULL,
  `CityId` int(11) DEFAULT NULL,
  `Population` bigint(20) NOT NULL,
  PRIMARY KEY (`ZoneId`),
  KEY `FK_ZoneMaster_CityId` (`CityId`),
  CONSTRAINT `constraint_citymaster_fk` FOREIGN KEY (`CityId`) REFERENCES `CityMaster` (`CityId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_ZoneMaster_CityId` FOREIGN KEY (`CityId`) REFERENCES `CityMaster` (`CityId`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EPolling`.`ZoneMaster`
--

/*!40000 ALTER TABLE `ZoneMaster` DISABLE KEYS */;
LOCK TABLES `ZoneMaster` WRITE;
INSERT INTO `EPolling`.`ZoneMaster` VALUES  (1,'North Zone',1,6000000),
 (2,'East Zone',1,300),
 (4,'South Zone',2,5005000),
 (16,'West Zone',3,1000000),
 (21,'Cert Zone',2,33000),
 (26,'Mils Zone',1,1332231),
 (27,'Bean Zone',4,33332222),
 (28,'Puna Zone',3,8881112),
 (29,'Mils Zone',3,11111111),
 (30,'heko',2,787),
 (31,'raj zone',1,666),
 (32,'wjeh',1,34637),
 (33,'jhvgj',2,4636),
 (34,'efh',3,7645654),
 (40,'aaa',2,435425),
 (41,'bbb',4,444444),
 (42,'bbb',4,444444),
 (43,'bbb',4,444444),
 (44,'ddd',4,444444),
 (45,'eee',4,444444),
 (46,'fff',4,444444),
 (47,'gggn',4,444444),
 (48,'gggn',4,444444),
 (49,'gggn',4,444444),
 (54,'bfdgfd',4,444444),
 (95,'rtyfrtrtgggn',4,444444),
 (99,'rtrtgggn',4,444444),
 (211,'vfhybb',4,444444),
 (214,'raj',4,444444),
 (331,'vfhybb',4,444444),
 (411,'bdffsd',4,444444),
 (999,'rtyfrtfrttrtgggn',4,444444),
 (1000,'Game Zone',4,666555),
 (1001,'a',4,11111);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ZoneMaster` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
