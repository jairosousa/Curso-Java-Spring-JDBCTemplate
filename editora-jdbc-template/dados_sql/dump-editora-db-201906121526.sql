-- MySQL dump 10.13  Distrib 5.6.41, for Win64 (x86_64)
--
-- Host: localhost    Database: editora-db
-- ------------------------------------------------------
-- Server version	5.6.41-log

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
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autores` (
  `ID_AUTOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `ID_EDITORA` int(11) NOT NULL,
  PRIMARY KEY (`ID_AUTOR`),
  UNIQUE KEY `NOME_UNIQUE` (`NOME`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  KEY `fk_AUTORES_editoras_idx` (`ID_EDITORA`),
  CONSTRAINT `fk_AUTORES_editoras` FOREIGN KEY (`ID_EDITORA`) REFERENCES `editoras` (`ID_EDITORA`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
INSERT INTO `autores` VALUES (1,'Jairo Nascimento','jns@email.com.br',11),(5,'Jairo Filho','jnsf@email.com.br',11),(6,'Silvana Sousa','sls@email.com.br',11),(7,'Caio Sousa','cls@email.com.br',11),(8,'Jhair Sousa','jhs@email.com.br',11),(9,'Jose Trajano','jtn@email.com.br',11),(10,'Acioli Macedo','ams@email.com.br',11),(11,'Edna Matos','ems@email.com.br',11),(12,'Valdomiro Matos','vms@email.com.br',11),(13,'Regina Célia','rcs@email.com.br',11),(14,'Thiago de Sousa','ths@email.com.br',11),(15,'Ricardo Pavuna','ricp@email.com.br',13),(16,'Hernan Rodrigues Pavuna','hrr@email.com.br',14),(17,'Santorio Mendes Castro','smc@email.com.br',15);
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editoras`
--

DROP TABLE IF EXISTS `editoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editoras` (
  `ID_EDITORA` int(11) NOT NULL AUTO_INCREMENT,
  `RAZAO_SOCIAL` varchar(60) NOT NULL,
  `CIDADE` varchar(60) NOT NULL,
  `EMAIL` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_EDITORA`),
  UNIQUE KEY `RAZAO_SOCIAL_UNIQUE` (`RAZAO_SOCIAL`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editoras`
--

LOCK TABLES `editoras` WRITE;
/*!40000 ALTER TABLE `editoras` DISABLE KEYS */;
INSERT INTO `editoras` VALUES (11,'Editora Icoaraci S/A','Belém','contato@edIcoaraci.com.br'),(12,'Editora Belém S/A','Belém','contato@edBelem.com.br'),(13,'Editora 3 Corações S/A','Macapá','contato@3coracoes.com.br'),(14,'Editora Mocorongo S/A','Santarém','contato@mocorongo.com.br'),(15,'Editora Águia S/A','Marabá','contato@aguia.com.br');
/*!40000 ALTER TABLE `editoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livros`
--

DROP TABLE IF EXISTS `livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livros` (
  `ID_LIVRO` int(11) NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(45) NOT NULL,
  `EDICAO` int(11) NOT NULL,
  `PAGINAS` int(11) NOT NULL,
  PRIMARY KEY (`ID_LIVRO`),
  UNIQUE KEY `TITULO_EDICAO` (`TITULO`,`EDICAO`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros`
--

LOCK TABLES `livros` WRITE;
/*!40000 ALTER TABLE `livros` DISABLE KEYS */;
INSERT INTO `livros` VALUES (1,'Aprenda JSE em 40 dias',1,168),(2,'Quando chegar a hora',1,220),(3,'Seja um Youtuber de sucesso',1,156),(4,'Ciência de Dados com Javascript',1,680),(5,'Aprenda JSE em 40 dias',2,202),(6,'Tudo tem seu preço',1,360),(7,'Tudo sobre Jogos on line',1,95),(8,'Spring Boot na veia',1,450),(9,'Tudo tem seu preço',2,368),(10,'Tudo sobre Jogos on line',2,105);
/*!40000 ALTER TABLE `livros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livros_autores`
--

DROP TABLE IF EXISTS `livros_autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livros_autores` (
  `ID_LIVRO_AUTOR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_LIVRO` int(11) NOT NULL,
  `ID_AUTOR` int(11) NOT NULL,
  PRIMARY KEY (`ID_LIVRO_AUTOR`),
  UNIQUE KEY `ID_LIVRO_ID_AUTOR` (`ID_LIVRO`,`ID_AUTOR`),
  KEY `fk_LIVROS_has_AUTORES_AUTORES1_idx` (`ID_AUTOR`),
  KEY `fk_LIVROS_has_AUTORES_LIVROS1_idx` (`ID_LIVRO`),
  CONSTRAINT `fk_LIVROS_has_AUTORES_AUTORES1` FOREIGN KEY (`ID_AUTOR`) REFERENCES `autores` (`ID_AUTOR`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIVROS_has_AUTORES_LIVROS1` FOREIGN KEY (`ID_LIVRO`) REFERENCES `livros` (`ID_LIVRO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros_autores`
--

LOCK TABLES `livros_autores` WRITE;
/*!40000 ALTER TABLE `livros_autores` DISABLE KEYS */;
INSERT INTO `livros_autores` VALUES (1,1,1),(2,1,5),(3,2,6),(4,3,7),(5,4,5),(6,5,1),(7,5,5),(8,6,6),(9,7,7),(10,8,1),(12,9,1),(11,9,6),(13,10,7);
/*!40000 ALTER TABLE `livros_autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'editora-db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-12 15:26:53
