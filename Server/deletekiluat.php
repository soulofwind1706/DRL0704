<?php
	include"connect.php";
	session_start();
	$idkiluat=$_POST['idkiluat'];
 	$query = "DELETE FROM kiluat WHERE idkiluat='$idkiluat'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>