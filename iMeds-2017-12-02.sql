CREATE DATABASE  IF NOT EXISTS `imeds` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `imeds`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: imeds
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  CONSTRAINT `fk_cliente_usuario` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacia`
--

DROP TABLE IF EXISTS `farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farmacia` (
  `idFarmacia` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `CNPJ` varchar(45) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idFarmacia`),
  UNIQUE KEY `idFarmacia_UNIQUE` (`idFarmacia`),
  UNIQUE KEY `CNPJ_UNIQUE` (`CNPJ`),
  CONSTRAINT `fk_farmacia_usuario` FOREIGN KEY (`idFarmacia`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacia`
--

LOCK TABLES `farmacia` WRITE;
/*!40000 ALTER TABLE `farmacia` DISABLE KEYS */;
/*!40000 ALTER TABLE `farmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacia_medicamento`
--

DROP TABLE IF EXISTS `farmacia_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farmacia_medicamento` (
  `idFarmacia` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `preco` float NOT NULL,
  `quantEstoque` int(11) NOT NULL,
  PRIMARY KEY (`idFarmacia`,`idMedicamento`),
  KEY `fk_Farmacia_has_Medicamento_Medicamento1_idx` (`idMedicamento`),
  KEY `fk_Farmacia_has_Medicamento_Farmacia1_idx` (`idFarmacia`),
  CONSTRAINT `fk_Farmacia_has_Medicamento_Farmacia1` FOREIGN KEY (`idFarmacia`) REFERENCES `farmacia` (`idFarmacia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Farmacia_has_Medicamento_Medicamento1` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`idMedicamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacia_medicamento`
--

LOCK TABLES `farmacia_medicamento` WRITE;
/*!40000 ALTER TABLE `farmacia_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `farmacia_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_pedido` (
  `idItemPedido` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  PRIMARY KEY (`idItemPedido`),
  UNIQUE KEY `idItemDePedido_UNIQUE` (`idItemPedido`),
  KEY `fk_ItemDePedido_Medicamento1_idx` (`idMedicamento`),
  KEY `fk_ItemDePedido_Pedido1_idx` (`idPedido`),
  CONSTRAINT `fk_ItemDePedido_Medicamento1` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`idMedicamento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ItemDePedido_Pedido1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `idMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `prescrito` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMedicamento`),
  UNIQUE KEY `idMedicamento_UNIQUE` (`idMedicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (1,'Tilenol','bla bla bla',0),(2,'AS','ble ble ',0),(3,'Rjfdi','fdsf ds fds',0);
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `imagemReceita` mediumblob,
  `idFarmacia` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`),
  UNIQUE KEY `idPedido_UNIQUE` (`idPedido`),
  KEY `fk_Pedido_Farmacia_idx` (`idFarmacia`),
  KEY `fk_Pedido_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_Pedido_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pedido_Farmacia` FOREIGN KEY (`idFarmacia`) REFERENCES `farmacia` (`idFarmacia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'imeds'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-02 19:00:04
