<?php
session_start();
include_once("../db.php");
include("inc/top.php");

$req = $bd->prepare("SELECT id, nom FROM users");
$req->execute();
$users = $req->fetchAll();
$req->closeCursor();

$msg="";

$desc = $title = $price = $categorie = "";
$desc_err = $title_err = $price_err = $categorie_err = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["description"])) {
        $desc_err = "Please enter a description";
    } else {
        $desc = $_POST["description"];
    }
    if (empty($_POST["title"])) {
        $title_err = "Please enter a title.";
    } else {
        $title = $_POST["title"];
    }
    if (empty($_POST["cate"])) {
        $categorie_err = "Please Select a Categorie.";
    } else {
        $categorie = $_POST["cate"];
    }
    if (empty($_POST["price"])) {
        $price_err = "Please Enter a Price.";
    } else {
        $price = $_POST["price"];
    }
    if(!empty($_POST["createdby"])){
        $created = $_POST["createdby"];
    }
    

    if (empty($desc_err) && empty($title_err) && empty($price_err) ) {

        $image = file_get_contents($_FILES['image']['tmp_name']);
        $sql = 'INSERT INTO annonces (title , price,image,description, categorie ,id_users 	) VALUES (:title , :price , :image ,:descr, :categorie , :id_users 	 )';


        if ($stmt = $bd->prepare($sql)) {
           
            $stmt->bindParam(":descr", $param_desc);
            $stmt->bindParam(":price", $param_price);
            $stmt->bindParam(":categorie", $param_categorie);
            $stmt->bindParam(":title", $param_title);
            $stmt->bindParam(":image", $param_image);
            $stmt->bindParam(":id_users", $param_uid);


          
            
          
            $param_image = $image;
            $param_uid = $created;
            $param_desc = $desc;
            $param_price = $price;
            $param_categorie = $categorie;
            $param_title = $title;


      
            if ($stmt->execute()) {
              
                $msg = 'SUCCESSFULLY Added ' .$title . ' !';
            } else {
                $msg= "Oops! Something went wrong. Please try again later.";
            }

          
            unset($stmt);
        }
    
    }
    
}
?>



<!--  debut contenu -->
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Annonces</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="index.php">Dashboard</a></li>
            <li class="breadcrumb-item active">Annonces</li>
        </ol>
        <div class="card mb-4">
            <div class="card-body">
                <?php
                if (!empty($msg)) {
                    echo $msg;
                } else {
                    echo "Message de l'action";
                }
                ?>
            </div>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Ajouter une annonce
            </div>
            <div class="card-body">
                <table>

                    <tbody>
                        
                            <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]) ?>" method="post" enctype="multipart/form-data">
                            <tr>
                                <td>Title : </td>
                                <td></td>
                                <td><input name="title" type="text" class="textbox"> </td>
                            </tr>
                            <tr>
                                <td>Price : </td><td></td>
                                <td><input name="price" type="number" class="textbox"> </td>
                            </tr>
                            <tr>
                                <td>Description : </td>
                                <td></td>
                                <td><textarea name="description"> </textarea> </td>
                            </tr>
                            <tr>
                                <td>Catégorie : </td>
                                <td></td>
                                <td>
                                <select class="custom-select" id="select-1" name="cate">
                                    <?php
                                    foreach ($_SESSION['categories'] as $key => $value) {
                                    ?>
                                        <option value="<?php echo getCategorieId($value[0]); ?>"><?php echo $value[0]; ?></option>
                                    <?php }
                                    ?>
                                </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Créer par : </td>
                                <td></td>
                                <td>
                                <select class="custom-select" id="select-1" name="createdby">
                                    <?php
                                    foreach ($users as $key => $value) {
                                    ?>
                                        <option value="<?php echo $value['id']; ?>"><?php echo $value['nom']; ?></option>
                                    <?php }
                                    ?>
                                </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Image : </td><td></td>
                                <td><input type="file" name="image"> </td>
                            </tr>
                            <tr>
                                <td>  </td>
                                <td> </td>
                                <td><input type="submit" value="Submit"></td>
                            </tr>
                            </form>
                        
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