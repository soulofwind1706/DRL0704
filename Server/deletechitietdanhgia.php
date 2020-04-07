<?php
	include"connect.php";
	session_start();
	$idchitiet=$_POST['idchitiet'];
 	$query = "DELETE FROM chitietdanhgia WHERE idchitiet='$idchitiet'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>