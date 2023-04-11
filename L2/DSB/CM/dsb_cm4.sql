

-- --------------------------------------------------------

--
-- Table structure for table `COMMANDES`
--

CREATE TABLE `COMMANDES` (
  `NUM` varchar(1) NOT NULL,
  `CNOM` varchar(7) DEFAULT NULL,
  `PNOM` varchar(8) DEFAULT NULL,
  `QUANTITE` int(2) DEFAULT NULL
) ;

--
-- Dumping data for table `COMMANDES`
--

INSERT INTO `COMMANDES` (`NUM`, `CNOM`, `PNOM`, `QUANTITE`) VALUES
('1', 'Jean', 'briques', 5),
('2', 'Jean', 'ciment', 10),
('3', 'Paul', 'briques', 3),
('4', 'Paul', 'parpaing', 9),
('5', 'Vincent', 'parpaing', 7);

-- --------------------------------------------------------

--
-- Table structure for table `FOURNISSEUR`
--

CREATE TABLE `FOURNISSEUR` (
  `FNOM` varchar(20) NOT NULL,
  `VILLE` varchar(20) DEFAULT NULL
) ;

--
-- Dumping data for table `FOURNISSEUR`
--

INSERT INTO `FOURNISSEUR` (`FNOM`, `VILLE`) VALUES
('Lulu', NULL),
('Marco', 'Marseille'),
('Toto', 'Paris');

-- --------------------------------------------------------

--
-- Table structure for table `FOURNISSEUR1`
--

CREATE TABLE `FOURNISSEUR1` (
  `FNOM` varchar(20) NOT NULL,
  `VILLE` varchar(20) DEFAULT NULL
) ;

--
-- Dumping data for table `FOURNISSEUR1`
--

INSERT INTO `FOURNISSEUR1` (`FNOM`, `VILLE`) VALUES
('Lulu', NULL),
('Marco', 'Marseille'),
('Toto', 'Paris');

-- --------------------------------------------------------

--
-- Table structure for table `FOURNISSEUR2`
--

CREATE TABLE `FOURNISSEUR2` (
  `FNOM` varchar(20) NOT NULL,
  `VILLE` varchar(20) DEFAULT NULL
) ;

--
-- Dumping data for table `FOURNISSEUR2`
--

INSERT INTO `FOURNISSEUR2` (`FNOM`, `VILLE`) VALUES
('Dupond', 'Paris'),
('Durand', 'Lyon'),
('Lucien', 'Lyon'),
('Remi', 'Lyon'),
('Toto', 'Paris');

-- --------------------------------------------------------

--
-- Table structure for table `FOURNITURE`
--

CREATE TABLE `FOURNITURE` (
  `FNOM` varchar(20) NOT NULL,
  `PNOM` varchar(20) NOT NULL,
  `PRIX` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `FOURNITURE`
--

INSERT INTO `FOURNITURE` (`FNOM`, `PNOM`, `PRIX`) VALUES
('Abounayan', 'briques', '1500'),
('Abounayan', 'sable', '300'),
('Preblocs', 'parpaing', '1200'),
('Sarnaco', 'ciment', '125'),
('Sarnaco', 'parpaing', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `FOURNITURE1`
--

CREATE TABLE `FOURNITURE1` (
  `FNOM` varchar(20) NOT NULL,
  `PNOM` varchar(20) NOT NULL,
  `PRIX` varchar(4) DEFAULT NULL
) ;

--
-- Dumping data for table `FOURNITURE1`
--

INSERT INTO `FOURNITURE1` (`FNOM`, `PNOM`, `PRIX`) VALUES
('Abounayan', 'briques', '1500'),
('Abounayan', 'sable', '300'),
('Preblocs', 'parpaing', '1200'),
('Sarnaco', 'ciment', '125'),
('Sarnaco', 'parpaing', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `FOURNITURE2`
--

CREATE TABLE `FOURNITURE2` (
  `FNOM` varchar(20) NOT NULL,
  `PNOM` varchar(20) NOT NULL,
  `PRIX` varchar(4) DEFAULT NULL
) ;

--
-- Dumping data for table `FOURNITURE2`
--

INSERT INTO `FOURNITURE2` (`FNOM`, `PNOM`, `PRIX`) VALUES
('Abounayan', 'briques', '1500'),
('Abounayan', 'sable', '300'),
('Durand', 'ardoise', '120'),
('Lucien', 'ardoise', '110'),
('Preblocs', 'parpaing', '1200'),
('Sarnaco', 'ciment', '125'),
('Sarnaco', 'parpaing', NULL),
('Toto', 'briques', '105');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `COMMANDES`
--
ALTER TABLE `COMMANDES`
  ADD PRIMARY KEY (`NUM`);

--
-- Indexes for table `FOURNISSEUR`
--
ALTER TABLE `FOURNISSEUR`
  ADD PRIMARY KEY (`FNOM`);

--
-- Indexes for table `FOURNISSEUR1`
--
ALTER TABLE `FOURNISSEUR1`
  ADD PRIMARY KEY (`FNOM`);

--
-- Indexes for table `FOURNISSEUR2`
--
ALTER TABLE `FOURNISSEUR2`
  ADD PRIMARY KEY (`FNOM`);

--
-- Indexes for table `FOURNITURE`
--
ALTER TABLE `FOURNITURE`
  ADD PRIMARY KEY (`FNOM`,`PNOM`);

--
-- Indexes for table `FOURNITURE1`
--
ALTER TABLE `FOURNITURE1`
  ADD PRIMARY KEY (`FNOM`,`PNOM`);

--
-- Indexes for table `FOURNITURE2`
--
ALTER TABLE `FOURNITURE2`
  ADD PRIMARY KEY (`FNOM`,`PNOM`);


