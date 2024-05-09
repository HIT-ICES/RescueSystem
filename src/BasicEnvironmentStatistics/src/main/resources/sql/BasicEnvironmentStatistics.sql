CREATE DATABASE  IF NOT EXISTS `basicenvironmentstatistics`;
USE `basicenvironmentstatistics` ;
START TRANSACTION;
DROP TABLE IF EXISTS `Data`;
CREATE TABLE `Data` (
    `Id` char(32) COLLATE ascii_general_ci NOT NULL,
    `Type` char(32) COLLATE ascii_general_ci NOT NULL,
    `update_time` datetime(6) NOT NULL,
    `Value` longtext CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT `PK_Data` PRIMARY KEY (`Id`)
) CHARACTER SET utf8mb4;
COMMIT;