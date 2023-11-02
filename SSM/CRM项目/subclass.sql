/*
 Navicat Premium Data Transfer

 Source Server         : 230302
 Source Server Type    : MySQL
 Source Server Version : 50550
 Source Host           : localhost:3306
 Source Schema         : 0423

 Target Server Type    : MySQL
 Target Server Version : 50550
 File Encoding         : 65001

 Date: 12/05/2023 09:53:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subclass
-- ----------------------------
DROP TABLE IF EXISTS `subclass`;
CREATE TABLE `subclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备件小类编码',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备件小类名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0：禁用，1：启用',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_people` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `modify_people` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
