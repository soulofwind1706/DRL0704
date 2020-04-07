<?php
	include"connect.php";
	session_start();
	//$iduser=13;


	$iduser=$_POST['iduser'];
 	$query = "DELETE FROM user WHERE iduser=$iduser";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>