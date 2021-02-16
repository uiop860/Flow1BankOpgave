-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bank` ;

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Customer` ;

CREATE TABLE IF NOT EXISTS `bank`.`Customer` (
  `Customer id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Age` INT NULL,
  `Address` VARCHAR(45) NULL,
  PRIMARY KEY (`Customer id`),
  UNIQUE INDEX `Customer id_UNIQUE` (`Customer id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Accounts` ;

CREATE TABLE IF NOT EXISTS `bank`.`Accounts` (
  `Account id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Balance` INT NULL,
  `Customer_Customer id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Account id`, `Customer_Customer id`),
  INDEX `fk_Accounts_Customer_idx` (`Customer_Customer id` ASC) VISIBLE,
  CONSTRAINT `fk_Accounts_Customer`
    FOREIGN KEY (`Customer_Customer id`)
    REFERENCES `bank`.`Customer` (`Customer id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Transactions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Transactions` ;

CREATE TABLE IF NOT EXISTS `bank`.`Transactions` (
  `Transactions id` INT NOT NULL AUTO_INCREMENT,
  `MoneyChange` INT NULL,
  `Date` DATETIME NULL DEFAULT now(),
  `Accounts_Account id` INT UNSIGNED NOT NULL,
  `Accounts_Customer_Customer id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Transactions id`, `Accounts_Account id`, `Accounts_Customer_Customer id`),
  INDEX `fk_Transactions_Accounts1_idx` (`Accounts_Account id` ASC, `Accounts_Customer_Customer id` ASC) VISIBLE,
  CONSTRAINT `fk_Transactions_Accounts1`
    FOREIGN KEY (`Accounts_Account id` , `Accounts_Customer_Customer id`)
    REFERENCES `bank`.`Accounts` (`Account id` , `Customer_Customer id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
