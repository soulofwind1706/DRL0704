<?php

	include"connect.php";

	session_start();



	//$idchitiet=$_POST['idchitiet'];

	//$iduser=$_POST['iduser'];
	$iduser=$_POST['iduser'];


	//$hocki=$_POST['hocki'];

	$diem_phongctsv=$_POST['diem_phongctsv'];

	//$sodiem=$_POST['sodiem'];

	//$idtieuchi=$_POST['idtieuchi'];

	// $diem_covan=$_POST['diem_covan'];

	//$diem_sinhvien=$_POST['diem_sinhvien'];

	//$idhocki=$_POST['idhocki'];

	//$idmucdanhgia=$_POST['idmucdanhgia'];




 	$query = "UPDATE chitietdanhgia SET diem_phongctsv='$diem_phongctsv' WHERE iduser='$iduser'";




	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>