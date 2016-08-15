# Host: 127.0.0.1  (Version 5.6.25-log)
# Date: 2016-08-15 19:25:27
# Generator: MySQL-Front 5.3  (Build 6.26)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `age` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
