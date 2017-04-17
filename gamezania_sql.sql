-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: arenadb
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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `teacher_username` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `teacher_id_idx` (`teacher_username`),
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_username`) REFERENCES `teachers` (`username`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Java','java course','Programming',10,'prog.jpg','teacher'),(2,'Matrix operation','Basics of Matrix Operations','Math',12,'disappointed.jpg','teacher'),(3,'Medhat','Medhat haynt7er khalas','Programming',19,'prog.jpg','teacher2');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcqgames`
--

DROP TABLE IF EXISTS `mcqgames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcqgames` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `course_cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `course_cid_idx` (`course_cid`),
  CONSTRAINT `course_cid` FOREIGN KEY (`course_cid`) REFERENCES `courses` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcqgames`
--

LOCK TABLES `mcqgames` WRITE;
/*!40000 ALTER TABLE `mcqgames` DISABLE KEYS */;
INSERT INTO `mcqgames` VALUES (1,'MySecondGame','fsaff','thumbProg.png',1),(2,'Matrix Addition','Practicing the matrix addition','1.png',2),(3,'GameMedhat','gameMedhatgameMedhatgameMedhatgameMedhat','unnamed.png',3);
/*!40000 ALTER TABLE `mcqgames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcqquestions`
--

DROP TABLE IF EXISTS `mcqquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcqquestions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(100) NOT NULL,
  `correct_answer` varchar(100) NOT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `mcqgame_gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mcqgame_id_idx` (`mcqgame_gid`),
  CONSTRAINT `mcqgame_id` FOREIGN KEY (`mcqgame_gid`) REFERENCES `mcqgames` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcqquestions`
--

LOCK TABLES `mcqquestions` WRITE;
/*!40000 ALTER TABLE `mcqquestions` DISABLE KEYS */;
INSERT INTO `mcqquestions` VALUES (1,'Question1','ch12','ch11','ch12','ch13','ch14',1),(2,'Question2','ch24','ch21','ch22','ch23','ch24',1),(3,'{ {1,2,3} , {4,5,6} } + { {10,4,6} , {1,1,1} }','{ {11,6,9}, {5,6,7} }','{ {11,5,9}, {5,6,7} }','{ {11,5,9}, {14,9,12} }','{ {11,6,9}, {5,6,7} }','{ {11,6,9}, {5,7,9} }',2),(4,'Testing2','2','1','2','3','4',2),(5,'lehh kull haga 3umraha osayer?','3ashan enta khaled','3ashan ehna f 7asebat','3ashan enta khaled','3ashan 3andna software project','3ashan el leader bta3na atef',3);
/*!40000 ALTER TABLE `mcqquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `username` varchar(25) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `intersets` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('student','123456','manar@hotmail.com','Manar','A','1996-11-07','Female',NULL,0);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `username` varchar(25) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile` varchar(30) NOT NULL,
  `teachingfield` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('teacher','sdasd@gmail.com','123456','Amr','A',NULL,'m','0121414','Programming'),('teacher2','asdasd@hotmail.com','123456789','Mohamed','M','1996-07-10','Male','012141434','Web Development');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tfgames`
--

DROP TABLE IF EXISTS `tfgames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tfgames` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `course_cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `course_cid_idx` (`course_cid`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_cid`) REFERENCES `courses` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tfgames`
--

LOCK TABLES `tfgames` WRITE;
/*!40000 ALTER TABLE `tfgames` DISABLE KEYS */;
INSERT INTO `tfgames` VALUES (8,'MyFirstGame','badaf','1.png',1),(9,'Game2','fsafasf','sin.png',1),(10,'Basic Operation','Practice about addition and division','sin.png',2);
/*!40000 ALTER TABLE `tfgames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tfquestions`
--

DROP TABLE IF EXISTS `tfquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tfquestions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(100) NOT NULL,
  `correct_answer` varchar(10) NOT NULL,
  `tfgame_gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tf_game_id_idx` (`tfgame_gid`),
  CONSTRAINT `tfgame_id` FOREIGN KEY (`tfgame_gid`) REFERENCES `tfgames` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tfquestions`
--

LOCK TABLES `tfquestions` WRITE;
/*!40000 ALTER TABLE `tfquestions` DISABLE KEYS */;
INSERT INTO `tfquestions` VALUES (1,'Test1','true',8),(2,'Test2','false',8),(3,'Question11','true',9),(4,'Question2','false',9),(5,'5 + 16 = 21','true',10),(6,'80 / 5 = 14','false',10),(7,'64 + 23 = 87','true',10);
/*!40000 ALTER TABLE `tfquestions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-17 13:44:11
