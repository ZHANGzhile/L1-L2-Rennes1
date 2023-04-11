
CREATE TABLE IF NOT EXISTS `EMPLOYE` (`EMPNO` int(2), `ENOM` varchar(15), `SAL` int(5), `DEPNO` int(2)) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
INSERT INTO `EMPLOYE`  VALUES 
 (10, 'Joe',   4000,  3),
 (20, 'Jack',  3000,  2),
 (30, 'Jim',  5000,   1),
 (40, 'Lucy',  5000,  3);
INSERT  INTO `EMPLOYE`  VALUES 
 (50, 'AjoutPourCasNull', NULL, 3);
 
