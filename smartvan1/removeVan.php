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
$driver_ID=$_POST["vanId"];
//$Child_ID=$_POST["childId"];
//$Van_ID=$_POST["vanId"];
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$qry1="UPDATE van SET van.activestatus='Deactive' WHERE van.vanID=$driver_ID;";
//$qry2="UPDATE child SET child.vanID='$Van_ID' WHERE child.childID=$childChild_ID;";
//$qry3="UPDATE van SET van.availableSeats=van.availableSeats-1 WHERE van.vanID='$Van_ID';";
if ($conn->query($qry1)==TRUE ) {
  echo "successful";
}
else {
  echo "error:".$conn->error;
}
?>
