/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-03-22 15:14:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `ID` bigint(20) NOT NULL auto_increment,
  `USER_ID` varchar(30) NOT NULL COMMENT '用户id',
  `USER_NAME` varchar(30) NOT NULL COMMENT '用户姓名',
  `NICK_NAME` varchar(30) default NULL COMMENT '昵称',
  `BRITH_DATE` datetime default NULL COMMENT '用户出生年月',
  `CTEATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `USER_PASSWOED` varchar(50) NOT NULL COMMENT '用户密码',
  `USER_PHOTO` varchar(255) NOT NULL COMMENT '用户图像',
  `USER_LEVE` int(5) NOT NULL COMMENT '用户等级',
  `USER_PHONE` varchar(30) default NULL COMMENT '用户电话号码',
  `USER_ACCOUNT` varchar(50) NOT NULL COMMENT '用户账号',
  `ACCOUNT_TYPE` int(10) NOT NULL COMMENT '账号类型(0:手机号码1:邮箱)',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
