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
$Request_ID=$_POST["requestId"];
$Child_ID=$_POST["childId"];
$Van_ID=$_POST["vanId"];
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$qry1="UPDATE requests SET requests.status='accept' WHERE requests.req_ID=$Request_ID;";
$qry2="UPDATE child SET child.vanID='$Van_ID' WHERE child.childID=$Child_ID;";
$qry3="UPDATE van SET van.availableSeats=van.availableSeats-1,van.filledSeats=van.filledSeats+1 WHERE van.vanID='$Van_ID';";
if ($conn->query($qry1)==TRUE && $conn->query($qry2)==TRUE && $conn->query($qry3)==TRUE) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
// $quary="SELECT requests.req_ID,requests.req_date,requests.req_van_ID,requests.re_child_ID,child.fname,child.lname,child.location, child.school
// FROM requests
// INNER JOIN van
// ON van.vanID=requests.req_van_ID
// INNER JOIN owner
// ON owner.owner_NIC=van.owner_NIC
// INNER JOIN child
// ON child.childID=requests.re_child_ID
// WHERE owner.owner_NIC='$User_Nic'
// AND requests.status='pending'
// AND child.vanID IS NULL;";
//
// $res=mysqli_query($conn,$quary);
// $response=array();
//
// while ($row=mysqli_fetch_array($res)) {
//   array_push($response,array('RequestID'=>$row[0],'RequestDate'=>$row[1],'Request Van ID'=>$row[2],'Child ID'=>$row[3],'Child First Name'=>$row[4],'Child Last Name'=>$row[5],'Child Location'=>$row[6],'Child School'=>$row[7]));
// }
//
// mysqli_close($conn);
// echo json_encode(array('Server_response'=>$response));


?>
