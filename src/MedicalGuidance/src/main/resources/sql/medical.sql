CREATE DATABASE IF NOT EXISTS `medicalguidance`;
USE  `medicalguidance`;

CREATE TABLE `patientInfo` (
    `userid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '用户的id，主键自增',
    `name` varchar(100) NOT NULL COMMENT '服务名称',
    `version` varchar(100) NOT NULL COMMENT '版本号',
    `branch` varchar(10) not null COMMENT '分支',
    `image` varchar(100) COMMENT '镜像地址',
    `port` integer  NOT NULL COMMENT '端口号',
    `basePath` varchar(100) NOT NULL COMMENT 'git仓库地址',
    PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `doctor` (
    `id` INTEGER NOT NULL AUTO_INCREMENT COMMENT '用户的id，主键自增',
    `name` varchar(64) NOT NULL COMMENT '用户的姓名',
    `tel` VARCHAR (100) NOT NULL COMMENT '电话',
    `Number` VARCHAR (100) NOT NULL COMMENT '身份证号码',
    `illType` varchar (100) NOT NULL COMMENT '医生的类别',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table `illNess` (
                           `id` varchar(100) NOT NULL,
                           `illType` INTEGER not null ,
                           `date` varchar (100) not null ,
                           `text` varchar (100) not null,
                           `startDate` varchar (100) not null ,
                           `endDate` varchar (100) not null ,
                           `patient` varchar (100) not null,
                           `diagnosesIds` varchar (100),
                           primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table `Diagnosis` (
    `id` varchar(100) NOT NULL,
    `illNessId` varchar (100) NOT NULL,
    `doctorId` varchar (100) not null ,
    `result` varchar (100) not null,
    `medicine` varchar (100),
    `check` varchar (100),
    `date` varchar (100),
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;