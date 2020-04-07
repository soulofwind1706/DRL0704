<?php

	include "connect.php";



	$query = "SELECT * FROM khoa";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Khoa(

    	$row['idkhoa'],

		$row['tenkhoa']

		));

	}

	echo json_encode($mangkm);



	class Khoa{

		function Khoa($idkhoa,$tenkhoa)

		{

			$this->idkhoa=$idkhoa;

			$this->tenkhoa=$tenkhoa;

		}

	}

?>