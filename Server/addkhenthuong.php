<?php

	include"connect.php";

	session_start();



	$idkhenthuong=$_POST['idkhenthuong'];

	$danhhieu=$_POST['danhhieu'];

	$maxdiem=$_POST['maxdiem'];

	$noidung=$_POST['noidung'];

	$iduser=$_POST['iduser'];




 	$query = "INSERT INTO khenthuong (idkhenthuong,danhhieu,maxdiem,noidung,iduser) VALUES ('$idkhenthuong','$danhhieu','$maxdiem','$noidung','$iduser')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>