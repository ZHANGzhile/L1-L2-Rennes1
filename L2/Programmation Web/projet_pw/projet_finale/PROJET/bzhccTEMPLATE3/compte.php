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

<!-- debut de la partie contenu -->
<div class="main">
    <div class="register">
        <?php
        echo
        $chaine=   $_SERVER["PHP_SELF"];
        '<form action="'. htmlspecialchars($chaine, ENT_COMPAT).'" method="post">';
        ?>
            <div class="register-top-grid">
                <h3>Vos informations</h3>
                <div>
                    <span>Prénom<label>*</label></span>
                    <input type="text" name="prenom" placeholder="<?php echo $_SESSION['prenom'] ?>">
                </div>
                <div>
                    <span>Nom<label>*</label></span>
                    <input type="text" name="nom" placeholder="<?php echo $_SESSION['nom'] ?>">
                </div>
                <div>
                    
                    <span>Email<label>*</label></span>
                    <input type="text" name="mail" class="form-control <?php echo (!empty($err_mail)) ? 'is-invalid' : ''; ?>" value="<?php echo $mail; ?>">
                    <span class="invalid-feedback"><?php echo $err_mail; ?></span>
                </div>
                <div class="clear"> </div>
                <a class="news-letter" href="#">
                    <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>S'inscrire à la neswletter</label>
                </a>
            </div>
            <div class="register-bottom-grid">
                <h3>Pour vous authentifier</h3>
                <div>
                    <span>Password<label>*</label></span>
                    <input type="password" name="password" placeholder="New password" class="form-control <?php echo (!empty($err_password)) ? 'is-invalid' : ''; ?>" value="<?php echo $password; ?>">
                    <span class="invalid-feedback"><?php echo $err_password; ?></span>
                </div>
                <div>
                    <span>Retapez votre Password<label>*</label></span>
                    <input type="password" placeholder="Confirm votre mot de passe" name="confirm_password" class="form-control <?php echo (!empty($err_autrepassword)) ? 'is-invalid' : ''; ?>" value="<?php echo $autre_password; ?>">
                    <span class="invalid-feedback"><?php echo $err_autrepassword; ?></span>
                </div>
                <div class="clear"> </div>
            </div>
            <div class="clear"> </div>
            <div class="register-but">
                <input type="submit" class="btn btn-primary" value="Submit" style="background-color: blue 
                    border: none;
                    color: white;
                    padding: 15px 32px;
                    text-align: center;
                    text-decoration: none;
                    display: inline-block;
                    font-size: 16px;">
                <div class="clear"> </div>
        </form>

        <div class="clear"></div>

        <button style="color:white;border:none;text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;" >
         <a href="enrg_favori.php" target="_self" style="color:red;">   sauvgarder les favoris</a></button>
    </div>
</div>
<div class="clear"></div>
</div>
<!-- fin de la partie contenu -->

<?php
include("inc/bottom.php");
?>