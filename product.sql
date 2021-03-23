-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema drugs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema drugs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `drugs` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventory` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema products
-- -----------------------------------------------------
USE `drugs` ;

-- -----------------------------------------------------
-- Table `drugs`.`drug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drugs`.`drug` (
  `drug_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NULL DEFAULT NULL,
  `lab` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `constituent` VARCHAR(45) NOT NULL,
  `buy_individual_price` DECIMAL(10,0) NOT NULL,
  `sell_individual_price` DECIMAL(10,0) NULL DEFAULT NULL,
  `patent` TINYINT NOT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  `expire_date` DATE NOT NULL,
  `buy_date` DATE NOT NULL,
  `pharmaceutical_form` VARCHAR(45) NOT NULL,
  `dosis` VARCHAR(45) NULL DEFAULT NULL,
  `content` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`drug_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

USE `inventory` ;

-- -----------------------------------------------------
-- Table `inventory`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventory`.`inventory` (
  `package_id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`package_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
