/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:26
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for leave_tbl
-- ----------------------------
CREATE TABLE `leave_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(20) NOT NULL,
  `tchName` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `remark` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
