<?php

	include "connect.php";



	$query = "SELECT * FROM khenthuong";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Khenthuong(

    	$row['idkhenthuong'],

		$row['danhhieu'],

		$row['maxdiem'],

		$row['noidung'],

		$row['iduser']

		));

	}

	echo json_encode($mangkm);



	class Khenthuong{

		function Khenthuong($idkhenthuong,$danhhieu,$maxdiem,$noidung,$iduser)

		{

			$this->idkhenthuong=$idkhenthuong;

			$this->danhhieu=$danhhieu;

			$this->maxdiem=$maxdiem;

			$this->noidung=$noidung;

			$this->iduser=$iduser;

		}

	}

?>