<?php
session_start();
include("inc/top.php");

?>

<!-- debut de la partie contenu -->
<div class="main">
<div class="ser-main">
	<h4>Nos annonces</h4>
	<div class="ser-para">
	<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna. Nunc easi diam risus, placerat ut scelerisque et,sus cipit eu ante. Nullam vitae dolor ullcper felises cursus gravida. Cras felis elit, pellentesqi amet. sus cipit eu ante. </p>
	</div>

    <!-- debut de  ligne de 3 produits -->    
    
	<?php
	foreach($_SESSION['ann'] as $key=> $elemt){ 
		echo 
		'<div  class="ser-grid-list">
		<h5>'.$elemt['title'].'</h5>
		<img src="images/'.$elemt['image'].'" alt="" width="150" height="120">
		<p>'.$elemt['description'].'</p>
		
		<div class="wish-list">
		<ul>
		<button>	<li class="wish"><a href="annonce.php?ann='. $elemt['annonceId']. '&fav=yes">Ajouter à mes favoris</a></li> </button>
		</ul>
	</div>
					
		<div class="btn top"><a href="annonce.php?ann='.$elemt['annonceId'].'">En savoir plus</a></div>
		</div>';
		
	} ?>

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

