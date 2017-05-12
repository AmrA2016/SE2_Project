CREATE DATABASE  IF NOT EXISTS `arenadb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `arenadb`;
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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `student_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `game_id_idx` (`gid`),
  CONSTRAINT `game_id` FOREIGN KEY (`gid`) REFERENCES `games` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'my comment',13,'student'),(2,'my comment2',13,'student'),(3,'my comment3',13,'student');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_subscriber`
--

DROP TABLE IF EXISTS `course_subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_subscriber` (
  `subscriber_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_cid` int(11) DEFAULT NULL,
  `student_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subscriber_id`),
  KEY `course_id_idx` (`course_cid`),
  KEY `student_id_idx` (`student_username`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_cid`) REFERENCES `courses` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_username` FOREIGN KEY (`student_username`) REFERENCES `students` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_subscriber`
--

LOCK TABLES `course_subscriber` WRITE;
/*!40000 ALTER TABLE `course_subscriber` DISABLE KEYS */;
INSERT INTO `course_subscriber` VALUES (1,1,'student');
/*!40000 ALTER TABLE `course_subscriber` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
-- Table structure for table `game_collaborator`
--

DROP TABLE IF EXISTS `game_collaborator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_collaborator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_username` varchar(25) DEFAULT NULL,
  `game_gid` int(11) DEFAULT NULL,
  `owner` tinyint(4) DEFAULT NULL,
  `accepted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_idx2` (`teacher_username`),
  KEY `game_gid_idx2` (`game_gid`),
  CONSTRAINT `game_id2` FOREIGN KEY (`game_gid`) REFERENCES `games` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_id2` FOREIGN KEY (`teacher_username`) REFERENCES `teachers` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_collaborator`
--

LOCK TABLES `game_collaborator` WRITE;
/*!40000 ALTER TABLE `game_collaborator` DISABLE KEYS */;
INSERT INTO `game_collaborator` VALUES (2,'teacher2',14,0,1),(3,'teacher',8,1,1),(4,'teacher',13,1,1),(5,'teacher',14,1,1);
/*!40000 ALTER TABLE `game_collaborator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `course_cid` int(11) DEFAULT NULL,
  `game_type` varchar(10) NOT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `course_cid_idx` (`course_cid`),
  CONSTRAINT `course_cid` FOREIGN KEY (`course_cid`) REFERENCES `courses` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (8,'MyFirstGame','Ay klam','53151079724f1_1493682405145.jpg',1,'TF',0),(13,'MyGame','Testing','edward-kenway-assassin-s-creed-iv-black-flag-20896-1366x768_1494268747554.jpg',1,'TF',0),(14,'testGame','Description','10390574_234516736738930_2077143325112731927_n1_1494325672634.jpg',1,'MCQ',0);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
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
  CONSTRAINT `mcqgame_id` FOREIGN KEY (`mcqgame_gid`) REFERENCES `games` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcqquestions`
--

LOCK TABLES `mcqquestions` WRITE;
/*!40000 ALTER TABLE `mcqquestions` DISABLE KEYS */;
INSERT INTO `mcqquestions` VALUES (4,'Question11','a ','c','a ','e','z',14);
/*!40000 ALTER TABLE `mcqquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_notification`
--

DROP TABLE IF EXISTS `student_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(1000) DEFAULT NULL,
  `student_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_usernname_idx` (`student_username`),
  CONSTRAINT `student_usernname` FOREIGN KEY (`student_username`) REFERENCES `students` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_notification`
--

LOCK TABLES `student_notification` WRITE;
/*!40000 ALTER TABLE `student_notification` DISABLE KEYS */;
INSERT INTO `student_notification` VALUES (3,'A new game has been added to course Java','student');
/*!40000 ALTER TABLE `student_notification` ENABLE KEYS */;
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
INSERT INTO `students` VALUES ('student','123456','manar@hotmail.com','Manar','A','1996-11-07','Female',NULL,0),('student2','123456','nourhan@hotmail.com','Nourhan','Essam','1996-07-10','Female',NULL,0);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_notification`
--

DROP TABLE IF EXISTS `teacher_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(1000) DEFAULT NULL,
  `teacher_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_username_idx` (`teacher_username`),
  CONSTRAINT `teacher_username` FOREIGN KEY (`teacher_username`) REFERENCES `teachers` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_notification`
--

LOCK TABLES `teacher_notification` WRITE;
/*!40000 ALTER TABLE `teacher_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_notification` ENABLE KEYS */;
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
INSERT INTO `teachers` VALUES ('teacher','sdasd@gmail.com','123456','Amr','A','1996-10-01','Male','0121414','Programming'),('teacher2','asdasd@hotmail.com','123456789','Mohamed','M','1996-07-10','Male','012141434','Web Development');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
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
  KEY `tfgame_id_idx` (`tfgame_gid`),
  CONSTRAINT `tfgame_id` FOREIGN KEY (`tfgame_gid`) REFERENCES `games` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tfquestions`
--

LOCK TABLES `tfquestions` WRITE;
/*!40000 ALTER TABLE `tfquestions` DISABLE KEYS */;
INSERT INTO `tfquestions` VALUES (8,'Question1','true',8),(9,'Question2','false',8),(21,'Test1','true',13),(22,'Test2','false',13);
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

-- Dump completed on 2017-05-12  7:34:01
