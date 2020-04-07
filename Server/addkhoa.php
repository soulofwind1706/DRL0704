<?php

	include"connect.php";

	session_start();



	$idkhoa=$_POST['idkhoa'];

	$tenkhoa=$_POST['tenkhoa'];




 	$query = "INSERT INTO khoa (idkhoa,tenkhoa) VALUES ('$idkhoa','$tenkhoa')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>