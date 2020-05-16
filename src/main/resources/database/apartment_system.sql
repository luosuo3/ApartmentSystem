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

 Date: 16/05/2020 17:04:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_room
-- ----------------------------
DROP TABLE IF EXISTS `book_room`;
CREATE TABLE `book_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(56) NOT NULL COMMENT '入住用户姓名\n',
  `id_card` varchar(256) NOT NULL COMMENT '身份证号',
  `room_nummber` int(11) NOT NULL COMMENT '入住房间号\n',
  `in_time` datetime NOT NULL COMMENT '入住时间\n',
  `out_time` datetime DEFAULT NULL COMMENT '离开时间\n',
  `deposit` int(11) DEFAULT NULL COMMENT '定金\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_room
-- ----------------------------
BEGIN;
INSERT INTO `book_room` VALUES (1, '王峥', '1234567890', 1, '2020-05-10 00:00:00', '2020-12-30 00:00:00', 100);
INSERT INTO `book_room` VALUES (2, '申杰', '2321312321321', 2, '2020-05-10 00:00:00', '2020-12-30 00:00:00', 200);
INSERT INTO `book_room` VALUES (3, '王慧凯', '1131232312321', 2, '2020-04-29 00:00:00', '2020-12-30 00:00:00', 100);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(56) NOT NULL COMMENT '用户登录名字',
  `password` varchar(56) NOT NULL COMMENT '用户登录密码\n',
  `type` int(11) DEFAULT '0' COMMENT '0是学生1是管理员\n',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '17851207', '123456', 0);
INSERT INTO `user` VALUES (2, 'admin', 'admin', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
