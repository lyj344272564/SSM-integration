/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.28-log : Database - ssmzh
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssmzh` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ssmzh`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(100) NOT NULL COMMENT '账户名称',
  `account` varchar(100) NOT NULL COMMENT '账户',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `dept_id` int(20) DEFAULT NULL COMMENT '部门id',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '移动电话',
  `tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `sex` int(2) DEFAULT '1' COMMENT '性别（1是男，0是女）',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`account_name`,`account`,`password`,`dept_id`,`email`,`mobile`,`tel`,`sex`,`birthday`) values (1,'liyujie','richard','381958e9bde2c3b73a4dee18b2488917',1,'34427@qq.com','1331313131','13131313',1,'2022-02-05 19:31:31'),(2,'lyj','lyjRichard','123456',3,'321313@qq.com','23213213123','1323213',0,'2022-02-06 13:44:30'),(3,'lllyyj','richardd','f7e65178ddb8e59016be84ff02d588ee',1,'123123123','1111','1231231231',1,'2022-02-06 21:24:22'),(4,'lllyyj','richarddd','96867daa82d68d5d29b84ca43eca6130',1,'123123123','1111','1231231231',1,'2022-02-07 11:20:06'),(5,'lllyyj','lyj','381958e9bde2c3b73a4dee18b2488917',1,'123123123','1111','1231231231',1,'2022-02-07 11:21:24'),(6,'lllyyj','lyjj','381958e9bde2c3b73a4dee18b2488917',1,'123123123','1111','1231231231',1,'2022-02-07 11:24:19'),(7,'lllyyj','lyjj','123456',3,'123123123@qq.com','1111','1231231231',1,'2022-02-07 17:20:41');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
