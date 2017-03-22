/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-03-22 15:14:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `ID` bigint(20) NOT NULL auto_increment,
  `GOODS_ID` int(11) NOT NULL COMMENT '商品id',
  `GOODS_TYPE` varchar(10) NOT NULL COMMENT '商品类型(0:手机1:笔记本电脑2:智能穿戴3:空气净化器4:厨卫5:其他)',
  `GOODS_PRICE` double(10,0) NOT NULL COMMENT '商品价格',
  `PRODUCT_DATE` datetime NOT NULL COMMENT '商品生产日期',
  `GOODS_PHOTO` varchar(100) default NULL COMMENT '商品图片',
  `GOODS_STATUS` int(5) NOT NULL COMMENT '商品是否上下架（0:为待上架1:上架2:下架）',
  `GOODS_AMOUT` bigint(20) NOT NULL COMMENT '商品数量',
  `GOODS_PROPER` int(10) NOT NULL COMMENT '商品属性(0:热销商品1:优惠商品2:最新产品)',
  `CONTACT_TEL` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
