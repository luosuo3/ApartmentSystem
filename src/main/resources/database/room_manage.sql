/*
 Navicat Premium Data Transfer

 Source Server         : schoolsystem
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : apartment_system

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 19/05/2020 17:21:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for room_manage
-- ----------------------------
DROP TABLE IF EXISTS `room_manage`;
CREATE TABLE `room_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `room_nums` int(11) NOT NULL DEFAULT '103' COMMENT '房间号',
  `username` varchar(56) DEFAULT NULL COMMENT '入住用户名字',
  `check_in` int(11) NOT NULL DEFAULT '0' COMMENT '是否入住0为未入住',
  `status` int(11) DEFAULT '1' COMMENT '是否禁用0为禁用',
  `in_time` datetime DEFAULT NULL COMMENT '入住时间',
  `out_time` datetime DEFAULT NULL COMMENT '离开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_manage
-- ----------------------------
BEGIN;
INSERT INTO `room_manage` VALUES (1, 101, '王峥', 1, 0, '2020-05-18 18:36:04', '2020-06-18 20:36:12');
INSERT INTO `room_manage` VALUES (2, 102, '顾文杰', 1, 1, '2020-05-18 21:47:25', '2020-06-18 21:47:28');
INSERT INTO `room_manage` VALUES (3, 103, NULL, 0, 0, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
