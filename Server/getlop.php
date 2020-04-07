<?php

	include "connect.php";



	$query = "SELECT * FROM lop";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Lop(

    	$row['idlop'],

		$row['tenlop'],

		$row['idkhoa']

		));

	}

	echo json_encode($mangkm);



	class Lop{

		function Lop($idlop,$tenlop,$idkhoa)

		{

			$this->idlop=$idlop;

			$this->tenlop=$tenlop;

			$this->idkhoa=$idkhoa;

		}

	}

?>