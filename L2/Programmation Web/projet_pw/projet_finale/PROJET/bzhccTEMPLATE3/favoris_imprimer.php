<?php
session_start();
?>
<!DOCTYPE HTML>
<html>

<head>
    <title>BreizhCoinCoin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Cabin+Condensed' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="formscript.js"></script>
</head>

<body onload="setTimeout(function () {
   window.location.href= 'favoris.php';}, 1000);
window.print()">
    <div class="main">
        <div class="ser-main">

            <!-- debut de  ligne de 3 produits -->
            <?php
            foreach ($favori as  $value) {
			echo'
			<div class="ser-grid-list" style="padding-left:1em;">
			<h5>'. $value['title'].'   </h5>
			<img src="images/'.$value['image'].'" alt="" width="150" height="120">
			<p> '. $value['description'].'</p>';}?>
			         
         <div class="clear"></div>
		
    

            <div class="sidebar">
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <!-- fin de la partie contenu -->
</body>

</html>