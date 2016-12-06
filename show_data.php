<?php
$servername = "localhost";
$username = "u939969079_test";
$password = "S0H7GXDIaV";
$dbname = "u939969079_test";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$NumSub = 5;
$start = (int)$_GET['limit'];

$sql = "SELECT * FROM storys  LIMIT $start , $NumSub";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    
	$All_storys = array();
    while($row = $result->fetch_assoc()) {
        $All_storys[] = $row;
    }
} else {
    echo "0 results";
}
	$json_re=array();
	array_push($json_re,array("All_storys"=>$All_storys));
	echo json_encode($json_re);
$conn->close();
?>