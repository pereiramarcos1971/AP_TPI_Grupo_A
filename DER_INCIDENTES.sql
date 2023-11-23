-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema INCIDENTES
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema INCIDENTES
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `INCIDENTES` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `INCIDENTES` ;

-- -----------------------------------------------------
-- Table `INCIDENTES`.`tecnicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`tecnicos` (
  `id_tecnico` INT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NULL,
  `telefono` VARCHAR(50) NULL,
  PRIMARY KEY (`id_tecnico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(50) NOT NULL,
  `cuit` BIGINT NOT NULL,
  `email` VARCHAR(50) NULL,
  `telefono` VARCHAR(50) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `INCIDENTES`.`tipos_servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`tipos_servicios` (
  `id_tipo_servicio` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_tipo_servicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`servicios` (
  `id_servicio` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  `tipo_servicio` INT NOT NULL,
  PRIMARY KEY (`id_servicio`),
  INDEX `fk_servicio_tipo_servicio_idx` (`tipo_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_servicios_tipos_servicios`
    FOREIGN KEY (`tipo_servicio`)
    REFERENCES `INCIDENTES`.`tipos_servicios` (`id_tipo_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`servicios_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`servicios_clientes` (
  `id_servicio_ciliente` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `id_servicio` INT NOT NULL,
  PRIMARY KEY (`id_servicio_ciliente`),
  INDEX `fk_servicio_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_servicio_cliente_servicio_idx` (`id_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_servicio_cliente_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `INCIDENTES`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_cliente_servicio`
    FOREIGN KEY (`id_servicio`)
    REFERENCES `INCIDENTES`.`servicios` (`id_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`tipo_problema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`tipo_problema` (
  `id_tipo_problema` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_tipo_problema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`problemas_servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`problemas_servicios` (
  `id_problema_servicio` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_problema` INT NOT NULL,
  `id_servicio` INT NOT NULL,
  `tiempo_maximo_resolucion` FLOAT NULL,
  PRIMARY KEY (`id_problema_servicio`),
  INDEX `fk_tipo_problema_idx` (`id_tipo_problema` ASC) VISIBLE,
  INDEX `fk_problemas_servicios_idx` (`id_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_tipo_problema`
    FOREIGN KEY (`id_tipo_problema`)
    REFERENCES `INCIDENTES`.`tipo_problema` (`id_tipo_problema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_problemas_servicios`
    FOREIGN KEY (`id_servicio`)
    REFERENCES `INCIDENTES`.`servicios` (`id_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`incidentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`incidentes` (
  `id_incidente` INT NOT NULL AUTO_INCREMENT,
  `id_servicio_cliente` INT NOT NULL,
  `id_problema_servicio` INT NOT NULL,
  `descripcion` TEXT NULL,
  `fecha_alta` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_incidente`),
  INDEX `fk_incidentes_servicios_cliente_idx` (`id_servicio_cliente` ASC) VISIBLE,
  INDEX `fk_incidentes_problemas_servicios_idx` (`id_problema_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_incidentes_servicios_cliente`
    FOREIGN KEY (`id_servicio_cliente`)
    REFERENCES `INCIDENTES`.`servicios_clientes` (`id_servicio_ciliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incidentes_problemas_servicios`
    FOREIGN KEY (`id_problema_servicio`)
    REFERENCES `INCIDENTES`.`problemas_servicios` (`id_problema_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`tecnicos_especialidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`tecnicos_especialidades` (
  `id_tecnico_especialidad` INT NOT NULL AUTO_INCREMENT,
  `id_tecnico` INT NOT NULL,
  `id_servicio` INT NOT NULL,
  PRIMARY KEY (`id_tecnico_especialidad`),
  INDEX `fk_tecnicos_especialidades_idx` (`id_tecnico` ASC) VISIBLE,
  INDEX `fk_servicios_idx` (`id_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_tecnicos_especialidades_tecnicos`
    FOREIGN KEY (`id_tecnico`)
    REFERENCES `INCIDENTES`.`tecnicos` (`id_tecnico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicios`
    FOREIGN KEY (`id_servicio`)
    REFERENCES `INCIDENTES`.`servicios` (`id_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`incidentes_relacionados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`incidentes_relacionados` (
  `id_incidentes_relacionados` INT NOT NULL AUTO_INCREMENT,
  `id_incidente` INT NOT NULL,
  `id_incidente_relacionado` INT NOT NULL,
  PRIMARY KEY (`id_incidentes_relacionados`),
  INDEX `fk_incidente_idx` (`id_incidente` ASC) VISIBLE,
  INDEX `fk_incidente_relacionado_idx` (`id_incidente_relacionado` ASC) VISIBLE,
  CONSTRAINT `fk_incidente`
    FOREIGN KEY (`id_incidente`)
    REFERENCES `INCIDENTES`.`incidentes` (`id_incidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_incidente_relacionado`
    FOREIGN KEY (`id_incidente_relacionado`)
    REFERENCES `INCIDENTES`.`incidentes` (`id_incidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `INCIDENTES`.`incidentes_asignados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `INCIDENTES`.`incidentes_asignados` (
  `id_incidente_asignado` INT NOT NULL AUTO_INCREMENT,
  `id_incidente` INT NOT NULL,
  `id_tecnico` INT NOT NULL,
  `tiempo_resolucion_default` FLOAT NULL,
  `complejo` TINYINT NOT NULL DEFAULT 0,
  `tiempo_resolucion_adicional` FLOAT NULL,
  `marca_resolucion` TINYINT NOT NULL DEFAULT 0,
  `observaciones_resolucion` TEXT NULL,
  `fecha_resolucion` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_incidente_asignado`),
  INDEX `fk_resoluciones_incidentes_idx` (`id_incidente` ASC) VISIBLE,
  INDEX `fk_resoluciones_tecnicos_idx` (`id_tecnico` ASC) VISIBLE,
  CONSTRAINT `fk_resoluciones_incidentes`
    FOREIGN KEY (`id_incidente`)
    REFERENCES `INCIDENTES`.`incidentes` (`id_incidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resoluciones_tecnicos`
    FOREIGN KEY (`id_tecnico`)
    REFERENCES `INCIDENTES`.`tecnicos` (`id_tecnico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
