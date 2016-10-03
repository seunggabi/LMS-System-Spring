/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


CREATE DATABASE `springlms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springlms`;
CREATE TABLE `course` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `professor_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `enroll` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `course_id` varchar(255) DEFAULT NULL,
  `grade` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

INSERT INTO `enroll` VALUES ('student','1','A+');
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `pw` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('professor','1234','Alpha-Go','prof');
INSERT INTO `user` VALUES ('student','1234','seunggabi','stu');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
