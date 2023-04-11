-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 04 Mars 2022 à 22:52
-- Version du serveur :  5.5.31
-- Version de PHP :  5.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `base_zhilzhang`
--

-- --------------------------------------------------------

--
-- Structure de la table `CHAMBRE`
--

CREATE TABLE IF NOT EXISTS `CHAMBRE` (
  `NOchambre` varchar(42) NOT NULL,
  `type` varchar(42) NOT NULL,
  `prix` varchar(42) NOT NULL,
  PRIMARY KEY (`NOchambre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `CHAMBRE`
--

INSERT INTO `CHAMBRE` (`NOchambre`, `type`, `prix`) VALUES
('8020', 'Suite', '200');

-- --------------------------------------------------------

--
-- Structure de la table `CLIENT`
--

CREATE TABLE IF NOT EXISTS `CLIENT` (
  `IDpasseport` varchar(42) NOT NULL,
  `Cnom` varchar(42) NOT NULL,
  `tel` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`IDpasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `CLIENT`
--

INSERT INTO `CLIENT` (`IDpasseport`, `Cnom`, `tel`) VALUES
('12546A54X', 'Brad Douri', '02 99 59 37 74');

-- --------------------------------------------------------

--
-- Structure de la table `EMPLOYE`
--

CREATE TABLE IF NOT EXISTS `EMPLOYE` (
  `NOemploye` varchar(42) NOT NULL,
  `Enom` varchar(42) NOT NULL,
  `poste` varchar(42) NOT NULL,
  PRIMARY KEY (`NOemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `EMPLOYE`
--

INSERT INTO `EMPLOYE` (`NOemploye`, `Enom`, `poste`) VALUES
('27S', 'Hadrien Lopes', 'Directeur générale');

-- --------------------------------------------------------

--
-- Structure de la table `GERE`
--

CREATE TABLE IF NOT EXISTS `GERE` (
  `NOchambre` varchar(42) NOT NULL,
  `NOemploye` varchar(42) NOT NULL,
  PRIMARY KEY (`NOchambre`,`NOemploye`),
  KEY `NOemploye` (`NOemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `GERE`
--

INSERT INTO `GERE` (`NOchambre`, `NOemploye`) VALUES
('8020', '27S');

-- --------------------------------------------------------

--
-- Structure de la table `NOTE`
--

CREATE TABLE IF NOT EXISTS `NOTE` (
  `NOnote` varchar(42) NOT NULL,
  `montantDesFrais` varchar(42) NOT NULL,
  `NOchambre` varchar(42) NOT NULL,
  PRIMARY KEY (`NOnote`),
  KEY `NOchambre` (`NOchambre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `NOTE`
--

INSERT INTO `NOTE` (`NOnote`, `montantDesFrais`, `NOchambre`) VALUES
('1337', '600', '8020');

-- --------------------------------------------------------

--
-- Structure de la table `RESERVE`
--

CREATE TABLE IF NOT EXISTS `RESERVE` (
  `NOchambre` varchar(42) NOT NULL,
  `IDpasseport` varchar(42) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  PRIMARY KEY (`NOchambre`,`IDpasseport`),
  KEY `IDpasseport` (`IDpasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `RESERVE`
--

INSERT INTO `RESERVE` (`NOchambre`, `IDpasseport`, `check_in_date`, `check_out_date`) VALUES
('8020', '12546A54X', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `RF`
--
CREATE TABLE IF NOT EXISTS `RF` (
`NOemploye` varchar(42)
,`NBchambre` bigint(21)
);
-- --------------------------------------------------------

--
-- Structure de la table `SERVIR`
--

CREATE TABLE IF NOT EXISTS `SERVIR` (
  `IDpasseport` varchar(42) NOT NULL,
  `NOemploye` varchar(42) NOT NULL,
  PRIMARY KEY (`IDpasseport`),
  KEY `NOemploye` (`NOemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `SERVIR`
--

INSERT INTO `SERVIR` (`IDpasseport`, `NOemploye`) VALUES
('12546A54X', '27S');

-- --------------------------------------------------------

--
-- Structure de la vue `RF`
--
DROP TABLE IF EXISTS `RF`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user_zhilzhang`@`%` SQL SECURITY DEFINER VIEW `RF` AS (select `GERE`.`NOemploye` AS `NOemploye`,count(`GERE`.`NOchambre`) AS `NBchambre` from `GERE` group by `GERE`.`NOemploye` having (`NBchambre` = (select count(0) from `CHAMBRE`)));

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `GERE`
--
ALTER TABLE `GERE`
  ADD CONSTRAINT `GERE_ibfk_1` FOREIGN KEY (`NOchambre`) REFERENCES `CHAMBRE` (`NOchambre`),
  ADD CONSTRAINT `GERE_ibfk_2` FOREIGN KEY (`NOemploye`) REFERENCES `EMPLOYE` (`NOemploye`);

--
-- Contraintes pour la table `NOTE`
--
ALTER TABLE `NOTE`
  ADD CONSTRAINT `NOTE_ibfk_1` FOREIGN KEY (`NOchambre`) REFERENCES `CHAMBRE` (`NOchambre`);

--
-- Contraintes pour la table `RESERVE`
--
ALTER TABLE `RESERVE`
  ADD CONSTRAINT `RESERVE_ibfk_1` FOREIGN KEY (`NOchambre`) REFERENCES `CHAMBRE` (`NOchambre`),
  ADD CONSTRAINT `RESERVE_ibfk_2` FOREIGN KEY (`IDpasseport`) REFERENCES `CLIENT` (`IDpasseport`);

--
-- Contraintes pour la table `SERVIR`
--
ALTER TABLE `SERVIR`
  ADD CONSTRAINT `SERVIR_ibfk_1` FOREIGN KEY (`IDpasseport`) REFERENCES `CLIENT` (`IDpasseport`),
  ADD CONSTRAINT `SERVIR_ibfk_2` FOREIGN KEY (`NOemploye`) REFERENCES `EMPLOYE` (`NOemploye`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
