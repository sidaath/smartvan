<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;

$van_Id=$_POST["vanId"];
$van_location=$_POST["location"];
// $van_filledSeats=$_POST["filledSeats"];
// $van_availableSeats=$_POST["availableSeats"];
// $van_conditions=$_POST["conditions"];
// $van_owner_Nic=$_POST["ownerNIC"];

$qry="DELETE FROM van_location WHERE  van_ID='$van_Id' AND location='$van_location';";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
