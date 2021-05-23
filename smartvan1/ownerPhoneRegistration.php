<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;

$User_Nic=$_POST["NIC_phone"];
$User_tel=$_POST["contactNumber"];
$insert_qry="INSERT into owner_phone values ('$User_Nic','$User_tel');";
if ($conn->query($insert_qry)==TRUE) {
  echo "add";
}
else {
  echo "error:".$conn->error;
}
?>
