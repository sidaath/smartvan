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
//$User_Nic=$_POST["Nic"];
$User_Nic="814107563v";
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT vanID,noOfSeats,filledSeats,availableSeats,conditions,reg_date
FROM driver
WHERE van.owner_NIC='$User_Nic' AND van.activestatus='Active';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('vanId'=>$row[0],'seats'=>$row[1],'fillseats'=>$row[2],'availableseats'=>$row[3],'condition'=>$row[4],'reg_date'=>$row[5]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
