/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ucp

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-09-21 21:56:24
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
  `admin_state` smallint(6) DEFAULT NULL COMMENT '状态：正常、禁用，对应java的枚举类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `role_id` bigint(20) NOT NULL,
  `admin_mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `admin_email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1631694462743', 'admin-zy', '123456', '1', '2021-09-13 16:28:48', '2021-09-13 16:28:48', '1631692579832', '18215626820', '185964885@qq.com');

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
INSERT INTO `tb_user` VALUES ('1631521728944', 'zy1', '123456', '1', '易哥1', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 16:28:48', '2021-09-13 16:28:48', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794549', 'zy2', '123456', '1', '易哥2', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794550', 'zy3', '123456', '1', '易哥3', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794551', 'zy4', '123456', '1', '易哥4', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794552', 'zy5', '123456', '1', '易哥5', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794553', 'zy6', '123456', '1', '易哥6', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794554', 'zy7', '123456', '1', '易哥7', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794555', 'zy8', '123456', '1', '易哥8', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794556', 'zy9', '123456', '1', '易哥9', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794557', 'zy10', '123456', '1', '易哥10', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794558', 'zy11', '123456', '1', '易哥11', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794559', 'zy12', '123456', '1', '易哥12', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1631527794560', 'zy13', '123456', '1', '易哥13', '123456789', '邹易', null, null, '10', '12345678', null, null, null, '2021-09-13 18:09:54', '2021-09-13 18:09:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1632063534145', 'zy14', '123456', '1', '易哥14', '13135468435132132', '邹易', null, null, '10', '18215626820', null, null, null, '2021-09-19 22:58:54', '2021-09-19 22:58:54', '1631693611742');
INSERT INTO `tb_user` VALUES ('1632232498548', 'zy', '123456', '1', '易哥', '513002199105122554', '邹易', null, null, '10', '18215626820', null, null, null, '2021-09-21 21:54:58', '2021-09-21 21:54:58', '1631693611742');
