<?php

	include "connect.php";


	$query = "SELECT * FROM tieuchidanhgia";
	

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Tieuchidanhgia(

    	$row['idtieuchi'],

		$row['noidung'],

		$row['maxdiem'],

		$row['idmucdanhgia']

		));

	}

	echo json_encode($mangkm);




	class Tieuchidanhgia{

		function Tieuchidanhgia($idtieuchi,$noidung,$maxdiem,$idmucdanhgia)

		{

			$this->idtieuchi=$idtieuchi;

			$this->noidung=$noidung;

			$this->maxdiem=$maxdiem;

			$this->idmucdanhgia=$idmucdanhgia;

		}

	}

?>