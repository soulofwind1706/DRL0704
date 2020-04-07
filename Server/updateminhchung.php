<?php

	include"connect.php";

	session_start();



	$idminhchung=$_POST['idminhchung'];

	$noidung=$_POST['noidung'];

	$hinhanh=$_POST['hinhanh'];

	$idchitiet=$_POST['idchitiet'];



 	$query = "UPDATE minhchung SET idminhchung='$idminhchung',noidung='$noidung',hinhanh='$hinhanh',idchitiet='$idchitiet' WHERE idminhchung='$idminhchung'";


	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>