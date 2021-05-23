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
$user_dob=$_POST["dob"];
$user_gender=$_POST["gender"];
$user_email=$_POST["Email"];
$user_salary=$_POST["salary"];
$user_Address=$_POST["Address"];
$user_licenceNumber=$_POST["LicenceNum"];
$User_tel=$_POST["contactNumber"];
$User_owner_Nic=$_POST["ownerNIC"];
$User_vanId=$_POST["vanId"];
$user_contract=$_POST["contract"];


$qry="INSERT INTO driver(driver_NIC,fname,mname,lname,dob,gender,email,salary,address,driverLicence,contactNum,owner_NIC,van_ID,contract)
VALUES ('$User_Nic','$user_fname','$user_mname','$user_lname','$user_dob','$user_gender','$user_email','$user_salary','$user_Address','$user_licenceNumber','$User_tel','$User_owner_Nic','$User_vanId','$user_contract');";
if ($conn->query($qry)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
