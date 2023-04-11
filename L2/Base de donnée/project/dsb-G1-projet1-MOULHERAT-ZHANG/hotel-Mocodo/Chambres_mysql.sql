CREATE DATABASE IF NOT EXISTS `SANS_TITRE` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `SANS_TITRE`;

CREATE TABLE `CLIENT` (
  `idpasseport` VARCHAR(42),
  `nom` VARCHAR(42),
  `tel` VARCHAR(42),
  PRIMARY KEY (`idpasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `SERVIR` (
  `idpasseport` VARCHAR(42),
  `noemploye` VARCHAR(42),
  PRIMARY KEY (`idpasseport`, `noemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RESERVE` (
  `nochambre` VARCHAR(42),
  `idpasseport` VARCHAR(42),
  `check-in_date` VARCHAR(42),
  `check-out_date` VARCHAR(42),
  PRIMARY KEY (`nochambre`, `idpasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `EMPLOYE` (
  `noemploye` VARCHAR(42),
  `nom` VARCHAR(42),
  `poste` VARCHAR(42),
  PRIMARY KEY (`noemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `GERE` (
  `nochambre` VARCHAR(42),
  `noemploye` VARCHAR(42),
  PRIMARY KEY (`nochambre`, `noemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CHAMBRE` (
  `nochambre` VARCHAR(42),
  `type` VARCHAR(42),
  `prix` VARCHAR(42),
  PRIMARY KEY (`nochambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `NOTE` (
  `nonote` VARCHAR(42),
  `montantdesfrais` VARCHAR(42),
  `nochambre` VARCHAR(42),
  PRIMARY KEY (`nonote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `SERVIR` ADD FOREIGN KEY (`noemploye`) REFERENCES `EMPLOYE` (`noemploye`);
ALTER TABLE `SERVIR` ADD FOREIGN KEY (`idpasseport`) REFERENCES `CLIENT` (`idpasseport`);
ALTER TABLE `RESERVE` ADD FOREIGN KEY (`idpasseport`) REFERENCES `CLIENT` (`idpasseport`);
ALTER TABLE `RESERVE` ADD FOREIGN KEY (`nochambre`) REFERENCES `CHAMBRE` (`nochambre`);
ALTER TABLE `GERE` ADD FOREIGN KEY (`noemploye`) REFERENCES `EMPLOYE` (`noemploye`);
ALTER TABLE `GERE` ADD FOREIGN KEY (`nochambre`) REFERENCES `CHAMBRE` (`nochambre`);
ALTER TABLE `NOTE` ADD FOREIGN KEY (`nochambre`) REFERENCES `CHAMBRE` (`nochambre`);