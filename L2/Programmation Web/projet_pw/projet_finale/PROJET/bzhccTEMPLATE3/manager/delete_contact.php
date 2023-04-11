<?php
include_once("../db.php");

$id = "";
$msg="";
  
    if (isset($_GET["id"])) {
        $id = $_GET["id"];
    }

  
    if(!empty($id)){
 
        $sql = 'DELETE FROM contact WHERE idcontact='.$id;

 
    $bd -> exec($sql);

    header('location: list_contacts.php?msg=yes');

        
    unset($bd);   
    }
    


?>