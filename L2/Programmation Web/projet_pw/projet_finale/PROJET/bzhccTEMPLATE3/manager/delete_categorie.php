<?php
include_once("../db.php");

$id = "";
$msg="";
  
    if (isset($_GET["id"])) {
        $id = $_GET["id"];
    }


    if(!empty($id)){

        $sql = 'DELETE FROM categories WHERE id='.$id;

 
    $bd -> exec($sql);

    header('location: list_categories.php?msg=yes');
  
    unset($bd);   
    }
    


?>