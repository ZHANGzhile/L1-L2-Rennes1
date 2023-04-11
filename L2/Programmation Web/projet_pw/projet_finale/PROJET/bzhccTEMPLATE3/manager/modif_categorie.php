<?php
include_once("../db.php");
include("inc/top.php");

$name = $id = "";
$msg="";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
   
    if (isset($_POST["name"])) {
        $name = $_POST["name"];
    }
   
    if (isset($_POST["id"])) {
        $id = $_POST["id"];
    }

    if(isset($name) && isset($id)){
   
        $sql = 'UPDATE categories SET NAME=:name WHERE id=:id';


        if ($stmt = $bd->prepare($sql)) {

            $stmt->bindParam(":name", $param_name, PDO::PARAM_STR);
            $stmt->bindParam(":id", $param_id, PDO::PARAM_STR);
            
      
            $param_id = $id;
            $param_name = $name;


            if ($stmt->execute()) {
   
                $msg = 'SUCCESSFULLY Updated !';
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
        <div class="card mb-4"></div>

        <div class="card mb-4">
            <div class="card-body">
                <?php 
                if(!empty($msg)){
                    echo $msg;
                }else{
                    echo 'Message de l\'action' ;
                }
                ?>
            </div>
        </div>
        <div class="card mb-4">

        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Catégories
            </div>
            <div class="card-body">
               
                        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]) ?>" method="post" >
                                <input name="id" type="hidden" value="<?php 
                                if(isset($_GET['id'])) {
                                    echo $_GET['id'] ;
                                }else {
                                    echo 'none';
                                } ?>">
                                <input name="name" type="text" class="textbox">
                                <input type="submit" value="Submit">
                        </form>
                
            </div>
        </div>
    </div>
</main>

<!-- fin contenu -->


<?php
include("inc/bottom.php");
?>