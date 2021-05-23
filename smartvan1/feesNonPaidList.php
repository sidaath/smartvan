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
//$User_Nic=$_POST["Nic"]
$van_Id=$_POST["vanId"];
$year=$_POST["year"];
$month=$_POST["month"];
$User_Nic=$_POST["Nic"];

//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT DISTINCT child.childID,child.fname,child.lname
FROM child
INNER JOIN feesPayment
ON feesPayment.childID<>child.childID
WHERE child.vanID='$van_Id'
AND feesPayment.year='$year'
OR feesPayment.month='$month';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('childId'=>$row[0],'fname'=>$row[1],'lname'=>$row[2]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
