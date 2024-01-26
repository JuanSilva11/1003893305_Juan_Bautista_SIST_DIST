-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema u342060465_sisdis_parcial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema u342060465_sisdis_parcial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `u342060465_sisdis_parcial` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `u342060465_sisdis_parcial` ;

-- -----------------------------------------------------
-- Table `u342060465_sisdis_parcial`.`customer_1003893305`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u342060465_sisdis_parcial`.`customer_1003893305` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(50) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `delete_at` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `phone` VARCHAR(50) NULL DEFAULT NULL,
  `state` BIT(1) NULL DEFAULT NULL,
  `update_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `u342060465_sisdis_parcial`.`product_1003893305`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u342060465_sisdis_parcial`.`product_1003893305` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `delete_at` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `state` BIT(1) NULL DEFAULT NULL,
  `update_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `u342060465_sisdis_parcial`.`customer_product_1003893305`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `u342060465_sisdis_parcial`.`customer_product_1003893305` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `balance` DOUBLE NOT NULL,
  `customer_id` BIGINT(20) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `delete_at` DATETIME(6) NULL DEFAULT NULL,
  `state` BIT(1) NULL DEFAULT NULL,
  `update_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_l19brt6m0pwy0rn0kf1dgchdo` (`product_id` ASC) VISIBLE,
  INDEX `FK46vm8odlkaarpmu5wpb15u4a7` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `FK46vm8odlkaarpmu5wpb15u4a7`
    FOREIGN KEY (`customer_id`)
    REFERENCES `u342060465_sisdis_parcial`.`customer_1003893305` (`id`),
  CONSTRAINT `FKi68ob2udewvfur243fg7c499u`
    FOREIGN KEY (`product_id`)
    REFERENCES `u342060465_sisdis_parcial`.`product_1003893305` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
