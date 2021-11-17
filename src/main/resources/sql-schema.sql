DROP SCHEMA `hwa`;

CREATE SCHEMA IF NOT EXISTS `hwa`;

USE `hwa`

DROP TABLE IF EXISTS `shop`;
DROP TABLE IF EXISTS `sheet_music`;

CREATE TABLE `shop`
(
	`shop_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`shop_name` varchar(255) NOT NULL,
	`shop_address` varchar(255) NOT NULL
	);

CREATE TABLE `sheet_music`
(
	`sheet_music_id` BIGINT AUTO_INCREMENT,
	`title` varchar(255) NOT NULL,
	`author` varchar(255) NOT NULL,
	`genre` varchar(25) NOT NULL,
	`price` double NOT NULL,
	`shop_id` bigint NOT NULL,
	PRIMARY KEY (sheet_music_id)
	);
	
	
	