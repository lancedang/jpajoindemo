/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : hackweek

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-03-17 21:06:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `book_detail_id` int(11) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`),
  KEY `fk_book_bookdetail_idx` (`book_detail_id`),
  CONSTRAINT `fk_book_bookdetail` FOREIGN KEY (`book_detail_id`) REFERENCES `book_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用于 table join 的案例表';

-- ----------------------------
-- Table structure for book_detail
-- ----------------------------
DROP TABLE IF EXISTS `book_detail`;
CREATE TABLE `book_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_count` int(11) DEFAULT NULL COMMENT '页数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_user
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) NOT NULL,
  `user_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(45) NOT NULL COMMENT '用户名',
  `email` varchar(45) DEFAULT NULL COMMENT '用户邮箱地址',
  `last_visit_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上一次访问时间',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `insert_by` varchar(45) DEFAULT NULL COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '最近修改者',
  `is_active` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `idx_inserttime` (`insert_time`),
  KEY `idx_updatetime` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_number` bigint(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
