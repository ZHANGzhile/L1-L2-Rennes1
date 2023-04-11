-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 04 Mars 2022 à 22:18
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
--
-- Base de données :  `test`
--

-- --------------------------------------------------------

--
-- Structure de la table `AERODROME`
--

CREATE TABLE IF NOT EXISTS `AERODROME` (
  `lieu` varchar(42) NOT NULL DEFAULT '',
  `hangar` int(20) DEFAULT NULL,
  `nb_avion` int(20) DEFAULT NULL,
  `president` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`lieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `AERODROME`
--

INSERT INTO `AERODROME` (`lieu`, `hangar`, `nb_avion`, `president`) VALUES
('Azelot', 1, 14, 'Astrid Chignnon'),
('Dierre', 3, 13, 'Eric Daillou'),
('Frauenberg', 2, 9, 'Ymir Jagger'),
('Kourou', 2, 6, 'Thais Kolair'),
('La Rochelle', 1, 14, 'Cyprien de Bergerac'),
('Muret', 4, 7, 'Marc Petit'),
('Reims', 3, 18, 'Bjorn Ragnulf'),
('Rennes', 5, 10, 'Phillipe De La Costa Viva Del Parmegiano'),
('Saumur', 13, 4, 'Mohamed Dupuis'),
('Tours', 10, 10, 'Guillaume Salomon');

-- --------------------------------------------------------

--
-- Structure de la table `APPARTENANCE`
--

CREATE TABLE IF NOT EXISTS `APPARTENANCE` (
  `id_equipage` int(20) NOT NULL DEFAULT '0',
  `matricule` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_equipage`,`matricule`),
  KEY `matricule` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `APPARTENANCE`
--

INSERT INTO `APPARTENANCE` (`id_equipage`, `matricule`) VALUES
(1, '000AAA'),
(3, '000AAC'),
(5, '000AAE'),
(9, '001AAA'),
(7, '004AAC');

-- --------------------------------------------------------

--
-- Structure de la table `AVION`
--

CREATE TABLE IF NOT EXISTS `AVION` (
  `id_avion` int(20) NOT NULL DEFAULT '0',
  `nb_place` int(20) DEFAULT NULL,
  `model` varchar(42) DEFAULT NULL,
  `nb_heure_de_vol` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id_avion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `AVION`
--

INSERT INTO `AVION` (`id_avion`, `nb_place`, `model`, `nb_heure_de_vol`) VALUES
(1, 4, 'Aeroncha champion', '1375h'),
(2, 4, 'Piper Tri-pacer', '843h'),
(3, 5, 'Cessna 182', '1189h'),
(4, 3, 'Piper Comanche', '731h'),
(5, 2, 'Cessna 210', '1452h'),
(6, 4, 'Piper Lance', '1337h'),
(7, 3, 'Vans RV-12', '1074h'),
(8, 4, 'Evolution Revo', '976h'),
(9, 4, 'Lockwood Aircraft Aircam', '2479h'),
(10, 5, 'Legend Cub', '1976h');

-- --------------------------------------------------------

--
-- Structure de la table `DOCS_A_BORD`
--

CREATE TABLE IF NOT EXISTS `DOCS_A_BORD` (
  `N°Certificat_de_navigabilité` int(20) NOT NULL DEFAULT '0',
  `Certificat_d'Immatriculation` tinyint(1) DEFAULT NULL,
  `LSA` tinyint(1) DEFAULT NULL,
  `Fiche_de_pesée` tinyint(1) DEFAULT NULL,
  `Attestation_d'assurance` tinyint(1) DEFAULT NULL,
  `Manuel_de_vol_de_l'avion` tinyint(1) DEFAULT NULL,
  `Carnet de route` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`N°Certificat_de_navigabilité`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `DOCS_A_BORD`
--

INSERT INTO `DOCS_A_BORD` (`N°Certificat_de_navigabilité`, `Certificat_d'Immatriculation`, `LSA`, `Fiche_de_pesée`, `Attestation_d'assurance`, `Manuel_de_vol_de_l'avion`, `Carnet de route`) VALUES
(1, 1, 1, 1, 1, 1, 1),
(2, 1, 0, 1, 1, 1, 1),
(3, 1, 1, 0, 1, 0, 1),
(4, 1, 1, 1, 1, 1, 1),
(5, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `EMMENE`
--

CREATE TABLE IF NOT EXISTS `EMMENE` (
  `n°certificat_de_navigabilité` int(20) NOT NULL DEFAULT '0',
  `matricule` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`n°certificat_de_navigabilité`,`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `EMMENE`
--

INSERT INTO `EMMENE` (`n°certificat_de_navigabilité`, `matricule`) VALUES
(1, '000AAC'),
(2, '002AAA'),
(3, '000AAB'),
(4, '004AAC'),
(5, '000AAD');

-- --------------------------------------------------------

--
-- Structure de la table `EQUIPAGE`
--

CREATE TABLE IF NOT EXISTS `EQUIPAGE` (
  `id_equipage` int(20) NOT NULL DEFAULT '0',
  `nb_membre` int(20) DEFAULT NULL,
  `nationalite` varchar(42) DEFAULT NULL,
  `id_avion` int(20) DEFAULT NULL,
  PRIMARY KEY (`id_equipage`),
  KEY `id_avion` (`id_avion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `EQUIPAGE`
--

INSERT INTO `EQUIPAGE` (`id_equipage`, `nb_membre`, `nationalite`, `id_avion`) VALUES
(1, 2, 'Breton', 5),
(2, 3, 'Belge', 4),
(3, 5, 'Suisse', 3),
(4, 4, 'Ukrenien', 1),
(5, 4, 'Roumain', 2),
(6, 4, 'Anglais', 9),
(7, 5, 'Canadien', 10),
(8, 3, 'Serbe', 7),
(9, 4, 'Irlandais', 8),
(10, 2, 'Portugai', 5);

-- --------------------------------------------------------

--
-- Structure de la table `EST_DANS`
--

CREATE TABLE IF NOT EXISTS `EST_DANS` (
  `lieu` varchar(42) NOT NULL DEFAULT '',
  `id_avion` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lieu`,`id_avion`),
  KEY `id_avion` (`id_avion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `EST_DANS`
--

INSERT INTO `EST_DANS` (`lieu`, `id_avion`) VALUES
('Reims', 2),
('Azelot', 3),
('Kourou', 4),
('Saumur', 8),
('Frauenberg', 10);

-- --------------------------------------------------------

--
-- Structure de la table `HIST_TRAJET`
--

CREATE TABLE IF NOT EXISTS `HIST_TRAJET` (
  `id_avion` int(20) NOT NULL DEFAULT '0',
  `id_equipage` int(20) NOT NULL DEFAULT '0',
  `date_depart` varchar(42) DEFAULT NULL,
  `lieu_depart` varchar(42) DEFAULT NULL,
  `date_arrivee` varchar(42) DEFAULT NULL,
  `lieu_arrivee` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id_avion`,`id_equipage`),
  KEY `id_equipage` (`id_equipage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `HIST_TRAJET`
--

INSERT INTO `HIST_TRAJET` (`id_avion`, `id_equipage`, `date_depart`, `lieu_depart`, `date_arrivee`, `lieu_arrivee`) VALUES
(1, 10, '10h45', 'Saumur', '11H30', 'Tours'),
(2, 9, '6h05', 'Kourou', '23H30', 'Reims'),
(3, 8, '4h30', 'Azelot', '7H25', 'Frauenberg'),
(4, 7, '14h55', 'Rennes', '16h00', 'Dierre'),
(5, 6, '23h00', 'Muret', '1H30', 'La Rochelle');

-- --------------------------------------------------------

--
-- Structure de la table `MEMBRE_EQUIP`
--

CREATE TABLE IF NOT EXISTS `MEMBRE_EQUIP` (
  `matricule` varchar(42) NOT NULL DEFAULT '',
  `nom` varchar(42) DEFAULT NULL,
  `prenom` varchar(42) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `poste` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `MEMBRE_EQUIP`
--

INSERT INTO `MEMBRE_EQUIP` (`matricule`, `nom`, `prenom`, `age`, `poste`) VALUES
('000AAA', 'Dupon', 'Brigitte', 56, 'passager'),
('000AAB', 'Esnault', 'Marcus', 43, 'passager'),
('000AAC', 'Paliche', 'Damien', 27, 'passager'),
('000AAD', 'Renna', 'Thom', 39, 'passager'),
('000AAE', 'Ouchabar', 'Ines', 17, 'passager'),
('000AAF', 'Smith', 'John', 25, 'passager'),
('001AAA', 'Jean', 'Mickael', 20, 'pilote'),
('002AAA', 'Helleu', 'Briac', 20, 'pilote'),
('003AAA', 'Valek', 'Yvan', 68, 'pilote'),
('004AAC', 'Pilimini', 'Remus', 54, 'pilote');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `APPARTENANCE`
--
ALTER TABLE `APPARTENANCE`
  ADD CONSTRAINT `APPARTENANCE_ibfk_2` FOREIGN KEY (`id_equipage`) REFERENCES `EQUIPAGE` (`id_equipage`),
  ADD CONSTRAINT `APPARTENANCE_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `MEMBRE_EQUIP` (`matricule`);

--
-- Contraintes pour la table `EQUIPAGE`
--
ALTER TABLE `EQUIPAGE`
  ADD CONSTRAINT `EQUIPAGE_ibfk_1` FOREIGN KEY (`id_avion`) REFERENCES `AVION` (`id_avion`);

--
-- Contraintes pour la table `EST_DANS`
--
ALTER TABLE `EST_DANS`
  ADD CONSTRAINT `EST_DANS_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `AVION` (`id_avion`),
  ADD CONSTRAINT `EST_DANS_ibfk_1` FOREIGN KEY (`lieu`) REFERENCES `AERODROME` (`lieu`);

--
-- Contraintes pour la table `HIST_TRAJET`
--
ALTER TABLE `HIST_TRAJET`
  ADD CONSTRAINT `HIST_TRAJET_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `AVION` (`id_avion`),
  ADD CONSTRAINT `HIST_TRAJET_ibfk_1` FOREIGN KEY (`id_equipage`) REFERENCES `EQUIPAGE` (`id_equipage`);
--
-- Base de données :  `test_1`
--

-- --------------------------------------------------------

--
-- Structure de la table `LECTEUR`
--

CREATE TABLE IF NOT EXISTS `LECTEUR` (
  `NOLECTEUR` int(11) NOT NULL,
  `NOM` varchar(128) DEFAULT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NOLECTEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `LECTEUR`
--

INSERT INTO `LECTEUR` (`NOLECTEUR`, `NOM`, `ADRESSE`) VALUES
(1, 'Roman Policier', '10 rue des fleurs'),
(2, 'Patrick Chesne', '12 avenue Clang'),
(3, 'Caroline Dusquesne', 'patio Robert'),
(4, 'Gaspard Dupont', 'porte droite'),
(5, 'Roméo Trichet', '?'),
(6, 'Sophie Duchamp', '?'),
(7, 'Mohammed Khaled', '10 place Desfetes'),
(8, 'Ernest Njike', '1 rue delime'),
(9, 'Robert Laffontaine', '15 rue du commandant Gouttedeau'),
(10, 'Elsa Caramel', 'place des grands troncs'),
(11, 'Maurice Leplanqué', 'rue du trou'),
(12, 'Dominique Calende', 'Quelquepart'),
(13, 'Lali Téraire', 'impasse de la lettre'),
(14, 'Lascard Pomme', 'jardin du coin');

-- --------------------------------------------------------

--
-- Structure de la table `LIVRE`
--

CREATE TABLE IF NOT EXISTS `LIVRE` (
  `COTE` char(6) NOT NULL DEFAULT '',
  `TITRE` varchar(255) NOT NULL,
  `CATEGORIE` varchar(30) NOT NULL,
  `AUTEUR` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`COTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `LIVRE`
--

INSERT INTO `LIVRE` (`COTE`, `TITRE`, `CATEGORIE`, `AUTEUR`) VALUES
('ADKI01', 'The Keys of Egypt', 'Divers', 'Lesley and Roy Adkins'),
('ALBE01', 'Vie publique Vie privée', 'Divers', 'Francesco Alberoni'),
('ALLE01', 'Portrait sépia', 'Littérature', 'Isabel Allende'),
('ALLE02', 'Portrait sépia', 'Littérature', 'Isabel Allende'),
('ALPA01', 'Lumina', 'Divers', 'Dan Alpac'),
('ALVT01', 'Recherchée', 'Policier', 'Karin Alvtegen'),
('ANDE01', 'La maison des Atréïdes', 'SF', 'Brian Herbert et Kevin J. Anderson'),
('ARMA01', 'Au bonheur du matin', 'Littérature', 'Marie-Paul Armand'),
('ARMA02', 'Au bonheur du matin', 'Littérature', 'Marie-Paul Armand'),
('ARMA04', 'Le pain rouge', 'Divers', 'Marie-Paul Armand'),
('ARNA01', 'La boïte à chagrins', 'Policier', 'Philippe Arnaud'),
('ARNA02', 'La Compagnie des glaces', 'SF', 'Georges-Jean Arnaud'),
('ARTH01', 'Parfum de sorcière', 'Divers', 'Clair Arthur'),
('ARVO01', 'Les enfants de l''aube', 'Littérature', 'Patrick Poivre d''Arvor'),
('ATTA01', 'La conférence des oiseaux', 'Divers', 'Farid-ud-Din Attar'),
('ATWO01', 'Le tueur aveugle', 'Littérature', 'Margaret Atwood'),
('AUBE01', 'La Mort dans le bois', 'Policier', 'Brigitte Aubert'),
('AUBE02', 'Funérarium', 'Policier', 'Brigitte Aubert'),
('AUBE03', 'La mort des bois', 'Policier', 'Brigitte Aubert'),
('AUBI01', 'Petit ours brun', 'Divers', 'Danièle Bour, Marie Aubinais'),
('AUEL04', 'Les refuges de pierre', 'Divers', 'Jean M. Auel'),
('AUEL05', 'Les Enfants de la Terre', 'Divers', 'Jean M. Auel'),
('AULN01', 'La dame des 35 heures', 'Essai', 'Philippe Alexandre et Béatrix de l''Aulnoit'),
('AUST01', 'Je pensais que mon père était Dieu', 'Essai', 'Paul Auster'),
('AYAC01', 'Lettres a Prunelle', 'Essai', 'Alain Ayache'),
('BARB01', 'Les Kangourous', 'Policier', 'Dominque Barberis'),
('BARJ01', 'La nuit des temps', 'BD', 'René Barjavel'),
('BARJ03', 'La Faim du tigre', 'Essai', 'Barjavel'),
('BARJ04', 'Le grand secret', 'Littérature', 'René Barjavel'),
('BARJ06', 'La nuit des temps', 'SF', 'René Barjavel'),
('BARJ07', 'La nuit des temps', 'SF', 'René Barjavel'),
('BARJ10', 'Ravage', 'SF', 'René Barjavel'),
('BARK01', 'Galilée', 'SF', 'Clive Barker'),
('BARN01', 'Something to declare', 'Essai', 'Julian Barnes'),
('BEAU01', 'Le tir à la cible, de l''initiation à la compétition', 'Essai', 'Jacques Beausergent'),
('BEIG01', 'Windows on the world', 'Littérature', 'Frédéric Beigbeder'),
('BELL01', 'Les assassins sont parmi nous', 'Policier', 'Pierre Bellemare'),
('BENA01', 'La machine à broyer les petites filles', 'Policier', 'Tonino Benacquista'),
('BENA02', 'L''inconnue de Peshawar', 'Policier', 'Cheryl Benard'),
('BENA03', 'Quelqu''un d''autre', 'Littérature', 'Tonino Benacquista'),
('BENS01', 'Ne rêve jamais de mourir', 'Policier', 'Raymond Benson'),
('BENZ02', 'Thibaut ou la croix perdue (Les Chevaliers, tome 1)', 'Divers', 'Juliette Benzoni'),
('BERG01', 'Laterna magica', 'Essai', 'Ingmar Bergman'),
('BERN01', 'Fantômes', 'Policier', 'Maïté Bernard'),
('BERT01', '365 jours pour la terre', 'Divers', 'Yann Arthus-Bertrand'),
('BERT02', 'La terre vue du ciel', 'Divers', 'Yann Arthus-Bertrand'),
('BERT03', 'La Terre vue du ciel, 2e édition ', 'Divers', 'Yann Arthus-Bertrand'),
('BERT04', 'La Terre vue du ciel', 'Divers', 'Yann Arthus-Bertrand'),
('BESS01', 'Arthur et les Minimoys', 'Divers', 'Luc Besson'),
('BESS02', 'Meurtres à l''antique', 'Policier', 'Yvonne Besson'),
('BESS03', 'Un garçon d''Italie', 'Littérature', 'Philippe Besson'),
('BESS04', 'Arthur et les minnimoy', 'SF', 'Luc Besson'),
('BLAK01', 'Caca boudin', 'Divers', 'Stephanie Blake'),
('BOIS01', 'Marie-Tempête', 'Littérature', 'Janine Boissard'),
('BOIS02', 'Rendez-vous avec mon fils', 'Littérature', 'Janine Boissard'),
('BONN01', 'Défi à la pudeur', 'Essai', 'Gérard Bonnet'),
('BONN02', 'La longue route de Jacob ben Ezra', 'Divers', 'Jacques Bonnet'),
('BORD01', 'Les guerriers du silence', 'SF', 'Pierre Bordage'),
('BORR01', 'L''ombre du chat', 'Policier', 'Paul Borrelli'),
('BOUL01', 'Eux les vaches, nous les porcs', 'Littérature', 'Carmen Boullosa'),
('BOUQ01', 'Zacarias Moussaoui, mon frère', 'Essai', 'A.S. Moussaoui, F. Bouquillat'),
('BOUR01', 'Une sorcière cordon bleue', 'Divers', 'Patricia Bourque'),
('BOUS01', 'La balle rouge', 'Divers', 'Patrick Bousquet'),
('BOUS02', 'Bleu, chien soleil des tranchées', 'Divers', 'Patrick Bousquet'),
('BOUT01', 'Sang Breton', 'Divers', 'Michel Bouts'),
('BOYD01', 'L''après-midi bleue', 'Policier', 'William Boyd'),
('BRAS01', 'Quatre filles et un jean', 'Divers', 'Ann Brashares'),
('BRAS02', 'Quatre filles et un jean : Le deuxième été', 'Divers', 'Ann Brashares'),
('BRAS03', 'Quatre filles et un jean', 'Divers', 'Ann Brashares'),
('BREM01', 'L''intelligence de la couleur', 'Divers', 'Elisabeth Brémond'),
('BRIA01', 'L''Ile de la désolation', 'Divers', 'Patrick O Brian'),
('BRIA02', 'Capitaine de vaisseau', 'Divers', 'Patrick O''Brian'),
('BRIO01', 'Regards sur le cinéma américain', 'Divers', 'Patrick Brion'),
('BROO01', 'Heartland, tome 7 : Le Champion brisé', 'Divers', 'Lauren Brooke'),
('BROO02', 'Heartland, numéro 11 : La Vérité ...ou presque', 'Divers', 'Lauren Brooke'),
('BROO03', 'Heartland, tome 1 : Je reste !', 'Divers', 'Lauren Brooke'),
('BRUN01', 'La tentation d''Edouard', 'Littérature', 'Elisa Brune'),
('BRUS01', 'L''Armure de vengeance', 'Policier', 'Serge Brussolo'),
('BRUS02', 'Le labyrinthe de Pharaon', 'Policier', 'Serge Brussolo'),
('BRUS03', 'Les emmurés', 'Policier', 'Serge Brussolo'),
('BRUS04', 'le labyrinthe de pharaon', 'Divers', 'Serge Brussolo'),
('BRUS05', 'Le syndrome du scaphandrier', 'SF', 'Serge Brussolo'),
('BRUS06', 'Le manoir des sortilèges', 'SF', 'Serge Brussolo'),
('BUJO01', 'La Prophétie des pierres', 'SF', 'Flavia Bujor'),
('BURN01', 'Le règne animal', 'Divers', 'David Burnie'),
('BURO01', 'Docteur, puis-je vous voir avant six mois ?', 'Essai', 'Nicole de Buron'),
('CABA01', 'Nuit gravement au tabac', 'Essai', 'Francis Caballero'),
('CABO01', 'Journal d''une princesse', 'Divers', 'Meg Cabot'),
('CADE01', 'Restavec, enfant esclave en Haiti', 'Essai', 'Jean-Robert Cadet'),
('CAHR01', 'L''aliéniste', 'Policier', 'Caleb Cahr'),
('CALM01', 'Le lit d''Alienor', 'Divers', 'Mireille Calmel'),
('CALM02', 'Le bal des louves', 'Divers', 'Mireille Calmel'),
('CALM03', 'Le bal des louves', 'Divers', 'Mireille Calmel'),
('CANT01', 'Pas facile d''être une star', 'Divers', 'Marc Cantin'),
('CAPO01', 'De  sang froid', 'Policier', 'Truman Capote'),
('CARD01', 'La Stratégie Ender', 'SF', 'Orson Scott Card'),
('CARR01', 'Une petite bière, pour la route', 'Policier', 'Philippe Carrese'),
('CARR02', 'L''aliéniste', 'Policier', 'Caleb Carr'),
('CARR03', 'La constance du jardinier', 'Policier', 'John Le Carr'),
('CARR04', 'L''adversaire', 'Policier', 'Emmanuel Carrère'),
('CARR05', 'L''aliéniste', 'Policier', 'Caleb Carr'),
('CARR06', 'Le bal des Cagoles', 'Littérature', 'Philippe Carrese'),
('CART01', 'Bien entendu... c''est off', 'Essai', 'Daniel Carton'),
('CASA01', 'L''aube rouge', 'Essai', 'Claire Casamby'),
('CASA02', 'L''aube rouge', 'Essai', 'Claire Casamby'),
('CASE01', 'Genesis', 'Policier', 'John Case'),
('CASE02', 'Genesis', 'Policier', 'John Case'),
('CAUV01', 'Haute-Pierre', 'SF', 'Patrick Cauvin'),
('CAUW03', 'L''éducation d''une fée', 'Littérature', 'Didier Van Cauwelaert'),
('CERV01', 'Don Quichotte de la Manche', 'Littérature', 'Miguel de Cervantès'),
('CHAL01', 'Chere Marie-Antoinette', 'Divers', 'Jean Chalon'),
('CHAR02', 'Papillon', 'Divers', 'Henri Charrière'),
('CHAT01', 'L''âme du mal', 'Policier', 'Maxime Chattam'),
('CHAT02', 'L''âme du mal', 'Policier', 'Maxime Chattam'),
('CHAT03', 'L''âme du mal', 'Policier', 'Maxime Chattam'),
('CHAU02', 'Rapporteur de guerre', 'Essai', 'Patrick Chauvel'),
('CHEF01', 'Cuisiner pour les enfants', 'Divers', 'Marabout Chef'),
('CHEV01', 'La jeune fille à la perle', 'Littérature', 'Tracy Chevalier'),
('CHOM01', 'De la propagande', 'Essai', 'Noam Chomsky'),
('CHRI01', 'La trilogie des tripodes (3 livres)', 'Divers', 'John Christopher'),
('CHRI02', 'Les dix petits nègres', 'Policier', 'Agatha Christie'),
('CHRI03', 'La troisième fille', 'Policier', 'Agatha Christie'),
('CLAN01', 'Jeux de guerre', 'Policier', 'Tom Clancy'),
('CLAR01', 'Les plus belles histoires de Franklin ', 'Divers', 'Paulette Bourgeois et Brenda Clark'),
('CLAR02', 'Souviens-toi', 'Policier', 'Mary Higgins Clark'),
('CLAR03', 'La maison du clair de lune', 'Policier', 'Mary Higgins Clark'),
('CLEM01', 'Seul dans la jungle', 'Divers', 'Yves-Marie Clément'),
('CLEM02', 'Le puma aux yeux d''émeraude', 'Divers', 'Yves-Marie Clément'),
('CLOW01', 'David Boring', 'BD', 'Daniel Clowes'),
('COBE01', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE02', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE03', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE04', 'Une chance de trop', 'Policier', 'Harlan Coben'),
('COBE05', 'Disparu à jamais', 'Policier', 'Harlan Coben'),
('COBE06', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE07', 'Disparu à jamais', 'Policier', 'Harlan Coben'),
('COBE08', 'Disparu à jamais', 'Policier', 'Harlan Coben'),
('COBE09', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE10', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE11', 'Rupture de contrat', 'Policier', 'Harlan Coben'),
('COBE12', 'Ne le dis à personne', 'Policier', 'Harlan Coben'),
('COBE13', 'Disparu à jamais', 'Policier', 'Harlan Coben'),
('COE01', 'Testament à l''anglaise', 'Littérature', 'Jonathan Coe'),
('COEL01', 'L''alchimiste', 'Littérature', 'Paulo Coelho'),
('COEL02', 'Onze minutes', 'Littérature', 'Paolo Coelho'),
('COHE01', 'La Face cachée du Monde', 'Essai', 'Pierre Péan, Philippe Cohen'),
('COLE01', 'Néphilim, Le chant de la terre', 'SF', 'Isabelle et David Colet'),
('COLF01', 'Artemis Fowl', 'Divers', 'Eoin Colfer'),
('COLF02', 'Artemis Fowl', 'SF', 'Eoin Colfer'),
('COLI01', 'Voilà : dans les coulisses de Voici', 'Essai', 'Jacques Colin'),
('COLL01', 'Si le monde était un village de 100 personnes', 'Essai', 'Collectif'),
('COLL02', 'Sur le sentier Maori', 'Divers', 'Collectif'),
('COLL03', 'Sur le sentier Maori', 'Divers', 'Collectif'),
('COLL04', 'Les Aventures de Pinocchio', 'Divers', 'Carlo Collodi'),
('COLL05', 'La dame en blanc', 'Policier', 'Wilkie Collins'),
('COLL06', 'La pierre de lune', 'Policier', 'W. Wilkie Collins'),
('COLL07', 'La cuisine asiatique pour tous', 'Divers', 'Collectif'),
('COLL08', 'Basic Cooking - Cuisine asiatique entre copains', 'Divers', 'Collectif'),
('COLO01', 'El Guanaco', 'Littérature', 'Francisco Coloane'),
('COND01', 'Moi, Tituba sorcière', 'Divers', 'Maryse Cond'),
('CONN01', 'La glace noire', 'Policier', 'Michael Connelly'),
('CONN02', 'Le poète', 'Policier', 'Michael Connelly'),
('CONN03', 'Wonderland Avenue', 'Policier', 'Michael Connely'),
('CONN04', 'Le Poète', 'Policier', 'Michael Connelly'),
('CONN05', 'Créance de sang', 'Policier', 'Michael Connelly'),
('CONN06', 'Laissez toute espérance', 'Policier', 'John Connolly'),
('CONN07', 'Créance de sang', 'Policier', 'Michael Connelly'),
('CONN08', 'Darling Lilly', 'Policier', 'Michael Connelly'),
('CONN09', 'Le Poète', 'Policier', 'Michael Connelly'),
('CONV01', 'Les trois crimes d''Anubis', 'Divers', 'Didier Convard'),
('CORE01', 'Mademoiselle sauve qui peut', 'Divers', 'Philippe Corentin'),
('CORN01', 'Dossier Benton', 'Policier', 'Patricia Cornwell'),
('COUA01', 'Soeur Amère', 'Littérature', 'Mireille Couant'),
('COUR01', 'La France du rez-de-chaussée', 'Essai', 'Jean-François Courtille et Arman Maljaei-Courtille'),
('COUR02', 'La France du rez-de-chaussée', 'Essai', 'Jean-François Courtille et Arman Maljaei-Courtille'),
('COUR03', 'A la découverte de la Lune', 'Divers', 'Géraud des Courtils'),
('CRES01', 'Chasseurs de têtes', 'Policier', 'Michel Crespy'),
('CROI01', 'Ecolos, petites esbroufes et gros mensonges', 'Essai', 'Jean Paul Croiz'),
('CYRU01', 'Les vilains petits canards', 'Essai', 'Boris Cyrulnik'),
('CYRU02', 'Les vilains petits canards', 'Essai', 'Boris Cyrulnik'),
('CZAR01', 'Fromages du monde', 'Divers', 'Roland Barthélémy et Arnaud Sperat-Czar'),
('DAHL01', 'Charlie et la chocolaterie', 'Divers', 'Roald Dahl'),
('DANI01', 'Contes d''Afrique', 'Divers', 'Henri Gougaud, Marc Daniau'),
('DANT01', 'Périphériques', 'Essai', 'Maurice G. Dantec'),
('DANT02', 'Les racines du mal', 'Policier', 'Maurice G. Dantec'),
('DANT03', 'La Sirène rouge', 'Policier', 'Maurice G. Dantec'),
('DAVE01', 'Les frères Holt', 'Littérature', 'Marcia Davenport'),
('DAVI01', 'L''esprit de Dieu', 'Essai', 'Paul Davies'),
('DAYR01', 'C''est la vie, Lili', 'Divers', 'Valérie Dayre'),
('DE01', 'La vie à en mourir : Lettres de fusillés 1941-1944', 'Essai', 'Guy Krivopissko (sous la direction de'),
('DEFO01', 'Survivre avec les loups', 'Essai', 'Misha Defonseca'),
('DELE01', 'La première gorgée de bière', 'Littérature', 'Philippe Delerm'),
('DERR01', 'La Promesse du seuil : Un voyage avec Marguerite Yourcenar', 'Divers', 'Christian Dumais-Lvowski, Saddri Derradji'),
('DESM01', 'C''est écrit là-haut', 'Divers', 'Catherine Desmarteau'),
('DICK01', 'Ubik', 'SF', 'Philip K. Dick'),
('DICK02', 'Au bout du labyrinthe', 'SF', 'Philip K. Dick'),
('DICK03', 'Basic cooking Cuisinez entre copains', 'Divers', 'Sabine Sälzer - Sebastian Dickhaut'),
('DIDI01', 'Mes conversations avec la Reine', 'Divers', 'Yaguel Didier'),
('DIDI02', 'Olympia, Bruno Coquatrix', 'Divers', 'Jean-Michel Boris, Jean-François Brieu et Eric Didi'),
('DOLT01', 'Tout est language', 'Divers', 'Françoise Dolto'),
('DONA01', 'L''appel de Mordant', 'SF', 'Stephen Donaldson'),
('DRUO01', 'Tistou les pouces verts', 'Divers', 'Maurice Druon'),
('DRUO02', 'Les Rois maudits', 'Divers', 'Maurice Druon'),
('DUDE01', 'Les Cakes de Sophie', 'Divers', 'Sophie Dudemaine'),
('DUFO01', 'Marie-Antoinette, la mal aimée', 'Divers', 'Hortense Dufour'),
('DUPE01', 'Allons voir plus loin, veux tu ?', 'Littérature', 'Anny Duperey'),
('DURA01', 'Daddy', 'Policier', 'Loup Durand'),
('DURR01', 'Le quatuor d''Alexandrie', 'Littérature', 'Lawrence Durrell'),
('ECO01', 'Apostille Au nom de la rose', 'Essai', 'Umberto Eco'),
('ECO02', 'Le nom de la rose', 'Littérature', 'Umberto Eco'),
('EDDI01', 'La Belgariade, suivi de La Mallorée', 'SF', 'David Eddings'),
('EDWA01', 'Danse avec l''ange', 'Policier', 'Ake Edwardson'),
('ELLI01', 'American Psycho', 'Policier', 'Bret Easton Ellis'),
('ELLI02', 'Une femme en danger', 'Policier', 'James Elliot'),
('ELLR01', 'Américan Tabloïd', 'Policier', 'James Ellroy'),
('ELLR02', 'Le dalhia noir', 'Policier', 'James Ellroy'),
('ELLR03', 'Le Grand Nulle Part', 'Policier', 'James Ellroy'),
('ELLR04', 'Le dahlia noir', 'Policier', 'James Ellroy'),
('ELSC01', 'Petite indienne Feuille-qui-Danse', 'Divers', 'Géraldine Elschner'),
('ELTO01', 'Devine qui vient mourir ce soir ?', 'Policier', 'Ben Elton'),
('ERLB01', 'De la petite taupe qui voulait savoir qui lui avait fait sur la tête', 'Divers', 'Werner Holzwarth/Wolf Erlbruch'),
('ESCH01', 'Jésus Vidéo', 'SF', 'Andréas Eschbach'),
('ETXE01', 'Amour, Prozac, et autres curiosités', 'Littérature', 'Lucia Etxebarria'),
('EVAN01', 'La Prime', 'Policier', 'Janet Evanovich'),
('EVAN02', 'Le coeur des flammes', 'Littérature', 'Nicholas Evans'),
('EVSK01', 'Crime et châtiment', 'Littérature', 'Fedor Mikhaïlovitch Dostoïevski'),
('EXUP01', 'Le Petit Prince', 'Divers', 'Antoine de Saint-Exupéry'),
('FAIL01', 'On a volé la Belle-étoile', 'Policier', 'Jean Failler'),
('FARL01', 'Le fils de l''étalon noir', 'Divers', 'Walter Farley'),
('FARR01', 'La ville de glace', 'Policier', 'John Farrow'),
('FARR02', 'Le lac de glace', 'Policier', 'John Farrow'),
('FARR03', 'La ville de glace', 'Policier', 'John Farrow'),
('FEIS01', 'Pug l''apprenti', 'SF', 'Raymond E. Feist'),
('FERG01', 'Mille femmes blanches', 'Divers', 'Jim Fergus'),
('FERG03', 'Mille femmes blanches', 'Divers', 'Jim Fergus'),
('FERM01', 'Neige', 'Littérature', 'Maxence Fermine'),
('FERR01', 'Les Visages de Dieu', 'Policier', 'Jean-Denis Bruet-Ferreol'),
('FERR02', 'Les Visages de Dieu', 'Policier', 'Jean-Denis Bruet-Ferreol'),
('FERR03', 'Les visages de Dieu', 'Policier', 'Jean-Denis Bruet-Ferréol'),
('FERR04', 'Les Visages de Dieu', 'Policier', 'Jean-Denis Bruet-Ferréol'),
('FETJ01', 'Le pas de Merlin', 'SF', 'Jean-Louis Fetjaine'),
('FIEL01', 'Ne compte pas les heures', 'Littérature', 'Joy Fielding'),
('FILI01', 'Les derniers jours de la classe ouvrière', 'Littérature', 'Aurélie Filippetti'),
('FLAM01', '300 recettes des cuisines du monde', 'Divers', 'Collectif (Editions Flammarion'),
('FLEU01', 'Sans père ni repères', 'Essai', 'Catherine Lehoux-Fleury'),
('FOLL01', 'Apocalypse sur commande', 'Policier', 'Ken Follet'),
('FOLL02', 'Les pilliers de la terre', 'Policier', 'Ken Follet'),
('FOLL03', 'Le troisième jumeau', 'Policier', 'Ken Follett'),
('FOLL04', 'la marque de Windfield', 'Divers', 'Ken Follet'),
('FOLL05', 'Les Pilliers de la Terre', 'Divers', 'Ken Follett'),
('FOLL06', 'Les piliers de la terre', 'Divers', 'Ken Follett'),
('FOLL08', 'Le Réseau Corneille', 'Divers', 'Ken Follet'),
('FOUG01', 'La fabuleuse aventure des hommes et des animaux', 'Divers', 'Boris Cyrulnick, Karine Lou Matignon, Frédéric Fougea'),
('FRAI01', 'Les hommes etc...', 'Divers', 'Irène Frain'),
('FRAN01', 'Le Journal d''Anne Frank', 'Essai', 'Anne Frank'),
('FREC01', 'Les chevaux célestes', 'Divers', 'José Frèches'),
('FREN01', 'La chambre écarlate', 'Policier', 'Nicci French'),
('FREN02', 'Feu de glace', 'Policier', 'Nicci French'),
('FRES01', 'Privés de télé', 'Divers', 'Gilles Fresse'),
('FREY01', 'Hector veut un chien', 'Divers', 'Nathalie Frey'),
('FROI01', 'Chroniques de la lune noire - L''Aigle Foudroyé', 'BD', 'Pontet - Froideval'),
('GAAR01', 'Le mystère de la patience', 'Essai', 'Josten Gaarder'),
('GABO01', 'Les Crépusculaires', 'SF', 'Mathieu Gaborit'),
('GAGN01', 'La femme patiente', 'Littérature', 'Alain Gagnol'),
('GAIL01', 'Un soir au club', 'Littérature', 'Christian Gailly'),
('GAIM01', 'Coraline', 'Divers', 'Neil Gaiman'),
('GAIM02', 'De bons présages', 'SF', 'Terry Pratchett et Neil Gaiman'),
('GALL01', 'Napoleon', 'Divers', 'Max Gallo'),
('GARD01', 'Les formes de l''intelligence', 'Essai', 'Howard Gardner'),
('GATT01', 'Un cours sur l''amour', 'Divers', 'Joan Gattuso'),
('GAUG01', 'Noa Noa', 'Divers', 'Paul Gauguin'),
('GAVA01', 'Je l''aimais', 'Littérature', 'Anna Gavalda'),
('GAYL01', 'Trente ans déjà', 'Littérature', 'Mike Gayle'),
('GEMM05', 'Légende', 'SF', 'David Gemmell'),
('GENE01', 'Raboliot', 'Littérature', 'Maurice Genevoix'),
('GEOG01', 'Peuples du monde', 'Divers', 'Collectif - National Geographic'),
('GEOR01', 'Mémoire infidèle', 'Policier', 'Elisabeth George'),
('GEOR02', 'Mémoire infidèle', 'Policier', 'Elisabeth George'),
('GEOR03', 'Pour solde de tout compte', 'Policier', 'Elizabeth George'),
('GERR01', 'Le Chirurgien', 'Policier', 'Tess Gerritsen'),
('GIBR01', 'Le Vol du Corbeau', 'BD', 'Gibrat'),
('GIBR02', 'Le Vol du Corbeau', 'BD', 'Gibrat'),
('GIBR03', 'Le prophète', 'Littérature', 'Khalil Gibran'),
('GIES01', 'L''abatteur', 'Policier', 'Franz-Olivier Giesbert'),
('GIES02', 'L''abatteur', 'Policier', 'Franz-Olivier Giesbert'),
('GILB01', 'Chiffon', 'BD', 'David Gilbert'),
('GIME01', 'La caste des Méta-Barons', 'BD', 'Alexandro Jodorowsky et Juan Gimenez'),
('GIRA01', 'OK Corral', 'BD', 'Charlier et Giraud'),
('GIVA01', 'Le Non Désiré - Dialogue avec l''enfant', 'Essai', 'Daniel Meurois-Givaudan'),
('GLOC01', 'La vie en rose', 'Divers', 'Dominique glocheux'),
('GOSC01', 'Astérix et le rentrée gauloise', 'BD', 'Albert Uderzo et René Goscinny'),
('GOUG01', 'Les sept plumes de l''aigle', 'Essai', 'Henri Gougaud'),
('GOUP01', 'Le Guide des amis en BD', 'Divers', 'Tepaz-Goupil'),
('GOYE02', 'Collèges de France', 'Essai', 'Mara Goyet'),
('GOYE03', 'Collèges de France', 'Essai', 'Mara Goyet'),
('GOYE04', 'Collèges de France', 'Essai', 'Mara Goyet'),
('GRAD01', 'L''Alsace, le pays et ses habitants', 'Divers', 'Charles Grad'),
('GRAF01', 'N comme Nausée', 'Policier', 'Sue Grafton'),
('GRAF02', 'A comme alibi', 'Policier', 'Sue Grafton'),
('GRAN01', 'La vie d''autrefois dans le Tarn-et-Garonne', 'Essai', 'Régis Granier'),
('GRAN02', 'L''empire des loups', 'Policier', 'Jean-Christophe Grang'),
('GRAN03', 'L''empire des loups', 'Policier', 'Jean-Christophe Grang'),
('GRAN04', 'Le vol des cigognes', 'Policier', 'Jean-Christophe Grang'),
('GRAN05', 'Les rivières pourpres', 'Policier', 'Christophe Grang'),
('GRAN06', 'Le vol des cigognes', 'Policier', 'Jean-Christophe Grang'),
('GRAN07', 'Les rivières pourpres', 'Policier', 'Christophe Grang'),
('GRAN08', 'Le Concile de pierre', 'Policier', 'Jean-Christophe Grang'),
('GRAN09', 'Double je', 'Policier', 'Sylvie Granotier'),
('GRAN10', 'Le Concile de pierre', 'Policier', 'Jean-Christophe Grang'),
('GRAN11', 'L''empire des loups', 'Policier', 'Jean-Christophe Grang'),
('GRAN12', 'L''empire des loups', 'Policier', 'Jean-Christophe Grang'),
('GRAN13', 'Le Concile de pierre', 'Policier', 'Jean-Christophe Grang'),
('GRAN14', 'Les Rivières pourpres', 'Policier', 'Jean-Christophe Grang'),
('GRAN15', 'Le vol des cigognes', 'Policier', 'Jean-Christophe Grang'),
('GREG01', 'Olivier Rameau', 'BD', 'Dany et Greg'),
('GREN01', 'Virus LIV-3 ou la Mort des livres', 'SF', 'Christian Grenier'),
('GRIS01', 'L''Engrenage', 'Policier', 'John Grisham'),
('GRIS02', 'L''Affaire Pélican', 'Policier', 'John Grisham'),
('GRIS03', 'Pas de NoÃ«l cette année', 'Policier', 'John Grisham'),
('GROD01', 'Le livre du ça', 'Essai', 'Georg Groddeck'),
('GUAR01', 'Blacksad', 'BD', 'Guarnido'),
('GUEN01', 'Paroles d''étoiles', 'Essai', 'Sous la direction de JP Guéno'),
('GUEN02', 'Plus fort que la haine', 'Essai', 'Tim Guénard'),
('GUIL01', 'Les chemins du destin', 'SF', 'Franck Guilbert'),
('GUIN01', 'Le voleur de briquet', 'Policier', 'Michael Guinzburg'),
('GUIS01', 'Thèse et foutaises sur les attentats du 11 septembre', 'Essai', 'Guillaume Dasquié, Jean Guisnel'),
('GUYA01', 'Opération Madelone', 'Policier', 'Yannick Le Guyadec'),
('HACK01', 'A pas feutrés sur les sentiers sauvages de Lorraine', 'Divers', 'David Hackel'),
('HADD01', 'Le jour où Lacan m''a adopté', 'Essai', 'Gérard Haddad'),
('HALT01', 'Le vent des Kazars', 'Divers', 'Marek Halter'),
('HALT02', 'La Bible au féminin : Sarah', 'Divers', 'Marek Halter'),
('HAMB01', 'La poussière des ombres', 'Divers', 'Barbara Hambly'),
('HARR01', 'Dragon Rouge', 'Policier', 'Thomas Harrys'),
('HARR02', 'Le silence des agneaux', 'Policier', 'Thomas Harris'),
('HARR03', 'Vin de bohème', 'Littérature', 'Joanne Harris'),
('HARU01', 'Le chant des plaines', 'Littérature', 'Kent Haruf'),
('HAUS01', 'Les chasseurs de l''aube', 'BD', 'René Hausman'),
('HAUS02', 'Le mur invisible', 'Littérature', 'Marlen Haushofer'),
('HEAR01', 'Le clan des Otori', 'Divers', 'Lian Hearn'),
('HEBE01', 'Esthétique domestique : Les arts ménagers 1920-1970', 'Divers', 'Jean-Bernard Hebey'),
('HEND01', 'Y''en a marre des blondes', 'Policier', 'Lauren Henderson'),
('HERB02', 'Dune', 'SF', 'Frank Herbert'),
('HERL01', 'Histoire du petit garçon qui était une petite fille', 'Divers', 'Didier Herlem'),
('HERM01', 'Moi, Christiane F., 13 ans, droguée, prostituéeâ¦', 'Essai', 'Kai Hermann'),
('HERM02', 'Mes desserts préférés', 'Divers', 'Dorie Greespan et Pierre Herm'),
('HERM03', 'Le Larousse des desserts', 'Divers', 'Pierre Herm'),
('HERZ01', 'Annapurna premier huit mille', 'Divers', 'Maurice Herzog'),
('HICK01', 'Les Portes de la Mort', 'SF', 'Margaret Weis  et  Tracy Hickman'),
('HOBB02', 'Le prince Assassin', 'SF', 'Robin Hobb'),
('HOBB03', 'Les aventuriers de la mer', 'SF', 'Robin Hobb'),
('HOBB07', 'L''assassin royale', 'SF', 'Robin Hobb'),
('HOBB08', 'L''Assassin royal', 'SF', 'Robin Hobb'),
('HOBB09', 'Les Aventuriers de la mer ', 'SF', 'Robin Hobb'),
('HOEY01', 'Hermux Tantamoq - Le temps ne s''arrête pas pour les souris', 'Divers', 'MichaÃ«l Hoeye'),
('HOLT01', 'Avez-vous vu Zachary Beaver ?', 'Divers', 'Kimberly Willis Holt'),
('HOME01', 'Lady Love', 'Littérature', 'Homeric'),
('HOMM01', 'Le Livre des étoiles', 'Divers', 'Erik L''Homme'),
('HONA01', 'Taxiphobie', 'Divers', 'Michel Honaker'),
('HORN01', 'Haute fidélité', 'Littérature', 'Nick Hornby'),
('HORN02', 'Pour un garçon', 'Littérature', 'Nick Hornby'),
('HUYS01', 'Là-Bas ', 'Divers', 'Joris-Karl Huysmans'),
('INCH01', 'Main basse sur la musique', 'Essai', 'Rémi Godeau et Irène Inchausp'),
('INTE01', 'Cyber Poulpe', 'Policier', 'Collectif Internet'),
('IZZO01', 'Total Kheops', 'Policier', 'Jean-Claude Izzo'),
('JACQ03', 'Ramsès', 'Divers', 'Christian Jacq'),
('JACQ06', 'Ramsès', 'Divers', 'Christians Jacq'),
('JALI01', 'Yack'' à lire de A à Zébre ', 'Divers', 'Claire Benedetti et Maria Jalibert'),
('JANI01', 'Damien autour du Monde', 'Divers', 'Gérard Janichon'),
('JARD01', '1+1+1=une révolution', 'Essai', 'Alexandre Jardin'),
('JEAN01', 'Esprit Loft', 'Divers', 'Cédric Resche, Jérôme de Vries, William Jean'),
('JOHN01', 'Qui a piqué mon fromage ?', 'Divers', 'Spencer Johnson'),
('JONQ01', 'Moloch', 'Policier', 'Thierry Jonquet'),
('JORD02', 'La roue du temps', 'SF', 'Robert Jordan'),
('JOSS01', 'Voyages virtuels ', 'SF', 'Djimgee (alias Jean-Marc Josset'),
('JOYA01', 'Plaisir en bouche', 'Policier', 'Béatrice Joyau'),
('JOYC01', 'La vérité sur Kate Gallagher', 'Littérature', 'Brenda Joyce'),
('KANA01', 'Ma guerre à l''indifférence', 'Essai', 'Jean-Sélim Kanaan'),
('KAPL01', 'La nutrition consciente', 'Divers', 'Marion Kaplan'),
('KAPU01', 'Ebène, Aventures africaines', 'Divers', 'Ryszard Kapuscinski'),
('KASM01', 'Le cimetière de verre', 'Littérature', 'Sorour Kasma'),
('KAUF01', 'Corps de femmes, regards d''hommes', 'Essai', 'Jean-Claude Kaufmann'),
('KEAN01', 'J''ai échangé mon père contre 2 poissons rouges', 'Divers', 'Neil Gaiman et Dave Mc Kean'),
('KENN01', 'Une relation dangereuse', 'Littérature', 'Douglas Kennedy'),
('KERC01', 'Mon père, ce harki', 'Divers', 'Dalila Kerchouche'),
('KERR01', 'La tour d''Abraham', 'Policier', 'Philp Kerr'),
('KERT01', 'Un Autre - Chronique d''une métamorphose', 'Essai', 'Imre Kertész'),
('KEYE01', 'Des fleurs pour Algernon', 'SF', 'Daniel Keyes'),
('KING01', 'Dolores Claiborne', 'Policier', 'Stephen King'),
('KING04', 'La Peau sur les Os', 'SF', 'Richard Bachman (Stephen King'),
('KING05', 'Simetière', 'SF', 'Stephen KING'),
('KING07', 'Dreamcatcher', 'SF', 'Stephen King'),
('KING09', 'Marche ou crève', 'SF', 'Stephen King'),
('KOB01', 'La femme des sables', 'Littérature', 'Abé Kôb'),
('KOON01', 'La Maison interdite', 'SF', 'Dean R. Koontz'),
('KOON02', 'Midnight', 'SF', 'Dean R. Koontz'),
('KOUR01', 'Le Pingouin', 'Littérature', 'Andreï Kourkov'),
('KRIN01', 'Luce la puce', 'Divers', 'Antoon Krings'),
('LABA01', 'L''Europe fédérale', 'Essai', 'Bernard Guetta - Philippe Labarde'),
('LABU01', 'A-ha, la vérité sur un groupe de légende', 'Essai', 'Laurent Labuche'),
('LACK01', 'La proie de la magie', 'SF', 'Mercedes Lackey'),
('LACL01', 'Les Liaisons dangereuses', 'Littérature', 'Pierre-Ambroise-François Choderlos de Laclos'),
('LACO01', 'Enron, la faillite qui ébranla l''Amérique', 'Essai', 'Anne-Sylvaine Chassany et Jean-Philippe Lacour'),
('LAFF01', 'Enfants d''ailleurs', 'Divers', 'Martine et Caroline Laffon'),
('LAFO01', 'Une fièvre impossible à négocier', 'Littérature', 'Lola Lafon'),
('LAGI01', 'Les mille yeux de Brian de Palma', 'Essai', 'Luc Lagier'),
('LAHA01', 'Mystic River', 'Policier', 'Dennis Lahanne'),
('LAMA01', 'Carnets de voyage', 'Divers', 'Titouan Lamazou'),
('LAMO01', 'Il y a des vies...', 'Littérature', 'Delphine Lamotte'),
('LAPI01', 'Agadamgorodok', 'BD', 'Pierre Bailly et Denis Lapière'),
('LARO01', 'Petit Larousse de la cuisine 1800 recettes', 'Divers', 'Larousse'),
('LASS01', 'Quand Papa avait mon âge', 'Divers', 'Gilles Honotaux, Hélène Lasserre'),
('LAUR01', 'La cuisine des Indiens : 50 recettes faciles au bon goût d''aventure', 'Divers', 'Gilles et Laurence Laurendon'),
('LAWH01', 'Le cycle de Pendragon', 'SF', 'Stephen Lawhead'),
('LAWR01', 'Coeur de loup', 'Divers', 'R.D. Lawrence'),
('LECH01', 'Cuisines d''Espagne', 'Divers', 'Elisabeth Lecharme'),
('LEHA01', 'Ténèbres, prenez-moi par la main ', 'Policier', 'Dennis Lehane'),
('LEHA02', 'Gone, baby, gone', 'Policier', 'Dennis Lehane'),
('LEHA03', 'Sacré', 'Policier', 'Dennis Lehane'),
('LEHA04', 'Mystic River', 'Policier', 'Dennis Lehane'),
('LEHA05', 'Gone, baby, gone', 'Policier', 'Dennis Lehane'),
('LEON01', 'L''affaire Paola', 'Policier', 'Donna Leon'),
('LEON02', 'Des amis hauts placés', 'Policier', 'Donna Leon'),
('LETE01', 'Pièges', 'Policier', 'Dominique Letellier'),
('LEVI01', 'Si c''est un homme', 'Divers', 'Primo Levi'),
('LEVY02', 'Qui a tué Daniel Pearl ?', 'Essai', 'Bernard-Henry Lévy'),
('LEVY03', 'Qui a tué Daniel Pearl ?', 'Essai', 'Bernard-Henri Lévy'),
('LEVY04', 'Et si c''était vrai...', 'Littérature', 'Marc Levy'),
('LEVY05', 'Et si c''était vrai...', 'Littérature', 'Marc Levy'),
('LEVY06', 'Le passé d''une innocence ', 'Divers', 'Laurent Lévy'),
('LIEB01', 'Le vagabond de Holmby Park', 'Policier', 'Herbert H. Lieberman'),
('LLOS01', 'Le Paradis, un peu plus loin', 'Divers', 'Mario Vargas Llosa'),
('LOEV01', 'La louve et l''enfant', 'SF', 'Henri Loevenbruck'),
('LOEV02', 'La louve et l''enfant', 'SF', 'Henri Loevenbruck'),
('LOIS01', 'Encyclopédie de la cuisine de A à Z (10 volumes)', 'Divers', 'France Loisirs'),
('LOPE01', 'Le vampirisme au quotidien', 'Essai', 'Gérard Lopez'),
('LOUB01', 'Petits polars à l''usage des grands', 'Policier', 'Sophie Loubière'),
('LUDL01', 'Le pacte Cassandre', 'Policier', 'Robert Ludlum'),
('LUDL02', 'La mémoire dans la peau', 'Policier', 'Robert Ludlum'),
('LUML01', 'Necroscope', 'SF', 'Brian Lumley'),
('LUND01', 'Pompéi', 'Divers', 'Maja Lundgren'),
('MAAL01', 'Les Identités meurtrières', 'Essai', 'Amin Maalouf'),
('MAAL02', 'Les identités meurtrières', 'Essai', 'Amin Maalouf'),
('MAAL04', 'Le périple de Baldassare', 'Divers', 'Amin Maalouf'),
('MAAL05', 'Léon L''Africain', 'Divers', 'Amin Maalouf'),
('MAAS01', 'Noces indiennes', 'Littérature', 'Sharon Maas'),
('MACD01', 'Origine suspecte', 'Policier', 'Patricia MacDonald'),
('MACD02', 'Moralité douteuse', 'Policier', 'Bonnie MacDougal'),
('MAHF02', 'Le jardin du passé', 'Divers', 'Naguib Mahfouz'),
('MAJA01', 'Vaches, je vous aime', 'Divers', 'Photo : Roberto Neumiller / Texte : Jean-Olivier Majastre'),
('MALF01', 'Golden City', 'BD', 'Daniel Pecqueur et Nicolas Malfin'),
('MANK01', 'Le guerrier solitaire', 'Policier', 'Henning Mankell'),
('MANK02', 'La cinquième femme', 'Policier', 'Henning Mankel'),
('MANK03', 'Les morts de la Saint Jean', 'Policier', 'Henning Mankell'),
('MANK04', 'La muraille invisible', 'Policier', 'Henning Mankell'),
('MANS01', 'The Long Hard Road Out of Hell', 'Essai', 'Marilyn Manson'),
('MARA01', 'L''héritage d''Esther', 'Littérature', 'Sandor Marai'),
('MARE01', 'Esclave !', 'Divers', 'Pascale Maret'),
('MARG01', 'Lulu s''maque', 'BD', 'Frank Margerin'),
('MARI01', 'Scorpion', 'BD', 'Stephen Desberg et  Enrico Marini'),
('MARI02', 'Plus de Platon moins de Prozac', 'Divers', 'Lou Marinoff'),
('MARQ01', 'Colère', 'SF', 'Denis Marquet'),
('MART01', 'Descente en eaux troubles', 'Policier', 'Julia Wallis Martin'),
('MART02', 'La relique', 'Divers', 'Jean-Louis Marteil'),
('MART04', 'Le petit livre des crêpes salées et sucrées', 'Divers', 'Héloïse Martel'),
('MARX01', 'Correspondance de Groucho Marx', 'Essai', 'Groucho Marx'),
('MASP01', 'Les abeilles et la guêpe', 'Essai', 'François Maspero'),
('MAST01', 'Démences', 'SF', 'Graham Masterton'),
('MATH01', 'La pâtisserie pour tous', 'Divers', 'Ginette Mathiot'),
('MATH02', 'La cuisine pour tous', 'Divers', 'Ginette Mathiot'),
('MATR01', 'Qui et Où? Régions de France', 'Divers', 'Chrystel Manfredi-Matringe'),
('MATT01', 'Hôtels : Petites histoires de grands hôtels', 'Divers', 'Francisca Matteoli'),
('MAYN01', 'L''Heure du Diable', 'Policier', 'Bernard Ollié-Guy Maynart'),
('MAZA01', 'Je redessinerai le ciel bleu dans tes yeux', 'Divers', 'Claire Mazard'),
('MCDA01', 'Et si c''était un ange ?', 'Divers', 'Lurlene McDaniel'),
('MCDE01', 'Le tueur des ombres', 'Policier', 'Val McDermid'),
('MEBA01', 'Les enfants lumières', 'Essai', 'Agnès Wachter-Mébarki'),
('MENS01', 'A table, Président !', 'Divers', 'Yann Mens'),
('MERL01', 'L''ïle', 'Littérature', 'Robert Merle'),
('MERL04', 'Fortune de France', 'Divers', 'Robert Merle'),
('MERN01', 'Le harem politique', 'Essai', 'Fatima Mernissi'),
('MICH01', 'Des grives aux loups', 'Divers', 'Claude Michelet'),
('MIHA01', 'L''accident', 'Littérature', 'Sébastien Mihail'),
('MIKS01', 'Le ruisseau aux larmes d''amour', 'Divers', 'Jean-Lucien Miksa'),
('MILL01', 'C''est pour ton bien', 'Essai', 'Alice Miller'),
('MOAT01', 'Villa Jasmin', 'Divers', 'Serge Moati'),
('MOIG01', 'Tempête sur le Guépratte', 'Littérature', 'Christine Grelet - Le Moigne'),
('MOKA01', 'L''enfant des ombres', 'Divers', 'Moka'),
('MOKA02', 'La marque du diable', 'SF', 'Moka'),
('MOLI01', 'Verres gourmands', 'Divers', 'Benoït Molin'),
('MONC01', 'Georges Bouton, explomigrateur', 'Divers', 'Gérard Moncomble'),
('MONF01', 'Commissaire Leon', 'Policier', 'Nadine Monfils'),
('MONO01', 'Et si l''aventure humaine devait  échouer', 'Essai', 'Théodore MONOD'),
('MONT01', 'l''arbre aux secrets', 'Littérature', 'Santa Montefiore'),
('MOOR02', 'Mike contre-attaque !', 'Essai', 'Michael Moore'),
('MOOR05', 'La vestale à paillettes dâAlualu', 'Policier', 'Christopher Moore'),
('MOOR07', 'Voici l''homme', 'SF', 'Michael Moorcock'),
('MORG01', 'La sixième', 'Divers', 'Susie Morgenstern'),
('MORG02', 'L''alchimiste assassiné', 'Policier', 'Fidelis Morgan'),
('MORG03', 'Le Bleu de la mer', 'Littérature', 'Cédric Morgan'),
('MORI02', 'Les morts parlaient trop', 'Policier', 'Lucile Clémens-Morisset'),
('MOUR01', 'Trolls dans la brume', 'BD', 'S. Arleston, J.L. Mourier'),
('MOUR02', 'La rivière à l''envers', 'Divers', 'Jean-Claude Mourlevat'),
('MOUR03', 'L''enfant Océan', 'Divers', 'Jean-Claude Mourlevat'),
('MOUR05', 'Le goût de Palerme', 'Divers', 'Jean-NoÃ«l Mouret'),
('MURA01', 'Golem, tome 2 : Joke', 'Divers', 'Marie-Aude Murail'),
('MURA02', 'Golem, tome 1 : Magic Berber', 'Divers', 'Marie-Aude Murail'),
('MURA03', 'Magic Berber, golem tome 1', 'Divers', 'Elvire, Lorris et Marie-Aude Murail'),
('MURA04', 'Magic Berber, Golem, tome 1', 'Divers', 'Elvire Lorris et Marie-Aude Murail'),
('MURR01', 'Jimi Hendrix', 'Essai', 'Charles Shaar Murray'),
('NAUD02', 'Le Cycle Tristan de Castelreng', 'Divers', 'Pierre Naudin'),
('NEEL01', 'Journal de voyage', 'Divers', 'Alexandra David-Neel'),
('NEVI01', 'Le Huit', 'Policier', 'Katherine Neville'),
('NGER01', 'Chasses subtiles', 'Essai', 'Ernst JÃ¼nger'),
('NGUY01', 'La nuit nous a surpris ', 'Divers', 'Kien Nguyen'),
('NICH01', 'Les Secrets d''Aramanth', 'Divers', 'William Nicholson'),
('NICH02', 'Les Secrets d''Aramanth - le Vent de Feu', 'Divers', 'William Nicholson'),
('NOTH01', 'Mercure', 'Littérature', 'Amélie Nothomb'),
('NOTH02', 'Cosmétique de l''ennemi', 'Littérature', 'Amélie Nothomb'),
('NOTH03', 'Hygiène de l''assassin', 'Littérature', 'Amélie Nothomb'),
('NOTH05', 'Stupeurs et tremblements', 'Littérature', 'Amélie Nothomb'),
('NOTT01', 'Poison vert', 'Policier', 'Patric Nottret'),
('NOZI01', 'Tu vaux mieux que mon frère', 'Divers', 'Nozière'),
('NOZI02', 'Eldorado', 'Divers', 'Jean-Paul Nozière'),
('OLLI01', 'La Longue Marche : Le Vent des steppes', 'Divers', 'Bernard Ollivier'),
('ONFR01', 'Archéologie du présent', 'Essai', 'Michel Onfray'),
('OPPE01', 'Silverwing', 'Divers', 'Kenneth Oppel'),
('ORSE01', 'Madame Bâ', 'Littérature', 'Erik Orsenna'),
('OVID01', 'L''art d''aimer', 'Essai', 'Ovide'),
('PACC01', 'Kamtchaka, la terre des origines', 'Divers', 'Yves Paccalet'),
('PADU01', 'Le Palmier et l''Etoile ', 'Littérature', 'Leonardo Padura'),
('PAGA01', 'Dernière station avant l''autoroute', 'Policier', 'Hugues Pagan'),
('PAGE01', 'Comment je suis devenu stupide', 'Littérature', 'Martin Page'),
('PARO01', 'L''homme au ventre de plomb', 'Policier', 'Jean-François Parot'),
('PARO02', 'L''énigme des Blancs-Manteaux', 'Policier', 'Jean-François Parot'),
('PARO04', 'L''affaire Nicolas Le Floch', 'Divers', 'Jean-François Parot'),
('PAUL01', 'Vos yeux Madame', 'Essai', 'Ivanka Paul'),
('PAVL01', 'Matin brun', 'Essai', 'Franck Pavloff'),
('PEF01', 'Le monstre poilu', 'Divers', 'Henriette Bichonnier - Pef'),
('PEF02', 'Le petit motordu', 'Divers', 'Pef'),
('PEIT01', 'Les Anges du Jugement', 'Policier', 'Claude Peitz'),
('PELL01', 'L''inconnu du donjon', 'Divers', 'Evelyne Brisou-Pellen'),
('PELT01', 'Les épices', 'Divers', 'Jean-Marie Pelt'),
('PENN01', 'L''oeil du loup', 'Divers', 'Daniel Pennac'),
('PENN02', 'La Fée carabine', 'Policier', 'Daniel Pennac'),
('PENN03', 'Le dictateur et le hamac', 'Littérature', 'Daniel Pennac'),
('PERE01', 'Les Trois mousquetaires', 'Divers', 'Alexandre Dumas (père'),
('PERN01', 'Le journal secret de Marine', 'Divers', 'Sandrine Pernusch'),
('PERR01', 'Passé sous silence', 'Policier', 'Anne Perry'),
('PERR02', 'La marque de Caïn', 'Policier', 'Anne Perry'),
('PERR03', 'Le bourreau de Hyde Park', 'Policier', 'Anne Perry'),
('PEYR01', 'Les chiens sauvages ', 'Divers', 'Michel Peyramaure'),
('PHOT01', 'Chambéry, une ville, des regards', 'Divers', '10 écrivains et une photographe'),
('PHOT04', 'Tout ce que vous devez avoir goûté au moins une fois dans votre vie', 'Divers', 'Eric Frechon (recettes), Sylvia Gabet, Hervé Amiard (photographies'),
('PHOT05', 'Je veux du chocolat !', 'Divers', 'Trish Deseine et Marie-Pierre Morel (photographe'),
('PIAS01', 'Ca déménage  classe 104 !', 'Divers', 'Jerry Piasecki'),
('PICO01', 'Pour que justice soit faite', 'Littérature', 'Jodi Picoult'),
('PLAC01', 'Le Royaume de Kensuké', 'Divers', 'Michael Morpurgo et François Place'),
('PLAC02', 'Le vieux fou de dessins', 'Divers', 'François Place'),
('PLIS01', 'La Mer', 'Divers', 'Philipp Plisson'),
('PODG01', 'La Pieta', 'Divers', 'Gregor Podgorski'),
('POMM01', 'Avant la télé', 'Divers', 'Yvan Pommaux'),
('POSA01', 'Cinq mouches bleues', 'Policier', 'Carmen Posadas'),
('POTA01', 'Le Port de la Mer de Glace', 'Divers', 'Dominique Potard'),
('POTO01', 'L''Elu', 'Littérature', 'Chaïm Potok'),
('POUL01', 'Annabel et la Bête', 'Divers', 'Dominique Demers et Stéphane Poulin'),
('POUY01', 'H4 Blues', 'Policier', 'Jean-Bernard Pouy'),
('PRAT01', 'Fable à Venise', 'BD', 'Hugo Pratt'),
('PRAT02', 'Le huitième sortilège', 'SF', 'Terry Pratchett'),
('PRAT04', 'La huitième couleur', 'SF', 'Terry Pratchett'),
('PRER01', 'L''examen de rattrapage ', 'SF', 'Guillaume Prerrie'),
('PRES01', 'Elvis mon amour', 'Essai', 'Priscilla Presley'),
('PULL01', 'A la croisée des mondes', 'Divers', 'Philip Pullman'),
('PULL02', 'A la Croisée des Mondes ', 'SF', 'Philip  Pullman'),
('RAND01', 'la source vive ', 'Littérature', 'Ayn Rand'),
('RANK01', 'L''ombre du tueur', 'Policier', 'Ian Rankin'),
('REDF01', 'La musique des sphères', 'Divers', 'Elizabeth Redfern'),
('REDF02', 'La prophétie des Andes', 'Divers', 'James Redfield'),
('REND01', 'Danger de mort', 'Policier', 'Ruth Rendell'),
('REND02', 'Danger de mort', 'Policier', 'Ruth Rendell'),
('RESC01', 'Esprit Loft 2', 'Divers', 'Jérôme de Vries et Cédric Resche'),
('REVE01', 'L''obsession anti-américaine', 'Essai', 'Jean-Francois Revel'),
('REVE02', 'Le tableau du maïtre flamand', 'Policier', 'Arturo Perez Reverte'),
('REVE03', 'La reine du Sud', 'Policier', 'Arturo Pérez-Reverte'),
('REVE04', 'L''Or du roi', 'Divers', 'Arturo Perez-Reverte'),
('RHOD01', 'Le prince de Central Park', 'Divers', 'Evan H. Rhodes'),
('RICE02', 'Lestat le Vampire', 'SF', 'Anne Rice'),
('ROBE01', 'Cardon (Dessins)', 'Divers', 'Jean Robert'),
('ROBE02', 'Grand livre de la cuisine desserts et patisserie', 'Divers', 'Alain Ducasse et Frédéric Robert'),
('ROBI01', 'L''Atlas mondial du vin', 'Divers', 'Hugh Johnson et Jancis Robinson'),
('ROCH01', 'Les Vautours blancs', 'Policier', 'Jean-Jacques Roche'),
('ROCH02', 'L''esclave de Dieu', 'Divers', 'Roger Frison-Roche'),
('ROEY01', 'Cybersexe', 'Essai', 'Luc Calis, Salvino A. Salvaggio, Sylvie Van Roey'),
('ROJZ01', 'Comment ne pas devenir électeur du Front National', 'Essai', 'Véronoque Le Gouaziou et Charles Rojzman'),
('ROSA01', 'Mon ange', 'Littérature', 'Guillermo Rosales'),
('ROSA02', 'L''espérance autour du monde', 'Divers', 'Christian de Boisredon, Nicolas de Fougeroux et Loïc de Rosanbo'),
('ROUT01', 'L''Ange exterminateur', 'Essai', 'Airy Routier'),
('ROUX01', 'Le Chat qui était Lord', 'Divers', 'Laurent Rouxel'),
('ROWL01', 'Harry Potter ', 'Divers', 'Joanne K. Rowling'),
('ROWL02', 'Harry Potter à l''école des sorciers', 'Divers', 'Joanne K. Rowling'),
('ROWL03', 'Harry Potter et la Coupe de feu', 'Divers', 'Joanne K. Rowling'),
('RUFF01', 'L''Abyssin', 'Divers', 'Jean-Cristophe Ruffin'),
('RUFI01', 'Rouge Brésil', 'Divers', 'Jean-Christophe Rufin'),
('RULE01', 'Sans nouvelles de toi', 'Policier', 'Ann Rule'),
('SA01', 'La joueuse de go', 'Littérature', 'Shan Sa'),
('SA02', 'La joueuse de go', 'Divers', 'Shan Sa'),
('SA03', 'La joueuse de go', 'Divers', 'Shan Sa'),
('SA04', 'Impératrice', 'Divers', 'Shan Sa'),
('SACK01', 'L''homme qui prenait sa femme pour un chapeau ', 'Essai', 'Olivier Sacks'),
('SART01', 'L''existentialisme est un humanisme', 'Essai', 'Jean-Paul Sartre'),
('SATI01', 'A la recherche de Rita Kemper', 'Policier', 'Luna Satie'),
('SATR01', 'Persépolis', 'BD', 'Marjane Satrapi'),
('SATR04', 'Persepolis', 'BD', 'Marjan Satrapi'),
('SAUT01', 'Diamants', 'Divers', 'Hubert Bari et Violaine Sautter'),
('SCHM01', 'Monsieur Ibrahim et les fleurs du Coran', 'Littérature', 'Eric-Emmanuel Schmitt'),
('SCHO01', 'L''aile du papillon', 'Littérature', 'Pierre Schoendoerffer'),
('SCOP01', 'Donato père et fille', 'Policier', 'Sandra Scoppettone'),
('SCOP02', 'Tout ce qui est à toi...', 'Policier', 'Sandra Scoppettone'),
('SEBO01', 'La nostalgie de l''ange', 'Littérature', 'Alice Sebold'),
('SEGU01', 'Un bon petit diable', 'Divers', 'La Comtesse de Ségur'),
('SEGU02', 'Les malheurs de Sophie', 'Divers', 'La Comtesse de Ségur'),
('SEGU03', 'Les petites filles modèles', 'Divers', 'La Comtesse de Ségur'),
('SEIT01', 'Le World Trade Center : une cible monumentale', 'Essai', 'Jean-Yves Andrieux et Frédéric Seitz'),
('SELL01', 'Atlas des peuples d''Orient : Moyen-Orient, Caucase, Asie centrale', 'Divers', 'Jean Sellier et André Sellier'),
('SEPU01', 'Le vieux qui lisait des romans d''amour', 'Littérature', 'Luis SepÃºlveda'),
('SERR01', 'Le Tiers-Instruit', 'Essai', 'Michel Serres'),
('SEWE01', 'Black Beauty', 'Divers', 'Anna Sewell'),
('SFAR02', 'Les Poupées de Jerusalem (Professeur Bell T. 2 )', 'BD', 'Joann Sfar'),
('SHAN01', 'L''aventure des manuscrits de la mer Morte', 'Essai', 'Hershel Shanks'),
('SHIV01', 'Vaincre le stress par le yoga', 'Divers', 'Swami Shivapremananda'),
('SIDD01', 'De l''autre côté de l''ïle', 'Littérature', 'Anne Rivers Siddons'),
('SIGN01', 'Les cailloux bleus', 'Littérature', 'Christian Signol'),
('SIMM01', 'L''Echiquier du mal', 'SF', 'Dan Simmons'),
('SIMM02', 'Le cycle d''Hypérion', 'SF', 'Dan Simmons'),
('SIMO01', 'Le livre de Némo', 'Divers', 'Nicole Bacharan et Dominique Simonnet'),
('SINI01', 'Femmes blafardes', 'Policier', 'Pierre Siniac'),
('SKIN01', 'Le parfum', 'Littérature', 'Patrick SÃ¼skind'),
('SMIT01', 'Sourires de Loup', 'Littérature', 'Zadie Smith'),
('SNIC01', 'Les désastreuses aventures des orphelins Baudelaire', 'Divers', 'Lemony Snicket'),
('SORI01', 'Guide de la littérature pour la jeunesse', 'Divers', 'Marc Soriano'),
('SORT01', 'Imprimatur', 'Divers', 'Rita Monaldi et Francesco Sorti'),
('SOUA02', 'Brûlée vive', 'Essai', 'Souad'),
('SOUA03', 'Brûlée vive', 'Essai', 'Souad'),
('SOUA04', 'Brûlée vive', 'Essai', 'Souad'),
('SPIN01', 'Bleue comme une orange', 'SF', 'Norman Spinrad'),
('SRIE01', 'Légende Indonésienne', 'Littérature', 'Virginie Srienz'),
('STEE02', 'Zoya', 'Divers', 'Danielle Steel'),
('SUSA01', 'Un petit frère pas comme les autres', 'Divers', 'Delval Marie-Hélène et Varley Susan'),
('SVEC01', 'Propriétaires, locataires, les règles du jeu', 'Divers', 'Valérie Svec'),
('SYDR01', 'D''arches, et d''alliances', 'Littérature', 'Carole de Sydrac'),
('TAN01', 'Le club de la chance', 'Littérature', 'Amy Tan'),
('TEND01', 'La quête de l''oiseau du temps', 'BD', 'Régis Loisel et Serge Le Tendre'),
('TEST01', 'Il n''y a pas beaucoup d''étoiles ce soir', 'Littérature', 'Sylvie Testud'),
('THIE01', 'A bout de course', 'Essai', 'Thierry'),
('THIO01', 'Hong Kong story', 'Divers', 'Anne Thiollier'),
('THIR01', 'Hémoglobine blues ', 'Policier', 'Philippe Thirault'),
('THOM01', 'Adieu, Chunky Rice', 'BD', 'Craig Thompson'),
('THOM02', 'Pélagie la sorcière', 'Divers', 'Valérie Thomas'),
('TIRT02', 'Le passeur de lumière', 'Divers', 'Bernard Tirtiaux'),
('TOLE01', 'Archimondain Jolipunk', 'Essai', 'Camille de Toledo'),
('TOLK02', 'Le Silmarillion', 'SF', 'John Ronald Reuel Tolkien'),
('TOSC01', 'La main de Dante', 'Littérature', 'Nick Tosches'),
('TREH01', 'Tahiti, l''Eden à l''épreuve de la photographie', 'Divers', 'Jean-Yves Tréhin'),
('TRIN01', 'Ma fille, Marie', 'Essai', 'Nadine Trintignant'),
('TSHI01', 'L''Internet, son Web et son E-mail en Afrique. Approche critique', 'Essai', 'RaphaÃ«l NTAMBUE-TSHIMBULU'),
('TUIL01', 'Interdit', 'Littérature', 'Karine Tuil'),
('UDAL01', 'Le destin miraculeux d''Edgar Mint', 'Littérature', 'Brady Udall'),
('UTTO01', 'Chhht', 'Divers', 'Salley Grindley et Peter Utton'),
('VACH01', 'Silence', 'Policier', 'Jeanne-Martine Vacher'),
('VARG01', 'Pars vite et reviens tard', 'Policier', 'Fred Vargas'),
('VARG02', 'Pars vite et reviens tard', 'Policier', 'Fred Vargas'),
('VARG03', 'Pars vite et reviens tard', 'Policier', 'Fred Varga'),
('VARG04', 'L''homme à l''envers', 'Policier', 'Fred Vargas'),
('VARG05', 'Debout les morts', 'Policier', 'Fred Vargas'),
('VARG06', 'Pars vite et reviens tard', 'Policier', 'Fred Vargas'),
('VARL01', 'Millénium', 'SF', 'John Varley'),
('VAUT01', 'L''espoir assassiné (Le Cri du Peuple, nÂ°2)', 'BD', 'Tardi et Vautrin'),
('VAUT02', 'Le journal de Louise B.', 'Policier', 'Jean Vautrin'),
('VERL01', 'Balavoine', 'Divers', 'Gilles Verlant'),
('VICH01', 'Sans instructions', 'Essai', 'Laurence Vichnievsky'),
('VINC01', 'Le pape des escargots', 'Divers', 'Henri Vincenot'),
('VINC02', 'Gauguin en Polynésie', 'Divers', 'Emanuelle Baum et Sarah Vincent'),
('VIVA01', 'La Cathédrale au fond du jardin', 'Divers', 'Maxime Vivas'),
('VIVI01', 'Blanc chemin', 'Policier', 'Moor Viviane'),
('VIVI02', 'Rouge sombre', 'Policier', 'Moore Viviane'),
('WAGN01', 'Graine d''ortie', 'Littérature', 'Paul Wagner'),
('WALT02', 'Chambre froide', 'Policier', 'Minette Walters'),
('WERB01', 'Encyclopédie du savoir relatif et absolu', 'Essai', 'Bernard Werber'),
('WERB02', 'Le livre du voyage', 'Littérature', 'Bernard Werber'),
('WERB03', 'Les Thanatonautes', 'SF', 'Bernard Werber'),
('WERB04', 'Les Fourmis', 'SF', 'Bernard Werber'),
('WERB06', 'L''ultime secret', 'SF', 'Bernard Werber'),
('WERB08', 'L''ultime secret', 'SF', 'Bernard Werber'),
('WERB09', 'L''ultime secret', 'SF', 'Bernard Werber'),
('WERB13', 'L''ultime secret', 'SF', 'Bernard Werber'),
('WERB14', 'Les Fourmis', 'SF', 'Bernard Werber'),
('WERB15', 'Les Fourmis ', 'SF', 'Bernard Werber'),
('WEST01', 'Le couperet', 'Policier', 'Donald Edwin Westlake'),
('WILL01', 'Sans parler du chien', 'SF', 'Connie Willis'),
('WILL02', 'Le 5e règne ', 'SF', 'Maxime Williams'),
('WIND01', 'Blanche Neige, rouge sang', 'SF', 'Ellen Datlow et Terry Windling'),
('WINN01', 'Hommage', 'Essai', 'Maurice Winnykamen'),
('WURT01', 'La Trilogie de l''Empire', 'SF', 'Raymond E. Feist et Janny Wurts'),
('XIAO01', 'Mort d''une héroine rouge', 'Policier', 'Qiu Xiaolong'),
('XIAO02', 'Mort d''une héroïne rouge', 'Policier', 'Qiu Xiaolong'),
('YICH01', 'Tête-bêche', 'Littérature', 'Liu Yichang'),
('YOUR01', 'L''Oeuvre au Noir', 'Divers', 'Marguerite Yourcenar'),
('YVEL01', 'Saisons sans voix', 'Divers', 'Stephan Yveline'),
('YVEL02', 'Un voile rouge à la surface des vagues', 'Divers', 'Stephan Yveline'),
('ZELA01', 'Les Neuf Princes d''Ambre', 'SF', 'Roger Zelazny'),
('ZEPE01', 'Les sales coups de la CIA', 'Essai', 'Mark Zepezauer'),
('ZOLA01', 'Au bonheur des dames', 'Littérature', 'Emile Zola'),
('ZOLA02', 'Germinal', 'Littérature', 'Emile Zola');

-- --------------------------------------------------------

--
-- Structure de la table `PRET`
--

CREATE TABLE IF NOT EXISTS `PRET` (
  `COTE` char(6) NOT NULL DEFAULT '',
  `NOLECTEUR` int(11) NOT NULL DEFAULT '0',
  `DATEEMPRUNT` date NOT NULL,
  `DATELIMITE` date NOT NULL,
  `RENDU` char(3) NOT NULL,
  PRIMARY KEY (`COTE`,`NOLECTEUR`),
  KEY `NOLECTEUR` (`NOLECTEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `PRET`
--

INSERT INTO `PRET` (`COTE`, `NOLECTEUR`, `DATEEMPRUNT`, `DATELIMITE`, `RENDU`) VALUES
('CHAT01', 11, '2015-05-03', '2015-06-03', 'non'),
('CHAT01', 12, '2027-09-03', '2027-11-03', 'oui'),
('CHAT02', 11, '2015-05-03', '2015-06-03', 'oui'),
('CHAT02', 12, '2027-09-03', '2027-11-03', 'oui'),
('CHAT03', 11, '2015-05-03', '2015-06-03', 'oui'),
('CHAT03', 12, '2027-09-03', '2027-11-03', 'oui'),
('JOHN01', 2, '2002-04-01', '2002-05-01', 'non'),
('JONQ01', 4, '2019-03-03', '2019-07-03', 'oui'),
('JONQ01', 5, '2019-03-03', '2019-07-03', 'oui'),
('JONQ01', 9, '2019-03-03', '2019-07-03', 'oui'),
('KOUR01', 2, '2002-04-01', '2002-06-01', 'non'),
('LARO01', 5, '0000-00-00', '0000-00-00', 'non'),
('NOTT01', 4, '2013-04-01', '2013-09-01', 'oui'),
('NOTT01', 5, '2013-04-01', '2013-09-01', 'oui'),
('NOTT01', 9, '2013-04-01', '2013-09-01', 'oui'),
('PERR01', 2, '2012-01-03', '2012-03-03', 'oui'),
('PERR02', 2, '2025-02-03', '2025-04-03', 'oui'),
('PERR03', 2, '2025-04-03', '2025-07-03', 'oui'),
('XIAO01', 4, '2025-09-02', '2025-12-02', 'oui'),
('XIAO01', 5, '2025-09-02', '2025-12-02', 'non'),
('XIAO01', 9, '2006-01-04', '2016-02-04', 'oui');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `PRET`
--
ALTER TABLE `PRET`
  ADD CONSTRAINT `PRET_ibfk_1` FOREIGN KEY (`COTE`) REFERENCES `LIVRE` (`COTE`),
  ADD CONSTRAINT `PRET_ibfk_2` FOREIGN KEY (`NOLECTEUR`) REFERENCES `LECTEUR` (`NOLECTEUR`);
--
-- Base de données :  `test_3`
--

-- --------------------------------------------------------

--
-- Structure de la table `COUREUR`
--

CREATE TABLE IF NOT EXISTS `COUREUR` (
  `idc` int(20) NOT NULL DEFAULT '0',
  `nom` varchar(42) DEFAULT NULL,
  `prenom` varchar(42) DEFAULT NULL,
  `temps` time DEFAULT NULL,
  `nationalite` varchar(42) DEFAULT NULL,
  `idteam` int(20) DEFAULT NULL,
  `depuis_quand` date DEFAULT NULL,
  `fin_de_contrat` date DEFAULT NULL,
  PRIMARY KEY (`idc`),
  KEY `idteam` (`idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `COUREUR`
--

INSERT INTO `COUREUR` (`idc`, `nom`, `prenom`, `temps`, `nationalite`, `idteam`, `depuis_quand`, `fin_de_contrat`) VALUES
(1, 'Robin', 'GROSGEAN', '00:00:00', 'France', 1, NULL, NULL),
(2, 'John', 'BALEVEN', '00:00:00', 'Danemark', 2, NULL, NULL),
(3, 'Thierry', 'KONAME', '00:00:00', 'Ethiopie', 5, NULL, NULL),
(5, 'Jean', 'DANIEL', '00:00:00', 'France', 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `DOSSARD`
--

CREATE TABLE IF NOT EXISTS `DOSSARD` (
  `idd` int(20) NOT NULL DEFAULT '0',
  `nom` varchar(42) DEFAULT NULL,
  `couleur` varchar(42) DEFAULT NULL,
  `idc` int(20) DEFAULT NULL,
  PRIMARY KEY (`idd`),
  KEY `idc` (`idc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `DOSSARD`
--

INSERT INTO `DOSSARD` (`idd`, `nom`, `couleur`, `idc`) VALUES
(1, 'Maillot Jaune', 'Jaune', 1),
(2, 'Grimpeur', 'Maillot à pois rouge', 2),
(3, 'Jeune', 'Vert', 3);

-- --------------------------------------------------------

--
-- Structure de la table `EQUIPE`
--

CREATE TABLE IF NOT EXISTS `EQUIPE` (
  `idteam` int(20) NOT NULL DEFAULT '0',
  `nom` varchar(42) DEFAULT NULL,
  `budget` int(20) DEFAULT NULL,
  `score_influence` int(20) DEFAULT NULL,
  PRIMARY KEY (`idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `EQUIPE`
--

INSERT INTO `EQUIPE` (`idteam`, `nom`, `budget`, `score_influence`) VALUES
(1, 'AG2R Citroen Team', 750000, 1500),
(2, 'Astana Qazaqstan Team', 600000, 6000),
(3, 'Bahrain Victorious', 550000, 300),
(4, 'Bora - Hansgrohe', 500000, 400),
(5, 'Cofidis', 400000, 9000),
(6, 'EF Education - Easypost', 1500000, 1500),
(7, 'Groupama - FDJ', 2000000, 6000);

-- --------------------------------------------------------

--
-- Structure de la table `EST_SPONSO_PAR`
--

CREATE TABLE IF NOT EXISTS `EST_SPONSO_PAR` (
  `idteam` int(20) NOT NULL DEFAULT '0',
  `idsponsor` int(20) NOT NULL DEFAULT '0',
  `budget` int(20) DEFAULT NULL,
  PRIMARY KEY (`idteam`,`idsponsor`),
  KEY `idsponsor` (`idsponsor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `EST_SPONSO_PAR`
--

INSERT INTO `EST_SPONSO_PAR` (`idteam`, `idsponsor`, `budget`) VALUES
(1, 1, 40000),
(2, 3, 15000);

-- --------------------------------------------------------

--
-- Structure de la table `ETAPE`
--

CREATE TABLE IF NOT EXISTS `ETAPE` (
  `ide` int(20) NOT NULL DEFAULT '0',
  `distance` int(20) DEFAULT NULL,
  `ville_depart` varchar(42) DEFAULT NULL,
  `ville_arrivee` varchar(42) DEFAULT NULL,
  `typeetape` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`ide`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ETAPE`
--

INSERT INTO `ETAPE` (`ide`, `distance`, `ville_depart`, `ville_arrivee`, `typeetape`) VALUES
(1, 13, 'Copenhague', 'Copenhague', 'CLM'),
(2, 199, 'Roskilde', 'Nyborg', 'PLAT'),
(3, 182, 'Vejle', 'Sonderborg', 'PLAT'),
(4, 172, 'Dunkerque', 'Calais', 'ACCIDENTEE'),
(5, 155, 'Lille Métropole', 'Arenberg Porte du Hainaut', 'ACCIDENTEE'),
(6, 220, 'Binche', 'Longwy', 'ACCIDENTE'),
(7, 176, 'Tomblaine', 'La Super Planche des Belles Filles', 'MONTAGNE'),
(8, 184, 'Dole', 'Lausanne', 'ACCIDENTEE');

-- --------------------------------------------------------

--
-- Structure de la table `PARTICIPE`
--

CREATE TABLE IF NOT EXISTS `PARTICIPE` (
  `idc` int(20) NOT NULL DEFAULT '0',
  `ide` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idc`,`ide`),
  KEY `ide` (`ide`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `SPONSOR`
--

CREATE TABLE IF NOT EXISTS `SPONSOR` (
  `idsponsor` int(20) NOT NULL DEFAULT '0',
  `nom` varchar(42) DEFAULT NULL,
  `reputation` int(20) DEFAULT NULL,
  PRIMARY KEY (`idsponsor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `SPONSOR`
--

INSERT INTO `SPONSOR` (`idsponsor`, `nom`, `reputation`) VALUES
(1, 'Leclerc', 10),
(2, 'Cochonou', 10),
(3, 'Skoda', 8),
(4, 'Orange', 6);

-- --------------------------------------------------------

--
-- Structure de la table `VELO`
--

CREATE TABLE IF NOT EXISTS `VELO` (
  `idv` int(20) NOT NULL DEFAULT '0',
  `prix` int(20) DEFAULT NULL,
  `marque` varchar(42) DEFAULT NULL,
  `type` varchar(42) DEFAULT NULL,
  `idc` int(20) DEFAULT NULL,
  PRIMARY KEY (`idv`),
  KEY `idc` (`idc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `VELO`
--

INSERT INTO `VELO` (`idv`, `prix`, `marque`, `type`, `idc`) VALUES
(1, 5200, 'Cannondale', 'Plat', 1),
(2, 6100, 'Cannondale', 'Montagne', 1),
(3, 4560, 'Cannondale', 'Pavée', 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `COUREUR`
--
ALTER TABLE `COUREUR`
  ADD CONSTRAINT `COUREUR_ibfk_1` FOREIGN KEY (`idteam`) REFERENCES `EQUIPE` (`idteam`);

--
-- Contraintes pour la table `DOSSARD`
--
ALTER TABLE `DOSSARD`
  ADD CONSTRAINT `DOSSARD_ibfk_1` FOREIGN KEY (`idc`) REFERENCES `COUREUR` (`idc`);

--
-- Contraintes pour la table `EST_SPONSO_PAR`
--
ALTER TABLE `EST_SPONSO_PAR`
  ADD CONSTRAINT `EST_SPONSO_PAR_ibfk_2` FOREIGN KEY (`idteam`) REFERENCES `EQUIPE` (`idteam`),
  ADD CONSTRAINT `EST_SPONSO_PAR_ibfk_1` FOREIGN KEY (`idsponsor`) REFERENCES `SPONSOR` (`idsponsor`);

--
-- Contraintes pour la table `PARTICIPE`
--
ALTER TABLE `PARTICIPE`
  ADD CONSTRAINT `PARTICIPE_ibfk_2` FOREIGN KEY (`idc`) REFERENCES `COUREUR` (`idc`),
  ADD CONSTRAINT `PARTICIPE_ibfk_1` FOREIGN KEY (`ide`) REFERENCES `ETAPE` (`ide`);

--
-- Contraintes pour la table `VELO`
--
ALTER TABLE `VELO`
  ADD CONSTRAINT `VELO_ibfk_1` FOREIGN KEY (`idc`) REFERENCES `COUREUR` (`idc`);
--
-- Base de données :  `test_php`
--

-- --------------------------------------------------------

--
-- Structure de la table `ANIMAL`
--

CREATE TABLE IF NOT EXISTS `ANIMAL` (
  `aniCode` varchar(5) NOT NULL,
  `aniCateg` varchar(1) NOT NULL,
  `aniNom` varchar(50) NOT NULL,
  `aniAge` int(11) NOT NULL,
  `aniPoids` float NOT NULL,
  `aniTatouage` varchar(8) NOT NULL,
  `aniMaitre` varchar(5) NOT NULL,
  PRIMARY KEY (`aniCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ANIMAL`
--

INSERT INTO `ANIMAL` (`aniCode`, `aniCateg`, `aniNom`, `aniAge`, `aniPoids`, `aniTatouage`, `aniMaitre`) VALUES
('A05', 'C', 'Tine', 3, 2.3, 'CF432', ''),
('A14', 'D', 'Milou', 7, 6.5, 'WX543', 'M42'),
('B26', 'D', 'Rex', 5, 8.4, 'VF982', 'M54'),
('C45', 'D', 'DogA', 3, 24.2, 'GT543', 'M66'),
('J08', 'D', 'Loup', 6, 16.7, 'HY765', ''),
('V17', 'B', 'Lili', 2, 0.6, '', 'M08');

-- --------------------------------------------------------

--
-- Structure de la table `CATEGORIE`
--

CREATE TABLE IF NOT EXISTS `CATEGORIE` (
  `categCode` varchar(5) NOT NULL,
  `categNom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `CATEGORIE`
--

INSERT INTO `CATEGORIE` (`categCode`, `categNom`) VALUES
('B', 'oiseau'),
('C', 'chat'),
('D', 'chien'),
('R', 'reptile');

-- --------------------------------------------------------

--
-- Structure de la table `MAITRE`
--

CREATE TABLE IF NOT EXISTS `MAITRE` (
  `maitreCode` varchar(5) NOT NULL,
  `maitreNom` varchar(50) NOT NULL,
  `maitrePrenom` varchar(50) NOT NULL,
  `maitreAdresse` varchar(100) NOT NULL,
  `maitreCpostal` int(5) NOT NULL,
  `maitreVille` varchar(50) NOT NULL,
  PRIMARY KEY (`maitreCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `MAITRE`
--

INSERT INTO `MAITRE` (`maitreCode`, `maitreNom`, `maitrePrenom`, `maitreAdresse`, `maitreCpostal`, `maitreVille`) VALUES
('M08', 'SANSET', 'Laurent', '7 impasse LANNY', 80002, 'CAGNY'),
('M42', 'TINTIN', 'Franck', 'Place Rochefort', 62100, 'ARRAS'),
('M54', 'LARRAUD', 'Alexis', '4 rue de lEst', 59020, 'LILLE'),
('M66', 'SYLVAIN', 'Luc', '19 rue de Lesquin', 59020, 'LILLE'),
('M98', 'PETER', 'John', '65 Bd V. Hugo', 59033, 'MAING');
--
-- Base de données :  `test_pw`
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
