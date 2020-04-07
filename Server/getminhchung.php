<?php

	include "connect.php";



	$query = "SELECT * FROM minhchung";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Minhchung(

    	$row['idminhchung'],

		$row['noidung'],

		$row['hinhanh'],

		$row['idchitiet']

		));

	}

	echo json_encode($mangkm);



	class Minhchung{

		function Minhchung($idminhchung,$noidung,$hinhanh,$idchitiet)

		{

			$this->idminhchung=$idminhchung;

			$this->noidung=$noidung;

			$this->hinhanh=$hinhanh;

			$this->idchitiet=$idchitiet;

		}

	}

?>