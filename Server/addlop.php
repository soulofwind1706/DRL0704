<?php

	include"connect.php";

	session_start();



	$idlop=$_POST['idlop'];

	$tenlop=$_POST['tenlop'];

	$idkhoa=$_POST['idkhoa'];




 	$query = "INSERT INTO lop (idlop,tenlop,idkhoa) VALUES ('$idlop','$tenlop','$idkhoa')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>