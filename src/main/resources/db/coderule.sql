/*
Navicat MySQL Data Transfer

Source Server         : 测试库
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : coderule

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-10-11 09:11:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for code_littlerule
-- ----------------------------
DROP TABLE IF EXISTS `code_littlerule`;
CREATE TABLE `code_littlerule` (
  `littleRuleid` int(11) NOT NULL AUTO_INCREMENT,
  `littleRuleName` varchar(50) DEFAULT NULL,
  `fkBigRule` int(11) DEFAULT NULL,
  `fkTargetId` int(11) DEFAULT NULL,
  `typeClass` varchar(50) DEFAULT NULL,
  `conditionalValue` varchar(50) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `spacer` varchar(5) DEFAULT NULL,
  `param` varchar(50) DEFAULT '',
  PRIMARY KEY (`littleRuleid`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_littlerule
-- ----------------------------
INSERT INTO `code_littlerule` VALUES ('68', '时间', null, null, 'TimeBase', 'yy', null, '', '');
INSERT INTO `code_littlerule` VALUES ('69', '时间', null, null, 'TimeBase', 'yydd', null, '', '');
INSERT INTO `code_littlerule` VALUES ('70', '时间', null, null, 'TimeBase', 'HHMM', null, '', 'hm');
INSERT INTO `code_littlerule` VALUES ('71', '固定值', null, null, 'Fix', '_', null, '', '');
INSERT INTO `code_littlerule` VALUES ('72', '固定值', null, null, 'Fix', '#', null, '', '');
INSERT INTO `code_littlerule` VALUES ('73', '合同号', null, null, 'Fix', '*', null, '', 'ht');
INSERT INTO `code_littlerule` VALUES ('74', '流水号', null, null, 'Flow', '5', '0', '0', '');
INSERT INTO `code_littlerule` VALUES ('75', '流水号', null, null, 'Flow', '5', '6', '*', '');
INSERT INTO `code_littlerule` VALUES ('76', '流水号', null, null, 'Flow', '5', '54', '#', 'ls');
INSERT INTO `code_littlerule` VALUES ('77', '时间', null, null, 'TimeBase', 'dd', null, '', '');

-- ----------------------------
-- Table structure for code_target
-- ----------------------------
DROP TABLE IF EXISTS `code_target`;
CREATE TABLE `code_target` (
  `targetId` int(11) NOT NULL AUTO_INCREMENT,
  `targetCode` varchar(50) DEFAULT NULL,
  `targetName` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createName` varchar(50) DEFAULT NULL,
  `targetRemark` varchar(255) DEFAULT NULL,
  `targetRule` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`targetId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_target
-- ----------------------------
INSERT INTO `code_target` VALUES ('11', 'Code1', '销售订单', '2017-09-22 15:24:53', null, '不要删除', '68^TimeBase^yy^,72^Fix^#^,76^Flow^5^ls');
