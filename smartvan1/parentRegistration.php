<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;

$User_Nic=$_POST["NIC"];
$user_fname=$_POST["FName"];
$user_mname=$_POST["MName"];
$user_lname=$_POST["LName"];
$user_email=$_POST["Email"];
$User_tel=$_POST["contactNumber"];
$user_Address=$_POST["Address"];
$user_Area=$_POST["Location"];
$user_Password=$_POST["Password"];

$qry="INSERT INTO parent(parent_NIC,fname,mname,lname,email,contactNumber,address,area,password)
VALUES ('$User_Nic','$user_fname','$user_mname','$user_lname','$user_email','$User_tel','$user_Address','$user_Area','$user_Password');";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
