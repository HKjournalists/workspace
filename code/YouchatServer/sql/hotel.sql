/*
Navicat MySQL Data Transfer

Source Server         : 本机拼车数据库
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : youchat

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-04-10 09:40:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t1_hotelarea
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelarea`;
CREATE TABLE `t1_hotelarea` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT ,
`t1_areaName`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '地区名称' ,
`t1_order`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
`t1_areaCode`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '地区代码' ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelarea
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelevaluate
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelevaluate`;
CREATE TABLE `t1_hotelevaluate` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
`t1_hotelId`  int(11) NULL DEFAULT NULL COMMENT '酒店编号' ,
`t1_hotelName`  varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店名称' ,
`t1_evaluativeContent`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '评价内容' ,
`t1_hotelStep`  varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店评级' ,
`t1_otherInfo`  varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '其他信息' ,
`t1_expandCol1`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol2`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol3`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol4`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol5`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelevaluate
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelinfo
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelinfo`;
CREATE TABLE `t1_hotelinfo` (
`t1_Id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '酒店编号' ,
`t1_hotelName`  varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店名称' ,
`t1_hotelAddress`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店地址' ,
`t1_hotelManger`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店管理员' ,
`t1_hotelMgnPhone`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店管理员手机号' ,
`t1_hotelStar`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店星级' ,
`t1_hotelType`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店类型' ,
`t1_ownProvince`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '所在省份' ,
`t1_ownArea`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '所在地区/市' ,
`t1_addressDesc`  varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '详细地址' ,
`t1_roomProce`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房均价' ,
`t1_roomNum`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '客房数量' ,
`t1_landMarks`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '附件地标' ,
`t1_hotelContent`  varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店介绍' ,
`t1_hotelServices`  varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '设施服务' ,
`t1_hotelImgUrl`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店主图' ,
`t1_messageConfirm`  varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '短信确认' ,
`t1_hotelOrder`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '酒店排名' ,
`t1_browseNum`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '浏览次数' ,
`t1_reserveNum`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '预订次数' ,
`t1_hotelGood`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '酒店好评' ,
`t1_hotelBad`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '酒店差评' ,
`t1_remarks`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '备注' ,
`t1_expandCol1`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol2`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol3`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol4`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol5`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
PRIMARY KEY (`t1_Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelinfo
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelorder
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelorder`;
CREATE TABLE `t1_hotelorder` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT ,
`t1_hotelId`  int(11) NULL DEFAULT NULL COMMENT '酒店编号' ,
`t1_hotelName`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '酒店名称' ,
`t1_roomId`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '客房编号' ,
`t1_roomName`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房名称' ,
`t1_visitorName`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客人姓名' ,
`t1_phoneNum`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '联系电话' ,
`t1_reserveDate`  datetime NULL DEFAULT NULL COMMENT '到酒店时间' ,
`t1_intoDate`  date NULL DEFAULT NULL COMMENT '入住时间' ,
`t1_leaveDate`  date NULL DEFAULT NULL COMMENT '退房时间' ,
`t1_reserveCount`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订房数量' ,
`t1_totalPirce`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '总房费' ,
`t1_roomSource`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '来源' ,
`t1_orderStatus`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '订单状态' ,
`t1_expandCol1`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol2`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol3`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol4`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol5`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelorder
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelphoto
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelphoto`;
CREATE TABLE `t1_hotelphoto` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
`t1_hotelId`  int(11) NULL DEFAULT NULL COMMENT '酒店编号' ,
`t1_hotelName`  varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店名称' ,
`t1_imgUrl`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '图片URL' ,
`t1_uploadDate`  datetime NULL DEFAULT NULL COMMENT '上传时间' ,
`t1_order`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '当前位置' ,
`t1_remarks`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '备注' ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelphoto
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelroom
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelroom`;
CREATE TABLE `t1_hotelroom` (
`t1_Id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '客房编号' ,
`t1_roomName`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房名称' ,
`t1_roomType`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房类型' ,
`t1_roomPrice`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客房价格' ,
`t1_recommendRoom`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '推荐房型' ,
`t1_breakfastType`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '早餐类型' ,
`t1_wideType`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '宽带类型' ,
`t1_roomNum`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '客房数量' ,
`t1_roomDesc`  varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房介绍' ,
`t1_roomRemarks`  varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房备注' ,
`t1_roomPhoto1`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房照片1' ,
`t1_roomPhoto2`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房照片2' ,
`t1_roomPhoto3`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '客房照片3' ,
`t1_expandCol1`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol2`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol3`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol4`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_expandCol5`  varchar(300) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '扩展属性' ,
`t1_hotelId`  int(11) NULL DEFAULT 0 COMMENT '酒店信息的id' ,
PRIMARY KEY (`t1_Id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelroom
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelsmsrec
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelsmsrec`;
CREATE TABLE `t1_hotelsmsrec` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
`t1_orderId`  varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '订单编号' ,
`t1_sender`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '发送者' ,
`t1_senderPhone`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '发送者手机' ,
`t1_messageType`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '短信类型' ,
`t1_Receive`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '接收者' ,
`t1_receivePhone`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '接收者手机' ,
`t1_messageContent`  varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '短信内容' ,
`t1_createTime`  datetime NULL DEFAULT NULL COMMENT '发送/接收时间' ,
`t1_remarks`  varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '备注' ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelsmsrec
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hotelstarlev
-- ----------------------------
DROP TABLE IF EXISTS `t1_hotelstarlev`;
CREATE TABLE `t1_hotelstarlev` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT ,
`t1_hotelStar`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店星级' ,
`t1_order`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hotelstarlev
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t1_hoteltype
-- ----------------------------
DROP TABLE IF EXISTS `t1_hoteltype`;
CREATE TABLE `t1_hoteltype` (
`t1_id`  int(11) NOT NULL AUTO_INCREMENT ,
`t1_hotelType`  varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '酒店类型' ,
`t1_order`  int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
PRIMARY KEY (`t1_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of t1_hoteltype
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Auto increment value for t1_hotelarea
-- ----------------------------
ALTER TABLE `t1_hotelarea` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelevaluate
-- ----------------------------
ALTER TABLE `t1_hotelevaluate` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelinfo
-- ----------------------------
ALTER TABLE `t1_hotelinfo` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelorder
-- ----------------------------
ALTER TABLE `t1_hotelorder` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelphoto
-- ----------------------------
ALTER TABLE `t1_hotelphoto` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelroom
-- ----------------------------
ALTER TABLE `t1_hotelroom` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelsmsrec
-- ----------------------------
ALTER TABLE `t1_hotelsmsrec` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hotelstarlev
-- ----------------------------
ALTER TABLE `t1_hotelstarlev` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for t1_hoteltype
-- ----------------------------
ALTER TABLE `t1_hoteltype` AUTO_INCREMENT=1;
