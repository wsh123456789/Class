/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50737 (5.7.37-log)
 Source Host           : localhost:3306
 Source Schema         : procurement

 Target Server Type    : MySQL
 Target Server Version : 50737 (5.7.37-log)
 File Encoding         : 65001

 Date: 13/11/2023 15:43:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for legal_replacement
-- ----------------------------
DROP TABLE IF EXISTS `legal_replacement`;
CREATE TABLE `legal_replacement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legalpersonCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replacementCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of legal_replacement
-- ----------------------------
INSERT INTO `legal_replacement` VALUES (1, '0001', 'a1a1');
INSERT INTO `legal_replacement` VALUES (2, '0001', 'a1a2');
INSERT INTO `legal_replacement` VALUES (3, '0001', 'a1a3');
INSERT INTO `legal_replacement` VALUES (4, '0001', 'a1a4');
INSERT INTO `legal_replacement` VALUES (5, '0002', 'a1a3');
INSERT INTO `legal_replacement` VALUES (6, '0002', 'a1a4');
INSERT INTO `legal_replacement` VALUES (7, '0003', 'a1a2');
INSERT INTO `legal_replacement` VALUES (8, '0002', 'a1a2');

-- ----------------------------
-- Table structure for legalperson
-- ----------------------------
DROP TABLE IF EXISTS `legalperson`;
CREATE TABLE `legalperson`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `legalPersonCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `legalPersonName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` int(1) NULL DEFAULT 1,
  `createTime` datetime NULL DEFAULT NULL,
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  `updateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `legalPersonCode`(`legalPersonCode`) USING BTREE COMMENT '法人编码'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of legalperson
-- ----------------------------
INSERT INTO `legalperson` VALUES (1, '0001', '联想(北京)', 1, '2023-11-08 15:23:38', NULL, NULL, NULL, 0);
INSERT INTO `legalperson` VALUES (2, '0002', '联想(上海)', 1, '2023-11-08 15:23:40', NULL, NULL, NULL, 0);
INSERT INTO `legalperson` VALUES (3, '0003', '联想(天津)', 1, '2023-11-08 15:23:43', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for legalperson_user
-- ----------------------------
DROP TABLE IF EXISTS `legalperson_user`;
CREATE TABLE `legalperson_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `legalPersonId` int(10) NULL DEFAULT NULL,
  `userId` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of legalperson_user
-- ----------------------------
INSERT INTO `legalperson_user` VALUES (1, 1, 1);
INSERT INTO `legalperson_user` VALUES (2, 2, 1);
INSERT INTO `legalperson_user` VALUES (3, 3, 1);
INSERT INTO `legalperson_user` VALUES (4, 1, 2);
INSERT INTO `legalperson_user` VALUES (5, 1, 2);

-- ----------------------------
-- Table structure for replacement
-- ----------------------------
DROP TABLE IF EXISTS `replacement`;
CREATE TABLE `replacement`  (
  `replacementId` int(10) NOT NULL AUTO_INCREMENT,
  `replacementCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replacementName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subclassName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spareName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(10) NULL DEFAULT 1 COMMENT '1是  0否',
  `borrow` int(10) NULL DEFAULT 1 COMMENT '1是  0否',
  `sale` int(10) NULL DEFAULT 1 COMMENT '1是  0否',
  `createTime` datetime NULL DEFAULT NULL,
  `createName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `changeTime` datetime NULL DEFAULT NULL,
  `changeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`replacementId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of replacement
-- ----------------------------
INSERT INTO `replacement` VALUES (1, 'a1a1', 'AAA', '高频头', NULL, '个', 1, 1, 1, '2023-11-09 16:17:09', 'zhangsan', '2023-11-09 16:17:17', 'zhangsan', 0);
INSERT INTO `replacement` VALUES (2, 'a1a2', 'BBB', 'LCD显示屏套件', NULL, '个', 1, 1, 1, '2023-11-09 16:18:42', 'zhangsan', '2023-11-09 16:18:48', 'zhangsan', 0);
INSERT INTO `replacement` VALUES (3, 'a1a3', 'CCC', 'LCD显示屏套件', NULL, '件', 1, 1, 1, '2023-11-09 16:19:38', 'lisi', '2023-11-09 16:19:43', 'lisi', 0);
INSERT INTO `replacement` VALUES (4, 'a1a4', 'DDD', '高频头', NULL, '件', 1, 1, 1, '2023-11-09 16:20:19', 'lisi', '2023-11-09 16:20:25', 'lisi', 0);

-- ----------------------------
-- Table structure for spare
-- ----------------------------
DROP TABLE IF EXISTS `spare`;
CREATE TABLE `spare`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT 1,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `updateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spare
-- ----------------------------
INSERT INTO `spare` VALUES (1, 'TVT', '高频头', 1, '就是高频！', NULL, NULL, NULL, NULL, 0);
INSERT INTO `spare` VALUES (2, 'AXM', 'LCD显示屏套件', 1, 'LCD还不行？', NULL, NULL, NULL, NULL, 0);
INSERT INTO `spare` VALUES (3, 'ATM', '提款机', 1, '你也是别人的提款机吗？', NULL, NULL, NULL, NULL, 0);
INSERT INTO `spare` VALUES (4, '123', 'AngusGOD', 0, '真的牛皮', '张三', '2023-11-06 18:19:13', '李四', '2023-11-06 19:19:03', 3);

-- ----------------------------
-- Table structure for subclass
-- ----------------------------
DROP TABLE IF EXISTS `subclass`;
CREATE TABLE `subclass`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT 1,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `updateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subclass
-- ----------------------------
INSERT INTO `subclass` VALUES (1, 'TVT', '高频头', 1, '就是高频！', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subclass` VALUES (2, 'AXM', 'LCD显示屏套件', 1, 'LCD还不行？', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subclass` VALUES (3, 'ATM', '提款机', 1, '你也是别人的提款机吗？', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subclass` VALUES (4, '123', 'AngusGOD', 1, '真的牛皮', '张三', '2023-11-06 18:19:13', '李四', '2023-11-06 19:19:03', 0);

-- ----------------------------
-- Table structure for suppliers
-- ----------------------------
DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE `suppliers`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `legalPersonCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `legalPlantCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `legalPlantDec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` int(1) NULL DEFAULT 1,
  `createTime` datetime NULL DEFAULT NULL,
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  `updateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suppliers
-- ----------------------------
INSERT INTO `suppliers` VALUES (1, '0001', '0110', '笔记本工厂', 1, '2023-11-08 15:23:12', NULL, NULL, NULL, 0);
INSERT INTO `suppliers` VALUES (2, '0001', '0153', '服务器备件工厂', 1, '2023-11-08 15:23:15', NULL, NULL, NULL, 0);
INSERT INTO `suppliers` VALUES (3, '0001', '0112', '键盘工厂', 1, '2023-11-08 15:23:17', NULL, NULL, NULL, 0);
INSERT INTO `suppliers` VALUES (4, '0002', '0116', '鼠标工厂', 1, '2023-11-08 15:23:20', NULL, NULL, NULL, 0);
INSERT INTO `suppliers` VALUES (5, '0003', '1111', '牛战士', 1, '2023-11-08 18:43:30', 'zhagnsan', '2023-11-08 18:43:30', 'zhagnsan', 4);

-- ----------------------------
-- Table structure for threshold
-- ----------------------------
DROP TABLE IF EXISTS `threshold`;
CREATE TABLE `threshold`  (
  `thresholdId` int(11) NOT NULL AUTO_INCREMENT,
  `legalpersonCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replacementCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `threshold` int(4) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `createName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `changeTime` datetime NULL DEFAULT NULL,
  `changeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`thresholdId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of threshold
-- ----------------------------
INSERT INTO `threshold` VALUES (1, '0001', 'a1a1', 5000, '需求量大', '2023-11-09 00:00:00', 'zhangsan', '2023-11-09 00:00:00', 'zhangsan', 0);
INSERT INTO `threshold` VALUES (2, '0001', 'a1a2', 2500, '急需', '2023-11-09 00:00:00', 'zhangsan', '2023-11-09 00:00:00', 'zhangsan', 0);
INSERT INTO `threshold` VALUES (3, '0001', 'a1a3', 3000, '不着急', '2023-11-09 00:00:00', 'lisi', '2023-11-09 00:00:00', 'lisi', 0);
INSERT INTO `threshold` VALUES (4, '0001', 'a1a4', 1000, '需求量少', '2023-11-09 00:00:00', 'lisi', '2023-11-09 00:00:00', 'lisi', 0);
INSERT INTO `threshold` VALUES (5, '0002', 'a1a3', 3500, '赶快赶快', '2023-11-09 00:00:00', 'zhangsan', '2023-11-09 00:00:00', 'zhangsan', 0);
INSERT INTO `threshold` VALUES (6, '0002', 'a1a4', 3000, '来不及了', '2023-11-09 00:00:00', 'zhangsan', '2023-11-09 00:00:00', 'zhangsan', 0);
INSERT INTO `threshold` VALUES (7, '0003', 'a1a2', 2000, '慢慢来', '2023-11-09 00:00:00', 'lisi', '2023-11-09 00:00:00', 'lisi', 0);
INSERT INTO `threshold` VALUES (8, '0003', 'a1a4', 9999, '急需', '2023-11-10 00:00:00', 'zhagnsan', '2023-11-10 00:00:00', 'zhagnsan', 0);
INSERT INTO `threshold` VALUES (10, '0002', 'a1a2', 111, '111', '2023-11-12 00:00:00', 'zhagnsan', '2023-11-12 00:00:00', 'zhagnsan', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  `updateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '123', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (2, '李四', '123', NULL, NULL, NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
