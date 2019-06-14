/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-06-14 18:34:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `defaultAddr` varchar(10) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '1', 'true', '中国', '河南', '郑州', '金水区', '二环路', '7楼');
INSERT INTO `address` VALUES ('2', '1', 'true', '中国', '广西', '安宁', '鞍山区', '安环里', '7楼');
INSERT INTO `address` VALUES ('3', '1', 'false', '中国', '广东', '广州', '哈哈', '安徽', '无敌');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `userpass` varchar(50) NOT NULL DEFAULT '',
  `nickname` varchar(50) NOT NULL DEFAULT '',
  `age` int(11) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `userStatus` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '炫金呀', '123456', '炫金', '88', '男', '1067998193@qq.com', '18878560854', '2019-06-14 16:35:11', '2019-06-14 16:35:11', '2019-06-14 16:35:11', '0', null);
INSERT INTO `users` VALUES ('2', '呵呵', '1548854', '呵呵', '88', '男', '1067998193@qq.com', '18888888888', '2019-06-14 17:35:12', '2019-06-14 17:35:12', '2019-06-14 17:35:12', '0', null);
