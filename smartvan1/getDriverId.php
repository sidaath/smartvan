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
$quary="SELECT driver_NIC FROM driver WHERE owner_NIC='$User_Nic';";

$res=mysqli_query($conn,$quary);
//$response=array();

while ($row=mysqli_fetch_assoc($res)) {
  $response[]=$row;
}

echo json_encode(array('Server_response'=>$response));
mysqli_close($conn);


?>
