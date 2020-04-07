<?php

	include"connect.php";

	session_start();



	$idhocki=$_POST['idhocki'];

	$tenhocki=$_POST['tenhocki'];

	$hockihientai=$_POST['hockihientai'];



 	$query = "UPDATE hocki SET idhocki='$idhocki',tenhocki='$tenhocki',hockihientai='$hockihientai' WHERE idhocki='$idhocki'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>