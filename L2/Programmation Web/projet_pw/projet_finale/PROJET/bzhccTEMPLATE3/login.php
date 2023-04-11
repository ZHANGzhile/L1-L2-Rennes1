<?php
session_start();
include("inc/top.php");
require_once "db.php";

if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: index.php");
    exit;
}
$username = $password = "";
$username_err = $password_err = $login_err = "";
 
  
if($_SERVER["REQUEST_METHOD"] == "POST"){
    if(empty(trim($_POST["mail"]))){
        $username_err = "Please enter email.";
    } else{
        $mail = trim($_POST["mail"]);
    }
    
 
    if(empty(trim($_POST["password"]))){
        $password_err = "Please enter your password.";
    } else{
        $password = trim($_POST["password"]);
    }
    
   
    if(empty($username_err) && empty($password_err)){
      
        $sql = "SELECT id,nom,prenom, mail, password ,admin FROM users WHERE mail = :mail";
        
        if($req = $bd->prepare($sql)){
    
            $req->bindParam(":mail", trim($_POST["mail"]));
            
            

            if($req->execute()){
                if($req->rowCount() == 1){
                    if($row = $req->fetch()){
                        $id = $row["id"];
                        $mail = $row["mail"];
						$name = $row["nom"];
						$prenom = $row["prenom"];
                        $hashed_password = $row["password"];
                        if(password_verify($password, $hashed_password)){    
                            session_start();
                            $_SESSION["loggedin"] = true;
                            $_SESSION["id"] = $id;
                            $_SESSION["nom"] = $name; 
							$_SESSION["prenom"]= $prenom;
                            if($row['admin']== 1 ){
                                $_SESSION['admin']=true;
                            }
                            
                            
                            header("location: index.php");
                        } else{
                            
                            $login_err = "Invalid username or password.";
                        }
                    }
                } else{
                   
                    $login_err = "Invalid username or password.";
                }
            } else{
                echo "Oops! Something went wrong. Please try again later.";
            }

         
            unset($req);
        }
    }
    unset($bd);
	}

?>

<!-- debut de la partie contenu -->
<div class="main">

		<div class="register">
			   <div class="col_1_of_list span_1_of_list login-left">
			  	 <h3>Nouveau membre</h3>
				 <p>En créant un compte, vous pourrez créer des annonces</p>
				 <a class="acount-btn" href="sinscrire.php">Créer un compte</a>
			   </div>
			   <div class="col_1_of_list span_1_of_list login-right">
			  	<h3>Déja membre ?</h3>
				<p>Si vous avez déja un compte, merci de vous connecter</p>
				<?php 
				if(!empty($login_err)){
					echo '<div class="alert alert-danger">' . $login_err . '</div>';
				}        
				?>
				<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
				  <div>
					<span>Adresse email<label>*</label></span>
					<input type="text" name="mail"> 
				  </div>
				  <div>
					<span>Mot de passe<label>*</label></span>
					<input type="password" name ="password"> 
				  </div>
				  <a class="forgot" href="#">Mot de passe oublié</a>
				  <input type="submit" value="Login">
			    </form>
			   </div>	
			   <div class="clearfix"> </div>
		
	</div>
  <div class="clear"></div>
</div><!-- fin de la partie contenu -->

<?php
include("inc/bottom.php");
?>