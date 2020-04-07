<?php

	include"connect.php";

	session_start();



	//$idchitiet=$_POST['idchitiet'];

	$iduser=$_POST['iduser'];
	

	$ten=$_POST['ten'];
	
	


	// $hocki=$_POST['hocki'];

	// $diem_phongctsv=$_POST['diem_phongctsv'];

	// $sodiem=$_POST['sodiem'];

	// $idtieuchi=$_POST['idtieuchi'];

	// $diem_covan=$_POST['diem_covan'];

	$diem_sinhvien=$_POST['diem_sinhvien'];


	//$idhocki=$_POST['idhocki'];

	//$idmucdanhgia=$_POST['idmucdanhgia'];




 	$query = "INSERT INTO chitietdanhgia (idchitiet,iduser,ten,hocki,diem_phongctsv,sodiem,idtieuchi,diem_covan,diem_sinhvien,idhocki,idmucdanhgia) VALUES (null,'$iduser','$ten',null,null,null,null,null,'$diem_sinhvien',null,null)";

 	$query1= "SELECT iduser FROM chitietdanhgia Where iduser=$iduser";
 	$ID=mysqli_query($conn,$query1);
 	if(mysqli_num_rows($ID)){
 		echo "error";
 	}

 	else if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>