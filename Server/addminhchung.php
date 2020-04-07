<?php

	include"connect.php";

	session_start();



	$idminhchung=$_POST['idminhchung'];

	$noidung=$_POST['noidung'];

	$hinhanh=$_POST['hinhanh'];

	$idchitiet=$_POST['idchitiet'];




 	$query = "INSERT INTO minhchung (idminhchung,noidung,hinhanh,idchitiet) VALUES ('$idminhchung','$noidung','$hinhanh','$idchitiet')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>