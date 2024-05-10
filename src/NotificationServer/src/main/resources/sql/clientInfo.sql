CREATE DATABASE IF NOT EXISTS `NotificationService`;
USE `NotificationService`;


CREATE TABLE `clientinfo` (
                              `clientid` varchar(100) NOT NULL COMMENT 'client id',
                              `location` varchar(100) NOT NULL COMMENT '地点',
                              `ip` varchar(100) NOT NULL COMMENT 'ip 地址',
                              `ifable` integer(100) not null COMMENT '是否可用',
                              PRIMARY KEY (`clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `serverinfo`(
                             `serverid` varchar (100) not null comment 'server id',
                             PRIMARY KEY (`serverid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;