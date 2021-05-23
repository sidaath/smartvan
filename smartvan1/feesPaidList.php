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

$van_Id=$_POST["vanId"];
$year=$_POST["year"];
$month=$_POST["month"];
$User_Nic=$_POST["Nic"];
// $User_Nic="814107563v"
// $van_Id="Na1236";
// $month="January";
// $year="2021";
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT feesPayment.paymentID,feesPayment.childID,child.fname,child.lname,feesPayment.amount,feesPayment.payment_date
FROM feesPayment
INNER JOIN child
ON feesPayment.childID=child.childID
WHERE child.vanID='$van_Id' AND feesPayment.status='Accept' AND feesPayment.ownerID='$User_Nic' AND feesPayment.year='$year' AND feesPayment.month='$month';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('paymentID'=>$row[0],'childId'=>$row[1],'fname'=>$row[2],'lname'=>$row[3],'amount'=>$row[4],'payment_date'=>$row[5]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
