<?php

	include"connect.php";

	session_start();



	$idkiluat=$_POST['idkiluat'];

	$mucdo=$_POST['mucdo'];

	$maxdiem=$_POST['maxdiem'];

	$noidung=$_POST['noidung'];

	$iduser=$_POST['iduser'];




 	$query = "INSERT INTO kiluat (idkiluat,mucdo,maxdiem,noidung,iduser) VALUES ('$idkiluat','$mucdo','$maxdiem','$noidung','$iduser')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>