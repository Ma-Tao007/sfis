/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for message_tbl
-- ----------------------------
CREATE TABLE `message_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `sendTime` date NOT NULL,
  `senderID` varchar(20) NOT NULL,
  `receiverID` varchar(20) DEFAULT NULL,
  `remark` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `message_tbl` VALUES ('104', 'a老师你好，我是bob家长', 'a老师你好，我是bob家长！\r\na老师你好，我是bob家长！', '2012-11-13', '11111111111', '1', '1');
INSERT INTO `message_tbl` VALUES ('105', 'a老师你好，我是well家长', 'a老师你好，我是well家长！\r\na老师你好，我是well家长！', '2012-11-13', '13218318053', '1', '1');
INSERT INTO `message_tbl` VALUES ('106', 'well', '', '2012-11-14', '1', '210908025', '1');
INSERT INTO `message_tbl` VALUES ('107', 'well你好，我是你的老师！', 'well你好，我是你的老师！\r\nwell你好，我是你的老师！', '2012-11-14', '1', '210908025', '1');
INSERT INTO `message_tbl` VALUES ('108', 'a 老师，我是well', 'a 老师，我是well!\r\na 老师，我是well!', '2012-11-14', '210908025', '1', '1');
INSERT INTO `message_tbl` VALUES ('109', '萨达是的撒的', '按时打算打算打算打算打撒的', '2012-11-14', '13218318053', '1', '1');
INSERT INTO `message_tbl` VALUES ('110', '啊实打实的', '阿萨德撒大声大声大声道', '2012-11-14', '1', '13218318053', '1');
INSERT INTO `message_tbl` VALUES ('111', 'niha', '', '2012-11-14', '210908042', '1', '1');
INSERT INTO `message_tbl` VALUES ('112', '我是谁', '我是学生', '2012-11-14', '210908042', '1', '1');
INSERT INTO `message_tbl` VALUES ('113', 'xzcxzxcxz', 'ZXZxzxXZxzxzXzczxc', '2012-11-15', '1', '210908042', '1');
INSERT INTO `message_tbl` VALUES ('114', 'well', 'well\r\nwell', '2012-11-15', '1', '210908025', '1');
INSERT INTO `message_tbl` VALUES ('115', 'asdasdasd', 'sadsadsadsadsad', '2012-11-15', '1', '210908025', '1');
INSERT INTO `message_tbl` VALUES ('116', 'dasad', 'asdasdsadasd', '2012-11-15', '1', '210908033', '1');
INSERT INTO `message_tbl` VALUES ('117', 'asdasd', 'asdazxczczxcxzcrtyhghvnmgh', '2012-11-15', '1', '11111111111', '1');
INSERT INTO `message_tbl` VALUES ('118', 'bob你好，我是你的老师', 'bob你好，我是你的老师！\r\nbob你好，我是你的老师！', '2012-11-15', '1', '210908042', '1');
INSERT INTO `message_tbl` VALUES ('119', '奥鹏蝶舞派人将额外破房间颇为富婆', '撒打算打算看的撒开店铺【俺是【撒开店铺【的撒泼【打开【怕撒开店铺【俺是【撒开【', '2012-11-15', '210908025', '1', '1');
INSERT INTO `message_tbl` VALUES ('120', '啊实打实的卡仕达', '撒大声地阿萨德安德森大神大声道啊是的撒的阿萨德爱上的撒旦阿萨德', '2012-11-15', '11111111111', '1', '1');
INSERT INTO `message_tbl` VALUES ('121', '123', '321', '2012-11-15', '1', '210908025', '0');
INSERT INTO `message_tbl` VALUES ('122', 'asdsada', 'asdasdasdsad', '2012-11-15', '2', '210908025', '0');
INSERT INTO `message_tbl` VALUES ('123', 'asdasd', 'asdasdsadasd', '2012-11-15', '2', '13218318053', '0');
INSERT INTO `message_tbl` VALUES ('124', 'asdadsd', 'asdasdasdsadsad', '2012-11-15', '1', '18936504809', '1');
INSERT INTO `message_tbl` VALUES ('125', '你好', '我是马家驹的爸爸', '2012-11-15', '18936504809', '1', '0');
INSERT INTO `message_tbl` VALUES ('126', 'asdsadasd', 'dsadasdadasds', '2012-11-15', '210908044', '1', '1');
INSERT INTO `message_tbl` VALUES ('127', 'sdasdasd', 'asdasdasdasdas', '2012-11-15', '1', '210908044', '1');
INSERT INTO `message_tbl` VALUES ('128', 'sdasdasd', 'adsasdasdasd', '2012-11-15', '1', '12345678901', '1');
