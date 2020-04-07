<?php
	include"connect.php";
	session_start();
	$idkhenthuong=$_POST['idkhenthuong'];
 	$query = "DELETE FROM khenthuong WHERE idkhenthuong='$idkhenthuong'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>