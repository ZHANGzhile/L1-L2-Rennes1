<?php
session_start();
require_once("db.php");
include("inc/top.php");
$favori = $_SESSION['favoris'];
if(isset( $_GET['delall'] ) ) {
	foreach ($_SESSION['favoris'] as  $fav) {
		if (in_array($fav, $_SESSION['favoris'], true)) {
			unset($_SESSION['favoris'][array_search($fav, $_SESSION['favoris'])]);
		}
	}
	header('location: index.php');
}
?>

<!-- debut de la partie contenu -->
<div class="main">
	<div class="ser-main">
		<h4>Vos favoris</h4>
		<div class="ser-para">
			<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna. Nunc easi diam risus, placerat ut scelerisque et,sus cipit eu ante. Nullam vitae dolor ullcper felises cursus gravida. Cras felis elit, pellentesqi amet. sus cipit eu ante. </p>
		</div>

		<!-- debut de  ligne de 3 produits -->
		<?php
		

		foreach ($favori as  $value) {
			echo'
			<div class="ser-grid-list" style="padding-left:1em;">
			<h5>'. $value['title'].'   </h5>
			<img src="images/'.$value['image'].'" alt="" width="150" height="120">
			<p> '. $value['description'].'</p>
			<div class="btn top"><a href="annonce.php?ann='. $value['annonceId'].'&del=yes">Supprimer de mes favoris</a></div>
			</div>';
	
		
			}
?>

				<div class="clear"></div>
			
		
		


		<?php
		if (isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true) {
		?>
			<div class="clear">
				<div class="btn top"><a href="favoris_imprimer.php">Imprimer mes favoris</a></div>
			</div>
			<div class="clear">
				<div class="btn top"><a href="favoris_mail.php">Envoyer par mail</a></div>
			</div>

		<?php
		}


		?>
		<div class="clear"></div>
		<a href="favoris.php?delall=yes">
		<button style="color:white;padding: 15px 32px;margin-top:2em;border:none;text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;">
			Supprimer tous les annonces</button></a>
	</div>

	<div class="sidebar">
		<div class="s-main">
			<div class="s_hdr">
				<h2>Categories</h2>
			</div>
			<div class="text1-nav">
				<ul>
				<?php 
				foreach ($_SESSION['categories'] as $key => $categorie) {
					echo
				
				'<li><a href="search.php?cat='. $categorie[0].' "> '.$categorie[0].' </a></li>';
			}
			
			?>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<!-- fin de la partie contenu -->
<?php
include("inc/bottom.php");
?>