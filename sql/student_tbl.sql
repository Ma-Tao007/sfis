/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student_tbl
-- ----------------------------
CREATE TABLE `student_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuNO` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '888888',
  `stuName` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL DEFAULT 'X',
  `stuEmail` varchar(20) NOT NULL DEFAULT 'XXXXX@XX.com',
  `stuClass` varchar(20) NOT NULL DEFAULT 'XXXX',
  `department` varchar(30) NOT NULL DEFAULT 'XXXX',
  `remark` varchar(1) NOT NULL DEFAULT '0',
  `role` varchar(10) NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`,`stuNO`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student_tbl` VALUES ('33', '210908025', '111111', 'well', 'X', 'jwillim@163.com', 'XXXX', 'XXXX', '1', 'student');
INSERT INTO `student_tbl` VALUES ('34', '210908042', '111111', 'bob', 'X', '491808144@qq.com', 'XXXX', 'XXXX', '1', 'student');
INSERT INTO `student_tbl` VALUES ('35', '210908033', '111111', 'yanmin', 'X', '491808144@qq.com', 'XXXX', 'XXXX', '1', 'student');
INSERT INTO `student_tbl` VALUES ('36', '210908002', '111111', 'dongzhi', 'X', '562449725@qq.com', 'XXXX', 'XXXX', '1', 'student');
INSERT INTO `student_tbl` VALUES ('37', '210908050', '111111', '马加爵', 'X', '304707486@qq.com', 'XXXX', 'XXXX', '1', 'student');
INSERT INTO `student_tbl` VALUES ('38', '210908045', '888888', 'yunfeng', 'X', 'XXXXX@XX.com', 'XXXX', 'XXXX', '0', 'student');
INSERT INTO `student_tbl` VALUES ('39', '210908001', '888888', 'cai', 'X', 'XXXXX@XX.com', 'XXXX', 'XXXX', '0', 'student');
INSERT INTO `student_tbl` VALUES ('41', '210908044', '111111', 'a', 'X', '13218318053@163.com', 'XXXX', 'XXXX', '1', 'student');
