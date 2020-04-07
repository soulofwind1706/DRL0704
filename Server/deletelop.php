<?php
	include"connect.php";
	
	$idlop=$_POST['idlop'];
 	$query = "DELETE FROM lop WHERE idlop='$idlop'";
	if(mysqli_query($conn,$query))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
?>