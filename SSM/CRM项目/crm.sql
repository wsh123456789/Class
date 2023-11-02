/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2019-06-04 15:56:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL,
  `c_gender` char(1) DEFAULT NULL,
  `c_phone` varchar(255) DEFAULT NULL,
  `c_email` varchar(255) DEFAULT NULL,
  `c_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '小李', null, null, null, null);

-- ----------------------------
-- Table structure for `customer_care`
-- ----------------------------
DROP TABLE IF EXISTS `customer_care`;
CREATE TABLE `customer_care` (
  `care_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `care_theme` varchar(50) DEFAULT NULL,
  `care_way` varchar(50) DEFAULT NULL,
  `care_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `care_remark` varchar(1000) DEFAULT NULL,
  `care_nexttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `care_people` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`care_id`),
  KEY `FK_Reference_15` (`customer_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_care
-- ----------------------------
INSERT INTO `customer_care` VALUES ('1', '1', '纪念日', '送礼品', '2013-05-23 23:12:29', '节日纪念', '2013-05-28 23:12:34', '孙悟空', '1');
INSERT INTO `customer_care` VALUES ('2', '2', '生日', '上门拜访', '2013-05-23 23:14:00', '过生日', '2013-06-12 23:14:15', '猪八戒', '1');
INSERT INTO `customer_care` VALUES ('3', null, null, null, '0000-00-00 00:00:00', null, '2016-12-06 12:56:50', null, '1');
INSERT INTO `customer_care` VALUES ('4', null, null, null, '0000-00-00 00:00:00', null, '2016-12-06 12:56:50', null, '1');

-- ----------------------------
-- Table structure for `customer_condition`
-- ----------------------------
DROP TABLE IF EXISTS `customer_condition`;
CREATE TABLE `customer_condition` (
  `condition_id` int(10) NOT NULL AUTO_INCREMENT,
  `condition_name` varchar(50) DEFAULT NULL,
  `condition_explain` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_sex` varchar(255) DEFAULT NULL,
  `customer_mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_condition
-- ----------------------------
INSERT INTO `customer_condition` VALUES ('1', '潜在客户', '可能成为客户的人', '1', null, null, null);
INSERT INTO `customer_condition` VALUES ('2', '意向客户', '有意愿车成为客户的人', '1', null, null, null);
INSERT INTO `customer_condition` VALUES ('3', '交易客户', '正在交易的客户', '1', null, null, null);

-- ----------------------------
-- Table structure for `customer_info`
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `condition_id` int(10) DEFAULT NULL,
  `source_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `type_id` int(10) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `customer_sex` varchar(10) DEFAULT NULL,
  `customer_mobile` varchar(20) DEFAULT NULL,
  `customer_qq` varchar(20) DEFAULT NULL,
  `customer_address` varchar(500) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_remark` varchar(1000) DEFAULT NULL,
  `customer_job` varchar(100) DEFAULT NULL,
  `customer_blog` varchar(100) DEFAULT NULL,
  `customer_tel` varchar(20) DEFAULT NULL,
  `customer_msn` varchar(50) DEFAULT NULL,
  `birth_day` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `customer_addtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `customer_addman` varchar(50) DEFAULT NULL,
  `customer_changtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `change_man` varchar(20) DEFAULT NULL,
  `customer_company` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`customer_id`),
  KEY `FK_Reference_16` (`condition_id`),
  KEY `FK_Reference_17` (`source_id`),
  KEY `FK_Reference_18` (`type_id`),
  KEY `FK_Reference_23` (`user_id`),
  CONSTRAINT `FKdv2yjy7ho9dbbfkoy4pmv644t` FOREIGN KEY (`condition_id`) REFERENCES `customer_condition` (`condition_id`),
  CONSTRAINT `FKe58ic62nywuhc9abtlabil3ct` FOREIGN KEY (`source_id`) REFERENCES `customer_source` (`source_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`condition_id`) REFERENCES `customer_condition` (`condition_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`source_id`) REFERENCES `customer_source` (`source_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`type_id`) REFERENCES `customer_type` (`type_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('1', null, null, '1', null, '李四', '男', '13854545454', '23245', '重庆', '379727687@qq.com', '<span style=\"background-color:#f546ff;font-size:32px;\">123</span>', '学生', '6567', '52454789', '53423134', '2019-06-03 14:48:43', '2019-06-03 14:48:43', null, '2019-06-03 14:48:43', null, '微微', null);
INSERT INTO `customer_info` VALUES ('2', '1', '3', '1', '1', '华纳', '女', '13924452345', '23456', '重庆三峡', '379727687@qq.com', '						反反复复\r\n		\r\n		', '学生', '6576', '85858584', '45454555', '2013-05-01 15:40:53', '2013-05-23 23:05:44', '张三', '2013-05-25 09:31:47', '二位', '天天', '0');
INSERT INTO `customer_info` VALUES ('3', null, null, '1', null, '李四', '男', '13854545454', '23245', '重庆', '379727687@qq.com', null, '学生', '6567', '52454789', '53423134', '2019-06-03 14:39:11', '2019-06-03 14:39:11', null, '2019-06-03 14:39:11', null, '微微', null);
INSERT INTO `customer_info` VALUES ('4', '1', '1', '1', '1', '阿黄', '男', '13544455544', '454578', '重庆三峡学院', '379727687@qq.com', '			法国风格\r\n		', '学生', '6565', '25478547', '45444455', '2013-05-01 15:40:54', '2013-05-23 23:10:17', '张三', '2013-05-25 09:33:24', '恒河', '三峡学院', '1');
INSERT INTO `customer_info` VALUES ('7', '1', '1', '1', '3', '黄晓军', '男', '15111866066', '909239200', '重庆云阳', '909239200@qq.com', '这个客户很水', '屌丝', 'guanzhuwo@blog.com', '42232323', '2323232', '1992-09-10 16:21:00', '2013-05-25 16:20:38', '蒋大爷', '2013-05-25 16:20:38', '', '敏军网络科技有限公司', '1');
INSERT INTO `customer_info` VALUES ('8', '3', '2', '1', '1', '温庆心', '男', '13652354533', '454578', '爱上对方', '123156@qq.com', '很有钱', '码农', '', '', '', '1991-11-03 16:50:38', '2013-05-25 16:49:28', 'admin', '2013-05-25 16:52:07', '', '', '1');
INSERT INTO `customer_info` VALUES ('9', '1', '3', '6', '2', '刘老师', '男', '15111866066', '454578', '重庆丰都', '379727687@qq.com', '			\r\n		这是个好老师', '程序猿', '', '58105789', '', '1987-05-13 20:02:29', '2013-05-25 20:00:42', '蒋元征', '2013-05-25 20:04:57', '蒋元征', '中软国际', '1');
INSERT INTO `customer_info` VALUES ('11', null, null, null, null, '华纳', '男', '15115014323', '2334343', '重庆', 'sfdgsd@qq.com', '', 'asdf', 'asdf', '1332432', 'asfd', '2019-06-03 10:52:11', '2019-06-03 10:52:23', null, '2019-06-03 10:52:23', null, 'sfg', null);
INSERT INTO `customer_info` VALUES ('12', null, '2', null, '1', '李四', '男', '15115014323', '2334343', '重庆', 'sfdgsd@qq.com', 'asdf', 'asdf', 'asdf', '1332432', 'asfd', '2019-06-28 10:53:35', '2019-06-03 10:53:55', null, '2019-06-03 10:53:55', null, 'sfg', null);

-- ----------------------------
-- Table structure for `customer_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkman`;
CREATE TABLE `customer_linkman` (
  `linkman_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `linkman_name` varchar(50) DEFAULT NULL,
  `linkman_sex` varchar(20) DEFAULT NULL,
  `linkman_job` varchar(100) DEFAULT NULL,
  `linkman_mobile` varchar(20) DEFAULT NULL,
  `linkman_age` int(10) DEFAULT NULL,
  `linkman_relation` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`linkman_id`),
  KEY `FK_Reference_20` (`customer_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_linkman
-- ----------------------------
INSERT INTO `customer_linkman` VALUES ('1', '2', '小李', '男', '老板', '35667', '34', '上下属', '1');

-- ----------------------------
-- Table structure for `customer_linkreord`
-- ----------------------------
DROP TABLE IF EXISTS `customer_linkreord`;
CREATE TABLE `customer_linkreord` (
  `record_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `link_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `who_link` varchar(50) DEFAULT NULL,
  `link_type` varchar(50) DEFAULT NULL,
  `link_theme` varchar(200) DEFAULT NULL,
  `link_nexttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `link_remark` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`record_id`),
  KEY `FK_Reference_19` (`customer_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_linkreord
-- ----------------------------
INSERT INTO `customer_linkreord` VALUES ('1', '1', '2013-05-23 23:15:11', '张三', '打电话', '过来买房', '2013-05-28 23:15:14', '很好', '1');

-- ----------------------------
-- Table structure for `customer_source`
-- ----------------------------
DROP TABLE IF EXISTS `customer_source`;
CREATE TABLE `customer_source` (
  `source_id` int(10) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_source
-- ----------------------------
INSERT INTO `customer_source` VALUES ('1', '自己上门', '1');
INSERT INTO `customer_source` VALUES ('2', '网上咨询', '1');
INSERT INTO `customer_source` VALUES ('3', '朋友推荐', '1');

-- ----------------------------
-- Table structure for `customer_type`
-- ----------------------------
DROP TABLE IF EXISTS `customer_type`;
CREATE TABLE `customer_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_type
-- ----------------------------
INSERT INTO `customer_type` VALUES ('1', '客户', '1');
INSERT INTO `customer_type` VALUES ('2', '合作伙伴', '1');
INSERT INTO `customer_type` VALUES ('3', '供应商', '1');
INSERT INTO `customer_type` VALUES ('4', '合作伙伴', '1');

-- ----------------------------
-- Table structure for `department_info`
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `department_id` int(10) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) DEFAULT NULL,
  `department_desc` varchar(500) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '财务部', '很有钱', '1');
INSERT INTO `department_info` VALUES ('2', '人事部', '管人的', '1');
INSERT INTO `department_info` VALUES ('3', '销售部', '搞销售的', '1');

-- ----------------------------
-- Table structure for `email_info`
-- ----------------------------
DROP TABLE IF EXISTS `email_info`;
CREATE TABLE `email_info` (
  `email_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `email_content` varchar(2000) DEFAULT NULL,
  `email_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email_state` varchar(50) DEFAULT NULL,
  `email_theme` varchar(200) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`email_id`),
  KEY `FK_Reference_14` (`user_id`),
  KEY `FK_Reference_21` (`customer_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_info
-- ----------------------------
INSERT INTO `email_info` VALUES ('21', '4', '1', '第三代是的大多数都是', '2013-05-25 19:48:27', '1', '地地道道是', '1');
INSERT INTO `email_info` VALUES ('22', '4', '4', '反对反对', '2013-05-25 19:49:15', '0', '风格大方的', '0');
INSERT INTO `email_info` VALUES ('23', '4', '4', '反对反对', '2013-05-25 19:49:28', '1', '风格大方的', '1');
INSERT INTO `email_info` VALUES ('24', '2', '1', '刚刚', '2013-05-25 19:50:38', '1', '123', '1');
INSERT INTO `email_info` VALUES ('25', '9', '1', '祝你生日快乐！身体健康！', '2013-05-25 20:22:31', '0', '生日快乐', '0');
INSERT INTO `email_info` VALUES ('26', '9', '1', '祝你生日快乐！身体健康！', '2017-06-13 17:36:49', '0', '生日快乐', '1');

-- ----------------------------
-- Table structure for `house_info`
-- ----------------------------
DROP TABLE IF EXISTS `house_info`;
CREATE TABLE `house_info` (
  `house_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `house_address` varchar(500) DEFAULT NULL,
  `house_price` int(20) DEFAULT NULL,
  `house_ambient` varchar(1000) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`house_id`),
  KEY `FK_Reference_13` (`user_id`),
  KEY `FK_Reference_26` (`type_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`type_id`) REFERENCES `house_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_info
-- ----------------------------
INSERT INTO `house_info` VALUES ('6', '2', '3', '滨江路', '10000', '很好啦！都来看看啊！', '1');
INSERT INTO `house_info` VALUES ('7', '1', '1', '三峡学院', '500', '你猜！', '1');
INSERT INTO `house_info` VALUES ('8', '1', '4', '2000', '500', 'gh ', '1');
INSERT INTO `house_info` VALUES ('9', '1', '1', '重庆云烟', '111', '这里是结婚生子的好地方', '1');
INSERT INTO `house_info` VALUES ('10', '1', '6', '重庆万州', '1200', '案发大发第三方', '1');
INSERT INTO `house_info` VALUES ('11', '1', '1', '重庆万州', '234', '', '1');
INSERT INTO `house_info` VALUES ('12', '1', '6', '重庆万州', '1200', '5555', '1');

-- ----------------------------
-- Table structure for `house_type`
-- ----------------------------
DROP TABLE IF EXISTS `house_type`;
CREATE TABLE `house_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_type
-- ----------------------------
INSERT INTO `house_type` VALUES ('1', '三室一厅', '1');
INSERT INTO `house_type` VALUES ('2', '三室两厅', '1');
INSERT INTO `house_type` VALUES ('3', '两室一厅', '1');
INSERT INTO `house_type` VALUES ('4', '四室两厅', '1');

-- ----------------------------
-- Table structure for `notice_info`
-- ----------------------------
DROP TABLE IF EXISTS `notice_info`;
CREATE TABLE `notice_info` (
  `notice_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `notice_item` varchar(100) DEFAULT NULL,
  `notice_content` varchar(2000) DEFAULT NULL,
  `notice_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `notice_endtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`notice_id`),
  KEY `FK_Reference_12` (`user_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_info
-- ----------------------------
INSERT INTO `notice_info` VALUES ('3', '4', '最近要开会', '记得带钱', '2013-05-23 23:22:12', '2013-05-30 23:22:29', '1');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '跳转地址',
  `parent_top` int(1) DEFAULT NULL COMMENT '是否为父类菜单',
  `parent_id` int(10) DEFAULT NULL COMMENT '父类菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '客户相关', '“”', '1', '0');
INSERT INTO `permission` VALUES ('2', '客户信息', '/customerAction_listByPageBean', '0', '1');
INSERT INTO `permission` VALUES ('3', '客户来源', '/customer_source', '0', '1');
INSERT INTO `permission` VALUES ('4', '客户状态', '/customer_source', '0', '1');
INSERT INTO `permission` VALUES ('5', '客户测试', '/customer_source', '0', '1');
INSERT INTO `permission` VALUES ('6', '角色管理', '“”', '1', '0');
INSERT INTO `permission` VALUES ('7', '分配角色', '/queryRole', '0', '6');
INSERT INTO `permission` VALUES ('8', '权限管理', '“”', '1', '0');
INSERT INTO `permission` VALUES ('9', '分配权限', '/customer_source', '0', '8');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_power` int(10) DEFAULT NULL,
  `is_used` int(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '1', '1');
INSERT INTO `role` VALUES ('2', '普通员工', '1', '1');

-- ----------------------------
-- Table structure for `role_permssion`
-- ----------------------------
DROP TABLE IF EXISTS `role_permssion`;
CREATE TABLE `role_permssion` (
  `id` int(10) DEFAULT NULL,
  `roleId` int(10) DEFAULT NULL,
  `permissionId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permssion
-- ----------------------------
INSERT INTO `role_permssion` VALUES ('1', '1', '1');
INSERT INTO `role_permssion` VALUES ('2', '1', '2');
INSERT INTO `role_permssion` VALUES ('3', '1', '3');
INSERT INTO `role_permssion` VALUES ('4', '1', '4');
INSERT INTO `role_permssion` VALUES ('5', '1', '5');
INSERT INTO `role_permssion` VALUES ('6', '1', '6');
INSERT INTO `role_permssion` VALUES ('7', '1', '7');
INSERT INTO `role_permssion` VALUES ('8', '1', '8');
INSERT INTO `role_permssion` VALUES ('9', '1', '9');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '测试111');
INSERT INTO `user` VALUES ('2', '小兰');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `department_id` int(10) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `pic` varchar(80) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_mobile` varchar(20) DEFAULT NULL,
  `user_age` int(10) DEFAULT NULL,
  `user_address` varchar(500) DEFAULT NULL,
  `user_num` varchar(100) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_tel` varchar(20) DEFAULT NULL,
  `user_idnum` varchar(20) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_addtime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `user_addman` varchar(50) DEFAULT NULL,
  `user_changetime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `user_changeman` varchar(50) DEFAULT NULL,
  `user_intest` varchar(1000) DEFAULT NULL,
  `user_diploma` varchar(20) DEFAULT NULL,
  `user_bankcard` varchar(20) DEFAULT NULL,
  `user_nation` varchar(20) DEFAULT NULL,
  `is_married` varchar(10) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_22` (`department_id`),
  KEY `FK_Reference_24` (`role_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`department_id`) REFERENCES `department_info` (`department_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`role_id`) REFERENCES `user_role2` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', '1', 'df48c49c96ef434b90ea6d827f90a61c.jpg', '张三', '女', '13525452584', '20', '北京', '1213', '202cb962ac59075b964b07152d234b70', '520001123', null, null, '2017-08-14 16:40:15', null, '2017-08-14 16:40:15', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('3', '1', '3', null, '李四', '男', '13254545454', '22', '上海', 'sdsd', '202cb962ac59075b964b07152d234b70', '520400112', null, null, '2017-08-11 14:44:35', null, '2017-08-11 14:44:35', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('4', '1', '1', null, '李会儿', '女', '13545454545', '55', '北京职业科技学院', 'qqq', '202cb962ac59075b964b07152d234b70', '5200660112', null, null, '2017-08-11 14:48:49', null, '2017-08-11 14:48:49', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('5', '1', '2', null, '123', '男', '13544477747', '2', '高老庄', '789', '202cb962ac59075b964b07152d234b70', '52000112', '524154655895854744', '3963547@qq.com', '2013-05-25 09:36:59', '张三', '2013-05-25 09:29:33', '未修改', '吃西瓜', '初中', '3535355555454787887', '汉', '已婚', '1');
INSERT INTO `user_info` VALUES ('6', '3', '1', null, '蒋元征', '男', '15923219017', '20', '重庆双桥', 'jiang', '202cb962ac59075b964b07152d234b70', '58105789', '500111199205191111', '253507692@qq.com', '2013-05-25 16:18:31', 'admin', '2013-05-25 16:20:27', '未修改', '上网、玩游戏', '本科', '6222023100045180177', '汉族', '未婚', '1');
INSERT INTO `user_info` VALUES ('7', '3', '1', null, '黄建新', '男', '15923219011', '21', '重庆开县', 'huang', '202cb962ac59075b964b07152d234b70', '58105744', '500111199205191114', '253507692@qq.com', '2013-05-25 19:55:29', '蒋元征', '2013-05-25 19:58:04', '未修改', '上网、DNF', '初中', '6222023100045180111', '汉族', '已婚', '1');
INSERT INTO `user_info` VALUES ('8', null, null, null, 'zhangsan', null, null, null, null, null, '123', null, null, null, '2019-04-11 13:48:58', null, '2019-04-11 13:48:58', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('9', null, null, null, '111', null, null, null, null, null, '111', null, null, null, '2019-04-11 13:50:14', null, '2019-04-11 13:50:14', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('10', null, null, null, '111', null, null, null, null, null, '111', null, null, null, '2019-04-11 13:51:09', null, '2019-04-11 13:51:09', null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('11', null, null, null, '111', null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('12', null, null, null, '111', null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('13', null, null, null, '111', null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('14', null, null, null, '111', null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('15', null, null, null, '111', null, null, null, null, null, '698d51a19d8a121ce581499d7b701668', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('16', null, null, null, '111', null, null, null, null, null, 'bcbe3365e6ac95ea2c0343a2395834dd', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('17', null, null, null, 'xiaoming111', null, null, null, null, null, '81dc9bdb52d04dc20036dbd8313ed055', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) DEFAULT NULL,
  `roleId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('9', '1', '1');

-- ----------------------------
-- Table structure for `user_role2`
-- ----------------------------
DROP TABLE IF EXISTS `user_role2`;
CREATE TABLE `user_role2` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_power` int(10) DEFAULT NULL,
  `is_used` varchar(10) DEFAULT '1',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role2
-- ----------------------------
INSERT INTO `user_role2` VALUES ('1', '管理员', '3', '1');
INSERT INTO `user_role2` VALUES ('2', '员工', '2', '1');
INSERT INTO `user_role2` VALUES ('3', '老板', '1', '1');
INSERT INTO `user_role2` VALUES ('4', '赵四', '4', '1');
