/*
 Navicat Premium Data Transfer

 Source Server         : 2019122128
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : lichun_gas

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 22/10/2021 14:43:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lichun_client
-- ----------------------------
DROP TABLE IF EXISTS `lichun_client`;
CREATE TABLE `lichun_client`  (
  `client_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 300015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_client
-- ----------------------------
INSERT INTO `lichun_client` VALUES (300001, '陈认', '13975465832', '江苏省无锡市惠山区绿地世纪城206-1301');
INSERT INTO `lichun_client` VALUES (300002, '曾国金', '13016914681', '江苏省无锡市惠山区理想城市花园855-1203');
INSERT INTO `lichun_client` VALUES (300003, '叶宗挽', '13016945217', '江苏省无锡市惠山区嘉利华府庄园43号楼');
INSERT INTO `lichun_client` VALUES (300004, '罗鸣', '17511637759', '江苏省无锡市惠山区绿地世纪城');
INSERT INTO `lichun_client` VALUES (300005, '黎晓', '13845267952', '江苏省无锡市惠山区绿地世纪城203-1001');
INSERT INTO `lichun_client` VALUES (300006, '骆明湖', '15954628876', '江苏省无锡市惠山区嘉利华府庄园十区29号楼');
INSERT INTO `lichun_client` VALUES (300007, '谢林安', '17513659756', '江苏省无锡市惠山区嘉利华府庄园九区18号楼');
INSERT INTO `lichun_client` VALUES (300008, '杨宇涛', '13954723665', '江苏省无锡市惠山区理想城市花园852-1701');
INSERT INTO `lichun_client` VALUES (300009, '李琳', '13845262795', '江苏省无锡市惠山区奥林匹克花园157-1004');
INSERT INTO `lichun_client` VALUES (300010, '钱林芳', '13812184526', '江苏省无锡市惠山区奥林匹克花园420-1503');
INSERT INTO `lichun_client` VALUES (300011, '华安', '17562452268', '江苏省无锡市惠山区金都花园205-1004');
INSERT INTO `lichun_client` VALUES (300012, '李云龙', '13845263498', '江苏省无锡市惠山区百大春城99-104');
INSERT INTO `lichun_client` VALUES (300013, '张飞', '13845364952', '江苏省无锡市惠山区金都花园212-1102');
INSERT INTO `lichun_client` VALUES (300014, '刘备', '15950124479', '江苏省无锡市惠山区百大春城100-1503');

-- ----------------------------
-- Table structure for lichun_gas
-- ----------------------------
DROP TABLE IF EXISTS `lichun_gas`;
CREATE TABLE `lichun_gas`  (
  `gas_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '煤气编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `inventory` int(11) NOT NULL DEFAULT 0 COMMENT '库存量',
  `purchase_price` double NULL DEFAULT 0 COMMENT '进价',
  `price` double NOT NULL DEFAULT 0 COMMENT '售价',
  PRIMARY KEY (`gas_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_gas
-- ----------------------------
INSERT INTO `lichun_gas` VALUES (100001, '人工煤气', 15, 20, 24);
INSERT INTO `lichun_gas` VALUES (100002, '天然气', 0, 0, 0);
INSERT INTO `lichun_gas` VALUES (100003, '液化石油气', 0, 0, 0);
INSERT INTO `lichun_gas` VALUES (100004, '沼气', 0, 0, 0);

-- ----------------------------
-- Table structure for lichun_instore
-- ----------------------------
DROP TABLE IF EXISTS `lichun_instore`;
CREATE TABLE `lichun_instore`  (
  `instore_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '入库编号',
  `instore_date` date NULL DEFAULT NULL COMMENT '入库日期',
  `gas_id` int(6) NOT NULL COMMENT '煤气编号',
  `supplier_id` int(6) NOT NULL COMMENT '供应商编号',
  `purchase_price` double(8, 2) NOT NULL COMMENT '进价',
  `instore_quantity` int(6) NOT NULL COMMENT '入库数量',
  `instore_expenditure` double(10, 2) NULL DEFAULT NULL COMMENT '入库支出',
  PRIMARY KEY (`instore_id`) USING BTREE,
  INDEX `fk_instore_gas`(`gas_id`) USING BTREE,
  INDEX `fk_instore_supplier`(`supplier_id`) USING BTREE,
  CONSTRAINT `fk_instore_gas` FOREIGN KEY (`gas_id`) REFERENCES `lichun_gas` (`gas_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_instore_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `lichun_supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_instore
-- ----------------------------
INSERT INTO `lichun_instore` VALUES (2, '2021-10-20', 100001, 400001, 20.00, 30, 600.00);

-- ----------------------------
-- Table structure for lichun_outstore
-- ----------------------------
DROP TABLE IF EXISTS `lichun_outstore`;
CREATE TABLE `lichun_outstore`  (
  `outstore_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '出库编号',
  `outstore_date` date NOT NULL COMMENT '出库日期',
  `gas_id` int(6) NOT NULL COMMENT '煤气编号',
  `outstore_quantity` int(6) NOT NULL COMMENT '出库数量',
  `outstore_income` double(8, 2) UNSIGNED NULL DEFAULT NULL COMMENT '出库收入',
  `staff_id` int(6) NOT NULL COMMENT '员工编号',
  `client_id` int(6) NOT NULL COMMENT '客户编号',
  PRIMARY KEY (`outstore_id`) USING BTREE,
  INDEX `fk_outstore_gas`(`gas_id`) USING BTREE,
  INDEX `fk_outstore_staff`(`staff_id`) USING BTREE,
  INDEX `fk_outstore_client`(`client_id`) USING BTREE,
  CONSTRAINT `fk_outstore_client` FOREIGN KEY (`client_id`) REFERENCES `lichun_client` (`client_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_outstore_gas` FOREIGN KEY (`gas_id`) REFERENCES `lichun_gas` (`gas_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_outstore_staff` FOREIGN KEY (`staff_id`) REFERENCES `lichun_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_outstore
-- ----------------------------
INSERT INTO `lichun_outstore` VALUES (1, '2021-10-20', 100001, 15, 360.00, 200001, 300001);

-- ----------------------------
-- Table structure for lichun_staff
-- ----------------------------
DROP TABLE IF EXISTS `lichun_staff`;
CREATE TABLE `lichun_staff`  (
  `staff_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别',
  `age` int(2) NULL DEFAULT NULL COMMENT '年龄',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_staff
-- ----------------------------
INSERT INTO `lichun_staff` VALUES (200001, '马云', 1, 56, '13812181928', '江苏省无锡市惠山区绿地世纪城212-1803');
INSERT INTO `lichun_staff` VALUES (200002, '马化腾', 1, 43, '18606297594', '江苏省无锡市惠山区金都花园108-1004');
INSERT INTO `lichun_staff` VALUES (200003, '王健林', 1, 65, '17511401178', '江苏省无锡市惠山区百大春城108-1803');
INSERT INTO `lichun_staff` VALUES (200004, '董明珠', 0, 52, '13921535887', '江苏省无锡市惠山区绿地世纪城206-1005');
INSERT INTO `lichun_staff` VALUES (200005, '范冰冰', 0, 47, '17511801165', '江苏省无锡市惠山区绿地世纪城217-2401');

-- ----------------------------
-- Table structure for lichun_supplier
-- ----------------------------
DROP TABLE IF EXISTS `lichun_supplier`;
CREATE TABLE `lichun_supplier`  (
  `supplier_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 400005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lichun_supplier
-- ----------------------------
INSERT INTO `lichun_supplier` VALUES (400001, '百度', '15950103319', '北京');
INSERT INTO `lichun_supplier` VALUES (400002, '阿里', '13812563548', '杭州');
INSERT INTO `lichun_supplier` VALUES (400003, '腾讯', '17533452286', '深圳');
INSERT INTO `lichun_supplier` VALUES (400004, '网易', '13954267559', '上海');

-- ----------------------------
-- Procedure structure for queryandsort
-- ----------------------------
DROP PROCEDURE IF EXISTS `queryandsort`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `queryandsort`(in theyear int, in themonth int)
begin
	select lichun_client.client_id as '客户编号', lichun_client.name as '姓名', SUM(outstore_quantity) as '用气量' from lichun_outstore, lichun_client
	where year(outstore_date) = theyear and month(outstore_date) = themonth and lichun_outstore.client_id = lichun_client.client_id
	group by lichun_outstore.client_id
	order by outstore_quantity desc
	limit 10;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for statisitcs
-- ----------------------------
DROP PROCEDURE IF EXISTS `statisitcs`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `statisitcs`(in theyear int, in themonth int)
begin
	select lichun_staff.staff_id as '员工编号', lichun_staff.name as '姓名', SUM(outstore_quantity) as '送气量' from lichun_outstore, lichun_staff
	where year(outstore_date) = theyear and month(outstore_date) = themonth and lichun_outstore.staff_id = lichun_staff.staff_id
	group by lichun_outstore.staff_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table lichun_instore
-- ----------------------------
DROP TRIGGER IF EXISTS `calculate_instore_expenditure`;
delimiter ;;
CREATE TRIGGER `calculate_instore_expenditure` BEFORE INSERT ON `lichun_instore` FOR EACH ROW begin

	set new.instore_expenditure = new.purchase_price * new.instore_quantity;
	
	set new.instore_date = now();

end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table lichun_instore
-- ----------------------------
DROP TRIGGER IF EXISTS `set_purchase_price_and_inventory`;
delimiter ;;
CREATE TRIGGER `set_purchase_price_and_inventory` AFTER INSERT ON `lichun_instore` FOR EACH ROW begin
	update lichun_gas set inventory = inventory + NEW.instore_quantity where gas_id = NEW.gas_id;
	update lichun_gas set purchase_price = NEW.purchase_price where gas_id = NEW.gas_id;
	update lichun_gas set price = NEW.purchase_price * 1.2 where gas_id = NEW.gas_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table lichun_outstore
-- ----------------------------
DROP TRIGGER IF EXISTS `calculate_outstore_expenditure`;
delimiter ;;
CREATE TRIGGER `calculate_outstore_expenditure` BEFORE INSERT ON `lichun_outstore` FOR EACH ROW begin

	set new.outstore_income = new.outstore_quantity * (select price from lichun_gas where gas_id = NEW.gas_id);

	set new.outstore_date = now();


end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table lichun_outstore
-- ----------------------------
DROP TRIGGER IF EXISTS `set_inventory`;
delimiter ;;
CREATE TRIGGER `set_inventory` AFTER INSERT ON `lichun_outstore` FOR EACH ROW update lichun_gas set inventory = inventory - NEW.outstore_quantity where gas_id = NEW.gas_id
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
