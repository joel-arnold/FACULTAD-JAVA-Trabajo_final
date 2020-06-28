CREATE DATABASE  IF NOT EXISTS `forrajeria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `forrajeria`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: forrajeria
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `categoria_producto`
--

DROP TABLE IF EXISTS `categoria_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria_producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_producto`
--

LOCK TABLES `categoria_producto` WRITE;
/*!40000 ALTER TABLE `categoria_producto` DISABLE KEYS */;
INSERT INTO `categoria_producto` VALUES (1,'Alimento para perros','Todo lo que se coma que sea exclusivamente para perritos'),(2,'Alimento para gatos','Todo lo que se coma que sea exclusivamente para gatos'),(4,'Alimento para aves','Todo lo comestible para aves'),(5,'Pipetas','Pipetas y accesorios');
/*!40000 ALTER TABLE `categoria_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `apellido` varchar(75) NOT NULL,
  `tipoDoc` varchar(4) NOT NULL,
  `documento` varchar(15) NOT NULL,
  `domicilioCalle` varchar(100) DEFAULT NULL,
  `domicilioNumero` varchar(10) DEFAULT NULL,
  `domicilioPiso` varchar(5) DEFAULT NULL,
  `domicilioDepto` varchar(3) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `tipo_cliente` int NOT NULL,
  `usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_cliente_idx` (`tipo_cliente`),
  KEY `usuario_idx` (`usuario`),
  CONSTRAINT `tipo_cliente` FOREIGN KEY (`tipo_cliente`) REFERENCES `tipo_cliente` (`id`),
  CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (26,'Nombre','Apellido','DNI','33620222','Uriarte','789','1','3','3415325544','cliente@hotmail.com',1,24),(29,'Otro','Cliente','DNI','33333333','Calle','123','1','1','(0341) 4371799','otro@cliente.com.ar',1,27),(31,'Joel','Arnold','DNI','33.720.429','Uriarte','789','1','3','3415325530','joel.arnold.ar@gmail.com',1,29),(32,'Cosme','Fulanito','DNI','12345678','Calle Falsa','123','','','123456789','maria-monza@hotmail.com',1,30);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_cliente`
--

DROP TABLE IF EXISTS `compra_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` varchar(10) DEFAULT NULL,
  `total` double NOT NULL,
  `cliente` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_cliente`
--

LOCK TABLES `compra_cliente` WRITE;
/*!40000 ALTER TABLE `compra_cliente` DISABLE KEYS */;
INSERT INTO `compra_cliente` VALUES (78,'01-06-2020',1400,31),(79,'01-06-2020',4409,31),(80,'02-06-2020',4627,31),(81,'02-06-2020',6873,31),(82,'02-06-2020',1605,31),(83,'02-06-2020',7180,31),(84,'02-06-2020',4300,31),(85,'02-06-2020',900,31);
/*!40000 ALTER TABLE `compra_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cuil` varchar(11) NOT NULL,
  `tipoDocumento` varchar(4) NOT NULL,
  `documento` varchar(8) NOT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  `domicilioCalle` varchar(50) DEFAULT NULL,
  `domicilioNumero` varchar(5) DEFAULT NULL,
  `domicilioPiso` varchar(3) DEFAULT NULL,
  `domicilioDepto` varchar(3) DEFAULT NULL,
  `usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_idx` (`usuario`),
  CONSTRAINT `usuarioEmpleado` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (2,'Ado','Emple','20159863442','DNI','15645646','empleado@sdasd.com','3415465','dasdasd','16','1','3',16),(4,'Meca','Adrián','20189995220','DNI','156465','adrianmeca@gmail.com','3415555555','Calle','123','1','9',18),(27,'Istrador','Admin','20335558889','DNI','33720429','admin@hotmail.com.ar','3415325530','Uriarte','789','1','3',25),(28,'Usuario','Super','20345678947','DNI','34567894','cesar.mecanico@gmail.com','3416897845','Calle','123','','',26);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea_compra_cliente`
--

DROP TABLE IF EXISTS `linea_compra_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linea_compra_cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCompra` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCompra_idx` (`idCompra`),
  KEY `idProducto_idx` (`idProducto`),
  CONSTRAINT `idCompra` FOREIGN KEY (`idCompra`) REFERENCES `compra_cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_compra_cliente`
--

LOCK TABLES `linea_compra_cliente` WRITE;
/*!40000 ALTER TABLE `linea_compra_cliente` DISABLE KEYS */;
INSERT INTO `linea_compra_cliente` VALUES (123,78,5,8),(124,79,6,9),(125,79,11,2),(126,79,1,7),(127,79,13,2),(128,80,9,1),(129,80,5,2),(130,80,8,3),(131,80,6,4),(132,80,1,5),(133,80,11,6),(134,81,5,6),(135,81,8,6),(136,81,11,9),(137,81,7,8),(138,81,13,6),(139,82,6,3),(140,82,1,1),(141,82,8,4),(142,83,7,6),(143,83,13,2),(144,83,10,6),(145,83,11,5),(146,83,8,4),(147,83,5,1),(148,84,9,4),(149,84,13,12),(150,84,5,1),(151,84,8,1),(152,84,6,1),(153,84,7,1),(154,84,11,5),(155,85,9,1),(156,85,8,3);
/*!40000 ALTER TABLE `linea_compra_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `tamano` double DEFAULT NULL,
  `unidadMedida` varchar(10) NOT NULL,
  `precioVenta` double NOT NULL,
  `categoria` int DEFAULT NULL,
  `imagen` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_idx` (`categoria`),
  CONSTRAINT `categoria` FOREIGN KEY (`categoria`) REFERENCES `categoria_producto` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'99','Avy','Alimento balanceado pajaritos',5,'gr',355,4,'bolsa_aves.jpeg'),(5,'91','Raza','Alimento para perros',1,'kg',175,1,'bolsa_perros.png'),(6,'90','Gati','Alimento para gatos',0.5,'kg',150,2,'bolsa_gatos.jpg'),(7,'92','Pajarito','Balanceado para pajaritos',2,'kg',300,4,'bolsa_aves.jpeg'),(8,'93','Doggy','Alimento para perros',10,'kg',200,1,'bolsa_perros.png'),(9,'94','Eukanuba','Alimento para perros',15,'kg',300,1,'bolsa_perros.png'),(10,'101','Birdy','Alimento para aves',2,'kg',555,4,'bolsa_aves.jpeg'),(11,'142','Pipetita para gatos','Pipeta para gatos pulgosos',1,'litro',167,5,'caja_pipeta.jpg'),(13,'143','Pipeta para perros','Pipeta para perros pulgosos',1,'litro',120,5,'caja_pipeta.jpg');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `razonSocial` varchar(100) NOT NULL,
  `cuit` varchar(11) NOT NULL,
  `domicilioCalle` varchar(100) DEFAULT NULL,
  `domicilioNumero` varchar(10) DEFAULT NULL,
  `domicilioPiso` varchar(3) DEFAULT NULL,
  `domicilioDepto` varchar(3) DEFAULT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (8,'Proveedor 1','30555555559','Calle','1','9','2','mail@proveedor.com.ar','(0341) 4300155'),(9,'Proveedor 2','30222222224','Callecita','123','125','G','correo@electronico.com.ar','(0341) 4305203'),(11,'Proveedor 3','3099999999','Calle','90210','11','E','unpro@veedor.com.ar','03 03 456');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(75) NOT NULL,
  `porcentajeDescuento` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (1,'Común',3),(3,'Super especial',2);
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(75) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `privilegio` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (16,'empleado','c4ca4238a0b923820dcc509a6f75849b','EMPLEADO'),(18,'ameca','c4ca4238a0b923820dcc509a6f75849b','SUPERUSUARIO'),(24,'cliente','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(25,'admin','c4ca4238a0b923820dcc509a6f75849b','ADMINISTRADOR'),(26,'susuario','c4ca4238a0b923820dcc509a6f75849b','SUPERUSUARIO'),(27,'ocliente','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(29,'jarnold','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(30,'CosmeFulanito','202cb962ac59075b964b07152d234b70','CLIENTE');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 20:36:21