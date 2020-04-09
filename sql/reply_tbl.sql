/*
MySQL Data Transfer
Source Host: 192.168.23.29
Source Database: oldfish
Target Host: 192.168.23.29
Target Database: oldfish
Date: 2012-11-15 18:39:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for reply_tbl
-- ----------------------------
CREATE TABLE `reply_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `replyTime` date NOT NULL,
  `replyerID` varchar(20) NOT NULL,
  `messageID` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `reply_tbl` VALUES ('1', 'asdasddsaadsad', '2012-11-14', '1', '104');
INSERT INTO `reply_tbl` VALUES ('2', 'sadasdasdasd', '2012-11-14', '1', '104');
INSERT INTO `reply_tbl` VALUES ('3', 'dasdasd', '2012-11-14', '1', '104');
INSERT INTO `reply_tbl` VALUES ('4', 'asdasdsadasdasdczxcxzczxcxzczxcxzc', '2012-11-14', '1', '104');
INSERT INTO `reply_tbl` VALUES ('5', '知道了，学生well。', '2012-11-14', '1', '108');
INSERT INTO `reply_tbl` VALUES ('6', '大声大声道', '2012-11-14', '1', '110');
INSERT INTO `reply_tbl` VALUES ('7', '1233213', '2012-11-14', '1', '111');
INSERT INTO `reply_tbl` VALUES ('8', '3213', '2012-11-14', '210908042', '111');
INSERT INTO `reply_tbl` VALUES ('9', 'sdaasdsadsadasd', '2012-11-15', '210908025', '115');
INSERT INTO `reply_tbl` VALUES ('10', 'asdsadasdasdsadasd', '2012-11-15', '1', '115');
INSERT INTO `reply_tbl` VALUES ('11', '你好，老师', '2012-11-15', '210908042', '118');
INSERT INTO `reply_tbl` VALUES ('12', 'asdasdasdsadsad', '2012-11-15', '1', '118');
INSERT INTO `reply_tbl` VALUES ('13', 'sadasdsadasd', '2012-11-15', '11111111111', '104');
INSERT INTO `reply_tbl` VALUES ('14', 'sadasdasdasd', '2012-11-15', '11111111111', '117');
INSERT INTO `reply_tbl` VALUES ('15', 'sadasdasdadsdasd', '2012-11-15', '1', '108');
INSERT INTO `reply_tbl` VALUES ('16', 'asdsadasdasdasdsadasd', '2012-11-15', '1', '108');
INSERT INTO `reply_tbl` VALUES ('17', '的外围王企鹅完全', '2012-11-15', '11111111111', '117');
INSERT INTO `reply_tbl` VALUES ('18', '3213', '2012-11-15', '1', '120');
INSERT INTO `reply_tbl` VALUES ('19', '231312', '2012-11-15', '1', '119');
INSERT INTO `reply_tbl` VALUES ('20', 'sdhfuasdhfoasd', '2012-11-15', '1', '126');
INSERT INTO `reply_tbl` VALUES ('21', 'suhdasdohfao', '2012-11-15', '210908044', '126');
INSERT INTO `reply_tbl` VALUES ('22', 'ashdlkasdlksad', '2012-11-15', '210908044', '127');
INSERT INTO `reply_tbl` VALUES ('23', 'asdasdasd', '2012-11-15', '12345678901', '128');
INSERT INTO `reply_tbl` VALUES ('24', 'sdadasdasdasd', '2012-11-15', '1', '128');
