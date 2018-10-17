


CREATE DATABASE   t31_student default charset utf8 COLLATE utf8_general_ci;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增 id',
  `studentNo` varchar(32) DEFAULT NULL COMMENT '学号',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别 1男 2女',
  `birthday` varchar(32) DEFAULT NULL COMMENT '生日',
  `familyAddr` varchar(100) DEFAULT NULL COMMENT '家庭地址',
  `contactTel` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `createtime` varchar(32) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `studentNo` (`studentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8
