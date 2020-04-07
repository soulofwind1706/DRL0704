<?php
	include"connect.php";
	session_start();
	$idtieuchi=$_POST['idtieuchi'];
 	$query = "DELETE FROM tieuchidanhgia WHERE idtieuchi='$idtieuchi'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>