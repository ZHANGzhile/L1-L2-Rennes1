<?php
session_start();
require_once "db.php";
    $Id_user = $_SESSION['id'];

    $req = $bd->prepare('SELECT * FROM favoris WHERE id_users=' . $Id_user);
    $req->execute();
    $res = $req -> fetchAll();
    $req->closeCursor();
    if(!empty($res)){
    $req = $bd->prepare('DELETE  FROM favoris WHERE id_users=' . $Id_user);
    $req->execute();
    $req->closeCursor();
    }
    foreach ($_SESSION['favoris'] as  $fav) {
        $ajout = "INSERT INTO favoris (id_users,id_annonce) VALUES (:id_users , :id_annonce)";
        if ($sel = $bd->prepare($ajout)) {
            $annonId = $fav['annonceId'];
            $userId = $Id_user;
            $sel->bindParam(":id_users", $userId);
            $sel->bindParam(":id_annonce",$annonId);
 
            if ($sel->execute()) {
                header("location: index.php");
            } else {
                echo " il ya quelque probleme merci d'attendre.";
            }      
            unset($stmt);        
        }
        unset($sql);
}
header('location: index.php');
?>