<?php

session_start();
unset($_SESSION['loggedin']);
unset($_SESSION['id']);
unset($_SESSION['nom']);
if(isset($_SESSION['adminin'])){
    unset($_SESSION['adminin']);
}
header("location: index.php");
exit;
?>