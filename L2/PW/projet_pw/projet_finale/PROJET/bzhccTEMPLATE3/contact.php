<?php
require_once("db.php");
session_start();
include("inc/top.php");

$mail = $telephone = $nom  = $message =  "";
$adresse="1 allee du gacet";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if (!empty($_POST["userEmail"])) {
		$mail = $_POST['userEmail'];	
	} 
	if (!empty($_POST["userName"])) {
		$nom = $_POST['userName'];	
	} 
	if (!empty($_POST["userPhone"])) {
		$telephone = $_POST['userPhone'];	
	} 
	if (!empty($_POST["userMsg"])) {
		$message = $_POST['userMsg'];	
	} 
	if (!empty($mail) && !empty($nom) && !empty($telephone) && !empty($message)) {
		$sql = "INSERT INTO contact (nom , email,telephone, message) VALUES (:nom , :email , :telephone , :message)";
		if ($req = $bd->prepare($sql)) {
			$req->bindParam(":email", $mail);
			$req->bindParam(":nom", $nom);
			$req->bindParam(":telephone", $telephone);
			$req->bindParam(":message", $message);

			if ($req->execute()) {
				header("location: index.php");
			} else {
				echo "il ya un probleme!!!.";
			}
			unset($req);
		}
	}

	unset($bd);
}
?>

<!-- debut de la partie contenu -->
<div class="main">
<div class="section group">				
				<div class="col span_1_of_2">
					<div class="contact_info">
			    	 	<h3>Nous trouver</h3>
			    	 		<div class="map">
					   		<iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=<?php echo $adresse ?>&amp;output=embed">
							</iframe>
							<br><small>
							<a href="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=<?php echo $adresse ?>&amp;output=embed" style="color: rgba(180, 192, 21, 0.71);;text-align:left;font-size:12px">View Larger Map</a></small>
					   		</div>
      				</div>
      			<div class="company_address">
				     	<h3>Nous situer</h3>
						<p>	7 Avenue Carnot</p>
						<p>75017, Paris</p>
						<p>France</p>
				   		<p>Phone:09 83 77 77 55</p>
				   		<p>Fax: (000) 000 00 00 0</p>
				 	 	<p>Email: <span>info@mycompany.com</span></p>
				   		<p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
				   </div>
				</div>				
				<div class="col span_2_of_4">
				  <div class="contact-form">
				  	<h3>Nous écrire</h3>
					       <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
					    	<div>
						    	<span><label>Nom</label></span>
						    	<span><input name="userName" type="text" class="textbox" required ></span>
						    </div>
						    <div>
						    	<span><label>Email</label></span>
						    	<span><input name="userEmail" type="email" class="textbox" required ></span>
						    </div>
						    <div>
						     	<span><label>Téléphone</label></span>
						    	<span><input name="userPhone" type="tel" class="textbox" required ></span>
						    </div>
						    <div>
						    	<span><label>Message</label></span>
						    	<span><textarea name="userMsg" required > </textarea></span>
						    </div>
						   <div>
						   		<span><input type="submit" value="Submit"></span>
						  </div>
					    </form>

				    </div>
  				</div>				
		  </div>
<div class="clear"></div>
</div>
<!-- fin de la partie contenu -->

<?php
include("inc/bottom.php");
?>