/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 01/08/2021 22:32:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(32) NOT NULL COMMENT '商品id',
  `goods_code` char(16) DEFAULT NULL COMMENT '商品编码（整个产品的大编码非sku）',
  `goods_name` varchar(128) NOT NULL COMMENT '产品名称',
  `goods_amount` double(11,2) DEFAULT NULL COMMENT '售价',
  `attr_name` varchar(128) NOT NULL COMMENT '属性名称',
  `market_amount` double(11,2) DEFAULT NULL COMMENT '市场价',
  `weight` decimal(8,2) DEFAULT '0.00' COMMENT '重量,KG',
  `keywords` varchar(255) DEFAULT NULL COMMENT '搜索关键词',
  `pc_thumb` varchar(128) DEFAULT NULL COMMENT '电脑端封面',
  `pc_img` varchar(128) DEFAULT NULL COMMENT '电脑端图片',
  `mobile_thumb` varchar(128) DEFAULT NULL COMMENT '手机端封面',
  `mobile_img` varchar(128) DEFAULT NULL COMMENT '手机端图片',
  `desc` varchar(255) DEFAULT '' COMMENT '说明',
  `context` mediumtext NOT NULL COMMENT '商品描述',
  `sort` int(2) NOT NULL DEFAULT '50' COMMENT '排序权重',
  `sales_count` int(11) NOT NULL DEFAULT '0' COMMENT '销售量',
  `check_count` int(11) NOT NULL DEFAULT '0' COMMENT '查看量',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE,
  KEY `sort` (`sort`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8mb4 COMMENT='商品主表';

-- ----------------------------
-- Table structure for shop_goods_album
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_album`;
CREATE TABLE `shop_goods_album` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_album_id` varchar(32) NOT NULL COMMENT '商品相册表ID',
  `goods_id` varchar(32) NOT NULL COMMENT '商品ID',
  `media_type` int(1) NOT NULL DEFAULT '1' COMMENT '1图片 2视频',
  `file_name` varchar(128) NOT NULL COMMENT '文件名',
  `file_desc` mediumtext COMMENT '文件描述',
  `file_url` varchar(256) NOT NULL COMMENT '文件位置',
  `sort` smallint(3) unsigned NOT NULL DEFAULT '50',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `goods_album_id` (`goods_album_id`) USING BTREE,
  KEY `goods_id` (`goods_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COMMENT='商品相册表';

-- ----------------------------
-- Table structure for shop_goods_stock
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_stock`;
CREATE TABLE `shop_goods_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_stock_id` varchar(32) NOT NULL COMMENT '商品相册表ID',
  `goods_id` varchar(32) NOT NULL COMMENT '商品ID',
  `stock` int(11) NOT NULL COMMENT '库存',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `goods_stock_id` (`goods_stock_id`) USING BTREE,
  KEY `goods_id` (`goods_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COMMENT='商品主表';

-- ----------------------------
-- Table structure for shop_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_goods`;
CREATE TABLE `shop_order_goods` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_goods_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL DEFAULT '0',
  `goods_id` varchar(32) NOT NULL DEFAULT '0',
  `goods_name` varchar(255) DEFAULT '',
  `goods_code` varchar(60) DEFAULT NULL,
  `goods_number` mediumint(8) unsigned NOT NULL DEFAULT '1' COMMENT '购买数量',
  `goods_amount` decimal(10,6) NOT NULL DEFAULT '0.000000' COMMENT '产品售价',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '该产品全部数量的结算价格',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `order_goods_id` (`order_goods_id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `goods_id` (`goods_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品详情表';

-- ----------------------------
-- Table structure for shop_order_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_info`;
CREATE TABLE `shop_order_info` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `goods_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品总价',
  `express_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '快递费 正数',
  `total_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `name` varchar(60) DEFAULT NULL COMMENT '收件人',
  `mobile` varchar(60) DEFAULT NULL COMMENT '收件人电话',
  `province` mediumint(3) unsigned DEFAULT '0',
  `city` mediumint(5) unsigned DEFAULT '0',
  `dist` mediumint(6) unsigned DEFAULT '0',
  `address` varchar(255) DEFAULT NULL COMMENT '收件人地址',
  `user_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `shop_remark` varchar(256) DEFAULT NULL COMMENT '商家备注',
  `express_sn` varchar(50) DEFAULT NULL COMMENT '快递单SN',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `express_time` datetime DEFAULT NULL COMMENT '发货时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `order_id` (`order_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_code` varchar(255) DEFAULT NULL COMMENT '编码',
  `nick_name` varchar(64) NOT NULL COMMENT '昵称',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像',
  `intro` text COMMENT '简介',
  `gend` int(1) NOT NULL DEFAULT '0' COMMENT '性别 0未填写 1男 2女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态1有效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12927 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Table structure for user_access
-- ----------------------------
DROP TABLE IF EXISTS `user_access`;
CREATE TABLE `user_access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_access_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态1有效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_access_id` (`user_access_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE,
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户的用户名密码';

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_address_id` varchar(32) NOT NULL COMMENT '用户地址ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `phone` varchar(11) NOT NULL COMMENT '电话',
  `province` smallint(3) unsigned NOT NULL DEFAULT '0' COMMENT '省份',
  `city` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '城市',
  `dist` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '区县',
  `province_name` varchar(32) DEFAULT NULL COMMENT '经纬度-省名字',
  `city_name` varchar(32) DEFAULT NULL COMMENT '经纬度-城市名字',
  `dist_name` varchar(32) DEFAULT NULL COMMENT '经纬度-区名字',
  `address` mediumtext NOT NULL,
  `operator_id` mediumint(6) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态1有效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_address_id` (`user_address_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=utf8mb4 COMMENT='用户收件地址表';

-- ----------------------------
-- Table structure for user_open_wechat
-- ----------------------------
DROP TABLE IF EXISTS `user_open_wechat`;
CREATE TABLE `user_open_wechat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_access_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `openid` varchar(64) DEFAULT NULL,
  `unionid` varchar(500) DEFAULT NULL,
  `operator_id` int(11) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态1有效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_access_id` (`user_access_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `openid` (`openid`) USING BTREE,
  KEY `unionid` (`unionid`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1700 DEFAULT CHARSET=utf8mb4 COMMENT='第三方登录微信\n';

SET FOREIGN_KEY_CHECKS = 1;
