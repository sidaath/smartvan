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
$User_Nic=$_POST["Nic"];
$user_pass=$_POST["Password"];
$quary1="select * from owner where owner_NIC ='$User_Nic' and password='$user_pass';"  ;
$quary2="select * from driver where driver_NIC ='$User_Nic' and password='$user_pass';"  ;
$quary3="select * from parent where parent_NIC ='$User_Nic' and password='$user_pass';"  ;
$result1=mysqli_query($conn,$quary1);
$result2=mysqli_query($conn,$quary2);
$result3=mysqli_query($conn,$quary3);
if(mysqli_num_rows($result1)>0){
  echo "van owner";
}
elseif (mysqli_num_rows($result2)>0) {
  echo "driver";
}
elseif (mysqli_num_rows($result3)>0) {
  echo "parent";
}
else{
  echo "not success login";
}
?>
