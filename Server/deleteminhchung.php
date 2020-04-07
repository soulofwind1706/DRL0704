<?php
	include"connect.php";
	session_start();
	$idminhchung=$_POST['idminhchung'];
 	$query = "DELETE FROM minhchung WHERE idminhchung='$idminhchung'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>