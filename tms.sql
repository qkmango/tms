/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : tms

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 14/10/2022 17:53:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', b'1', '1', 'postmaster@qkmango.cn');

-- ----------------------------
-- Table structure for t_building
-- ----------------------------
DROP TABLE IF EXISTS `t_building`;
CREATE TABLE `t_building`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '楼id',
  `number` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼号,可以有英文结尾',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼名称',
  `buildingType` enum('j','s','q') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼类型， pedagogical教学楼，experimental实验楼,other其他',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UQ_number_buildingType`(`number`, `buildingType`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_building
-- ----------------------------
INSERT INTO `t_building` VALUES (1, '13', '大数据与人工智能学院', 'j');
INSERT INTO `t_building` VALUES (2, '11', '艺术学院', 'j');
INSERT INTO `t_building` VALUES (3, '12', '财会与金融学院', 'j');
INSERT INTO `t_building` VALUES (5, '14', '电子工程学院', 'j');
INSERT INTO `t_building` VALUES (6, '1', '土木与环境工程学院-A', 'j');
INSERT INTO `t_building` VALUES (7, '2', '土木与环境工程学院-B1', 'j');
INSERT INTO `t_building` VALUES (8, '7A', '国际教育学院', 'j');
INSERT INTO `t_building` VALUES (9, '7B', '文化与新闻传播学院', 'j');
INSERT INTO `t_building` VALUES (10, '15', '科技学院', 'j');

-- ----------------------------
-- Table structure for t_calendar
-- ----------------------------
DROP TABLE IF EXISTS `t_calendar`;
CREATE TABLE `t_calendar`  (
  `year` int(11) NOT NULL COMMENT '学年',
  `term` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学期1,2',
  `start` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学期起始日期',
  `end` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学期结束日期',
  `holiday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '假期格式字符串\n2022-5-1,2,3,4,5,6,7\n2022-6-5,6',
  PRIMARY KEY (`year`, `term`) USING BTREE,
  UNIQUE INDEX `t_calendar_year_term`(`year`, `term`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '校历' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_calendar
-- ----------------------------
INSERT INTO `t_calendar` VALUES (2022, '1', '2022-02-21', '2022-07-01', '2022-5-1,2,3,4,5,6,7');
INSERT INTO `t_calendar` VALUES (2022, '2', '2022-02-21', '2022-07-01', '2022-5-1,2,3,4,5,6,7');

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `specialized` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazzYear` int(4) UNSIGNED NOT NULL COMMENT '所属级，如2020级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_clazz_REF_specialized`(`specialized`) USING BTREE,
  INDEX `FK_clazz_REF_year`(`clazzYear`) USING BTREE,
  CONSTRAINT `FK_clazz_REF_specialized` FOREIGN KEY (`specialized`) REFERENCES `t_specialized` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_clazz_REF_year` FOREIGN KEY (`clazzYear`) REFERENCES `t_year` (`year`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 375 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, 1, '20计应1班', 2020);
INSERT INTO `t_clazz` VALUES (2, 2, '20通信2班', 2020);
INSERT INTO `t_clazz` VALUES (3, 1, '20计应2班', 2020);
INSERT INTO `t_clazz` VALUES (4, 2, '20通信1班', 2020);
INSERT INTO `t_clazz` VALUES (5, 3, '21软工1班', 2021);
INSERT INTO `t_clazz` VALUES (6, 3, '21软工2班', 2021);
INSERT INTO `t_clazz` VALUES (7, 4, '21无人驾驶1班', 2021);
INSERT INTO `t_clazz` VALUES (8, 4, '21无人驾驶2班', 2021);
INSERT INTO `t_clazz` VALUES (135, 1, '计算机应用技术2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (136, 2, '通信工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (137, 3, '软件工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (138, 4, '无人驾驶技术2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (139, 5, '计算机科学与技术2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (140, 6, '网络工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (141, 8, '数字媒体技术2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (142, 9, '数据科学与大数据技术2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (143, 10, '人工智能2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (144, 11, '电子通信工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (145, 12, '通信工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (146, 13, '物联网工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (147, 14, '机械设计制造及其自动化2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (148, 15, '自动化2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (149, 16, '电气工程及其自动化2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (150, 17, '机器人工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (151, 18, '土木工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (152, 19, '安全工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (153, 20, '工程管理2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (154, 21, '建筑学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (155, 22, '风景园林2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (156, 23, '测绘工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (157, 24, '药学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (158, 25, '制药工程2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (159, 26, '药物制剂2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (160, 27, '健康服务与管理2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (161, 28, '财务管理2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (162, 29, '会计学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (163, 30, '经济与金融2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (164, 31, '审计学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (165, 32, '金融科技2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (166, 33, '国际经济与贸易2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (167, 34, '人力资源管理2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (168, 35, '物流管理2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (169, 36, '电子商务2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (170, 37, '大数据管理与应用2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (171, 38, '数字经济2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (172, 39, '视觉传达设计2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (173, 40, '环境设计2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (174, 41, '动画2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (175, 42, '美术学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (176, 43, '汉语言文学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (177, 44, '新闻学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (178, 45, '广告学2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (179, 46, '广播电视编导2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (180, 47, '表演2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (181, 48, '学前教育2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (182, 49, '小学教育2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (183, 50, '英语2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (184, 51, '商务英语2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (185, 52, '日语2020 1班', 2020);
INSERT INTO `t_clazz` VALUES (198, 1, '计算机应用技术2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (199, 2, '通信工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (200, 3, '软件工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (201, 4, '无人驾驶技术2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (202, 5, '计算机科学与技术2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (203, 6, '网络工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (204, 8, '数字媒体技术2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (205, 9, '数据科学与大数据技术2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (206, 10, '人工智能2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (207, 11, '电子通信工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (208, 12, '通信工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (209, 13, '物联网工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (210, 14, '机械设计制造及其自动化2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (211, 15, '自动化2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (212, 16, '电气工程及其自动化2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (213, 17, '机器人工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (214, 18, '土木工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (215, 19, '安全工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (216, 20, '工程管理2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (217, 21, '建筑学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (218, 22, '风景园林2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (219, 23, '测绘工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (220, 24, '药学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (221, 25, '制药工程2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (222, 26, '药物制剂2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (223, 27, '健康服务与管理2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (224, 28, '财务管理2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (225, 29, '会计学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (226, 30, '经济与金融2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (227, 31, '审计学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (228, 32, '金融科技2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (229, 33, '国际经济与贸易2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (230, 34, '人力资源管理2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (231, 35, '物流管理2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (232, 36, '电子商务2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (233, 37, '大数据管理与应用2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (234, 38, '数字经济2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (235, 39, '视觉传达设计2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (236, 40, '环境设计2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (237, 41, '动画2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (238, 42, '美术学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (239, 43, '汉语言文学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (240, 44, '新闻学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (241, 45, '广告学2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (242, 46, '广播电视编导2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (243, 47, '表演2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (244, 48, '学前教育2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (245, 49, '小学教育2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (246, 50, '英语2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (247, 51, '商务英语2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (248, 52, '日语2020 2班', 2020);
INSERT INTO `t_clazz` VALUES (261, 1, '计算机应用技术2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (262, 2, '通信工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (263, 3, '软件工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (264, 4, '无人驾驶技术2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (265, 5, '计算机科学与技术2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (266, 6, '网络工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (267, 8, '数字媒体技术2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (268, 9, '数据科学与大数据技术2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (269, 10, '人工智能2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (270, 11, '电子通信工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (271, 12, '通信工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (272, 13, '物联网工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (273, 14, '机械设计制造及其自动化2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (274, 15, '自动化2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (275, 16, '电气工程及其自动化2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (276, 17, '机器人工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (277, 18, '土木工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (278, 19, '安全工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (279, 20, '工程管理2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (280, 21, '建筑学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (281, 22, '风景园林2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (282, 23, '测绘工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (283, 24, '药学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (284, 25, '制药工程2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (285, 26, '药物制剂2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (286, 27, '健康服务与管理2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (287, 28, '财务管理2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (288, 29, '会计学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (289, 30, '经济与金融2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (290, 31, '审计学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (291, 32, '金融科技2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (292, 33, '国际经济与贸易2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (293, 34, '人力资源管理2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (294, 35, '物流管理2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (295, 36, '电子商务2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (296, 37, '大数据管理与应用2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (297, 38, '数字经济2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (298, 39, '视觉传达设计2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (299, 40, '环境设计2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (300, 41, '动画2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (301, 42, '美术学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (302, 43, '汉语言文学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (303, 44, '新闻学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (304, 45, '广告学2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (305, 46, '广播电视编导2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (306, 47, '表演2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (307, 48, '学前教育2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (308, 49, '小学教育2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (309, 50, '英语2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (310, 51, '商务英语2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (311, 52, '日语2021 1班', 2021);
INSERT INTO `t_clazz` VALUES (324, 1, '计算机应用技术2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (325, 2, '通信工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (326, 3, '软件工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (327, 4, '无人驾驶技术2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (328, 5, '计算机科学与技术2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (329, 6, '网络工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (330, 8, '数字媒体技术2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (331, 9, '数据科学与大数据技术2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (332, 10, '人工智能2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (333, 11, '电子通信工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (334, 12, '通信工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (335, 13, '物联网工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (336, 14, '机械设计制造及其自动化2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (337, 15, '自动化2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (338, 16, '电气工程及其自动化2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (339, 17, '机器人工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (340, 18, '土木工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (341, 19, '安全工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (342, 20, '工程管理2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (343, 21, '建筑学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (344, 22, '风景园林2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (345, 23, '测绘工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (346, 24, '药学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (347, 25, '制药工程2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (348, 26, '药物制剂2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (349, 27, '健康服务与管理2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (350, 28, '财务管理2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (351, 29, '会计学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (352, 30, '经济与金融2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (353, 31, '审计学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (354, 32, '金融科技2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (355, 33, '国际经济与贸易2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (356, 34, '人力资源管理2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (357, 35, '物流管理2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (358, 36, '电子商务2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (359, 37, '大数据管理与应用2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (360, 38, '数字经济2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (361, 39, '视觉传达设计2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (362, 40, '环境设计2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (363, 41, '动画2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (364, 42, '美术学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (365, 43, '汉语言文学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (366, 44, '新闻学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (367, 45, '广告学2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (368, 46, '广播电视编导2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (369, 47, '表演2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (370, 48, '学前教育2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (371, 49, '小学教育2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (372, 50, '英语2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (373, 51, '商务英语2021 2班', 2021);
INSERT INTO `t_clazz` VALUES (374, 52, '日语2021 2班', 2021);

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` enum('1','2','3','4') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学分',
  `teacher` int(11) UNSIGNED NOT NULL COMMENT '授课老师',
  `courseYear` int(4) UNSIGNED NOT NULL COMMENT '年度',
  `term` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学期,true1第二学期，false0第一学期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_REF_teacher`(`teacher`) USING BTREE,
  INDEX `FK_course_REF_year`(`courseYear`) USING BTREE,
  CONSTRAINT `FK_course_REF_teacher` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_REF_year` FOREIGN KEY (`courseYear`) REFERENCES `t_year` (`year`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (27, '高等数学(工程类)(1)', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (28, ' C/C++语言程序设计', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (29, '数字逻辑电路', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (30, '计算机文化基础', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (31, 'photoshop C', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (32, 'JAVA程序设计与应用', '1', 1, 2021, '2');
INSERT INTO `t_course` VALUES (33, 'Linux操作系统', '1', 1, 2021, '2');
INSERT INTO `t_course` VALUES (34, '毛泽东思想和中国特色社会主义理论体系概论', '1', 1, 2021, '2');
INSERT INTO `t_course` VALUES (35, '计算机组装与维护', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (36, '微机原理及接口技术', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (37, 'HTML5', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (38, 'SQL Server数据库', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (39, 'Android应用开发', '1', 1, 2021, '1');
INSERT INTO `t_course` VALUES (40, 'PHP', '3', 55, 2021, '1');
INSERT INTO `t_course` VALUES (42, '测试', '1', 1, 2019, '1');
INSERT INTO `t_course` VALUES (44, '测试', '1', 1, 2019, '1');

-- ----------------------------
-- Table structure for t_course_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_course_clazz`;
CREATE TABLE `t_course_clazz`  (
  `course` int(11) UNSIGNED NOT NULL,
  `clazz` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`course`, `clazz`) USING BTREE,
  INDEX `t_course_clazz_t_clazz_id_fk`(`clazz`) USING BTREE,
  CONSTRAINT `t_course_clazz_t_clazz_id_fk` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_course_clazz_t_course_id_fk` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '此表是课程和班级的关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course_clazz
-- ----------------------------
INSERT INTO `t_course_clazz` VALUES (27, 1);
INSERT INTO `t_course_clazz` VALUES (28, 1);
INSERT INTO `t_course_clazz` VALUES (29, 1);
INSERT INTO `t_course_clazz` VALUES (30, 1);
INSERT INTO `t_course_clazz` VALUES (31, 1);
INSERT INTO `t_course_clazz` VALUES (32, 1);
INSERT INTO `t_course_clazz` VALUES (33, 1);
INSERT INTO `t_course_clazz` VALUES (34, 1);
INSERT INTO `t_course_clazz` VALUES (35, 1);
INSERT INTO `t_course_clazz` VALUES (36, 1);
INSERT INTO `t_course_clazz` VALUES (37, 1);
INSERT INTO `t_course_clazz` VALUES (38, 1);
INSERT INTO `t_course_clazz` VALUES (39, 1);
INSERT INTO `t_course_clazz` VALUES (40, 1);
INSERT INTO `t_course_clazz` VALUES (42, 1);
INSERT INTO `t_course_clazz` VALUES (44, 1);
INSERT INTO `t_course_clazz` VALUES (27, 3);
INSERT INTO `t_course_clazz` VALUES (28, 3);
INSERT INTO `t_course_clazz` VALUES (29, 3);
INSERT INTO `t_course_clazz` VALUES (30, 3);
INSERT INTO `t_course_clazz` VALUES (31, 3);
INSERT INTO `t_course_clazz` VALUES (32, 3);
INSERT INTO `t_course_clazz` VALUES (33, 3);
INSERT INTO `t_course_clazz` VALUES (34, 3);
INSERT INTO `t_course_clazz` VALUES (35, 3);
INSERT INTO `t_course_clazz` VALUES (36, 3);
INSERT INTO `t_course_clazz` VALUES (37, 3);
INSERT INTO `t_course_clazz` VALUES (38, 3);
INSERT INTO `t_course_clazz` VALUES (39, 3);
INSERT INTO `t_course_clazz` VALUES (42, 3);
INSERT INTO `t_course_clazz` VALUES (44, 3);
INSERT INTO `t_course_clazz` VALUES (40, 135);

-- ----------------------------
-- Table structure for t_course_info
-- ----------------------------
DROP TABLE IF EXISTS `t_course_info`;
CREATE TABLE `t_course_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course` int(11) UNSIGNED NOT NULL COMMENT 'course ID',
  `courseType` enum('theory','practice') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类型 \'theory\',\'practice\' 理论课 实验课',
  `weekType` enum('sgl','dbl','all') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '周次 \'sgl\',\'dbl\',\'all\' 单周 双周 不限',
  `beginWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '起始周',
  `lengthWeek` tinyint(4) UNSIGNED NOT NULL COMMENT '持续周',
  `weekDay` tinyint(4) NOT NULL COMMENT '星期1-7',
  `begin` tinyint(4) UNSIGNED NOT NULL COMMENT '起始节',
  `length` tinyint(4) UNSIGNED NOT NULL COMMENT '持续节',
  `address` int(11) UNSIGNED NOT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_info_REF_course`(`course`) USING BTREE,
  INDEX `FK_course_info_REF_room`(`address`) USING BTREE,
  CONSTRAINT `FK_course_info_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_info_REF_room` FOREIGN KEY (`address`) REFERENCES `t_room` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_course_info
-- ----------------------------
INSERT INTO `t_course_info` VALUES (27, 27, 'theory', 'all', 1, 15, 3, 1, 2, 1);
INSERT INTO `t_course_info` VALUES (28, 28, 'theory', 'all', 1, 10, 1, 1, 2, 1);
INSERT INTO `t_course_info` VALUES (29, 29, 'theory', 'sgl', 1, 18, 2, 7, 2, 1);
INSERT INTO `t_course_info` VALUES (30, 30, 'theory', 'all', 1, 10, 4, 3, 2, 1);
INSERT INTO `t_course_info` VALUES (31, 31, 'practice', 'all', 1, 18, 3, 5, 2, 1);
INSERT INTO `t_course_info` VALUES (32, 32, 'practice', 'all', 1, 10, 3, 7, 1, 1);
INSERT INTO `t_course_info` VALUES (33, 33, 'practice', 'dbl', 1, 18, 4, 1, 1, 1);
INSERT INTO `t_course_info` VALUES (34, 34, 'practice', 'all', 1, 15, 4, 2, 1, 1);
INSERT INTO `t_course_info` VALUES (35, 35, 'practice', 'sgl', 1, 10, 1, 3, 1, 1);
INSERT INTO `t_course_info` VALUES (36, 36, 'practice', 'all', 1, 20, 2, 5, 2, 1);
INSERT INTO `t_course_info` VALUES (37, 37, 'practice', 'dbl', 1, 15, 6, 7, 2, 1);
INSERT INTO `t_course_info` VALUES (38, 38, 'practice', 'dbl', 1, 10, 4, 7, 2, 1);
INSERT INTO `t_course_info` VALUES (39, 39, 'practice', 'dbl', 1, 16, 3, 9, 2, 1);
INSERT INTO `t_course_info` VALUES (40, 40, 'theory', 'all', 1, 10, 5, 1, 1, 1);
INSERT INTO `t_course_info` VALUES (42, 42, 'theory', 'all', 1, 10, 1, 1, 2, 1);
INSERT INTO `t_course_info` VALUES (43, 44, 'theory', 'all', 1, 10, 1, 1, 2, 1);

-- ----------------------------
-- Table structure for t_elective
-- ----------------------------
DROP TABLE IF EXISTS `t_elective`;
CREATE TABLE `t_elective`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student` int(11) UNSIGNED NOT NULL,
  `course` int(11) UNSIGNED NOT NULL,
  `score` int(11) NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UI_student_course`(`student`, `course`) USING BTREE,
  INDEX `FK_elective_REF_course`(`course`) USING BTREE,
  CONSTRAINT `FK_elective_REF_course` FOREIGN KEY (`course`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_elective_REF_student` FOREIGN KEY (`student`) REFERENCES `t_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 581 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_elective
-- ----------------------------
INSERT INTO `t_elective` VALUES (573, 1, 32, NULL);
INSERT INTO `t_elective` VALUES (575, 1, 33, NULL);
INSERT INTO `t_elective` VALUES (576, 1, 35, 50);
INSERT INTO `t_elective` VALUES (577, 1, 27, NULL);
INSERT INTO `t_elective` VALUES (578, 1, 28, NULL);
INSERT INTO `t_elective` VALUES (579, 1, 29, NULL);
INSERT INTO `t_elective` VALUES (580, 1, 30, NULL);

-- ----------------------------
-- Table structure for t_faculty
-- ----------------------------
DROP TABLE IF EXISTS `t_faculty`;
CREATE TABLE `t_faculty`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_faculty
-- ----------------------------
INSERT INTO `t_faculty` VALUES (1, '大数据与人工智能学院');
INSERT INTO `t_faculty` VALUES (2, '电子工程学院/智能制造学院');
INSERT INTO `t_faculty` VALUES (3, '城市建设学院');
INSERT INTO `t_faculty` VALUES (4, '药学院');
INSERT INTO `t_faculty` VALUES (5, '财会与金融学院');
INSERT INTO `t_faculty` VALUES (6, '商学院');
INSERT INTO `t_faculty` VALUES (7, '艺术学院');
INSERT INTO `t_faculty` VALUES (8, '文化与传媒学院');
INSERT INTO `t_faculty` VALUES (9, '外国语学院');

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `building` int(11) UNSIGNED NOT NULL COMMENT '所属楼id',
  `number` int(11) UNSIGNED NOT NULL COMMENT '房间号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间名称，可以不指定',
  `capacity` int(11) UNSIGNED NOT NULL COMMENT '容纳人数',
  `roomType` enum('bz','jt','sy','sx','wj','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bz标准教室\r\njt阶梯教室\r\nsy实验室\r\nsx实训教室\r\nwj微机教室\r\nq其他',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UI_number_building`(`building`, `number`) USING BTREE,
  CONSTRAINT `FK_room_REF_building` FOREIGN KEY (`building`) REFERENCES `t_building` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, 1, 402, '计算机网络实训基地', 50, 'sx');
INSERT INTO `t_room` VALUES (4, 7, 404, '土木', 55, 'bz');
INSERT INTO `t_room` VALUES (5, 10, 999, '11', 11, 'bz');
INSERT INTO `t_room` VALUES (6, 2, 308, '动漫设计', 70, 'bz');
INSERT INTO `t_room` VALUES (7, 1, 605, '计算机组装与维护', 60, 'bz');

-- ----------------------------
-- Table structure for t_specialized
-- ----------------------------
DROP TABLE IF EXISTS `t_specialized`;
CREATE TABLE `t_specialized`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `faculty` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_specialized_REF_faculty`(`faculty`) USING BTREE,
  CONSTRAINT `FK_specialized_REF_faculty` FOREIGN KEY (`faculty`) REFERENCES `t_faculty` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_specialized
-- ----------------------------
INSERT INTO `t_specialized` VALUES (1, 1, '计算机应用技术');
INSERT INTO `t_specialized` VALUES (2, 2, '通信工程');
INSERT INTO `t_specialized` VALUES (3, 1, '软件工程');
INSERT INTO `t_specialized` VALUES (4, 2, '无人驾驶技术');
INSERT INTO `t_specialized` VALUES (5, 1, '计算机科学与技术');
INSERT INTO `t_specialized` VALUES (6, 1, '网络工程');
INSERT INTO `t_specialized` VALUES (8, 1, '数字媒体技术');
INSERT INTO `t_specialized` VALUES (9, 1, '数据科学与大数据技术');
INSERT INTO `t_specialized` VALUES (10, 1, '人工智能');
INSERT INTO `t_specialized` VALUES (11, 2, '电子通信工程');
INSERT INTO `t_specialized` VALUES (12, 2, '通信工程');
INSERT INTO `t_specialized` VALUES (13, 2, '物联网工程');
INSERT INTO `t_specialized` VALUES (14, 2, '机械设计制造及其自动化');
INSERT INTO `t_specialized` VALUES (15, 2, '自动化');
INSERT INTO `t_specialized` VALUES (16, 2, '电气工程及其自动化');
INSERT INTO `t_specialized` VALUES (17, 2, '机器人工程');
INSERT INTO `t_specialized` VALUES (18, 3, '土木工程');
INSERT INTO `t_specialized` VALUES (19, 3, '安全工程');
INSERT INTO `t_specialized` VALUES (20, 3, '工程管理');
INSERT INTO `t_specialized` VALUES (21, 3, '建筑学');
INSERT INTO `t_specialized` VALUES (22, 3, '风景园林');
INSERT INTO `t_specialized` VALUES (23, 3, '测绘工程');
INSERT INTO `t_specialized` VALUES (24, 4, '药学');
INSERT INTO `t_specialized` VALUES (25, 4, '制药工程');
INSERT INTO `t_specialized` VALUES (26, 4, '药物制剂');
INSERT INTO `t_specialized` VALUES (27, 4, '健康服务与管理');
INSERT INTO `t_specialized` VALUES (28, 5, '财务管理');
INSERT INTO `t_specialized` VALUES (29, 5, '会计学');
INSERT INTO `t_specialized` VALUES (30, 5, '经济与金融');
INSERT INTO `t_specialized` VALUES (31, 5, '审计学');
INSERT INTO `t_specialized` VALUES (32, 5, '金融科技');
INSERT INTO `t_specialized` VALUES (33, 6, '国际经济与贸易');
INSERT INTO `t_specialized` VALUES (34, 6, '人力资源管理');
INSERT INTO `t_specialized` VALUES (35, 6, '物流管理');
INSERT INTO `t_specialized` VALUES (36, 6, '电子商务');
INSERT INTO `t_specialized` VALUES (37, 6, '大数据管理与应用');
INSERT INTO `t_specialized` VALUES (38, 6, '数字经济');
INSERT INTO `t_specialized` VALUES (39, 7, '视觉传达设计');
INSERT INTO `t_specialized` VALUES (40, 7, '环境设计');
INSERT INTO `t_specialized` VALUES (41, 7, '动画');
INSERT INTO `t_specialized` VALUES (42, 7, '美术学');
INSERT INTO `t_specialized` VALUES (43, 8, '汉语言文学');
INSERT INTO `t_specialized` VALUES (44, 8, '新闻学');
INSERT INTO `t_specialized` VALUES (45, 8, '广告学');
INSERT INTO `t_specialized` VALUES (46, 8, '广播电视编导');
INSERT INTO `t_specialized` VALUES (47, 8, '表演');
INSERT INTO `t_specialized` VALUES (48, 8, '学前教育');
INSERT INTO `t_specialized` VALUES (49, 8, '小学教育');
INSERT INTO `t_specialized` VALUES (50, 9, '英语');
INSERT INTO `t_specialized` VALUES (51, 9, '商务英语');
INSERT INTO `t_specialized` VALUES (52, 9, '日语');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别，1男，0女',
  `birth` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生日',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `clazz` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '所属班级',
  `specialized` int(11) UNSIGNED NOT NULL COMMENT '所属专业',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_student_REF_clazz`(`clazz`) USING BTREE,
  INDEX `FK_student_REF_specialized`(`specialized`) USING BTREE,
  CONSTRAINT `FK_student_REF_clazz` FOREIGN KEY (`clazz`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_student_REF_specialized` FOREIGN KEY (`specialized`) REFERENCES `t_specialized` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '是世昌', b'1', '2000-11-13', '1', 1, 1, '2099432021@qq.com');
INSERT INTO `t_student` VALUES (2, '表梓晨', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (3, '东门夏沫', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (4, '候璟春', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (5, '湛耘郗', b'0', '2000-12-23', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (6, '班奕玮', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (7, '夹谷东硕', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (8, '常千', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (9, '穆晓', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (10, '项蓝月', b'0', '2000-12-23', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (11, '孔树人', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (12, '麴柯一', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (13, '宁熙', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (14, '城晟华', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (15, '烟睿', b'0', '2000-12-23', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (16, '相羽铮', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (17, '廖雪', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (18, '山亚捷', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (19, '洛子轩', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (20, '覃景川', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (21, '翦羽', b'1', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (22, '祖一然', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (23, '丹树涵', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (24, '叶爱丹', b'0', '2000-12-23', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (25, '别浩毅', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (26, '程小秋', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (27, '尉迟恒宇', b'0', '2001-12-22', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (28, '顾圣贤', b'1', '2000-11-15', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (29, '蓝树源', b'1', '2000-11-13', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (30, '居涵舒', b'0', '2000-10-10', '1', 1, 1, NULL);
INSERT INTO `t_student` VALUES (31, '苗熙苒', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (32, '佛千', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (33, '房玉惠', b'0', '2000-12-23', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (34, '刑明哲', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (35, '娄柯汝', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (36, '真林莹', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (37, '司空洪滨', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (38, '巢楠', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (39, '祢东慧', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (40, '费梓童', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (41, '东文博', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (42, '松誉馨', b'0', '2000-12-23', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (43, '甄一诺', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (44, '慕馨阳', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (45, '曲筱萌', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (46, '阴宇硕', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (47, '丁睿', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (48, '诺阳阳', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (49, '势羽墨', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (50, '零珞', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (51, '养恩贝', b'0', '2000-12-23', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (52, '茂阳', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (53, '傅慧青', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (54, '阙篷璐', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (55, '紫爱豪', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (56, '钊轩', b'1', '2000-11-13', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (57, '师钰岩', b'0', '2000-10-10', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (58, '业冰杰', b'0', '2001-12-22', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (59, '雪旭', b'1', '2000-11-15', '1', 2, 2, NULL);
INSERT INTO `t_student` VALUES (60, '逮淑怡', b'0', '2000-12-23', '1', 2, 2, NULL);

-- ----------------------------
-- Table structure for t_system
-- ----------------------------
DROP TABLE IF EXISTS `t_system`;
CREATE TABLE `t_system`  (
  `key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统表，包含当前学年，当前学期等系统信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_system
-- ----------------------------
INSERT INTO `t_system` VALUES ('currTeamEndDay', '2022-2-21', '当前学期结束日期');
INSERT INTO `t_system` VALUES ('currTeamStartDay', '2022-7-1', '当前学期起始日期');
INSERT INTO `t_system` VALUES ('currTerm', '1', '当前学期');
INSERT INTO `t_system` VALUES ('currYear', '2021', '当前年份');

-- ----------------------------
-- Table structure for t_teach_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_teach_evaluate`;
CREATE TABLE `t_teach_evaluate`  (
  `elective` int(11) UNSIGNED NOT NULL COMMENT '选课表ID',
  `student` int(11) UNSIGNED NOT NULL COMMENT '学生ID',
  `attitude` tinyint(3) UNSIGNED NOT NULL COMMENT '教材态度',
  `prepare` tinyint(3) UNSIGNED NOT NULL COMMENT '教学准备',
  `content` tinyint(3) UNSIGNED NOT NULL COMMENT '教学内容',
  `method` tinyint(4) UNSIGNED NOT NULL COMMENT '教学方法',
  `thinking` tinyint(3) UNSIGNED NOT NULL COMMENT '教学思路',
  `talk` tinyint(3) UNSIGNED NOT NULL COMMENT '教学语言',
  `tool` tinyint(3) UNSIGNED NOT NULL COMMENT '教学工具',
  `coaching` tinyint(3) UNSIGNED NOT NULL COMMENT '作业与辅导',
  `composite` tinyint(3) UNSIGNED NOT NULL COMMENT '综合评价',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评语',
  PRIMARY KEY (`elective`) USING BTREE,
  INDEX `FK_teach_evaluate_REF_student`(`student`) USING BTREE,
  CONSTRAINT `FK_teach_evaluate_REF_elective` FOREIGN KEY (`elective`) REFERENCES `t_elective` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teach_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `faculty` int(11) UNSIGNED NOT NULL COMMENT '所属院系',
  `profes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称',
  `eamil` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_teacher_REF_faculty`(`faculty`) USING BTREE,
  CONSTRAINT `FK_teacher_REF_faculty` FOREIGN KEY (`faculty`) REFERENCES `t_faculty` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, 'ls1', b'0', '1', 1, '教授', NULL);
INSERT INTO `t_teacher` VALUES (2, 'ls2', b'1', '1', 2, '老师', NULL);
INSERT INTO `t_teacher` VALUES (3, 'ls3', b'0', '1', 1, '教授', NULL);
INSERT INTO `t_teacher` VALUES (4, 'ls4', b'1', '1', 2, '老师', NULL);
INSERT INTO `t_teacher` VALUES (5, 'ls5', b'0', '1', 1, '教授', NULL);
INSERT INTO `t_teacher` VALUES (6, 'ls6', b'1', '1', 2, '老师', NULL);
INSERT INTO `t_teacher` VALUES (7, 'ls7', b'0', '1', 1, '教授', NULL);
INSERT INTO `t_teacher` VALUES (8, 'ls8', b'1', '1', 2, '老师', NULL);
INSERT INTO `t_teacher` VALUES (9, 'ls1', b'0', '1', 1, '教授', 'ls1.test.com');
INSERT INTO `t_teacher` VALUES (10, 'ls0', b'0', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (11, 'ls1', b'1', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (12, 'ls2', b'0', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (13, 'ls3', b'1', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (14, 'ls4', b'0', '1', 5, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (15, 'ls5', b'1', '1', 6, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (16, 'ls6', b'0', '1', 7, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (17, 'ls7', b'1', '1', 8, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (18, 'ls8', b'0', '1', 9, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (19, 'ls9', b'1', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (20, 'ls10', b'0', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (21, 'ls11', b'1', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (22, 'ls12', b'0', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (23, 'ls13', b'1', '1', 5, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (24, 'ls14', b'0', '1', 6, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (25, 'ls15', b'1', '1', 7, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (26, 'ls16', b'0', '1', 8, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (27, 'ls17', b'1', '1', 9, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (28, 'ls18', b'0', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (29, 'ls19', b'1', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (30, 'ls20', b'0', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (31, 'ls21', b'1', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (32, 'ls22', b'0', '1', 5, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (33, 'ls23', b'1', '1', 6, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (34, 'ls24', b'0', '1', 7, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (35, 'ls25', b'1', '1', 8, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (36, 'ls26', b'0', '1', 9, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (37, 'ls27', b'1', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (38, 'ls28', b'0', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (39, 'ls29', b'1', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (40, 'ls30', b'0', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (41, 'ls31', b'1', '1', 5, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (42, 'ls32', b'0', '1', 6, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (43, 'ls33', b'1', '1', 7, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (44, 'ls34', b'0', '1', 8, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (45, 'ls35', b'1', '1', 9, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (46, 'ls36', b'0', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (47, 'ls37', b'1', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (48, 'ls38', b'0', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (49, 'ls39', b'1', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (50, 'ls40', b'0', '1', 5, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (51, 'ls41', b'1', '1', 6, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (52, 'ls42', b'0', '1', 7, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (53, 'ls43', b'1', '1', 8, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (54, 'ls44', b'0', '1', 9, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (55, 'ls45', b'1', '1', 1, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (56, 'ls46', b'0', '1', 2, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (57, 'ls47', b'1', '1', 3, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (58, 'ls48', b'0', '1', 4, '教授', 'ls.test.com');
INSERT INTO `t_teacher` VALUES (59, 'ls49', b'1', '1', 5, '教授', 'ls.test.com');

-- ----------------------------
-- Table structure for t_year
-- ----------------------------
DROP TABLE IF EXISTS `t_year`;
CREATE TABLE `t_year`  (
  `year` int(4) UNSIGNED NOT NULL COMMENT '年度，如2019',
  `name` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '如2019-2020',
  PRIMARY KEY (`year`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_year
-- ----------------------------
INSERT INTO `t_year` VALUES (2015, '2015-2016');
INSERT INTO `t_year` VALUES (2016, '2016-2017');
INSERT INTO `t_year` VALUES (2017, '2017-2018');
INSERT INTO `t_year` VALUES (2018, '2018-2019');
INSERT INTO `t_year` VALUES (2019, '2019-2020');
INSERT INTO `t_year` VALUES (2020, '2020-2021');
INSERT INTO `t_year` VALUES (2021, '2021-2022');
INSERT INTO `t_year` VALUES (2022, '2022-2023');
INSERT INTO `t_year` VALUES (2023, '2023-2024');
INSERT INTO `t_year` VALUES (2024, '2024-2025');
INSERT INTO `t_year` VALUES (2029, '2029-2030');

SET FOREIGN_KEY_CHECKS = 1;
