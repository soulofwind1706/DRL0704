<?php
	include"connect.php";
	session_start();
	$idrole=$_POST['idrole'];
 	$query = "DELETE FROM usersrole WHERE idrole='$idrole'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>