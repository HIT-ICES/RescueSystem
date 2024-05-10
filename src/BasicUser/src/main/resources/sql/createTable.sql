CREATE DATABASE IF NOT EXISTS `BasicUser`;
USE  `BasicUser`;

create table `basicuser`(
                            `userid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '用户的id，主键自增',
                            `name` VARCHAR(16) NOT NULL COMMENT '用户的姓名',
                            `birthday` DATE COMMENT '用户的生日，可以为空, 类型为DATE 年月日',
                            `email` VARCHAR(16)  COMMENT '用户邮箱， 可以为空',
                            `sex` INTEGER NOT NULL COMMENT '用户的性别',
                            `phone` VARCHAR(16) NOT NULL COMMENT '用户的手机号',
                            `type` INTEGER NOT NULL COMMENT '用户类别',
                            `password` VARCHAR(16) NOT NULL COMMENT '密码',
                            primary key (userid)
)
