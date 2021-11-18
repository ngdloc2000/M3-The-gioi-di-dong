CREATE DATABASE  IF NOT EXISTS `casestudym3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `casestudym3`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: casestudym3
-- ------------------------------------------------------
-- Server version	8.0.27

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
  `idAccount` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idRole` int NOT NULL,
  PRIMARY KEY (`idAccount`),
  UNIQUE KEY `username` (`username`),
  KEY `idRole` (`idRole`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'an','1','an',1),(2,'loc','2','loc',2),(3,'khanh','3','khanh',3),(4,'y','4','y',2),(5,'1','1','Admin',1),(6,'2','2','Chủ Shop',2),(7,'3','3','User',3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `idCart` int NOT NULL AUTO_INCREMENT,
  `idAccount` int NOT NULL,
  `createDate` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idCart`),
  KEY `idAccount` (`idAccount`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idAccount`) REFERENCES `account` (`idAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartdetail`
--

DROP TABLE IF EXISTS `cartdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartdetail` (
  `idCart` int NOT NULL,
  `idProduct` int NOT NULL,
  `number` int DEFAULT NULL,
  PRIMARY KEY (`idCart`,`idProduct`),
  KEY `idProduct` (`idProduct`),
  CONSTRAINT `cartdetail_ibfk_1` FOREIGN KEY (`idCart`) REFERENCES `cart` (`idCart`),
  CONSTRAINT `cartdetail_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartdetail`
--

LOCK TABLES `cartdetail` WRITE;
/*!40000 ALTER TABLE `cartdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idProduct` int NOT NULL AUTO_INCREMENT,
  `nameProduct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idType` int NOT NULL,
  `idShop` int NOT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `idType` (`idType`),
  KEY `idShop` (`idShop`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`idType`) REFERENCES `type` (`idType`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`idShop`) REFERENCES `shop` (`idShop`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (4,'Day',10000,100,'https://giayxshop.vn/wp-content/uploads/2021/01/z2261641090407_9a527dfa37fa44a1b8cfd0fd14d1ca77-scaled.jpg',1,1),(5,'Dep',5000,500,'https://shopgiaythethaogiare.com/wp-content/uploads/2020/10/Gi%C3%A0y-MLB-Boston-Gi%C3%A1-R%E1%BA%BB.jpg',2,1),(6,'Ung',20000,20,'https://phuongstore.vn/uploads/images/2021/giay-the-thao-trang-cho-be-gai-be-trai-tu3-10-tuoi-0.jpg',3,1),(7,'day da',12000,10,'https://salt.tikicdn.com/cache/400x400/ts/product/6c/65/29/cb2f6ea8e921f2f743a2e5199517780b.jpg',1,2),(8,'dep da',2000,20,'https://cafebiz.cafebizcdn.vn/thumb_w/600/162123310254002176/2021/3/3/photo1614740923253-16147409234661851365310.jpg',2,3),(9,'ung da',23000,30,'http://product.hstatic.net/1000092380/product/giay_sneaker_nam_thoi_trang_de_giay_boc_got_rozalo_rm34211b_-_den8_grande.png',3,4),(10,'day go',34000,50,'https://www.anphuoc.com.vn/Data/Sites/1/Product/4367/thumbs/gt-ap0156001a-(2).jpg',1,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `idRate` int NOT NULL AUTO_INCREMENT,
  `idAccount` int DEFAULT NULL,
  `idProduct` int DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rate` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idRate`),
  KEY `idAccount` (`idAccount`),
  KEY `idProduct` (`idProduct`),
  CONSTRAINT `rate_ibfk_1` FOREIGN KEY (`idAccount`) REFERENCES `account` (`idAccount`),
  CONSTRAINT `rate_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  CONSTRAINT `rate_chk_1` CHECK (((`rate` >= 0) and (`rate` <= 5)))
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (2,1,4,'good',4),(3,2,5,'perfect',5),(4,3,4,'good',4),(5,4,4,'bad',2),(6,3,4,'ok',0),(7,5,4,'rac',1),(8,5,4,'rac',1),(9,5,4,'rất tốt',5),(10,5,4,'rất tốt',4),(11,5,4,'1',5),(12,5,4,'5',5);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idRole` int NOT NULL AUTO_INCREMENT,
  `nameRole` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Chủ Shop'),(3,'Khách Hàng');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `idShop` int NOT NULL AUTO_INCREMENT,
  `nameShop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idAccount` int NOT NULL,
  PRIMARY KEY (`idShop`),
  KEY `idAccount` (`idAccount`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`idAccount`) REFERENCES `account` (`idAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'Xuan Anh',1),(2,'Xuan anh 2',1),(3,'locsh',2),(4,'Khanhsh',3),(5,'ysh',4);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `idType` int NOT NULL AUTO_INCREMENT,
  `nameType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Day'),(2,'Dep'),(3,'Ung'),(4,'Quần'),(5,'Áo'),(6,'Đồ lót');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 16:08:32
