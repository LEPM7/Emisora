-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema emisora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema emisora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emisora` DEFAULT CHARACTER SET utf8 ;
USE `emisora` ;

-- -----------------------------------------------------
-- Table `emisora`.`CLIENTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emisora`.`CLIENTES` (
  `id_cliente` INT NOT NULL,
  `nombre_cliente` VARCHAR(45) NULL,
  `apellido_cliente` VARCHAR(45) NULL,
  `telefono_cliente` VARCHAR(15) NULL,
  `documento_identificacion_cliente` VARCHAR(20) NULL,
  `direccion_cliente` VARCHAR(45) NULL,
  `email_cliente` VARCHAR(30) NULL,
  `nombre_usuario` VARCHAR(10) NULL,
  `contraseña` VARCHAR(10) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emisora`.`CUENTAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emisora`.`CUENTAS` (
  `id_cuenta` INT NOT NULL,
  `numero_cuenta` VARCHAR(15) NULL,
  `tipo_cuenta` VARCHAR(10) NULL,
  `CLIENTES_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  INDEX `fk_CUENTAS_CLIENTES_idx` (`CLIENTES_id_cliente` ASC),
  CONSTRAINT `fk_CUENTAS_CLIENTES`
    FOREIGN KEY (`CLIENTES_id_cliente`)
    REFERENCES `emisora`.`CLIENTES` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emisora`.`BANCOS_RECEPTORES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emisora`.`BANCOS_RECEPTORES` (
  `id_banco_receptor` INT NOT NULL,
  `nombre_banco_receptor` VARCHAR(45) NULL,
  `telefono` VARCHAR(8) NULL,
  `direccion` VARCHAR(45) NULL,
  `correo_contacto` VARCHAR(20) NULL,
  PRIMARY KEY (`id_banco_receptor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emisora`.`REMESAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emisora`.`REMESAS` (
  `id_remesa` INT NOT NULL,
  `contraseña` VARCHAR(8) NULL,
  `id_usuario` VARCHAR(20) NULL,
  `nombre_receptor` VARCHAR(45) NULL,
  `correo_receptor` VARCHAR(30) NULL,
  `dpi_receptor` VARCHAR(13) NULL,
  `monto` FLOAT NULL,
  `estado` VARCHAR(10) NULL,
  `fecha_enviado` DATE NULL,
  `fecha_recibido` DATE NULL,
  `CLIENTES_id_cliente` INT NOT NULL,
  `BANCOS_RECEPTORES_id_banco_receptor` INT NOT NULL,
  `CODIGO_SEGURIDAD` VARCHAR(7) NULL,
  PRIMARY KEY (`id_remesa`),
  INDEX `fk_REMESAS_CLIENTES1_idx` (`CLIENTES_id_cliente` ASC),
  INDEX `fk_REMESAS_BANCOS_RECEPTORES1_idx` (`BANCOS_RECEPTORES_id_banco_receptor` ASC),
  CONSTRAINT `fk_REMESAS_CLIENTES1`
    FOREIGN KEY (`CLIENTES_id_cliente`)
    REFERENCES `emisora`.`CLIENTES` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REMESAS_BANCOS_RECEPTORES1`
    FOREIGN KEY (`BANCOS_RECEPTORES_id_banco_receptor`)
    REFERENCES `emisora`.`BANCOS_RECEPTORES` (`id_banco_receptor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
