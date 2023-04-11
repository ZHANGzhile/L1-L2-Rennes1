<?php
session_start();
include("inc/top.php");
require_once "db.php";


//declarer les variable en string
$mail = $password = $autre_password = $nom = $prenom = "";
$err_mail = $err_password = $err_autrepassword = "";


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $pattern = "/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,})$/i";
    if (empty(trim($_POST["mail"]))) {
        $err_mail = "entrer votre e-mail.";
    } elseif (!preg_match($pattern, trim($_POST["mail"]))) {
        $err_mail = "mail il peut contenir juste numero ,caractere.";
    }
    if (isset($_POST["mail"])) {
        $mail = trim($_POST["mail"]);
    }
    if (isset($_POST["nom"])) {
        $nom = trim($_POST["nom"]);
    }
    if (isset($_POST["prenom"])) {
        $prenom = trim($_POST["prenom"]);
    }
    if (empty(trim($_POST["password"]))) {
        $err_password = "Please enter a password.";
    } elseif (strlen(trim($_POST["password"])) < 6) {
        $password_err = "le mot de passe il doit avoir plus 8 caractere.";
    } else {
        $password = trim($_POST["password"]);
    }
    if (empty(trim($_POST["confirm_password"]))) {
        $err_autrepassword = "confirmer vote mot de passe.";
    } else {
        $autre_password = trim($_POST["confirm_password"]);
        if (empty($err_password) && ($password != $autre_password)) {
            $err_autrepassword = "si pas le meme mot de passe.";
        }
    }


    if (empty($err_mail) && empty($err_password) && empty($err_autrepassword)) {
        $sql = 'UPDATE users SET nom=:nom,prenom=:prenom,mail=:mail,password=:password WHERE id=' . $_SESSION["id"];
        if ($req = $bd->prepare($sql)) {
            $param_mail = $mail;
            $param_nom = $nom;
            $param_prenom = $prenom;
            $param_password = password_hash($password, PASSWORD_DEFAULT); 
            $req->bindParam(":mail", $mail);
            $req->bindParam(":nom", $nom);
            $req->bindParam(":prenom", $prenom);
            $req->bindParam(":password", $param_password);

            if ($req->execute()) {
                session_start();
                unset($_SESSION["nom"]);
                unset($_SESSION["prenom"]);
                $_SESSION["nom"] = $nom;
                $_SESSION["prenom"] = $prenom;
                header("location: index.php");
            } else {
                echo "probleme de connecter";
            }
            unset($req);}}
             unset($bd);}
?>
