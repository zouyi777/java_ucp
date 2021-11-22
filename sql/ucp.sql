/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : ucp

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-11-22 22:25:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL,
  `admin_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `admin_password` varchar(128) DEFAULT NULL COMMENT '密码',
  `admin_nickname` varchar(30) DEFAULT NULL,
  `admin_mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `admin_email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `admin_state` smallint(6) DEFAULT NULL COMMENT '状态：正常、禁用，对应java的枚举类型',
  `role_id` bigint(20) unsigned NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1631694462743', 'admin-zy', 'e10adc3949ba59abbe56e057f20f883e', '系统管理员', '18215626820', '2021-09-13 16:28:48', '185964885@qq.com', '1', '1631692579832', '2021-09-13 16:28:48');

-- ----------------------------
-- Table structure for `tb_right`
-- ----------------------------
DROP TABLE IF EXISTS `tb_right`;
CREATE TABLE `tb_right` (
  `id` bigint(20) NOT NULL,
  `right_name` varchar(30) NOT NULL,
  `right_rule` varchar(128) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_right
-- ----------------------------
INSERT INTO `tb_right` VALUES ('1631691997514', '系统管理权限', '/admin', '2021-09-13 16:28:48', '2021-09-13 16:28:48');
INSERT INTO `tb_right` VALUES ('1631693379969', '普通用户权限', '/', '2021-09-13 16:28:48', '2021-09-13 16:28:48');

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(30) NOT NULL,
  `role_code` varchar(30) NOT NULL,
  `description` varchar(128) NOT NULL,
  `right_id` bigint(20) NOT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1631692579832', '超级管理员', 'administrator', '拥有最高权限', '1631691997514', '2021-09-13 16:28:48', '2021-09-13 16:28:48');
INSERT INTO `tb_role` VALUES ('1631693611742', '普通用户', 'customer', '拥有普通用户权限', '1631693379969', '2021-09-13 16:28:48', '2021-09-13 16:28:48');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL COMMENT '用户Id',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(128) DEFAULT NULL COMMENT '密码',
  `user_state` smallint(6) DEFAULT NULL COMMENT '状态：正常、禁用，对应java的枚举类型',
  `user_nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `user_id_number` varchar(18) DEFAULT NULL COMMENT '身份证号号码',
  `user_realname` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `user_avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `user_birthday` date DEFAULT NULL COMMENT '生日',
  `user_gender` smallint(6) DEFAULT NULL COMMENT '性别，对应java的枚举类型',
  `user_mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `user_address` varchar(128) DEFAULT NULL,
  `user_slef_word` varchar(128) DEFAULT NULL COMMENT '个性签名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userName` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1635164214642', 'zy', 'e10adc3949ba59abbe56e057f20f883e', '0', '易哥', '513002099105122554', '张三', 'default-head.png', '2021-10-28', '10', '18215626820', '185964885@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生', '2021-10-25 20:16:54', '2021-10-25 20:16:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635164253049', 'zy1', 'e10adc3949ba59abbe56e057f20f883e', '1', '易哥', '513002099105122554', '张三', 'default-head.png', '2021-10-30', '10', '18215626821', '185964886@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生', '2021-10-25 20:17:33', '2021-10-25 20:17:33', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635164287499', 'zy2', 'e10adc3949ba59abbe56e057f20f883e', '0', '易哥', '513002099105122554', '张三', 'default-head.png', '2021-10-30', '10', '18215626822', '185964887@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生', '2021-10-25 20:18:07', '2021-10-25 20:18:07', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635164311473', 'zy3', 'e10adc3949ba59abbe56e057f20f883e', '1', '易哥', '513002099105122554', '张三', 'default-head.png', '2021-10-30', '10', '18215626823', '185964888@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生', '2021-10-25 20:18:31', '2021-10-25 20:18:31', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635170357883', 'zy4', 'e10adc3949ba59abbe56e057f20f883e', '1', '易哥', '513002099105122554', '张三', 'default-head.png', '2021-10-30', '10', '18215626824', '185964889@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生', '2021-10-25 21:59:17', '2021-10-25 21:59:17', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635170389139', 'zy5', 'e10adc3949ba59abbe56e057f20f883e', '1', '易哥', '513002099105122554', '张三', 'default-head.png', null, '10', '18215626825', '185964890@qq.com', '成都市新津区', '当停下脚步发现这个世界竟然变得如此陌生22222222222222222222', '2021-10-25 21:59:49', '2021-10-31 14:47:08', '1631693611742');
INSERT INTO `tb_user` VALUES ('1635599053697', 'zy6', 'e10adc3949ba59abbe56e057f20f883e', '1', '易哥6', '513002099105122554', '张三', 'default-head.png', null, '10', '18215626826', '185964891@qq.com', '成都市新津区', '111111111111111111111111111', '2021-10-30 21:04:13', '2021-10-31 14:45:17', '1631693611742');

-- ----------------------------
-- Table structure for `tb_works`
-- ----------------------------
DROP TABLE IF EXISTS `tb_works`;
CREATE TABLE `tb_works` (
  `id` bigint(20) NOT NULL COMMENT '作品Id',
  `content` varchar(255) DEFAULT NULL COMMENT '文字内容',
  `quote` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '引用：图片、视频等',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `comment_id` bigint(20) DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_works
-- ----------------------------
INSERT INTO `tb_works` VALUES ('1636778992522', '我是檐上三寸雪，你是人间惊鸿客', 'default-works.png', '2021-11-13 12:49:52', '2021-11-13 12:49:52', '1635164214642', null);
INSERT INTO `tb_works` VALUES ('1636778992551', '城南小陌又逢春，只见梅花不见人', 'default-works.png', '2021-11-13 12:49:52', '2021-11-13 12:49:52', '1635164214642', null);
INSERT INTO `tb_works` VALUES ('1636778992555', '本是青灯不归客，却因浊酒恋红尘', 'default-works.png', '2021-11-13 12:49:52', '2021-11-13 12:49:52', '1635164214642', null);
