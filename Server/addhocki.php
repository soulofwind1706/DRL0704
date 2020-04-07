<?php

	include"connect.php";

	session_start();



	$idhocki=$_POST['idhocki'];

	$tenhocki=$_POST['tenhocki'];

	$hockihientai=$_POST['hockihientai'];




 	$query = "INSERT INTO hocki (idhocki,tenhocki,hockihientai) VALUES ('$idhocki','$tenhocki','$hockihientai')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>