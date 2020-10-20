/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-11-26 16:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  `url` varchar(64) DEFAULT '',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'edit', '#');
INSERT INTO `permission` VALUES ('2', 'add', '#');
INSERT INTO `permission` VALUES ('3', 'delete', '#');

-- ----------------------------
-- Table structure for permission_role
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `pid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`pid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission_role
-- ----------------------------
INSERT INTO `permission_role` VALUES ('1', '2');
INSERT INTO `permission_role` VALUES ('1', '3');
INSERT INTO `permission_role` VALUES ('2', '1');
INSERT INTO `permission_role` VALUES ('3', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'customer');
INSERT INTO `role` VALUES ('3', 'sys');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '0192023a7bbd73250516f069df18b500');
INSERT INTO `user` VALUES ('2', 'customser', '123');
INSERT INTO `user` VALUES ('3', 'sys', '123');
INSERT INTO `user` VALUES ('4', 'md5', '0192023a7bbd73250516f069df18b500');
INSERT INTO `user` VALUES ('5', 'test', '47ec2dd791e31e2ef2076caf64ed9b3d');
INSERT INTO `user` VALUES ('6', 'test1', '4a3252a5edf8fcaa8bde0bfcce79560d');
INSERT INTO `user` VALUES ('7', 'chen', '6b4308e762489d86fd98151fbb476d2e');
INSERT INTO `user` VALUES ('8', 'register', 'fd8c61f409bef32b8123130a865fbe55');
INSERT INTO `user` VALUES ('9', 'admin', '0192023a7bbd73250516f069df18b500');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('3', '3');
