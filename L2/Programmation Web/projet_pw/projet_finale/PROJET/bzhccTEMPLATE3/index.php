<?php
session_start();
require_once("db.php");
if(!isset($_SESSION['favoris'])){
	$_SESSION['favoris']=array();	
}

include("inc/top.php");
	
$req = $bd -> prepare("SELECT DISTINCT name FROM categories");
$req -> execute();
$res = $req->fetchAll();
$req -> closeCursor();
$req2 = $bd -> prepare("SELECT * FROM annonces");
$req2 -> execute();
$res2 = $req2 -> fetchAll();
	$_SESSION['annonces']= $res2;
	$_SESSION['categories']= $res;
	
	$six_annonce = array_rand($res2,6);
	$one_annonce = array_rand($six_annonce,1);
	$one_image=$res2[$one_annonce ]['image'];
	$id_annonce=$res2[$one_annonce]['annonceId'];
	$title=$res2[$one_annonce]['title'];
 $description=	$res2[$one_annonce]['description'];
?>

<!-- debut de la partie contenu -->
<div class="main">
<div class="sidebar">
<div class="s-main">
	<div class="s_hdr">
		<h2>Catégories</h2>
	</div>
	<div class="text1-nav">
		<ul>
		<?php
			foreach ($res as $key => $categorie) {

			echo 	'<li><a href="search.php?cat='. $categorie[0].'">'.$categorie[0]. '</a></li>';
			
			}
			?>
	    </ul>
	</div>
</div>


</div>

<div class="content">
	<div class="clear"></div>
	<div class="cnt-main">
		<div class="s_btn">
			<ul>
			<?php 
			if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true && isset($_SESSION['nom'])){
				echo '<li><h2>bienvenue '.$_SESSION['prenom'].'-'.$_SESSION['nom'].'</h2></li>';
				echo'<div class="clear"></div>';
			}else {
				echo'
				<li><h2>Bienvenue !</h2></li>
				<li><h3><a href="login.php">Se connecter</a></h3></li>
				<li><h2>Nouveau visiteur ?</h2></li>
				<li><h4><a href="sinscrire.php">S\'enregistrer</a></h4></li>
				<div class="clear"></div>';
			 }
			?>
				
			</ul>
		</div>
	<div class="grid">
	<div class="grid-img">
	<?php
		echo 
		'<a href="annonce.php?ann='. $id_annonce.' "><img src="images/'.$one_image.'" alt=""/>			
	</a>
	
	</div>
	<div class="grid-para">
		<h2>Nouveau sur le site</h2>
		<h3> '. $title .' </h3>
		<p> '.$description.' </p>
		<div class="btn top">
		<a href="annonce.php?ann='.$id_annonce.'">Details&nbsp;
		<img src="images/marker2.png" alt="" ></a>
		</div>
	</div>';
	?>
	<div class="clear"></div>
	</div>
</div>
<div class="cnt-main btm">
	<div class="section group">
	<?php
		foreach($six_annonce as $key=> $i){
			echo	'<div class="grid_1_of_3 images_1_of_3">
					 <a href="annonce.php?ann='. $res2[$i]['annonceId'].'"><img src="images/'.$res2[$i]['image'].'" alt=""/></a>
					 <a href="annonce.php?ann='. $res2[$i]['annonceId'].'"><h3>'.$res2[$i]['title'].'</h3></a>
					 <div class="cart-b">
					<span class="price left"><sup>'.$res2[$i]['price'].'€</sup><sub></sub></span>
				    <div class="btn top-right right"><a href="annonce.php?ann='. $res2[$i]['annonceId'].'&fav=yes">Ajouter à mes favoris</a></div>
				    <div class="clear"></div>
				 </div>
				</div>';
				
			}
				?>
		
		
</div>
</div>
<div class="clear"></div>
</div>

<!-- fin de la partie contenu -->
<?php
include("inc/bottom.php");
?>
