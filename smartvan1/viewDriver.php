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
//echo $User_Nic;
//$query="SELECT * FROM parent;";
$quary="SELECT driver_NIC,fname,lname,dob,gender,email,salary,address,driverLicence,contactNum,van_ID,contract,reg_date
FROM driver
WHERE driver.owner_NIC='$User_Nic' AND driver.activestatus='Active';";

$res=mysqli_query($conn,$quary);
$response=array();

while ($row=mysqli_fetch_array($res)) {
  array_push($response,array('driver_nic'=>$row[0],'fname'=>$row[1],'lname'=>$row[2],'dob'=>$row[3],'gender'=>$row[4],'email'=>$row[5],'salary'=>$row[6],'address'=>$row[7],
  'driverLicence'=>$row[8],'contactNum'=>$row[9],'van_ID'=>$row[10],'contract'=>$row[11],'reg_date'=>$row[12]));
}

mysqli_close($conn);
echo json_encode(array('Server_response'=>$response));


?>
