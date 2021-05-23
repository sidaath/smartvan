<?php
$db_name="smartvan";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name) ;
// if($conn){
//   echo "success!" ;
// }
// else{
//   echo "not success!" ;
// }


$year=$_POST["year"];
$month=$_POST["month"];
$User_Nic=$_POST["Nic"];
// $User_Nic="814107563v";
// $van_Id="Na1236";
// $month="January";
// $year="2021";
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT salarypayment.paymentID,salarypayment.driverID,driver.fname,driver.lname,salarypayment.amount,salarypayment.paymentDate
FROM salarypayment
INNER JOIN driver
ON salarypayment.driverID=driver.driver_NIC
WHERE salarypayment.status='accept' AND salarypayment.ownerID='$User_Nic' AND salarypayment.year='$year' AND salarypayment.month='$month';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('paymentID'=>$row[0],'driverId'=>$row[1],'fname'=>$row[2],'lname'=>$row[3],'amount'=>$row[4],'payment_date'=>$row[5]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
