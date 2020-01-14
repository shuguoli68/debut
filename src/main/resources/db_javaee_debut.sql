/*
Navicat MySQL Data Transfer

Source Server         : lsg
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : db_javaee_debut

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-01-14 16:21:52
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
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `url_path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `des` varchar(255) DEFAULT NULL COMMENT '简介',
  `mstr` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531798262708&di=53d278a8427f482c5b836fa0e057f4ea&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F342ac65c103853434cc02dda9f13b07eca80883a.jpg', 'https://translate.google.cn/', '都市生活', 'banner图片', '');
INSERT INTO `banner` VALUES ('2', 'https://b-ssl.duitang.com/uploads/item/201709/26/20170926131419_8YhLA.jpeg', 'https://github.com/', '野生自然', 'banner图片', '');
INSERT INTO `banner` VALUES ('3', 'https://b-ssl.duitang.com/uploads/item/201510/14/20151014172010_RnJVz.jpeg', 'https://baidu.com/', '景区风光', 'banner图片', '');

-- ----------------------------
-- Table structure for `center_diary_tag`
-- ----------------------------
DROP TABLE IF EXISTS `center_diary_tag`;
CREATE TABLE `center_diary_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diary_id` varchar(50) NOT NULL,
  `tag_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of center_diary_tag
-- ----------------------------
INSERT INTO `center_diary_tag` VALUES ('1', '12121578033729348', '1');
INSERT INTO `center_diary_tag` VALUES ('2', '12121578033729348', '3');
INSERT INTO `center_diary_tag` VALUES ('6', '12121578043333953', '6');
INSERT INTO `center_diary_tag` VALUES ('7', '12121578043333953', '5');
INSERT INTO `center_diary_tag` VALUES ('8', '12121578043333953', '8');
INSERT INTO `center_diary_tag` VALUES ('9', '12121578043333953', '9');
INSERT INTO `center_diary_tag` VALUES ('10', '12121578043333953', '10');
INSERT INTO `center_diary_tag` VALUES ('11', '12121578043567694', '6');
INSERT INTO `center_diary_tag` VALUES ('12', '12121578043567694', '5');
INSERT INTO `center_diary_tag` VALUES ('13', '12121578043567694', '8');
INSERT INTO `center_diary_tag` VALUES ('14', '12121578043567694', '9');
INSERT INTO `center_diary_tag` VALUES ('15', '12121578043567694', '10');
INSERT INTO `center_diary_tag` VALUES ('16', '12121578639136550', '6');
INSERT INTO `center_diary_tag` VALUES ('17', '12121578639136550', '5');
INSERT INTO `center_diary_tag` VALUES ('18', '12121578639136550', '8');
INSERT INTO `center_diary_tag` VALUES ('19', '12121578639136550', '9');
INSERT INTO `center_diary_tag` VALUES ('20', '12121578639136550', '10');
INSERT INTO `center_diary_tag` VALUES ('21', '12121578639869772', '0');
INSERT INTO `center_diary_tag` VALUES ('22', '12121578640347134', '0');
INSERT INTO `center_diary_tag` VALUES ('23', '12121578640655086', '0');
INSERT INTO `center_diary_tag` VALUES ('24', '12121578970766405', '9');
INSERT INTO `center_diary_tag` VALUES ('25', '12121578970766405', '11');

-- ----------------------------
-- Table structure for `center_diary_theme`
-- ----------------------------
DROP TABLE IF EXISTS `center_diary_theme`;
CREATE TABLE `center_diary_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diary_id` varchar(20) DEFAULT NULL,
  `theme_id` int(11) DEFAULT NULL,
  `sub_theme_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of center_diary_theme
-- ----------------------------
INSERT INTO `center_diary_theme` VALUES ('1', '12121578033729348', '1', '1');
INSERT INTO `center_diary_theme` VALUES ('2', '121324', '1', '1');
INSERT INTO `center_diary_theme` VALUES ('3', '12121578639136550', '0', '0');
INSERT INTO `center_diary_theme` VALUES ('4', '12121578639869772', '1', '13');
INSERT INTO `center_diary_theme` VALUES ('5', '12121578640347134', '1', '4');
INSERT INTO `center_diary_theme` VALUES ('6', '12121578640655086', '1', '12');
INSERT INTO `center_diary_theme` VALUES ('7', '12121578970766405', '1', '9');

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
  `content` longtext,
  `theme` int(11) DEFAULT '0',
  `sub_theme` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` varchar(20) DEFAULT '',
  PRIMARY KEY (`diary_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('12121578639136550', '35sg', 'gfwgsdg', '0', '0', '2020-01-10 14:52:16', '2020-01-10 14:52:16', '1212');
INSERT INTO `diary` VALUES ('12121578639869772', '如何加', '告诉看过心胸宽广u反正会风中劲草喜剧房租回家做饭给现金举行ch6868i关系就像个就高兴发i死舒服发家致富紧张个这句负责中介费徐句喜剧u反正接着发巨款v看v房租几分钟继续看徐fzujxgjxvkv，，ku发试卷租房客虚空嘘嘘负责就像个开心果开心果看v想发租u反正技工学校几个可惜个房租西沟几个选修课v看fzujfxgxjvjvk，if只需姐姐虚空v看吧风俗继续挂机小高考v徐看吧吃if自己洗干净刚下课续卡v想看吧吃发i在看小高考虚空虚空v显卡v想空虚发i这个小家具辛苦V型看徐v显卡复习', '1', '13', '2020-01-10 15:04:29', '2020-01-10 15:04:29', '1212');
INSERT INTO `diary` VALUES ('12121578640347134', 'u顾个', '告诉看过心胸宽广u反正会风中劲草喜剧房租回家做饭给现金举行ch6868i关系就像个就高兴发i死舒服发家致富紧张个这句负责中介费徐句喜剧u反正接着发巨款v看v房租几分钟继续看徐fzujxgjxvkv，，ku发试卷租房客虚空嘘嘘负责就像个开心果开心果看v想发租u反正技工学校几个可惜个房租西沟几个选修课v看fzujfxgxjvjvk，if只需姐姐虚空v看吧风俗继续挂机小高考v徐看吧吃if自己洗干净刚下课续卡v想看吧吃发i在看小高考虚空虚空v显卡v想空虚发i这个小家具辛苦V型看徐v显卡复习', '1', '4', '2020-01-10 15:12:27', '2020-01-10 15:12:27', '1212');
INSERT INTO `diary` VALUES ('12121578640655086', '蹲个坑', '告诉看过心胸宽广u反正会风中劲草喜剧房租回家做饭给现金举行ch6868i关系就像个就高兴发i死舒服发家致富紧张个这句负责中介费徐句喜剧u反正接着发巨款v看v房租几分钟继续看徐fzujxgjxvkv，，ku发试卷租房客虚空嘘嘘负责就像个开心果开心果看v想发租u反正技工学校几个可惜个房租西沟几个选修课v看fzujfxgxjvjvk，if只需姐姐虚空v看吧风俗继续挂机小高考v徐看吧吃if自己洗干净刚下课续卡v想看吧吃发i在看小高考虚空虚空v显卡v想空虚发i这个小家具辛苦V型看徐v显卡复习', '1', '12', '2020-01-10 15:17:35', '2020-01-10 15:17:35', '1212');
INSERT INTO `diary` VALUES ('12121578970766405', '日记账号密码', '告诉看过心胸宽广u反正会风中劲草喜剧房租回家做饭给现金举行ch6868i关系就像个就高兴发i死舒服发家致富紧张个这句负责中介费徐句喜剧u反正接着发巨款v看v房租几分钟继续看徐fzujxgjxvkv，，ku发试卷租房客虚空嘘嘘负责就像个开心果开心果看v想发租u反正技工学校几个可惜个房租西沟几个选修课v看fzujfxgxjvjvk，if只需姐姐虚空v看吧风俗继续挂机小高考v徐看吧吃if自己洗干净刚下课续卡v想看吧吃发i在看小高考虚空虚空v显卡v想空虚发i这个小家具辛苦V型看徐v显卡复习', '1', '9', '2020-01-14 10:59:26', '2020-01-14 10:59:26', '1212');

-- ----------------------------
-- Table structure for `diary_like`
-- ----------------------------
DROP TABLE IF EXISTS `diary_like`;
CREATE TABLE `diary_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `diary_id` varchar(20) DEFAULT NULL,
  `love` int(2) DEFAULT NULL,
  `collect` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary_like
-- ----------------------------
INSERT INTO `diary_like` VALUES ('8', '1212', '12121578043567694', '0', '1');
INSERT INTO `diary_like` VALUES ('2', '123456', '12121578043567694', '1', '0');
INSERT INTO `diary_like` VALUES ('9', '12', '12121578043567694', '0', '0');
INSERT INTO `diary_like` VALUES ('7', '1212', '123531', '1', '1');
INSERT INTO `diary_like` VALUES ('15', '1212', '12121578033729348', '1', '1');
INSERT INTO `diary_like` VALUES ('16', '818', '12121578033729348', '1', '1');

-- ----------------------------
-- Table structure for `diary_like_count`
-- ----------------------------
DROP TABLE IF EXISTS `diary_like_count`;
CREATE TABLE `diary_like_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diary_id` varchar(20) DEFAULT NULL,
  `love` int(11) DEFAULT NULL,
  `unlove` int(11) DEFAULT NULL,
  `collect` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary_like_count
-- ----------------------------
INSERT INTO `diary_like_count` VALUES ('4', '12121578033729348', '1', '0', '1');

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
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

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
INSERT INTO `diary_sub_theme` VALUES ('60', '0', '未知', '0');

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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

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
INSERT INTO `diary_theme` VALUES ('10', '0', '未知');

-- ----------------------------
-- Table structure for `sign`
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `ct_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('1', '1212', '2020-01-13 00:00:00');
INSERT INTO `sign` VALUES ('2', '131', '2020-01-13 00:00:00');
INSERT INTO `sign` VALUES ('3', '818', '2020-01-13 00:00:00');

-- ----------------------------
-- Table structure for `token`
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `user_token` varchar(300) NOT NULL COMMENT '用户登录的token',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------

-- ----------------------------
-- Table structure for `up_file`
-- ----------------------------
DROP TABLE IF EXISTS `up_file`;
CREATE TABLE `up_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of up_file
-- ----------------------------
INSERT INTO `up_file` VALUES ('1', 'fbok.png', 'http://localhost:8085/downloadFile/fbok.png', 'image/png', '5169');
INSERT INTO `up_file` VALUES ('2', '激活码.txt', 'http://localhost:8085/downloadFile/%E6%BF%80%E6%B4%BB%E7%A0%81.txt', 'text/plain', '3677');
INSERT INTO `up_file` VALUES ('5', 'enjoy.png', 'http://localhost:8085/downloadFile/enjoy.png', 'image/png', '1384');
INSERT INTO `up_file` VALUES ('6', 'lyf_2.jpg', 'http://127.0.0.1:8085/downloadFile/lyf_2.jpg', 'image/jpeg', '71369');
INSERT INTO `up_file` VALUES ('7', '1117.jpg', 'http://192.168.1.198:8085/downloadFile/1117.jpg', 'application/octet-stream', '409788');
INSERT INTO `up_file` VALUES ('8', '414083.jpg', 'http://192.168.1.198:8085/downloadFile/414083.jpg', 'application/octet-stream', '973738');
INSERT INTO `up_file` VALUES ('9', 't01e532adf321445663.jpg', 'http://192.168.1.198:8085/downloadFile/t01e532adf321445663.jpg', 'application/octet-stream', '15864');
INSERT INTO `up_file` VALUES ('10', '337292.jpg', 'http://192.168.1.198:8085/downloadFile/337292.jpg', 'application/octet-stream', '275945');
INSERT INTO `up_file` VALUES ('11', 't014a44eb6e8e320bd0.jpg', 'http://192.168.1.198:8085/downloadFile/t014a44eb6e8e320bd0.jpg', 'application/octet-stream', '9752');
INSERT INTO `up_file` VALUES ('12', '414083.jpg', 'http://192.168.1.198:8085/downloadFile/414083.jpg', 'application/octet-stream', '973738');
INSERT INTO `up_file` VALUES ('13', '1117.jpg', 'http://192.168.1.198:8085/downloadFile/1117.jpg', 'application/octet-stream', '409788');
INSERT INTO `up_file` VALUES ('14', 't0159005f9c4450c9cc.jpg', 'http://192.168.1.198:8085/downloadFile/t0159005f9c4450c9cc.jpg', 'application/octet-stream', '15988');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `pass_word` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT '',
  `sex` int(11) DEFAULT '0' COMMENT '0:女,1:男',
  `age` int(11) DEFAULT '18' COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建的时间戳',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改User的时间戳',
  PRIMARY KEY (`user_id`,`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '818', '123456', '13294659161', '0', '20', '2020-01-13 21:02:32', '2020-01-13 21:02:32');
INSERT INTO `user` VALUES ('2', '12', '123456', '13294659161', '0', '20', '2020-01-13 21:02:26', '2020-01-13 21:02:26');
INSERT INTO `user` VALUES ('3', '123456', '123456', '13294659161', '0', '20', '2020-01-13 21:01:46', '2020-01-13 21:01:46');
INSERT INTO `user` VALUES ('4', '1212', '123456', '13294659161', '0', '20', '2020-01-13 21:01:40', '2020-01-13 21:01:40');
INSERT INTO `user` VALUES ('5', '121', '123456', '13294659161', '0', '20', '2020-01-13 21:01:32', '2020-01-13 21:01:32');
INSERT INTO `user` VALUES ('6', '525', '123456', '13200000000', '1', '18', '2020-01-13 21:12:14', '2020-01-13 21:12:14');
INSERT INTO `user` VALUES ('7', '111', '123456', '13200000000', '1', '18', '2020-01-13 21:12:26', '2020-01-13 21:12:26');

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
