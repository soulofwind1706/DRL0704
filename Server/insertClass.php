<?php
	include"connect.php";
	
	$tenlop = $_POST['tenlop'];
	$idkhoa = (int) $_POST['idkhoa'];
    



 	$query = "INSERT INTO lop VALUES(null,'$tenlop','$idkhoa')";
	

	if(mysqli_query($conn,$query))
	{

		echo "success";

	}
	else
	{

		echo "error";

	}

?>