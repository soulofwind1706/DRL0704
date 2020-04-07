<?php

	include "connect.php";



	$query = "SELECT * FROM kiluat";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Kiluat(

    	$row['idkiluat'],

		$row['mucdo'],

		$row['maxdiem'],

		$row['noidung'],

		$row['iduser']

		));

	}

	echo json_encode($mangkm);



	class Khenthuong{

		function Khenthuong($idkiluat,$mucdo,$maxdiem,$noidung,$iduser)

		{

			$this->idkiluat=$idkiluat;

			$this->mucdo=$mucdo;

			$this->maxdiem=$maxdiem;

			$this->noidung=$noidung;

			$this->iduser=$iduser;

		}

	}

?>