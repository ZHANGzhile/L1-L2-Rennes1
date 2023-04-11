<?php
session_start();
include_once("db.php");
include("inc/top.php");
if(isset($_GET['cat'])){
    $categorie = $_GET['cat'];
}else if (isset($_GET['selection'] )){
    $categorie = $_GET['selection'];
}
if(isset($_GET['textSearch'])){
    $textsearched = $_GET['textSearch'];
}

    if(isset($textsearched) && $textsearched!=""){
        if($categorie!='Catégorie'){
            $req = $bd-> prepare('SELECT * FROM annonces WHERE title LIKE "%'.$textsearched.'%" AND categorie="'.getCategorieId($categorie).'"');
            $req -> execute();    
        }else{
            $req = $bd-> prepare('SELECT * FROM annonces WHERE title LIKE "%'.$textsearched.'%"');
            $req -> execute();  
        }
    }
    else{
    $req = $bd-> prepare('SELECT * FROM annonces WHERE categorie="'.getCategorieId($categorie).'"');
    $req -> execute();    
    }
    
    if(isset($req)){
        $res=  $req ->fetchAll();
    }  else {
        $res = array();
    }


?>

<!-- debut de la partie contenu -->
<div class="main">
<div class="ser-main">
	<h4>Categorie <?php 
    if($categorie!="Catégorie"){
            echo $categorie; 
    }else if ($categorie=="Catégorie" && $textsearched!="tapez votre recherche"){
		header("Location: categories.php");
    }
    else {
        header("Location: index.php");
    }
    ?></h4>
	<div class="ser-para">
	<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna. Nunc easi diam risus, placerat ut scelerisque et,sus cipit eu ante. Nullam vitae dolor ullcper felises cursus gravida. Cras felis elit, pellentesqi amet. sus cipit eu ante. </p>
	</div>

    <!-- debut de  ligne de 3 produits -->    
    
	<?php

	foreach ($res as $key => $value) {
		echo'
		<div class="ser-grid-list" style="padding-left:1em;">
		<h5>'. $value['title'].'   </h5>
		<img src="images/'.$value['image'].'" width="150" height="100"/>
		<p> '. $value['description'].' </p>
		<div class="btn top"><a href="annonce.php?ann='. $value['annonceId'].'">En savoir plus</a></div>
		</div>';

	
		}
		?>
		<div class="clear"></div>
		
		
	
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
