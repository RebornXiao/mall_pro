/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-03-22 15:14:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_goods_sales
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_sales`;
CREATE TABLE `mall_goods_sales` (
  `ID` bigint(20) NOT NULL auto_increment,
  `GOODS_ID` int(11) NOT NULL COMMENT '商品id',
  `GOODS_TYPE` varchar(20) NOT NULL COMMENT '商品类型',
  `SALES_AMOUNT` bigint(20) unsigned zerofill NOT NULL COMMENT '销售总量',
  `SALES_SURPLUS` bigint(20) unsigned zerofill NOT NULL COMMENT '剩余数量',
  `GOODS_SALARY` double(10,0) NOT NULL COMMENT '产品单价',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
