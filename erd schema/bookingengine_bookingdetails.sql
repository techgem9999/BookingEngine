-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookingengine
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookingdetails`
--

DROP TABLE IF EXISTS `bookingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookingdetails` (
  `BookingDetailsId` int(11) NOT NULL AUTO_INCREMENT,
  `BookingId` int(11) NOT NULL,
  `RoomId` int(11) NOT NULL,
  `PersonId` int(11) NOT NULL COMMENT 'Client which made the booking',
  `CheckIn` datetime NOT NULL,
  `CheckOut` datetime NOT NULL,
  `CheckedIn` datetime NOT NULL,
  `CheckedOut` datetime NOT NULL,
  `Canceled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`BookingDetailsId`),
  UNIQUE KEY `uq_BookingDetailsBookingRoomPersonCheckCheckedInOutCanc` (`BookingId`,`RoomId`,`PersonId`,`CheckIn`,`CheckOut`,`CheckedIn`,`CheckedOut`,`Canceled`),
  KEY `fk_BookingDetailsRoom` (`RoomId`),
  KEY `fk_BookingDetailsPerson` (`PersonId`),
  CONSTRAINT `fk_BookingDetailsBooking` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`BookingId`),
  CONSTRAINT `fk_BookingDetailsPerson` FOREIGN KEY (`PersonId`) REFERENCES `person` (`PersonId`),
  CONSTRAINT `fk_BookingDetailsRoom` FOREIGN KEY (`RoomId`) REFERENCES `room` (`RoomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetails`
--

LOCK TABLES `bookingdetails` WRITE;
/*!40000 ALTER TABLE `bookingdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookingdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-22 15:54:45
