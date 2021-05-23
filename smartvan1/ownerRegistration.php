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
$user_licenceNumber=$_POST["GovtLicenceNum"];
$user_Address=$_POST["Address"];
$User_tel=$_POST["contactNumber"];
$user_Password=$_POST["Password"];

$qry="INSERT INTO owner(owner_NIC,fname,mname,lname,email,govt_licence_num,address,contactNumber,password)
VALUES ('$User_Nic','$user_fname','$user_mname','$user_lname','$user_email','$user_licenceNumber','$user_Address','$User_tel','$user_Password');";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
