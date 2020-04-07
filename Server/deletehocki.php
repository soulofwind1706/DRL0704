<?php
	include"connect.php";
	session_start();
	$idhocki=$_POST['idhocki'];
 	$query = "DELETE FROM hocki WHERE idhocki='$idhocki'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>