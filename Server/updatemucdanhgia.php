<?php

	include"connect.php";
	mysqli_set_charset($conn,'UTF8');


	session_start();



	// $idmucdanhgia=18;

	// $noidung="Học hàm";

	// $maxdiem=20;

	

	$idmucdanhgia=$_POST['idmucdanhgia'];

	$noidung=$_POST['noidung'];

	$maxdiem=$_POST['maxdiem'];




 	$query = "UPDATE mucdanhgia SET noidung='$noidung',maxdiem='$maxdiem' WHERE idmucdanhgia='$idmucdanhgia'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>