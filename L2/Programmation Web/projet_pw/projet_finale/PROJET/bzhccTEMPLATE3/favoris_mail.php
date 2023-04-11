<?php
session_start();
require("sendgrid/sendgrid-php.php");
include("inc/top.php");
$SENDGRID_API_KEY = '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';
$site = file_get_contents("favoris.php");

$str= "";
foreach ($_SESSION['favoris'] as $key => $value) {

  $str.=  '<div class="ser-grid-list" style="padding-left:1em;">
    <h5>'. $value['title'].'   </h5>
    <img src="images/'.$value['image'].'" alt="" width="150" height="120">
    <p> '. $value['description'].'</p>
    <div class="clear"></div>'; 
}

$va = '
<html>
<head>
  <title>Favs</title>
</head>
<body>
<div class="main">
<div class="ser-main">   
       ' . $strl . '
</div
<div class="clear"></div>

</body>
</html>
';
?>
<?php

if (!isset($_POST["submit"])) {

?>

    <div class="col span_2_of_4">
        <div class="contact-form">
            <form method="post" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
              To  : <input type="text" name="envoyer"><br>
                <input type="submit" name="submit" value="envoyez par mail">
            </form>
        </div>
    </div>
        <?php
    } else {

        if (isset($_POST['envoyer'])) {
            $env      = $_POST['envoyer'];
            $subject = 'Sending favoris';
            $message = $va;

            $email = new \SendGrid\Mail\Mail();
            $email->setFrom("ilyes.sais@etudiant.univ-rennes1.fr", "ilyes");
            $email->setSubject("Used Sengrid for this");
            $email->addTo($env, "From $env");
            $email->addContent("text/plain", "and easy to do anywhere, even with PHP");
            $email->addContent(
                "text/html",
                $message
            );
            $sendgrid = new SendGrid($SENDGRID_API_KEY);
            try {
                $response = $sendgrid->send($email);
                header('location: favoris.php');
            } catch (Exception $e) {
                echo 'Caught exception: ' . $e->getMessage() . "\n";
            }
        }
    }
      
   
    ?>