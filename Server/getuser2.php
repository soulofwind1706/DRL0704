<?php

	include "connect.php";

	mysqli_set_charset( $conn,'UTF8');



	$query = "SELECT * FROM `usersrole` INNER JOIN user where  usersrole.idrole=user.idrole ";




    $result = mysqli_query( $conn, $query);

    $mangkm=array();

    while($row = mysqli_fetch_assoc($result))

    {
    	$mangkm[]=$row;

	}

	echo json_encode($mangkm);





?>