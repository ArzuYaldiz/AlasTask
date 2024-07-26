-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `categories_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Ring'),(2,'Notebook'),(3,'T-Shirt');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('drop_Table_categories','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',1,'MARK_RAN','9:8458dd40b4f554b964339f5387440aeb','dropForeignKeyConstraint baseTableName=products, constraintName=fk_category; dropTable tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('create_categories','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',2,'MARK_RAN','9:e6c26e4e9d6f9d3ebff4e66a649e5e53','createTable tableName=categories; addForeignKeyConstraint baseTableName=products, constraintName=fk_category, referencedTableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('categories_1','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',3,'MARK_RAN','9:01acbf68383ec7f6925bd47ab03c57e4','insert tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('categories_2','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',4,'MARK_RAN','9:03d13890723c70b3507dcd88c5ef8a72','insert tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('categories_3','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',5,'MARK_RAN','9:e9181e2ad0a8a154caf6d824f169de42','insert tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('categories_4','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',6,'MARK_RAN','9:7a57293672750bbe568de27dc2ac8381','insert tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('categories_5','root','db/changelog/categories-changelog.yaml','2024-07-22 14:04:18',7,'MARK_RAN','9:0678d0f4976a7d31b379b14a81eadcf3','insert tableName=categories','',NULL,'4.27.0',NULL,NULL,'1642658422'),('drop_Table_productdetails','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',8,'MARK_RAN','9:23d226911f7f7e5dbc19373113c41267','dropForeignKeyConstraint baseTableName=productdetails, constraintName=fk_productdetail; dropTable tableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('create_productdetails','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',9,'MARK_RAN','9:5211a7d9d944fdf201e589154a3c8f51','createTable tableName=productdetails; addForeignKeyConstraint baseTableName=products, constraintName=fk_productdetail, referencedTableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('productdetails_1','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',10,'MARK_RAN','9:86bf28b63417c024cc77636f8144e28c','insert tableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('productdetails_2','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',11,'MARK_RAN','9:20447a2a03f643f47dee94a2256b9533','insert tableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('productdetails_3','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',12,'MARK_RAN','9:323013992dc65f38f03328161508455b','insert tableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('productdetails_4','root','db/changelog/productdetails-changelog.yaml','2024-07-22 14:04:18',13,'MARK_RAN','9:060689f720b7b2eb081cb311bcdd1515','insert tableName=productdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('drop_Table_shoppingcart','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',14,'MARK_RAN','9:de41e701273fa3eec0a3352a27e8bf67','dropTable tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('create_shoppingcart','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',15,'MARK_RAN','9:11c36fce8078b0c2b9c4216ea3414062','createTable tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_1','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',16,'MARK_RAN','9:a276f9c696155ad2f3cc854905e615fb','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_2','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',17,'MARK_RAN','9:61d12cd6dd2a62d9b03b82daf92dc3ff','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_3','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',18,'MARK_RAN','9:861a958ad33bb9766c5d3754edd4362f','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_4','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',19,'MARK_RAN','9:6c9a8d0efcefc57273b54f21b72b610f','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_5','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',20,'MARK_RAN','9:3fae3f2de2883c01f423ad36a2e8269f','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_6','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',21,'MARK_RAN','9:ba185c7d4d8874923869e270f45da7ff','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_7','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',22,'MARK_RAN','9:4c66e3553c21b5ba3e2b1434ded47b7e','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('shoppingcart_8','root','db/changelog/shoppingCart-changelog.yaml','2024-07-22 14:04:18',23,'MARK_RAN','9:8dc2353e3678945b9507dc2a5c64caf2','insert tableName=shopping_cart','',NULL,'4.27.0',NULL,NULL,'1642658422'),('drop_Table_products','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',24,'MARK_RAN','9:0800bcef956c0c657c115e88ef6a287a','dropForeignKeyConstraint baseTableName=shopping_cart_products, constraintName=fk_products; dropTable tableName=productsdetails','',NULL,'4.27.0',NULL,NULL,'1642658422'),('create_products','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',25,'MARK_RAN','9:08b893167b0b8d4c6f98ab4b1cdb8cd4','createTable tableName=products; addForeignKeyConstraint baseTableName=products, constraintName=fk_productdetail, referencedTableName=productdetails; addForeignKeyConstraint baseTableName=products, constraintName=fk_category, referencedTableName=ca...','',NULL,'4.27.0',NULL,NULL,'1642658422'),('product_1','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',26,'MARK_RAN','9:d4b14aee421fb86ac8bed855a4ce4519','insert tableName=products','',NULL,'4.27.0',NULL,NULL,'1642658422'),('product_2','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',27,'MARK_RAN','9:d48982f522c04e5a6b1d0923fce6bac0','insert tableName=products','',NULL,'4.27.0',NULL,NULL,'1642658422'),('product_3','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',28,'MARK_RAN','9:d7e9aa0c62aa3ecf7f6028061a92166e','insert tableName=products','',NULL,'4.27.0',NULL,NULL,'1642658422'),('product_4','root','db/changelog/products-changelog.yaml','2024-07-22 14:04:18',29,'MARK_RAN','9:d2dfc1225a4d36f60bb009b2e16b08e3','insert tableName=products','',NULL,'4.27.0',NULL,NULL,'1642658422');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productdetails` (
  `product_details_id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
INSERT INTO `productdetails` VALUES (1,'Silver','url123'),(2,'Black','url1'),(3,'White','url2'),(4,'Brown','url3');
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `category_id` int DEFAULT NULL,
  `productdetail_id` int DEFAULT NULL,
  `products_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`products_id`),
  UNIQUE KEY `UKdrfb0ngxyv3v68n032wu1ni9` (`productdetail_id`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`categories_id`) ON DELETE CASCADE,
  CONSTRAINT `FKrfptlolyhvqs2mcte1oo8eggh` FOREIGN KEY (`productdetail_id`) REFERENCES `productdetails` (`product_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,1,'Bridal Ring'),(2,2,2,'Asus Tuff Gaming'),(3,3,3,'Mavi T-Shirt'),(3,4,4,'Pull&Bear T-Shirt');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (1,'My Cart'),(2,'My new Cart'),(3,'1');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_products`
--

DROP TABLE IF EXISTS `shopping_cart_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart_products` (
  `cart_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`cart_id`,`product_id`),
  KEY `FKnf1xjkiucco0nm5kva0aknqto` (`product_id`),
  CONSTRAINT `FK3rsavyu0gugjrwrb9g7qrlvtd` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`cart_id`),
  CONSTRAINT `FKnf1xjkiucco0nm5kva0aknqto` FOREIGN KEY (`product_id`) REFERENCES `products` (`products_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_products`
--

LOCK TABLES `shopping_cart_products` WRITE;
/*!40000 ALTER TABLE `shopping_cart_products` DISABLE KEYS */;
INSERT INTO `shopping_cart_products` VALUES (1,2),(1,3);
/*!40000 ALTER TABLE `shopping_cart_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-22 16:28:07
