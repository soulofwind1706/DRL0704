<?php

	include "connect.php";



	$query = "SELECT * FROM hocki";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Hocki(

    	$row['idhocki'],

		$row['tenhocki'],

		$row['hockihientai']

		));

	}

	echo json_encode($mangkm);



	class Hocki{

		function Hocki($idhocki,$tenhocki,$hockihientai)

		{

			$this->idhocki=$idhocki;

			$this->tenhocki=$tenhocki;

			$this->hockihientai=$hockihientai;

		}

	}

?>