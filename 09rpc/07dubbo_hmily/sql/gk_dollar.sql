/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : gk_dollar

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 24/08/2021 00:27:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wallet_dollar
-- ----------------------------
DROP TABLE IF EXISTS `wallet_dollar`;
CREATE TABLE `wallet_dollar` (
  `user_id` int(11) NOT NULL,
  `money` double(11,2) NOT NULL DEFAULT '0.00',
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of wallet_dollar
-- ----------------------------
BEGIN;
INSERT INTO `wallet_dollar` VALUES (1, 50.00, '2021-08-24 00:21:31');
COMMIT;

-- ----------------------------
-- Table structure for wallet_dollar_logs
-- ----------------------------
DROP TABLE IF EXISTS `wallet_dollar_logs`;
CREATE TABLE `wallet_dollar_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `money` double(11,2) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of wallet_dollar_logs
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
