CREATE TABLE IF NOT EXISTS `DEPT` (`DEPNO` int(1), `DNOM` varchar(5)) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;# MySQL a retourné un résultat vide (aucune ligne).
INSERT INTO `DEPT` (`DEPNO`, `DNOM`) VALUES (1, 'Comm.'),
 (2, 'Adm.'),
 (4, 'Tech.');# 3 lignes affectées.
