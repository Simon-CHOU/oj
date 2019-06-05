/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 119.23.209.207:3306
 Source Schema         : oj

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 04/06/2019 17:05:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ac
-- ----------------------------
DROP TABLE IF EXISTS `ac`;
CREATE TABLE `ac`  (
  `idassignment` int(11) NOT NULL,
  `idclass` int(11) NOT NULL,
  PRIMARY KEY (`idassignment`, `idclass`) USING BTREE,
  INDEX `FK_class_idx`(`idclass`) USING BTREE,
  CONSTRAINT `FK_assginment` FOREIGN KEY (`idassignment`) REFERENCES `assignment` (`idassignment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_class` FOREIGN KEY (`idclass`) REFERENCES `class` (`idclass`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'assignment-class' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ac
-- ----------------------------
INSERT INTO `ac` VALUES (1, 1);
INSERT INTO `ac` VALUES (3, 1);
INSERT INTO `ac` VALUES (1, 2);
INSERT INTO `ac` VALUES (3, 2);
INSERT INTO `ac` VALUES (1, 3);
INSERT INTO `ac` VALUES (3, 3);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `idadmin` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `permission` int(11) NOT NULL DEFAULT 3,
  PRIMARY KEY (`idadmin`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('500', '123456', 3);
INSERT INTO `admin` VALUES ('555558', 'roo232', 3);
INSERT INTO `admin` VALUES ('555559', 'jakjdf', 3);
INSERT INTO `admin` VALUES ('5555597', 'jakjdf', 3);
INSERT INTO `admin` VALUES ('5555599', 'jakjdf', 3);

-- ----------------------------
-- Table structure for ap
-- ----------------------------
DROP TABLE IF EXISTS `ap`;
CREATE TABLE `ap`  (
  `idassignment` int(11) NOT NULL,
  `idproblem` int(11) NOT NULL,
  PRIMARY KEY (`idassignment`, `idproblem`) USING BTREE,
  INDEX `FK_problem_idx`(`idproblem`) USING BTREE,
  CONSTRAINT `FK_assignment` FOREIGN KEY (`idassignment`) REFERENCES `assignment` (`idassignment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_problem` FOREIGN KEY (`idproblem`) REFERENCES `problem` (`idproblem`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'assignment-problem' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ap
-- ----------------------------
INSERT INTO `ap` VALUES (1, 1);
INSERT INTO `ap` VALUES (1, 3);
INSERT INTO `ap` VALUES (1, 9);
INSERT INTO `ap` VALUES (3, 9);
INSERT INTO `ap` VALUES (1, 10);
INSERT INTO `ap` VALUES (3, 10);
INSERT INTO `ap` VALUES (1, 11);
INSERT INTO `ap` VALUES (3, 11);

-- ----------------------------
-- Table structure for assignment
-- ----------------------------
DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment`  (
  `idassignment` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idteacher` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `commence` datetime(0) NOT NULL,
  `deadline` datetime(0) NOT NULL,
  `status` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未开始',
  PRIMARY KEY (`idassignment`) USING BTREE,
  UNIQUE INDEX `title_UNIQUE`(`title`) USING BTREE,
  INDEX `FK_teacher`(`idteacher`) USING BTREE,
  CONSTRAINT `FK_teacher` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`idteacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '作业状态名未开始、进行中、已结束三种' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assignment
-- ----------------------------
INSERT INTO `assignment` VALUES (1, '测试作业1', '444', '2019-05-14 02:58:47', '2019-05-29 02:58:56', '未开始');
INSERT INTO `assignment` VALUES (3, '测试作业2', '444', '2019-05-22 03:00:27', '2019-05-25 03:00:33', '未开始');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `idclass` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idteacher` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `semester` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `stu_amount` int(11) NULL DEFAULT 0,
  `opendate` datetime(0) NULL DEFAULT NULL,
  `closedate` datetime(0) NULL DEFAULT NULL,
  `status` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '待开班',
  PRIMARY KEY (`idclass`) USING BTREE,
  UNIQUE INDEX `classname_UNIQUE`(`classname`) USING BTREE,
  INDEX `idteacher_idx`(`idteacher`) USING BTREE,
  CONSTRAINT `FK_headteacher` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`idteacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '班级状态名有待开班、已开启、已关闭、已存档四种' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '18秋软件测试', '444', '20182', 54, '2018-09-27 11:52:12', '2018-11-29 11:52:24', '已存档');
INSERT INTO `class` VALUES (2, '19春C++', '444', '20191', 54, NULL, NULL, '已开启');
INSERT INTO `class` VALUES (3, '19秋C程序设计', '444', '20192', 34, NULL, NULL, '待开班');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `idproblem` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `input` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `output` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `committed` int(11) NULL DEFAULT 0,
  `passed` int(11) NULL DEFAULT 0,
  `tag` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`idproblem`) USING BTREE,
  UNIQUE INDEX `title_UNIQUE`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1, 'A+B', '给出两个整数 aa 和 bb , 求他们的和。', '1 2', '3', NULL, NULL, '简单,水题');
INSERT INTO `problem` VALUES (3, '整数反转', '给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。', '123', '321', 0, 0, 'easy');
INSERT INTO `problem` VALUES (8, '测试0', '测试0', '0', 'hello', 0, 0, NULL);
INSERT INTO `problem` VALUES (9, '测试1', '测试1描述', 'x', 'xxx', 0, 0, NULL);
INSERT INTO `problem` VALUES (10, '测试2', '测试2描述', '78', '87', 0, 0, NULL);
INSERT INTO `problem` VALUES (11, '测试3', '测试3描述', '88', '8', 0, 0, NULL);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `idstudent` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `idclass` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idclass`, `idstudent`) USING BTREE,
  INDEX `FK_idx`(`idclass`) USING BTREE,
  INDEX `FK_student_idx`(`idstudent`) USING BTREE,
  CONSTRAINT `FK_class_1` FOREIGN KEY (`idclass`) REFERENCES `class` (`idclass`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_student` FOREIGN KEY (`idstudent`) REFERENCES `student` (`idstudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'student-class' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('301', 1);
INSERT INTO `sc` VALUES ('302', 1);
INSERT INTO `sc` VALUES ('303', 1);
INSERT INTO `sc` VALUES ('304', 2);
INSERT INTO `sc` VALUES ('305', 2);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `idstudent` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nature_class` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idstudent`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('112333', '王抗美', '软件1504', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('300', '王先金', '软件1504', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('301', '李婷婷', '软件1503', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('302', '王圆圆', '软件1501', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('303', '李白白', '软件1502', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('304', '张小小', '软件1505', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('305', '旷大大', '软件1505', NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('308', NULL, NULL, NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('310', NULL, NULL, NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('311', NULL, NULL, NULL, NULL, '123456', 1);
INSERT INTO `student` VALUES ('388', NULL, NULL, NULL, NULL, '123456', 1);

-- ----------------------------
-- Table structure for submit
-- ----------------------------
DROP TABLE IF EXISTS `submit`;
CREATE TABLE `submit`  (
  `idsubmit` int(11) NOT NULL AUTO_INCREMENT,
  `idstudent` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idproblem` int(11) NOT NULL,
  `idassignment` int(11) NOT NULL,
  `sourcecode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `compiler` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'g++',
  `console_output` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duration` int(11) NULL DEFAULT NULL,
  `space` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`idsubmit`) USING BTREE,
  INDEX `idproblem_idx`(`idproblem`) USING BTREE,
  INDEX `FK_student_idx`(`idstudent`) USING BTREE,
  INDEX `FK_assignment_idx`(`idassignment`) USING BTREE,
  INDEX `Fk_assignment_11_idx`(`idassignment`) USING BTREE,
  CONSTRAINT `FK_problem_2` FOREIGN KEY (`idproblem`) REFERENCES `problem` (`idproblem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_student_3` FOREIGN KEY (`idstudent`) REFERENCES `student` (`idstudent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_assignment_11` FOREIGN KEY (`idassignment`) REFERENCES `assignment` (`idassignment`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submit
-- ----------------------------
INSERT INTO `submit` VALUES (1, '301', 1, 1, '#include', '2019-05-30 20:15:59', 'g++', NULL, NULL, NULL, NULL, 99);
INSERT INTO `submit` VALUES (2, '303', 1, 3, '#include', '2019-05-30 20:16:02', 'g++', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submit` VALUES (3, '305', 1, 1, '#include', '2019-05-30 20:16:06', 'gcc', NULL, NULL, NULL, NULL, 89);
INSERT INTO `submit` VALUES (7, '112333', 1, 3, '#include', '2019-05-27 10:46:01', 'g++', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `idteacher` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `qq` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `permission` int(11) NOT NULL DEFAULT 2,
  PRIMARY KEY (`idteacher`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('401', '李绘卓', '9090950', '12233335555', 'lihuihzuo@qq.com', '123456', 2);
INSERT INTO `teacher` VALUES ('444', '老师1', '111111', '1121112', 'ee@kk.com', '123456', 2);

-- ----------------------------
-- Procedure structure for test_loop
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_loop`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_loop`()
begin
	declare cnt int default 1;
	declare i int default 1;
	select count(*) into cnt from user where classname like '%16%';
	
	while i <= cnt
	do
		select i;
		set i=i+1;
	end while;
	commit;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
