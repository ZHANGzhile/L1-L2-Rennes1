<?php
include_once("../db.php");
include("inc/top.php");

$req = $bd -> prepare("SELECT id,nom FROM users");
$req -> execute();
$resultatsFromUsers = $req->fetchAll();
$req -> closeCursor(); 


$name  = "";
$msg="";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["name"])) {
        $name = $_POST["name"];
    }


    if(isset($name) ){
        
        $sql ='UPDATE users SET isadmin=1  WHERE id= :name ';
   

        if ($stmt = $bd->prepare($sql)) {

            $stmt->bindParam(":name", $param_name);
            
    
           $param_name = $name;

   
            if ($stmt->execute()) {
             
                $msg = ' ADMIN SUCCESSFULLY Added !';
            } else {
                echo "Oops! Something went wrong. Please try again later.";
            }

        
            unset($stmt);
        }
     unset($bd);   
    }
    
}

?>



<!--  debut contenu -->
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Admins</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="index.php">Dashboard</a></li>
            <li class="breadcrumb-item active">Admins</li>
        </ol>
        <div class="card mb-4">
            <div class="card-body">
                <?php
                if (!empty($msg)) {
                    echo $msg;
                } else {
                    echo 'Message de l\'action';
                }
                ?>
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Ajouter un admin
            </div>
            <div class="card-body">
                <table>
                <thead>
                        <tr>
                                <th>Nom</th>                                
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]) ?>" method="post">
                                <td>
                                    <select name="name">
                                        <?php
                                            foreach ($resultatsFromUsers as $key => $value) {
                                                # code...?>
                                                <option value="<?php echo $value['id'] ?>"><?php echo $value['nom'] ?></option>
                                            <?php }
                                        ?>
                                    </select>
                            </td>
                               
                                <td><input type="submit" name="" value="Ajouter" /></td>
                            </form>
                        </tr>
                    </tbody>


                </table>
            </div>
        </div>
    </div>
</main>

<!-- fin contenu -->


<?php
include("inc/bottom.php");
?>