-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema editora-db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema editora-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `editora-db` DEFAULT CHARACTER SET latin1 ;
USE `editora-db` ;

-- -----------------------------------------------------
-- Table `editora-db`.`editoras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `editora-db`.`editoras` (
  `ID_EDITORA` INT(11) NOT NULL AUTO_INCREMENT,
  `RAZAO_SOCIAL` VARCHAR(60) NOT NULL,
  `CIDADE` VARCHAR(60) NOT NULL,
  `EMAIL` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`ID_EDITORA`),
  UNIQUE INDEX `RAZAO_SOCIAL_UNIQUE` (`RAZAO_SOCIAL` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `editora-db`.`AUTORES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `editora-db`.`AUTORES` (
  `ID_AUTOR` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `ID_EDITORA` INT(11) NOT NULL,
  PRIMARY KEY (`ID_AUTOR`),
  UNIQUE INDEX `NOME_UNIQUE` (`NOME` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC),
  INDEX `fk_AUTORES_editoras_idx` (`ID_EDITORA` ASC),
  CONSTRAINT `fk_AUTORES_editoras`
    FOREIGN KEY (`ID_EDITORA`)
    REFERENCES `editora-db`.`editoras` (`ID_EDITORA`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
