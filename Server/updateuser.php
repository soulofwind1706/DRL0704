<?php

	include"connect.php";





	$iduser= (int) $_POST['iduser'];

	$tenuser=$_POST['tenuser'];

	$emailuser=$_POST['emailuser'];

	$password=$_POST['password'];

	$idrole=$_POST['idrole'];

	$idlop=$_POST['idlop'];





 	$query = "UPDATE user SET tenuser='$tenuser',emailuser='$emailuser',password='$password',idrole='$idrole',idlop='$idlop' WHERE iduser='$iduser'";


	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>