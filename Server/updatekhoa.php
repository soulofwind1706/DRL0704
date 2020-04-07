<?php

	include"connect.php";

	session_start();



	$idkhoa=$_POST['idkhoa'];

	$tenkhoa=$_POST['tenkhoa'];




 	$query = "UPDATE khoa SET idkhoa='$idkhoa',tenkhoa='$tenkhoa' WHERE idkhoa='$idkhoa'";


	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>