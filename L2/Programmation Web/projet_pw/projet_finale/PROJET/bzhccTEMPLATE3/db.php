<?php 

$server = "localhost";
$login = "root";
if (strtoupper(substr(PHP_OS, 0, 3)) === 'WIN') {
	$pass = "";
} else {
	$pass = "root";
}

try{
    $bd = new PDO("mysql:host=" . $server . ";dbname=test" , $login, $pass);
    $bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch(PDOException $e){
    die("error de connexion. " . $e->getMessage());
}
function getCategorieId($cat){
    global $bd;
    $requete = $bd-> prepare('SELECT id FROM categories WHERE NAME="'.$cat.'"');
    $requete -> execute();
    return $requete ->fetch()[0];
}
function getCategorieName($cat){
    global $bd;
    $requete = $bd-> prepare('SELECT NAME FROM categories WHERE id="'.$cat.'"');
    $requete -> execute();
    return $requete ->fetch()[0];
}
    

?>
