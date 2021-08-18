-- MySQL Workbench Synchronization
-- Generated: 2021-08-10 13:46
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: user

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `heroku_60bbdab0e91f951`.`contact` 
CHARACTER SET = utf8  , COLLATE = utf8_general_ci ,
DROP COLUMN `socialmedia_id`,
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `link` `link` VARCHAR(45) NULL DEFAULT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC)  ,
ADD INDEX `fk_contact_employee1_idx` (`employee_id` ASC)  ,
ADD INDEX `fk_contact_socialmedia1_idx` (`socialmedia_platform` ASC)  ,
DROP INDEX `FK1py2bn6sjbv6qy86h6lug1nil` ,
DROP INDEX `FKahgr65l45anwaeoft98neymad` ;
;

CREATE TABLE IF NOT EXISTS `heroku_60bbdab0e91f951`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `rol` VARCHAR(45) NULL DEFAULT NULL,
  `bio` VARCHAR(45) NULL DEFAULT NULL,
  `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

ALTER TABLE `heroku_60bbdab0e91f951`.`leader` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `rol` `rol` VARCHAR(45) NULL DEFAULT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC)  ,
ADD INDEX `fk_leader_employee_idx` (`employee_id` ASC)  ,
DROP INDEX `FKofl74vveobr2q035ocius3auu` ;
;

ALTER TABLE `heroku_60bbdab0e91f951`.`socialmedia` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
DROP COLUMN `id`,
CHANGE COLUMN `platform` `platform` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`platform`);
;

ALTER TABLE `heroku_60bbdab0e91f951`.`team` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC)  ,
ADD INDEX `fk_team_leader1_idx` (`leader_id` ASC)  ,
DROP INDEX `FKat2qnmqfyorgo6chwr2p2iph9` ;
;

ALTER TABLE `heroku_60bbdab0e91f951`.`team_member` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `team_id` `team_id` INT(11) NOT NULL AFTER `id`,
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC)  ,
ADD INDEX `fk_team_member_team1_idx` (`team_id` ASC)  ,
ADD INDEX `fk_team_member_employee1_idx` (`employee_id` ASC)  ,
DROP INDEX `FK9ubp79ei4tv4crd0r9n7u5i6e` ,
DROP INDEX `FKrvt32kcvmn9w2ykhbxfjs7m7` ;
;

ALTER TABLE `heroku_60bbdab0e91f951`.`document` 
CHANGE COLUMN `employee_id` `employee_id` INT(11) NULL DEFAULT NULL AFTER `id`,
CHANGE COLUMN `type` `type` VARCHAR(45) NULL DEFAULT NULL AFTER `document_data`,
CHANGE COLUMN `document_type` `document_type` VARCHAR(45) NULL DEFAULT NULL AFTER `type`,
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `document_data` `document_data` BLOB(209715200) NULL DEFAULT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC)  ,
ADD INDEX `fk_document_employee1_idx` (`employee_id` ASC)  ,
ADD INDEX `fk_document_type1_idx` (`type` ASC)  ,
ADD INDEX `fk_document_document_type1_idx` (`document_type` ASC)  ,
DROP INDEX `FK86159qyw7dp2x87oe58q7eseu` ,
DROP INDEX `FKq13cdsfasmo3k23c32aeq0qnw` ,
DROP INDEX `FK2kokkipw9627qe8qc7i4x33j0` ;
;
ALTER TABLE `heroku_60bbdab0e91f951`.`type` 
CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC)  ;
;

ALTER TABLE `heroku_60bbdab0e91f951`.`document_type` 
CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `insert_time` `insert_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
CHANGE COLUMN `update_time` `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC)  ;
;

DROP TABLE IF EXISTS `heroku_60bbdab0e91f951`.`hibernate_sequence` ;

ALTER TABLE `heroku_60bbdab0e91f951`.`contact` 
ADD CONSTRAINT `fk_contact_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`employee` (`id`),
ADD CONSTRAINT `fk_contact_socialmedia1`
  FOREIGN KEY (`socialmedia_platform`)
  REFERENCES `heroku_60bbdab0e91f951`.`socialmedia` (`platform`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `heroku_60bbdab0e91f951`.`leader` 
ADD CONSTRAINT `fk_leader_employee`
  FOREIGN KEY (`employee_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`employee` (`id`);

ALTER TABLE `heroku_60bbdab0e91f951`.`team` 
ADD CONSTRAINT `fk_team_leader1`
  FOREIGN KEY (`leader_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`leader` (`id`);

ALTER TABLE `heroku_60bbdab0e91f951`.`team_member` 
ADD CONSTRAINT `fk_team_member_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`employee` (`id`),
ADD CONSTRAINT `fk_team_member_team1`
  FOREIGN KEY (`team_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`team` (`id`);

ALTER TABLE `heroku_60bbdab0e91f951`.`document` 
ADD CONSTRAINT `fk_document_employee1`
  FOREIGN KEY (`employee_id`)
  REFERENCES `heroku_60bbdab0e91f951`.`employee` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_document_type1`
  FOREIGN KEY (`type`)
  REFERENCES `heroku_60bbdab0e91f951`.`type` (`name`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_document_document_type1`
  FOREIGN KEY (`document_type`)
  REFERENCES `heroku_60bbdab0e91f951`.`document_type` (`name`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
