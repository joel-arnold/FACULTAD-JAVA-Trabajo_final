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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (26,'Nombre','Apellido','DNI','33620222','Cale','1222','6','8','3415325544','cliente@hotmail.com',1,24),(29,'Otro','Cliente','DNI','33333333','Calle','123','1','1','(0341) 4371799','otro@cliente.com.ar',1,27),(31,'Joel','Arnold','DNI','14545455','Uriarte','877','2','3','3415555555','joel.arnold.ar@gmail.com',1,29),(32,'Cosme','Fulanito','DNI','12345678','Calle Falsa','123','','','123456789','asdsadsadsa@hotmail.com',1,30),(33,'Juan','Perez','DNI','33333333','Oscuridad','tanteo','9','b','4333333','juan@perez.com',1,31);
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
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_cliente`
--

LOCK TABLES `compra_cliente` WRITE;
/*!40000 ALTER TABLE `compra_cliente` DISABLE KEYS */;
INSERT INTO `compra_cliente` VALUES (91,'08-06-2020',375,31),(92,'08-06-2020',700,31),(93,'09-06-2020',855,31),(94,'09-06-2020',2502,31),(95,'16-06-2020',950,26),(96,'19-06-2020',2365,31),(97,'26-06-2020',1100,31),(98,'27-06-2020',2722,31),(99,'27-06-2020',7186,32),(100,'12-08-2020',1660,32),(101,'03-07-2020',12000,31),(103,'07-07-2020',1950,31),(104,'07-07-2020',150,31),(105,'07-07-2020',325,31);
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
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_compra_cliente`
--

LOCK TABLES `linea_compra_cliente` WRITE;
/*!40000 ALTER TABLE `linea_compra_cliente` DISABLE KEYS */;
INSERT INTO `linea_compra_cliente` VALUES (169,91,8,1),(170,91,5,1),(171,92,9,1),(172,92,8,2),(173,93,7,1),(174,93,5,1),(175,94,1,1),(176,94,7,2),(177,94,5,2),(178,94,6,1),(179,94,11,1),(180,94,13,1),(181,95,1,2),(182,95,13,2),(183,96,6,4),(184,96,5,4),(185,96,1,3),(186,97,6,5),(187,97,5,2),(188,98,6,2),(189,98,1,4),(190,98,11,6),(191,99,1,5),(192,99,5,5),(193,99,11,8),(194,99,7,8),(195,99,8,4),(196,100,5,2),(197,100,6,4),(198,100,1,2),(199,101,7,17),(200,101,1,15),(201,101,6,7),(202,101,5,3),(205,103,5,1),(206,103,1,5),(207,104,6,1),(208,105,5,1),(209,105,6,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'99','Avy','Alimento balanceado pajaritos',5,'gr',355,4,'bolsa_aves.jpeg'),(5,'91','Raza','Alimento para perros',1,'kg',175,1,'bolsa_perros.png'),(6,'90','Gati','Alimento para gatos',1,'kg',150,2,'bolsa_gatos.jpg'),(7,'92','Pajarito','Balanceado para pajaritos',2,'kg',300,4,'bolsa_aves.jpeg'),(8,'93','Doggy','Alimento para perros',11,'kg',200,1,'bolsa_perros.png'),(9,'94','Eukanuba','Alimento para perros',15,'kg',300,1,'bolsa_perros.png'),(11,'142','Pipetita gatos','Pipeta para gatos pulgosos',1,'litro',167,5,'caja_pipeta.jpg'),(13,'143','Pipeta perros','Pipeta para perros pulgosos',1,'litro',120,5,'caja_pipeta.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (1,'Común',5),(32,'Super',10),(33,'Especial',15),(34,'Super especial',20);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (16,'empleado','c4ca4238a0b923820dcc509a6f75849b','EMPLEADO'),(18,'ameca','c4ca4238a0b923820dcc509a6f75849b','SUPERUSUARIO'),(24,'cliente','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(25,'admin','c4ca4238a0b923820dcc509a6f75849b','ADMINISTRADOR'),(26,'susuario','c4ca4238a0b923820dcc509a6f75849b','SUPERUSUARIO'),(27,'ocliente','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(29,'jarnold','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(30,'CosmeFulanito','c4ca4238a0b923820dcc509a6f75849b','CLIENTE'),(31,'juanperez','a94652aa97c7211ba8954dd15a3cf838','CLIENTE');
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

-- Dump completed on 2020-07-07 12:02:26
