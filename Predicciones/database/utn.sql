-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: utn
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `DNI` int NOT NULL,
  `Nombre` varchar(15) DEFAULT NULL,
  `Apellido` varchar(15) DEFAULT NULL,
  `Nacionalidad` varchar(15) DEFAULT NULL,
  `Departamento` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1837438,'Alberto','Perez','Peruano','Sistemas'),(11582432,'Albert','Williams','Boliviano','Logistica'),(21321521,'Mariana','Fernandez','Mexicana','Logistica'),(27874372,'Sabrina','Martinez','Chilena','Compras'),(32533213,'Tomas','Secco','Paraguayo','Logistica'),(36385462,'Carmen','Gomez','Uruguayo','Compras'),(45171315,'Lucas','Saenz','Argentino','Sistemas');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `Departamento` varchar(15) NOT NULL,
  `Presupuesto` double DEFAULT NULL,
  PRIMARY KEY (`Departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('Compras',500000),('Logistica',750000);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prediccion`
--

DROP TABLE IF EXISTS `prediccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prediccion` (
  `Usuario` varchar(20) DEFAULT NULL,
  `EquipoA` varchar(15) DEFAULT NULL,
  `Gana1` varchar(2) DEFAULT NULL,
  `Empate` varchar(2) DEFAULT NULL,
  `Gana2` varchar(2) DEFAULT NULL,
  `EquipoB` varchar(15) DEFAULT NULL,
  `Goles` int DEFAULT NULL,
  `Partido` int DEFAULT NULL,
  `Ronda` int DEFAULT NULL,
  `Fase` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prediccion`
--

LOCK TABLES `prediccion` WRITE;
/*!40000 ALTER TABLE `prediccion` DISABLE KEYS */;
INSERT INTO `prediccion` VALUES ('Lucas','Mexico','','','X','Alemania',2,1,1,1),('Lucas','Uruguay','','','X','Alemania',1,2,1,1),('Lucas','Argentina','X','','','Croacia',2,1,2,1),('Lucas','Ecuador','','X','','Polonia',0,2,2,1),('Lucas','Chile','','','X','Polonia',2,1,3,1),('Lucas','Colombia','','X','','Marruecos',0,2,3,1),('Lucas','Chile','','','X','Polonia',2,1,1,2),('Lucas','Ecuador','','','X','Marruecos',1,2,1,2),('Lucas','Chile','','','X','Inglaterra',3,1,2,2),('Lucas','Brasil','X','','','Croacia',2,2,2,2),('Nahuel','Mexico','','','X','Francia',3,1,1,1),('Nahuel','Paraguay','','','X','Croacia',1,2,1,1),('Nahuel','Paraguay','','','X','Francia',3,1,2,1),('Nahuel','Paraguay','','','X','Portugal',1,2,2,1),('Nahuel','Brasil','','X','','Inglaterra',0,1,3,1),('Nahuel','Mexico','','','X','Alemania',2,2,3,1),('Nahuel','Mexico','X','','','Senegal',2,1,1,2),('Nahuel','Chile','','','X','Portugal',1,2,1,2),('Nahuel','Ecuador','','X','','Marruecos',0,1,2,2),('Nahuel','Mexico','','','X','Inglaterra',2,2,2,2);
/*!40000 ALTER TABLE `prediccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `Usuario` varchar(20) NOT NULL,
  `Puntos` double DEFAULT NULL,
  PRIMARY KEY (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES ('Lucas',7.5),('Nahuel',8.75);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-07 15:30:10
