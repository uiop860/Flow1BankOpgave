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
-- Table `bank`.`bank.main.Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Customer` ;

CREATE TABLE IF NOT EXISTS `bank`.`Customer` (
    `customerid` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `age` INT NULL,
    `address` VARCHAR(45) NULL,
    `Login_username` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`customerid`, `Login_username`),
    UNIQUE INDEX `Customer id_UNIQUE` (`customerid` ASC),
    INDEX `fk_Customer_Login1_idx` (`Login_username` ASC),
    CONSTRAINT `fk_Customer_Login1`
    FOREIGN KEY (`Login_username`)
    REFERENCES `bank`.`Login` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Accounts` ;

CREATE TABLE IF NOT EXISTS `bank`.`Accounts` (
  `accountid` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `balance` INT NULL,
  `customer_customerid` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`accountid`, `customer_customerid`),
  INDEX `fk_Accounts_Customer_idx` (`customer_customerid` ASC) VISIBLE,
  CONSTRAINT `fk_Accounts_Customer`
    FOREIGN KEY (`customer_customerid`)
    REFERENCES `bank`.`bank.main.Customer` (`customerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Transactions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`Transactions` ;

CREATE TABLE IF NOT EXISTS `bank`.`Transactions` (
  `transactionid` INT NOT NULL AUTO_INCREMENT,
  `moneychange` INT NULL,
  `date` DATETIME NULL DEFAULT now(),
  `accounts_accountid` INT UNSIGNED NOT NULL,
  `accounts_customer_customerid` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`transactionid`, `accounts_accountid`, `accounts_customer_customerid`),
  INDEX `fk_Transactions_Accounts1_idx` (`accounts_accountid` ASC, `accounts_customer_customerid` ASC) VISIBLE,
  CONSTRAINT `fk_Transactions_Accounts1`
    FOREIGN KEY (`accounts_accountid` , `accounts_customer_customerid`)
    REFERENCES `bank`.`Accounts` (`accountid` , `customer_customerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
