<?php

	include"connect.php";

	session_start();




	$noidung=$_POST['noidung'];

	$maxdiem=$_POST['maxdiem'];

	$idmucdanhgia=$_POST['idmucdanhgia'];







 	$query = "INSERT INTO tieuchidanhgia (idtieuchi,noidung,maxdiem,idmucdanhgia) VALUES (null,'$noidung','$maxdiem','$idmucdanhgia')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>