/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:40:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for teacher_tbl
-- ----------------------------
CREATE TABLE `teacher_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tchNO` varchar(20) NOT NULL,
  `tchName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '888888',
  `gender` varchar(10) NOT NULL DEFAULT 'X',
  `tel` varchar(11) NOT NULL DEFAULT 'XXXXXXXXXXX',
  `tchEmail` varchar(20) NOT NULL DEFAULT 'XXXXX@XX.com',
  `remark` varchar(1) NOT NULL DEFAULT '0',
  `role` varchar(10) NOT NULL DEFAULT 'teacher',
  PRIMARY KEY (`id`,`tchNO`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `teacher_tbl` VALUES ('15', '1', 'a', '111111', 'X', 'XXXXXXXXXXX', '562449725@qq.com', '1', 'teacher');
INSERT INTO `teacher_tbl` VALUES ('16', '2', 'b', '111111', 'X', 'XXXXXXXXXXX', '491808144@qq.com', '1', 'teacher');
INSERT INTO `teacher_tbl` VALUES ('17', '3', 'c', '111111', 'X', 'XXXXXXXXXXX', '13218318053@163.com', '1', 'teacher');
INSERT INTO `teacher_tbl` VALUES ('19', '5', '李刚', '888888', 'X', 'XXXXXXXXXXX', 'XXXXX@XX.com', '0', 'teacher');
