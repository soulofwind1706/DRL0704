<?php

	include "connect.php";



	$query = "SELECT * FROM mucdanhgia";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Mucdanhgia(

    	$row['idmucdanhgia'],

		$row['noidung'],

		$row['maxdiem'],

		$row['iduser']

		));

	}

	echo json_encode($mangkm);



	class Mucdanhgia{

		function Mucdanhgia($idmucdanhgia,$noidung,$maxdiem,$iduser)

		{

			$this->idmucdanhgia=$idmucdanhgia;

			$this->noidung=$noidung;

			$this->maxdiem=$maxdiem;

			$this->iduser=$iduser;

		}

	}

?>