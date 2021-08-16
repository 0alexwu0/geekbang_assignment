/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : gk_order_1

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 17/08/2021 02:25:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_10
-- ----------------------------
DROP TABLE IF EXISTS `t_order_10`;
CREATE TABLE `t_order_10` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_11
-- ----------------------------
DROP TABLE IF EXISTS `t_order_11`;
CREATE TABLE `t_order_11` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_12
-- ----------------------------
DROP TABLE IF EXISTS `t_order_12`;
CREATE TABLE `t_order_12` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_13
-- ----------------------------
DROP TABLE IF EXISTS `t_order_13`;
CREATE TABLE `t_order_13` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_14
-- ----------------------------
DROP TABLE IF EXISTS `t_order_14`;
CREATE TABLE `t_order_14` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_15
-- ----------------------------
DROP TABLE IF EXISTS `t_order_15`;
CREATE TABLE `t_order_15` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_2
-- ----------------------------
DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_3
-- ----------------------------
DROP TABLE IF EXISTS `t_order_3`;
CREATE TABLE `t_order_3` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_4
-- ----------------------------
DROP TABLE IF EXISTS `t_order_4`;
CREATE TABLE `t_order_4` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_5
-- ----------------------------
DROP TABLE IF EXISTS `t_order_5`;
CREATE TABLE `t_order_5` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_6
-- ----------------------------
DROP TABLE IF EXISTS `t_order_6`;
CREATE TABLE `t_order_6` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_7
-- ----------------------------
DROP TABLE IF EXISTS `t_order_7`;
CREATE TABLE `t_order_7` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_8
-- ----------------------------
DROP TABLE IF EXISTS `t_order_8`;
CREATE TABLE `t_order_8` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

-- ----------------------------
-- Table structure for t_order_9
-- ----------------------------
DROP TABLE IF EXISTS `t_order_9`;
CREATE TABLE `t_order_9` (
  `id` bigint(64) unsigned NOT NULL,
  `order_sn` varchar(32) NOT NULL COMMENT '订单号',
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单最终总额 正数 不小于0',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '0新生成 1未支付 2已支付 3已出库 4已发货 5已确认 9已取消',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单信息';

SET FOREIGN_KEY_CHECKS = 1;
