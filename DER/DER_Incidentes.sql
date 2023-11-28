-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: incidentes
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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `cuit` bigint NOT NULL,
  `email` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `telefono` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentes`
--

DROP TABLE IF EXISTS `incidentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidentes` (
  `id_incidente` int NOT NULL AUTO_INCREMENT,
  `id_servicio_cliente` int NOT NULL,
  `id_problema_servicio` int NOT NULL,
  `descripcion` text COLLATE utf8mb3_spanish_ci,
  `fecha_alta` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_incidente`),
  KEY `fk_incidentes_servicios_cliente_idx` (`id_servicio_cliente`),
  KEY `fk_incidentes_problemas_servicios_idx` (`id_problema_servicio`),
  CONSTRAINT `fk_incidentes_problemas_servicios` FOREIGN KEY (`id_problema_servicio`) REFERENCES `problemas_servicios` (`id_problema_servicio`),
  CONSTRAINT `fk_incidentes_servicios_cliente` FOREIGN KEY (`id_servicio_cliente`) REFERENCES `servicios_clientes` (`id_servicio_ciliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentes`
--

LOCK TABLES `incidentes` WRITE;
/*!40000 ALTER TABLE `incidentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentes_asignados`
--

DROP TABLE IF EXISTS `incidentes_asignados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidentes_asignados` (
  `id_incidente_asignado` int NOT NULL AUTO_INCREMENT,
  `id_incidente` int NOT NULL,
  `id_tecnico` int NOT NULL,
  `tiempo_resolucion_default` float DEFAULT NULL,
  `complejo` tinyint NOT NULL DEFAULT '0',
  `tiempo_resolucion_adicional` float DEFAULT NULL,
  `marca_resolucion` tinyint NOT NULL DEFAULT '0',
  `observaciones_resolucion` text COLLATE utf8mb3_spanish_ci,
  `fecha_resolucion` timestamp NOT NULL,
  PRIMARY KEY (`id_incidente_asignado`),
  KEY `fk_resoluciones_incidentes_idx` (`id_incidente`),
  KEY `fk_resoluciones_tecnicos_idx` (`id_tecnico`),
  CONSTRAINT `fk_resoluciones_incidentes` FOREIGN KEY (`id_incidente`) REFERENCES `incidentes` (`id_incidente`),
  CONSTRAINT `fk_resoluciones_tecnicos` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentes_asignados`
--

LOCK TABLES `incidentes_asignados` WRITE;
/*!40000 ALTER TABLE `incidentes_asignados` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidentes_asignados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentes_relacionados`
--

DROP TABLE IF EXISTS `incidentes_relacionados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidentes_relacionados` (
  `id_incidentes_relacionados` int NOT NULL AUTO_INCREMENT,
  `id_incidente` int NOT NULL,
  `id_incidente_relacionado` int NOT NULL,
  PRIMARY KEY (`id_incidentes_relacionados`),
  KEY `fk_incidente_idx` (`id_incidente`),
  KEY `fk_incidente_relacionado_idx` (`id_incidente_relacionado`),
  CONSTRAINT `fk_incidente` FOREIGN KEY (`id_incidente`) REFERENCES `incidentes` (`id_incidente`),
  CONSTRAINT `fk_incidente_relacionado` FOREIGN KEY (`id_incidente_relacionado`) REFERENCES `incidentes` (`id_incidente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentes_relacionados`
--

LOCK TABLES `incidentes_relacionados` WRITE;
/*!40000 ALTER TABLE `incidentes_relacionados` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidentes_relacionados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problemas_servicios`
--

DROP TABLE IF EXISTS `problemas_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problemas_servicios` (
  `id_problema_servicio` int NOT NULL AUTO_INCREMENT,
  `id_tipo_problema` int NOT NULL,
  `id_servicio` int NOT NULL,
  `tiempo_maximo_resolucion` float DEFAULT NULL,
  PRIMARY KEY (`id_problema_servicio`),
  KEY `fk_tipo_problema_idx` (`id_tipo_problema`),
  KEY `fk_problemas_servicios_idx` (`id_servicio`),
  CONSTRAINT `fk_problemas_servicios` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id_servicio`),
  CONSTRAINT `fk_tipo_problema` FOREIGN KEY (`id_tipo_problema`) REFERENCES `tipos_problema` (`id_tipo_problema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problemas_servicios`
--

LOCK TABLES `problemas_servicios` WRITE;
/*!40000 ALTER TABLE `problemas_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `problemas_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `id_tipo_servicio` int NOT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `fk_servicio_id_tipo_servicio_idx` (`id_tipo_servicio`),
  CONSTRAINT `fk_servicios_tipos_servicios` FOREIGN KEY (`id_tipo_servicio`) REFERENCES `tipos_servicios` (`id_tipo_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios_clientes`
--

DROP TABLE IF EXISTS `servicios_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios_clientes` (
  `id_servicio_ciliente` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_servicio` int NOT NULL,
  PRIMARY KEY (`id_servicio_ciliente`),
  KEY `fk_servicio_cliente_idx` (`id_cliente`),
  KEY `fk_servicio_cliente_servicio_idx` (`id_servicio`),
  CONSTRAINT `fk_servicio_cliente_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `fk_servicio_cliente_servicio` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios_clientes`
--

LOCK TABLES `servicios_clientes` WRITE;
/*!40000 ALTER TABLE `servicios_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnicos`
--

DROP TABLE IF EXISTS `tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnicos` (
  `id_tecnico` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `telefono` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnicos`
--

LOCK TABLES `tecnicos` WRITE;
/*!40000 ALTER TABLE `tecnicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnicos_especialidades`
--

DROP TABLE IF EXISTS `tecnicos_especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnicos_especialidades` (
  `id_tecnico_especialidad` int NOT NULL AUTO_INCREMENT,
  `id_tecnico` int NOT NULL,
  `id_servicio` int NOT NULL,
  PRIMARY KEY (`id_tecnico_especialidad`),
  KEY `fk_tecnicos_especialidades_idx` (`id_tecnico`),
  KEY `fk_servicios_idx` (`id_servicio`),
  CONSTRAINT `fk_servicios` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id_servicio`),
  CONSTRAINT `fk_tecnicos_especialidades_tecnicos` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnicos_especialidades`
--

LOCK TABLES `tecnicos_especialidades` WRITE;
/*!40000 ALTER TABLE `tecnicos_especialidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnicos_especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_problema`
--

DROP TABLE IF EXISTS `tipos_problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_problema` (
  `id_tipo_problema` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_problema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_problema`
--

LOCK TABLES `tipos_problema` WRITE;
/*!40000 ALTER TABLE `tipos_problema` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_problema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_servicios`
--

DROP TABLE IF EXISTS `tipos_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_servicios` (
  `id_tipo_servicio` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_servicios`
--

LOCK TABLES `tipos_servicios` WRITE;
/*!40000 ALTER TABLE `tipos_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_servicios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-27 21:35:57
