<?php

	include "connect.php";

	mysqli_set_charset( $conn,'UTF8');
	$idlop=$_POST['idlop'];
	//$idlop=1;

	
	//$iduser=$_POST['iduser'];

	//$query = "SELECT * FROM `user` INNER JOIN lop where user.idlop=lop.idlop AND user.idrole=1";
	$query = "SELECT * FROM `user` where user.idrole=1 AND user.idlop= $idlop ";


    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {
    	$mangkm[]=$row;

	}

	echo json_encode($mangkm);



?>