<?php

	include "connect.php";



	$query = "SELECT * FROM chitietdanhgia";

    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {

    	array_push($mangkm, new Chitietdanhgia(

    	$row['idchitiet'],

		$row['iduser'],
		$row['ten'],

		$row['hocki'],

		$row['diem_phongctsv'],

		$row['sodiem'],

		$row['idtieuchi'],

		$row['diem_covan'],

		$row['diem_sinhvien'],

		$row['idhocki'],

		$row['idmucdanhgia']

		));

	}

	echo json_encode($mangkm);



	class Chitietdanhgia{

		function Chitietdanhgia($idchitiet,$iduser,$ten,$hocki,$diem_phongctsv,$sodiem,$idtieuchi,$diem_covan,$diem_sinhvien,$idhocki,$idmucdanhgia)

		{

			$this->idchitiet=$idchitiet;

			$this->iduser=$iduser;

			$this->ten=$ten;

			$this->hocki=$hocki;

			$this->diem_phongctsv=$diem_phongctsv;

			$this->sodiem=$sodiem;

			$this->idtieuchi=$idtieuchi;

			$this->diem_covan=$diem_covan;

			$this->diem_sinhvien=$diem_sinhvien;

			$this->idhocki=$idhocki;

			$this->idmucdanhgia=$idmucdanhgia;

		}

	}

?>