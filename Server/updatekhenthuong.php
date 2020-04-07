<?php

	include"connect.php";

	session_start();



	$idkhenthuong=$_POST['idkhenthuong'];

	$danhhieu=$_POST['danhhieu'];

	$maxdiem=$_POST['maxdiem'];

	$noidung=$_POST['noidung'];

	$iduser=$_POST['iduser'];


 	$query = "UPDATE khenthuong SET idkhenthuong='$idkhenthuong',danhhieu='$danhhieu',maxdiem='$maxdiem',noidung='$noidung',iduser='$iduser' WHERE idkhenthuong='$idkhenthuong'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>