<?php
	include"connect.php";
	session_start();
	$idmucdanhgia=$_POST['idmucdanhgia'];
 	$query = "DELETE FROM mucdanhgia WHERE idmucdanhgia='$idmucdanhgia'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>