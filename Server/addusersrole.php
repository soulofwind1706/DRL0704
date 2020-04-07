<?php

	include"connect.php";

	session_start();



	$idrole=$_POST['idrole'];

	$tenrole=$_POST['tenrole'];

	$iduser=$_POST['iduser'];




 	$query = "INSERT INTO usersrole (idrole,tenrole,iduser) VALUES ('$idrole','$tenrole','$iduser')";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>