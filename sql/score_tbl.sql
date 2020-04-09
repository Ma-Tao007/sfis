/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for score_tbl
-- ----------------------------
CREATE TABLE `score_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuNO` bigint(20) NOT NULL,
  `course` varchar(20) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`,`stuNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
