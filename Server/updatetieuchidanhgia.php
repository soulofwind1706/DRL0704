<?php

	include"connect.php";

	session_start();



	$idtieuchi=$_POST['idtieuchi'];

	$noidung=$_POST['noidung'];

	$maxdiem=$_POST['maxdiem'];

	$idmucdanhgia=$_POST['idmucdanhgia'];

	





 	$query = "UPDATE tieuchidanhgia SET noidung='$noidung',maxdiem='$maxdiem',idmucdanhgia='$idmucdanhgia' WHERE idtieuchi='$idtieuchi'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>