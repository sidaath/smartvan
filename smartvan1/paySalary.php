<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;

$driver=$_POST["driver"];
$User_Nic=$_POST["Nic"];
$month=$_POST["month"];
$amount=$_POST["amount"];
// $van_filledSeats=$_POST["filledSeats"];
// $van_availableSeats=$_POST["availableSeats"];
// $van_conditions=$_POST["conditions"];
// $van_owner_Nic=$_POST["ownerNIC"];

$qry="INSERT INTO salarypayment(driverID,ownerID,month,amount)
VALUES ('$driver','$User_Nic','$month',$amount);";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
