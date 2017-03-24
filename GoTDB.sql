-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gotdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gotdb` ;

-- -----------------------------------------------------
-- Schema gotdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gotdb` DEFAULT CHARACTER SET utf8 ;
USE `gotdb` ;

-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player` ;

CREATE TABLE IF NOT EXISTS `player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NULL,
  `nickname2` VARCHAR(45) NULL,
  `status` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `house`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house` ;

CREATE TABLE IF NOT EXISTS `house` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `house_name` VARCHAR(45) NULL,
  `castle_name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `head_of_house` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `house_character`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house_character` ;

CREATE TABLE IF NOT EXISTS `house_character` (
  `character_id` INT NOT NULL,
  `house_id` INT NOT NULL,
  CONSTRAINT `fk_house_character_character1`
    FOREIGN KEY (`character_id`)
    REFERENCES `player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_house_character_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_house_character_character1_idx` ON `house_character` (`character_id` ASC);

CREATE INDEX `fk_house_character_house1_idx` ON `house_character` (`house_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `gotdb`;
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Arya ', 'Stark', NULL, NULL, 'Alive - currently on a warpath to kill those on her list');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Sansa ', 'Stark', NULL, NULL, 'Alive - currently residing in Winterfell with Jon Snow');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Jamie ', 'Lannister', 'King Slayer', NULL, 'Alive - currently returning from taking back Riverrun from the Blackfish');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Cersi ', 'Lannister', NULL, NULL, 'Alive - currently reigning queen of Westeros');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Tyrion ', 'Lannister', 'The Imp', NULL, 'Alive - currently crossing the Narrow sea as Hand of the Queen to Daenerys Targaryen');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Robin', 'Arryn', NULL, NULL, 'Alive - head of House Arryn, probably feebly swinging swords at folks');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Edmure', 'Tully', NULL, NULL, 'Alive - currently captive at the Twins');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Greyjoy', 'Theon', NULL, NULL, 'Alive - currently with Danyers');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Greyjoy', 'Yara', NULL, NULL, 'Alive - currently with Danyers');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Greyjoy', 'Euron', NULL, NULL, 'Alive - currently trying to murder his neice and nephew');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Daenerys', 'Targaryen', NULL, NULL, 'Alive - currently crossing the narrow sea to retake the Iron Throne');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Olena', 'Tyrell', 'The Queen of Thorns', NULL, 'Alive - currently in Dorne making alliances with the Sandsnakes');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Oberyn', 'Martell', 'The Red Viper', NULL, 'Deceased - had his head smashed in by Gregor Clegane ');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Catlin ', 'Tully', NULL, NULL, 'Deceased - murdered by Black Frey at the Red Wedding');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Robert', 'Baratheon', NULL, NULL, 'Deceased - killed by a boar');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Stannis', 'Baratheon', NULL, NULL, 'Deceased - killed by Brianne of Tarth');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Renley', 'Baratheon', NULL, NULL, 'Deceased - murdered by a smoke demon baby');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Sandor', 'Clegane', 'The Hound', NULL, 'Alive - currently with the Brotherhood Without Banners in the Riverlands');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Gregor ', 'Clegane', 'The Mountain', 'Robert Strong', 'Alive - currently a zombie and Cersi\'s personal body guard and hitman');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Petyr', 'Baelish', 'Littlefinger', NULL, 'Alive - currently with Sansa Stark and Jon Snow in Winterfell');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Varys', DEFAULT, 'The Spider', NULL, 'Alive - currently with Daenarys ');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `nickname`, `nickname2`, `status`) VALUES (DEFAULT, 'Jon', 'Snow', 'The White Wolf', NULL, 'Alive - currently in Winterfell with Sansa Stark');

COMMIT;


-- -----------------------------------------------------
-- Data for table `house`
-- -----------------------------------------------------
START TRANSACTION;
USE `gotdb`;
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Stark', 'Winterfell', 'The North', 'Sansa Stark');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Lannister', 'Casterly Rock', 'Casterly Rock', 'Jamie Lannister');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Arryn', 'The Eerie', 'Vale Of Arryn', 'Robin Arryn');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Tully', 'Riverrun', 'River Lands', NULL);
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Greyjoy', 'Pyke', 'The Iron Islands', 'Euron Greyjoy');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Tyrell', 'Highgarden', 'The Reach', 'Olenna Tyrell');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Martell', 'Sunspear', 'The Red Mountains', 'Elaria Sand');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Targaryen', 'Dragonstone', 'Blackwater Bay', 'Dany Targaryen');
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Baratheon ', 'Storm\'s End', 'The Stormlands', NULL);
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Bastards/Unaffiliated', NULL, NULL, NULL);
INSERT INTO `house` (`id`, `house_name`, `castle_name`, `location`, `head_of_house`) VALUES (DEFAULT, 'Clegane', 'Clegane\'s Keep', 'The Westerlands', NULL);

COMMIT;

