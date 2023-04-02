DROP TABLE IF EXISTS `loan_application`;

CREATE TABLE `loan_application` (
 
 `id` int(11) NOT NULL AUTO_INCREMENT,
  
`customer_ssn` varchar(50) NOT NULL COMMENT 'customer_ssn',
  
`full_name` varchar(200) NOT NULL COMMENT 'full_name',
  
`loan_amount` decimal(20,2) NOT NULL COMMENT 'loan_amount',
 
 `equity_amount` decimal(20,2) DEFAULT NULL COMMENT 'equity_amount',
 
 `salary_amount` decimal(20,2) DEFAULT NULL COMMENT 'salary_amount',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time',
  
`update_time` datetime DEFAULT NULL COMMENT 'update_time',
  
PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `loan_user`;

CREATE TABLE `loan_user` (
 
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '”√ªß±Ìid',
  
`username` varchar(50) NOT NULL COMMENT 'username',
 
`password` varchar(50) NOT NULL COMMENT 'password£¨MD5 encrypt',
  
`email` varchar(50) NOT NULL COMMENT 'email',
 
`phone` varchar(20) DEFAULT NULL COMMENT 'phone'
,
  
`role` varchar(20) NOT NULL COMMENT 'adviser or customer',
  
`create_time` datetime NOT NULL COMMENT 'create_time',
 
`update_time` datetime NOT NULL COMMENT 'update_time',
  
PRIMARY KEY (`id`),
  UNIQUE KEY 
`user_name_unique` (`username`) USING BTREE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
