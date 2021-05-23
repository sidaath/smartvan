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

$User_Nic=$_POST["Nic"];
$date=$_POST["date"];

//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT morning_trip.tripID,morning_trip.vanID,morning_trip.route,morning_trip.startDate_TIme,morning_trip.endDate_time,morning_trip.date FROM morning_trip INNER JOIN van ON van.vanID=morning_trip.vanID WHERE van.owner_NIC='$User_Nic' AND morning_trip.date='$date';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('tripid'=>$row[0],'vanId'=>$row[1],'route'=>$row[2],'startdatetime'=>$row[3],'enddatetime'=>$row[4],'date'=>$row[5]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
