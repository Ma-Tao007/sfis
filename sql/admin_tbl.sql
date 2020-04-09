/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin_tbl
-- ----------------------------
CREATE TABLE `admin_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `adminEmail` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin_tbl` VALUES ('1', 'admin', 'admin', '13218318053@163.com');
INSERT INTO `admin_tbl` VALUES ('2', 'well', '123', '13218318053@163.com');
