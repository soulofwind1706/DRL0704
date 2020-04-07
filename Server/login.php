<?php

	include "connect.php";

		
	$email=$_POST['emailuser'];

	$query = "SELECT * FROM user where emailuser = '$email'";

    $result = mysqli_query( $conn, $query);

	$mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new User(

    	$row['iduser'],

		$row['tenuser'],

		$row['emailuser'],

		$row['password'],

		$row['idrole'],

		$row['idlop']

		));

	}

	echo json_encode($mangkm);

	class User{

		function user($iduser,$tenuser,$emailuser,$password,$idrole,$idlop)
		{
			$this->iduser=$iduser;
			$this->tenuser=$tenuser;
			$this->emailuser = $emailuser;
			$this->password = $password;
			$this->idrole = $idrole;
			$this->idlop = $idlop;
		}

	}
	

?>

