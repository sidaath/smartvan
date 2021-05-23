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
$date=$_POST["date"];
$vanId=$_POST["vanId"];
// $User_Nic=$_POST["Nic"];


//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT child.fname,child.lname,child.school,child.location
FROM child
INNER JOIN morning_child_trip
ON morning_child_trip.childID=child.childID
WHERE morning_child_trip.date='$date' AND child.vanID='$vanId';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('fname'=>$row[0],'lname'=>$row[1],'school'=>$row[2],'location'=>$row[3]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
