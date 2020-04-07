<?php

	include "connect.php";



	$query = "SELECT * FROM usersrole";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Usersrole(

    	$row['idrole'],

		$row['tenrole'],

		$row['iduser']

		));

	}

	echo json_encode($mangkm);



	class Usersrole{

		function Usersrole($idrole,$tenrole,$iduser)

		{

			$this->idrole=$idrole;

			$this->tenrole=$tenrole;

			$this->iduser=$iduser;

		}

	}

?>