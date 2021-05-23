<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;

$van_Id=$_POST["vanId"];
$van_seats=$_POST["noOfSeats"];
$van_filledSeats=$_POST["filledSeats"];
$van_availableSeats=$_POST["availableSeats"];
$van_conditions=$_POST["conditions"];
$van_owner_Nic=$_POST["ownerNIC"];

$qry="INSERT INTO van(vanID,noOfSeats,filledSeats,availableSeats,conditions,owner_NIC)
VALUES ('$van_Id',$van_seats,$van_filledSeats,$van_availableSeats,'$van_conditions','$van_owner_Nic');";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
