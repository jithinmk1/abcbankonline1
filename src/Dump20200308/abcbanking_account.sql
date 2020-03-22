-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: abcbanking
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Account_id` int(11) NOT NULL,
  `account_type` varchar(45) NOT NULL,
  `account_name` varchar(45) NOT NULL,
  `account_address` varchar(100) NOT NULL,
  `account_status` varchar(45) NOT NULL,
  `email_id` varchar(65) NOT NULL,
  `mobile_number` varchar(65) NOT NULL,
  `date_open` datetime DEFAULT NULL,
  `date_closed` datetime DEFAULT NULL,
  `account_balance` float NOT NULL,
  PRIMARY KEY (`Account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1111,'saving','bhuvana','bhuvi address','active','bhuvi@gmail.com','1234567890','2008-11-20 00:00:00','2021-11-20 00:00:00',10000),(2222,'saving','sivaraja','siva address','active','raja@gmail.com','1233445678','2005-11-20 00:00:00','2023-11-20 00:00:00',10000),(3333,'saving','atharv','atharvaddress','active','atharv@gmail.com','1234567890','2013-11-20 00:00:00','2029-11-20 00:00:00',10000),(4444,'saving','aditi','adithiaddress','active','aditi@gmail.com','1234567890','2017-11-20 00:00:00','2031-11-20 00:00:00',10000),(5555,'checking','preeti','preetiaddress','inactive','preeti@gmail.com','1234567890','2008-11-20 00:00:00','2021-11-20 00:00:00',10000),(6666,'checking','vasuki','vasukiaddress','inactive','vasu@gmail.com','1234567890','2008-11-20 00:00:00','2021-11-20 00:00:00',10000),(7777,'savings','srujana','srujana address','active','sujii@gmail.com','1234567890','2008-11-20 00:00:00','2021-11-20 00:00:00',10000);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-08 15:03:32
