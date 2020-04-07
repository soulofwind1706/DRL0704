<?php

	include"connect.php";

	session_start();



	$idrole=$_POST['idrole'];

	$tenrole=$_POST['tenrole'];

	$iduser=$_POST['iduser'];



 	$query = "UPDATE usersrole SET idrole='$idrole',tenrole='$tenrole',iduser='$iduser' WHERE idrole='$idrole'";



	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>