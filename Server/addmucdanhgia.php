<?php

	include"connect.php";

	mysqli_set_charset($conn,'UTF8');

	session_start();

	

	$noidung=$_POST['noidung'];

	$maxdiem=$_POST['maxdiem'];

	


 	$query = "INSERT INTO mucdanhgia(idmucdanhgia,noidung,maxdiem,iduser) VALUES (null,'$noidung','$maxdiem',null)";



	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}

?>