<?php
require_once("db.php");
session_start();
include("inc/top.php");
$id_annonce = $_GET['ann'];

$req= $bd->prepare('SELECT * FROM annonces WHERE annonceId=' . $id_annonce);
$req->execute();
$detail_annonce = $req->fetch();
$req->closeCursor();
$req2 = $bd->prepare('SELECT * FROM `annonces` WHERe categorie IN(SELECT categorie FROM annonces where annonceId='.$id_annonce.') and  annonceId !='.$id_annonce.' LIMIT 3');
$req2->execute();
if (isset($_GET['fav'])) {
	if (!in_array($detail_annonce, $_SESSION['favoris'], true)) {
		$_SESSION['favoris'][] = $detail_annonce;
	}
}

if (isset($_GET['del'])) {
	if (in_array($detail_annonce, $_SESSION['favoris'], true)) {
		unset($_SESSION['favoris'][array_search($detail_annonce, $_SESSION['favoris'])]);
	}
}
$annonce_inter=$req2->fetchall();


?>

<!-- debut de la partie contenu -->
<div class="main">
	<div class="details">
		<div class="product-details">
			<div class="images_3_of_2">
				<div id="container">
					<div id="products_example">
						<div id="products">
							<div class="slides_container">
								<a href="#"><img src="images/<?php echo $detail_annonce['image']; ?>"  width="350" height="300" /></a>
							</div>
							<ul class="pagination">
								<li><a href="#"><img src="images/<?php echo $detail_annonce['image']; ?>"  width="150" height="100"   /></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="desc span_3_of_2">
				<h2><?php echo  $detail_annonce['title'] ?></h2>
				<p><?php echo  $detail_annonce['description'] ?></p>
				<div class="price">
					<p>Prix: <span><?php echo  $detail_annonce['price'] ?>€</span></p>
				</div>
				<div class="wish-list">
					<ul>
						<li class="wish"><a href="annonce.php?ann=<?php echo  $detail_annonce['annonceId'] ?>&fav=yes">Ajouter à mes favoris</a></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>

		<div class="content_bottom">
			<div class="text-h1 top1 btm">
				<h2>Annonces qui pourraient vous intéresser</h2>
			</div>
			<div class="div2">
				<div id="mcts1">
					<?php
					
					foreach($annonce_inter as $group)	

 echo   '
 <div  class="ser-grid-list">
 <h5>'.$group['title'].'</h5>
 <img src="images/'.$group['image'].'" alt="" width="150" height="120">
 <div class="price">
 <p>Prix: <span>'.$group['price'].'€</span></p>
</div>

 <div class="btn top"><a href="annonce.php?ann='.$group['annonceId'].'">En savoir plus</a></div>
 </div>
 '; ?>
					
					
					<div class="clear"></div>
				</div>
			</div>
		</div>
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