<?php
include_once("../db.php");

$id = "";
$msg="";
    // Validate id
    if (isset($_GET["id"])) {
        $id = $_GET["id"];
    }
    $req = $bd->prepare("SELECT * FROM annonces WHERE id_users 	=$id");
    $req->execute();
    $allAnn = $req->fetchAll();
    $req->closeCursor();

    foreach ($allAnn as $key => $value) {
        $req =$bd -> prepare('UPDATE annonces SET id_users 	=0');
        $req -> execute();
        $req -> closeCursor();
    }
 
    if(!empty($id)){
      
        $sql = 'DELETE FROM users WHERE id='.$id;

       
    $bd -> exec($sql);
   
    header('location: list_membres.php?msg=yes');

        
    unset($bd);   
    }
    


?>