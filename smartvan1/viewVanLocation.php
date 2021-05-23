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
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT location
FROM van_location
WHERE van_Id='$van_Id';";

$res=mysqli_query($conn,$quary);
$data=array();

while ($row=mysqli_fetch_array($res)) {
  //$data[]=$row;
  array_push($data,array('location'=>$row[0]));
}


echo json_encode(array($data));
mysqli_close($conn);


?>
