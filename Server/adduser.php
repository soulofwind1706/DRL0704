<?php

	include"connect.php";





	

	$tenuser=$_POST['tenuser'];

	$emailuser=$_POST['emailuser'];

	$password=$_POST['password'];

	$idrole=$_POST['idrole'];

	$idlop=  $_POST['idlop'];

	// $tenuser="Trần Khải Nguyên";

	// $emailuser="hattoinghe@gmail.com";

	// $password=111;

	// $idrole=1;

	// $idlop=1;




 	$query = "INSERT INTO user VALUES (null,'$tenuser','$emailuser','$password','$idrole','$idlop')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>