-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dietdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dietdb` ;

-- -----------------------------------------------------
-- Schema dietdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dietdb` DEFAULT CHARACTER SET utf8 ;
USE `dietdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NULL,
  `address2` VARCHAR(100) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `diet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diet` ;

CREATE TABLE IF NOT EXISTS `diet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `purpose` TEXT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  `role` VARCHAR(45) NULL DEFAULT 'standard',
  `image_url` TEXT NULL,
  `address_id` INT NOT NULL,
  `height` INT NULL,
  `weight` INT NULL,
  `description` TEXT NULL,
  `diet_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address_idx` (`address_id` ASC),
  INDEX `fk_user_diet1_idx` (`diet_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_diet1`
    FOREIGN KEY (`diet_id`)
    REFERENCES `diet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `food` ;

CREATE TABLE IF NOT EXISTS `food` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `portion_size` DOUBLE NULL DEFAULT 0,
  `portion_type` VARCHAR(45) NULL,
  `calorie` DOUBLE NULL DEFAULT 0,
  `fat` DOUBLE NULL DEFAULT 0,
  `cholesterol` DOUBLE NULL DEFAULT 0,
  `sodium` DOUBLE NULL DEFAULT 0,
  `carbohydrate` DOUBLE NULL DEFAULT 0,
  `fiber` DOUBLE NULL DEFAULT 0,
  `sugar` DOUBLE NULL DEFAULT 0,
  `protein` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `cook_time` INT NULL DEFAULT 0,
  `prep_time` INT NULL DEFAULT 0,
  `image_url` TEXT NULL,
  `image_url2` TEXT NULL,
  `image_url3` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment` ;

CREATE TABLE IF NOT EXISTS `equipment` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_equipment` ;

CREATE TABLE IF NOT EXISTS `user_equipment` (
  `user_id` INT NOT NULL,
  `equipment_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `equipment_id`),
  INDEX `fk_user_equipment_user1_idx` (`user_id` ASC),
  INDEX `fk_user_equipment_equipment_type1_idx` (`equipment_id` ASC),
  CONSTRAINT `fk_user_equipment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_equipment_equipment_type1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `service` ;

CREATE TABLE IF NOT EXISTS `service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `price` DOUBLE NULL,
  `available` TINYINT NOT NULL DEFAULT 1,
  `image_url` TEXT NULL,
  `image_url2` TEXT NULL,
  `image_url3` TEXT NULL,
  `user_id` INT NOT NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_service_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reservation` ;

CREATE TABLE IF NOT EXISTS `reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `open_date` DATETIME NOT NULL,
  `close_date` DATETIME NOT NULL,
  `completed` TINYINT NULL DEFAULT 0,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `approved` TINYINT NULL DEFAULT 0,
  `user_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservation_user1_idx` (`user_id` ASC),
  INDEX `fk_reservation_service1_idx` (`service_id` ASC),
  CONSTRAINT `fk_reservation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_service1`
    FOREIGN KEY (`service_id`)
    REFERENCES `service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review_of_service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review_of_service` ;

CREATE TABLE IF NOT EXISTS `review_of_service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` DOUBLE NOT NULL DEFAULT 5,
  `review` TEXT NULL,
  `review_date` DATE NULL,
  `reservation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_of_service_reservation1_idx` (`reservation_id` ASC),
  CONSTRAINT `fk_review_of_service_reservation1`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `reservation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chat` ;

CREATE TABLE IF NOT EXISTS `chat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` TEXT NULL,
  `message_date` DATETIME NULL,
  `reservation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_chat_reservation1_idx` (`reservation_id` ASC),
  CONSTRAINT `fk_chat_reservation1`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `reservation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `allergy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `allergy` ;

CREATE TABLE IF NOT EXISTS `allergy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food_recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `food_recipe` ;

CREATE TABLE IF NOT EXISTS `food_recipe` (
  `food_id` INT NOT NULL,
  `recipe_id` INT NOT NULL,
  PRIMARY KEY (`food_id`, `recipe_id`),
  INDEX `fk_food_recipe_recipe1_idx` (`recipe_id` ASC),
  CONSTRAINT `fk_food_recipe_food1`
    FOREIGN KEY (`food_id`)
    REFERENCES `food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_recipe_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_allergy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_allergy` ;

CREATE TABLE IF NOT EXISTS `user_allergy` (
  `user_id` INT NOT NULL,
  `allergy_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `allergy_id`),
  INDEX `fk_user_allergy_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_allergy_allergy1`
    FOREIGN KEY (`allergy_id`)
    REFERENCES `allergy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_allergy_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_food`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_food` ;

CREATE TABLE IF NOT EXISTS `user_food` (
  `user_id` INT NOT NULL,
  `food_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `food_id`),
  INDEX `fk_user_food_food1_idx` (`food_id` ASC),
  CONSTRAINT `fk_user_food_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_food_food1`
    FOREIGN KEY (`food_id`)
    REFERENCES `food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS diet@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'diet'@'localhost' IDENTIFIED BY 'diet';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'diet'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (2, 'Fargodome', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (3, 'Great Smoky Mountains', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (4, 'Indiana Dunes National Park', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (5, 'Kings Canyon National Park', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (6, 'Yosemite National Park', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (7, 'Crater Lake', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (8, 'Everglades National Park', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `address` (`id`, `address`, `address2`, `city`, `state`, `postal_code`, `country`) VALUES (9, 'Acadia National Park', NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `diet`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `diet` (`id`, `name`, `purpose`, `description`) VALUES (1, 'No Diet', NULL, NULL);
INSERT INTO `diet` (`id`, `name`, `purpose`, `description`) VALUES (2, 'Keto', 'lose weight', 'low carb high fat diet');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (1, 'Adam', 'Adam', 'adam@adam.com', '$2y$12$cM2dr3TV.nxMhj6wwlqZu.9TnbRMv4f7Hdl7.9vJmDoqqI9ALPthC', '111-111-1111', 1, 'admin', NULL, 2, 64, 140, 'adam is adam', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (2, 'Amanda', 'Amanda', 'amanda@amanda.com', '$2y$12$Xkxu2H2hxngIL9WTwyf4/eDz/RHhJCZALyKj53geQnl787jvcAs7C', '222-222-2222', 1, 'admin', NULL, 3, NULL, NULL, 'amanda is amanda', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (3, 'Kyle', 'Kyle', 'kyle@kyle.com', '$2y$12$RuLgtX9dtQwVF6lZKG5C8O.4t1RMdkNZ6D8tOsYPBn/KEmqAQ6.1i', '111-222-1111', 1, 'standard', NULL, 4, 72, 150, 'kyle is kyle', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (4, 'Jeramie', 'Jeramie', 'jeramie@jeramie.com', '$2y$12$79qZ4.WELEOpef4W9nDp7OytbG1HM2B7X8VcZ4Wr3QJfjjfEnm2kS', '112-111-1111', 1, 'standard', NULL, 5, 73, 155, 'jeramie is jeramie', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (5, 'Noel', 'Noel', 'noel@noel.com', '$2y$12$orowyALdyiONNGamOZiyIeOe7PksdMtv9DpAueH3cb7cvLC6Z8dOi', '113-111-1111', 1, 'standard', NULL, 6, 70, 160, 'noel is noel', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (6, 'Sajana', 'Sajana', 'sajana@sajana.com', '$2y$12$nbo/n8SOMj8/BD9z1HA/KelBXByk4e0gTo79tV8p0pA0mOim5giSS', '111-111-2222', 1, 'standard', NULL, 7, NULL, NULL, 'sajana is sajana', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (7, 'Erycka', 'Erycka', 'erycka@erycka.com', '$2y$12$IOkCk1oVZ3NhPeoTIbIxheI/9NM5.hL.2T5C7uCqIj4zrhkyMZtEG', '111-121-1211', 1, 'standard', NULL, 8, NULL, NULL, 'erycka is erycka', 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `phone`, `enabled`, `role`, `image_url`, `address_id`, `height`, `weight`, `description`, `diet_id`) VALUES (8, 'Monika', 'Monika', 'monika@monika.com', '$2y$12$fd3FmUyDdr0fbNP1XRZRSO3NsnNAyTCSpt5bysNO4YeV/b5fvh7Oe', '222-111-2222', 1, 'standard', NULL, 9, NULL, NULL, 'monika is monika', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `food`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `food` (`id`, `name`, `description`, `portion_size`, `portion_type`, `calorie`, `fat`, `cholesterol`, `sodium`, `carbohydrate`, `fiber`, `sugar`, `protein`) VALUES (1, 'bread', 'made from dough and flour', 51, 'gram', 54, 0.5, 0, 97, 11.2, 2.4, 1.0, 2.0);
INSERT INTO `food` (`id`, `name`, `description`, `portion_size`, `portion_type`, `calorie`, `fat`, `cholesterol`, `sodium`, `carbohydrate`, `fiber`, `sugar`, `protein`) VALUES (2, 'lettuce', 'grown in garden', 47, 'gram', 8, 0, 0, 4, 2, 1, 1, 1);
INSERT INTO `food` (`id`, `name`, `description`, `portion_size`, `portion_type`, `calorie`, `fat`, `cholesterol`, `sodium`, `carbohydrate`, `fiber`, `sugar`, `protein`) VALUES (3, 'tomato', 'grown in garden', 123, 'gram', 22, 0, 0, 6, 5, 1, 3, 1);
INSERT INTO `food` (`id`, `name`, `description`, `portion_size`, `portion_type`, `calorie`, `fat`, `cholesterol`, `sodium`, `carbohydrate`, `fiber`, `sugar`, `protein`) VALUES (4, 'bacon', 'baked', 18, 'gram', 90, 7, 20, 400, 0, 0, 0, 6);
INSERT INTO `food` (`id`, `name`, `description`, `portion_size`, `portion_type`, `calorie`, `fat`, `cholesterol`, `sodium`, `carbohydrate`, `fiber`, `sugar`, `protein`) VALUES (5, 'butter', 'cant believe its not butter', 14, 'gram', 60, 6, 15, 90, 0, 0, 0, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `recipe` (`id`, `name`, `description`, `cook_time`, `prep_time`, `image_url`, `image_url2`, `image_url3`) VALUES (1, 'Salad', 'vegetarian meal', 0, 10, NULL, NULL, NULL);
INSERT INTO `recipe` (`id`, `name`, `description`, `cook_time`, `prep_time`, `image_url`, `image_url2`, `image_url3`) VALUES (2, 'BLT', 'quick sandwich', 10, 5, NULL, NULL, NULL);
INSERT INTO `recipe` (`id`, `name`, `description`, `cook_time`, `prep_time`, `image_url`, `image_url2`, `image_url3`) VALUES (3, 'Bacon', 'oven cooked', 10, 0, NULL, NULL, NULL);
INSERT INTO `recipe` (`id`, `name`, `description`, `cook_time`, `prep_time`, `image_url`, `image_url2`, `image_url3`) VALUES (4, 'Bruchetta', 'italian', 1, 1, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `equipment` (`id`, `name`, `description`) VALUES (1, 'frying pan', 'pan used for frying');
INSERT INTO `equipment` (`id`, `name`, `description`) VALUES (2, 'pot', NULL);
INSERT INTO `equipment` (`id`, `name`, `description`) VALUES (3, 'oven', NULL);
INSERT INTO `equipment` (`id`, `name`, `description`) VALUES (4, 'stove', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (1, 1);
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (1, 2);
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (1, 3);
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (1, 4);
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (2, 2);
INSERT INTO `user_equipment` (`user_id`, `equipment_id`) VALUES (2, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `service`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `service` (`id`, `name`, `description`, `price`, `available`, `image_url`, `image_url2`, `image_url3`, `user_id`, `category`) VALUES (1, 'diet advice', 'great diet advice for you', 14.99, 1, NULL, NULL, NULL, 2, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `reservation`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `reservation` (`id`, `open_date`, `close_date`, `completed`, `created_at`, `updated_at`, `approved`, `user_id`, `service_id`) VALUES (1, '2020-01-10 22:00:00', '2020-01-20 23:00:00', 1, '2020-01-08 10:00:00', '2020-01-08 10:00:00', 1, 1, 1);
INSERT INTO `reservation` (`id`, `open_date`, `close_date`, `completed`, `created_at`, `updated_at`, `approved`, `user_id`, `service_id`) VALUES (2, '2020-01-21 16:00:00', '2020-01-24 17:00:00', 1, '2020-01-09 12:00:00', '2020-01-09 12:00:00', 1, 3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `review_of_service`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `review_of_service` (`id`, `rating`, `review`, `review_date`, `reservation_id`) VALUES (1, 5, 'amanda gives great advice', '2020-01-31 10:30:37', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `chat`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `chat` (`id`, `message`, `message_date`, `reservation_id`) VALUES (1, 'hello cant wait for advice', '2020-01-16 14:27:33', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `allergy`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `allergy` (`id`, `name`, `description`) VALUES (1, 'None', NULL);
INSERT INTO `allergy` (`id`, `name`, `description`) VALUES (2, 'Celiac disease', 'gluten intolerance');

COMMIT;


-- -----------------------------------------------------
-- Data for table `food_recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (2, 1);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (3, 1);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (1, 2);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (2, 2);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (3, 2);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (4, 2);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (5, 2);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (4, 3);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (1, 4);
INSERT INTO `food_recipe` (`food_id`, `recipe_id`) VALUES (3, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_allergy`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `user_allergy` (`user_id`, `allergy_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_food`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (1, 1);
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (1, 2);
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (1, 3);
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (1, 4);
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (2, 2);
INSERT INTO `user_food` (`user_id`, `food_id`) VALUES (2, 3);

COMMIT;

