/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for parent_tbl
-- ----------------------------
CREATE TABLE `parent_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tel` varchar(11) NOT NULL,
  `parName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `relation` varchar(20) NOT NULL DEFAULT 'X',
  `job` varchar(20) NOT NULL DEFAULT 'X',
  `address` varchar(50) NOT NULL DEFAULT 'X',
  `stuNO` varchar(10) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'parent',
  PRIMARY KEY (`id`,`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `parent_tbl` VALUES ('3', '13218318053', 'WYP', '111111', 'X', 'X', 'X', '210908025', 'parent');
INSERT INTO `parent_tbl` VALUES ('6', '11111111111', 'BOB', '111111', 'X', 'X', 'X', '210908042', 'parent');
INSERT INTO `parent_tbl` VALUES ('7', '18936504809', '马爸爸', '123321', 'X', 'X', 'X', '210908050', 'parent');
INSERT INTO `parent_tbl` VALUES ('9', '12345678901', 'asdasd', '111111', 'X', 'X', 'X', '210908044', 'parent');
