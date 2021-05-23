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
$quary="SELECT childID,fname,lname,dob,school,gender,location,reg_date
FROM child
WHERE child.vanID='$van_Id' AND child.activestatus='Active';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('childId'=>$row[0],'fname'=>$row[1],'lname'=>$row[2],'dob'=>$row[3],'school'=>$row[4],'gender'=>$row[5],'location'=>$row[6],
  'reg_date'=>$row[7]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
