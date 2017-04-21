-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: customer
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `AMS_PC_SPD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE AMS_PC_SPD
(
  PC_ID           INTEGER                     NOT NULL PRIMARY KEY,
  PC              VARCHAR(7)              NOT NULL,
  LDU_TYPE_CDE    VARCHAR(50),
  FSA_ID          INTEGER                     NOT NULL,
  FSA             VARCHAR(3)              NOT NULL,
  LFCL_STAT_CDE   VARCHAR(50),
  DM_TYPE_CDE     VARCHAR(50),
  DM_DISP_NME     VARCHAR(6)              NOT NULL,
  DF_ID           INTEGER                     NOT NULL,
  DF_DISP_NME     VARCHAR(100),
  DF_PC_ID        INTEGER,
  DF_PC_DISP_NME  VARCHAR(7)              NOT NULL,
  RPO_ID          INTEGER,
  RPO_NME         VARCHAR(50),
  RPO_BUS_NME     VARCHAR(50),
  RPO_ADDR_LINE1  VARCHAR(50),
  RPO_ADDR_LINE3  VARCHAR(50),
  LATITUDE        DECIMAL(38,8),
  LONGITUDE       DECIMAL(38,8)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AMS_PC_SPD`
--

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-11 20:56:11