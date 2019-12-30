/*
Navicat MySQL Data Transfer

Source Server         : python专用
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : db_javaee_debut

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2019-12-30 21:33:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '中行', '1');
INSERT INTO `account` VALUES ('2', '工行', '1');
INSERT INTO `account` VALUES ('3', '键行', '2');

-- ----------------------------
-- Table structure for `center_diary_tag`
-- ----------------------------
DROP TABLE IF EXISTS `center_diary_tag`;
CREATE TABLE `center_diary_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diary_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of center_diary_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', 'xx公司');
INSERT INTO `company` VALUES ('2', 'yy公司');

-- ----------------------------
-- Table structure for `diary`
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `diary_id` varchar(20) NOT NULL DEFAULT '',
  `title` varchar(255) DEFAULT '',
  `content` varchar(255) DEFAULT '',
  `theme` int(11) DEFAULT '0',
  `sub_theme` int(11) DEFAULT '0',
  `create_time` bigint(20) DEFAULT '15',
  `update_time` bigint(20) DEFAULT '15',
  `user_id` varchar(20) DEFAULT '',
  PRIMARY KEY (`diary_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('986131', '金融', '十二分金额看过惹人家看', '0', '31', '1566123154', '1566112354', '142567');
INSERT INTO `diary` VALUES ('123531', '黄金', '时开车门都没时考评得分时面覅', '3', '5', '1566133254', '1562345454', '123456');
INSERT INTO `diary` VALUES ('456', '底', '哦时开车门都没时考评得分时面覅', '3', '5', '1566133254', '1562345454', '123456');
INSERT INTO `diary` VALUES ('123', '底', '哦时开车门都没时考评得分时面覅', '3', '5', '1566133254', '1562345454', '123456');
INSERT INTO `diary` VALUES ('15658', 'kol', '为借口的出口量', '1', '5', '1566133254', '1562345454', '123456');
INSERT INTO `diary` VALUES ('15658678', 'kol', '为借口的出口量', '1', '5', '1566133254', '1562345454', '123456');

-- ----------------------------
-- Table structure for `diary_sub_theme`
-- ----------------------------
DROP TABLE IF EXISTS `diary_sub_theme`;
CREATE TABLE `diary_sub_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_theme_id` int(11) NOT NULL,
  `sub_theme_name` varchar(50) NOT NULL,
  `theme_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary_sub_theme
-- ----------------------------
INSERT INTO `diary_sub_theme` VALUES ('1', '1', 'Java开发', '1');
INSERT INTO `diary_sub_theme` VALUES ('2', '2', 'UI设计师', '1');
INSERT INTO `diary_sub_theme` VALUES ('3', '3', 'Web前端', '1');
INSERT INTO `diary_sub_theme` VALUES ('4', '4', 'PHP', '1');
INSERT INTO `diary_sub_theme` VALUES ('5', '5', 'Python', '1');
INSERT INTO `diary_sub_theme` VALUES ('6', '6', 'Android', '1');
INSERT INTO `diary_sub_theme` VALUES ('7', '7', '美工', '1');
INSERT INTO `diary_sub_theme` VALUES ('8', '8', '深度学习算法工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('9', '9', 'Hadoop', '1');
INSERT INTO `diary_sub_theme` VALUES ('10', '10', 'Node.js', '1');
INSERT INTO `diary_sub_theme` VALUES ('11', '11', '数据开发数据分析师', '1');
INSERT INTO `diary_sub_theme` VALUES ('12', '12', '数据架构', '1');
INSERT INTO `diary_sub_theme` VALUES ('13', '13', '人工智能', '1');
INSERT INTO `diary_sub_theme` VALUES ('14', '14', '区块链', '1');
INSERT INTO `diary_sub_theme` VALUES ('15', '15', '电气工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('16', '16', '电子工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('17', '17', 'PLC测试工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('18', '18', '设备工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('19', '19', '硬件工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('20', '20', '结构工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('21', '21', '工艺工程师', '1');
INSERT INTO `diary_sub_theme` VALUES ('22', '22', '产品经理', '1');
INSERT INTO `diary_sub_theme` VALUES ('23', '23', '新媒体运营', '1');
INSERT INTO `diary_sub_theme` VALUES ('24', '24', '运营专员', '1');
INSERT INTO `diary_sub_theme` VALUES ('25', '25', '产品助理', '1');
INSERT INTO `diary_sub_theme` VALUES ('26', '26', '产品运营', '1');
INSERT INTO `diary_sub_theme` VALUES ('27', '27', '产品客服', '1');
INSERT INTO `diary_sub_theme` VALUES ('28', '28', '游戏运营编辑', '1');
INSERT INTO `diary_sub_theme` VALUES ('29', '1', '投资经理', '2');
INSERT INTO `diary_sub_theme` VALUES ('30', '2', '风控', '2');
INSERT INTO `diary_sub_theme` VALUES ('31', '3', '催收', '2');
INSERT INTO `diary_sub_theme` VALUES ('32', '4', '银行柜员', '2');
INSERT INTO `diary_sub_theme` VALUES ('33', '5', '银行销售', '2');
INSERT INTO `diary_sub_theme` VALUES ('34', '6', '信审', '2');
INSERT INTO `diary_sub_theme` VALUES ('35', '7', '信用卡', '2');
INSERT INTO `diary_sub_theme` VALUES ('36', '8', '贷款', '2');
INSERT INTO `diary_sub_theme` VALUES ('37', '9', '金融产品', '2');
INSERT INTO `diary_sub_theme` VALUES ('38', '10', '汽车金融', '2');
INSERT INTO `diary_sub_theme` VALUES ('39', '11', '金融研究', '2');
INSERT INTO `diary_sub_theme` VALUES ('40', '12', '证券交易员', '2');
INSERT INTO `diary_sub_theme` VALUES ('41', '13', '投资经理', '2');
INSERT INTO `diary_sub_theme` VALUES ('42', '14', '期货', '2');
INSERT INTO `diary_sub_theme` VALUES ('43', '15', '操盘手', '2');
INSERT INTO `diary_sub_theme` VALUES ('44', '16', '基金', '2');
INSERT INTO `diary_sub_theme` VALUES ('45', '17', '股票', '2');
INSERT INTO `diary_sub_theme` VALUES ('46', '18', '投资顾问', '2');
INSERT INTO `diary_sub_theme` VALUES ('47', '19', '信托', '2');
INSERT INTO `diary_sub_theme` VALUES ('48', '20', '典当', '2');
INSERT INTO `diary_sub_theme` VALUES ('49', '21', '担保', '2');
INSERT INTO `diary_sub_theme` VALUES ('50', '22', '信贷', '2');
INSERT INTO `diary_sub_theme` VALUES ('51', '23', '权证', '2');
INSERT INTO `diary_sub_theme` VALUES ('52', '24', '财产保险', '2');
INSERT INTO `diary_sub_theme` VALUES ('53', '25', '保险内勤', '2');
INSERT INTO `diary_sub_theme` VALUES ('54', '26', '理赔', '2');
INSERT INTO `diary_sub_theme` VALUES ('55', '27', '精算师', '2');
INSERT INTO `diary_sub_theme` VALUES ('56', '28', '保险销售', '2');
INSERT INTO `diary_sub_theme` VALUES ('57', '29', '理财顾问', '2');
INSERT INTO `diary_sub_theme` VALUES ('58', '30', '查勘定损', '2');
INSERT INTO `diary_sub_theme` VALUES ('59', '31', '车险', '2');

-- ----------------------------
-- Table structure for `diary_tag`
-- ----------------------------
DROP TABLE IF EXISTS `diary_tag`;
CREATE TABLE `diary_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` varchar(50) NOT NULL,
  `tag_str` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary_tag
-- ----------------------------
INSERT INTO `diary_tag` VALUES ('1', '1', '热血沸腾');
INSERT INTO `diary_tag` VALUES ('2', '2', '激情澎湃');
INSERT INTO `diary_tag` VALUES ('3', '3', '波澜起伏');
INSERT INTO `diary_tag` VALUES ('4', '4', '生动有趣');
INSERT INTO `diary_tag` VALUES ('5', '5', '诗情画意');
INSERT INTO `diary_tag` VALUES ('6', '6', '静谧安宁');
INSERT INTO `diary_tag` VALUES ('7', '7', '平淡如水');
INSERT INTO `diary_tag` VALUES ('8', '8', '糟糕透顶');
INSERT INTO `diary_tag` VALUES ('9', '9', '天灾人祸');
INSERT INTO `diary_tag` VALUES ('10', '10', '伤心欲绝');
INSERT INTO `diary_tag` VALUES ('11', '11', '其他类型');

-- ----------------------------
-- Table structure for `diary_theme`
-- ----------------------------
DROP TABLE IF EXISTS `diary_theme`;
CREATE TABLE `diary_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_id` int(11) NOT NULL,
  `theme_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary_theme
-- ----------------------------
INSERT INTO `diary_theme` VALUES ('1', '1', '互联网IT');
INSERT INTO `diary_theme` VALUES ('2', '2', '金融');
INSERT INTO `diary_theme` VALUES ('3', '3', '房地产/建筑');
INSERT INTO `diary_theme` VALUES ('4', '4', '贸易/零售/物流');
INSERT INTO `diary_theme` VALUES ('5', '5', '教育/传媒/广告');
INSERT INTO `diary_theme` VALUES ('6', '6', '服务业');
INSERT INTO `diary_theme` VALUES ('7', '7', '市场/销售');
INSERT INTO `diary_theme` VALUES ('8', '8', '人事/财务/行政');
INSERT INTO `diary_theme` VALUES ('9', '9', '其他');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `pass_word` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT '',
  `sex` int(11) DEFAULT '0' COMMENT '0:女,1:男',
  `age` int(11) DEFAULT '18' COMMENT '年龄',
  `create_time` bigint(20) DEFAULT '0' COMMENT '创建的时间戳',
  `update_time` bigint(20) DEFAULT '0' COMMENT '最近修改User的时间戳',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', '111111', '132250202', '1', '23', '1566823454', '15613566');
INSERT INTO `user` VALUES ('145906', '123456', '1365000002', '0', '31', '1566123154', '1566112354');
INSERT INTO `user` VALUES ('142567', '567111', '132250202', '1', '15', '1566123154', '15613566');
INSERT INTO `user` VALUES ('1', '1234111', '132250202', '2', '23', '1566123154', '15613566');
INSERT INTO `user` VALUES ('12', '1234111', '132250202', '1', '23', '1566123154', '15613566');
INSERT INTO `user` VALUES ('1235', '123456', '1365000002', '0', '31', '1566123154', '1566112354');
INSERT INTO `user` VALUES ('127895', '123456', '1365000002', '0', '31', '1566123154', '1566112354');
INSERT INTO `user` VALUES ('88', '123456', '132250202', '2', '23', '1566123154', '11113566');
INSERT INTO `user` VALUES ('818', '123456', '132250202', '2', '23', '1566123154', '15613566');

-- ----------------------------
-- Table structure for `work`
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('1', 'aa', '1');
INSERT INTO `work` VALUES ('2', 'bb', '2');