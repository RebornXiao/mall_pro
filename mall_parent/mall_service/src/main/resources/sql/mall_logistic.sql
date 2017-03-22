/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-03-22 15:14:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_logistic
-- ----------------------------
DROP TABLE IF EXISTS `mall_logistic`;
CREATE TABLE `mall_logistic` (
  `ID` bigint(100) NOT NULL,
  `GOODS_ID` int(10) NOT NULL COMMENT '商品ID',
  `USER_ID` varchar(30) NOT NULL COMMENT '收货人地址',
  `GOODS_TYPE` int(10) NOT NULL,
  `GOODS_AMOUNT` bigint(20) NOT NULL,
  `GOODS_COUNT_SALARY` double(10,0) NOT NULL COMMENT '总金额',
  `RECEVE_ADDRES` varchar(255) NOT NULL COMMENT '收货地址',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
