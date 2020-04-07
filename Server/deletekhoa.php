<?php
	include"connect.php";
	session_start();
	$idkhoa=$_POST['idkhoa'];
 	$query = "DELETE FROM khoa WHERE idkhoa='$idkhoa'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>