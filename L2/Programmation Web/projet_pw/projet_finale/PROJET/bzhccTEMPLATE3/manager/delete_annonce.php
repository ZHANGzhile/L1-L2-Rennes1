<?php
include_once("../db.php");

$id = "";
$msg="";
    // Validate id
    if (isset($_GET["id"])) {
        $id = $_GET["id"];
    }




    if(!empty($id)){

        $sql = 'DELETE FROM annonces WHERE annonceId='.$id;

    
    $bd -> exec($sql);
 
    header('location: list_annonces.php?msg=yes');

        
    unset($bd);   
    }
    


?>