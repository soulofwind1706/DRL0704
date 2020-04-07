<?php

	include"connect.php";

	$idlop= (int) $_POST['idlop'];

	$tenlop=$_POST['tenlop'];

	$idkhoa=$_POST['idkhoa'];



 	$query = "UPDATE lop SET idlop='$idlop',tenlop='$tenlop',idkhoa='$idkhoa' WHERE idlop='$idlop'";


	if(mysqli_query($conn,$query))

	{

		echo "success";

	}

	else

	{

		echo "error";

	}

?>