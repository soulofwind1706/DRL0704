<?php

	include"connect.php";

	session_start();



	$idkiluat=$_POST['idkiluat'];

	$mucdo=$_POST['mucdo'];

	$maxdiem=$_POST['maxdiem'];

	$noidung=$_POST['noidung'];

	$iduser=$_POST['iduser'];



 	$query = "UPDATE kiluat SET idkiluat='$idkiluat',mucdo='$mucdo',maxdiem='$maxdiem',noidung='$noidung',iduser='$iduser' WHERE idkiluat='$idkiluat'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>