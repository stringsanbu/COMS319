<?php
	//connect to mysql
	include("db_connect.php");

	//save variables from POST (hash password via md5 and convert librarian to boolean value)
	$username = $_POST["username"];
	$password = md5($_POST["password"]);
	$email = $_POST["email"];
	$phone = $_POST["phone"];

	if($_POST["user_type"] == "Librarian")
	{
		$librarian = TRUE;
	}
	else
	{
		$librarian = FALSE;
	}

	$first = $_POST["first_name"];
	$last = $_POST["last_name"];

	//form sql statement
	$sql="INSERT INTO users (Groupnumber, Username, Password, Email, Phone, Librarian, Firstname, Lastname)
VALUES ('" . mysql_real_escape_string($username) . "', '" . mysql_real_escape_string($password) . "', '"
		. mysql_real_escape_string($email) . "',
	'" . mysql_real_escape_string($phone) . "', '" . mysql_real_escape_string($librarian) . "', '" . mysql_real_escape_string($first) . "'
	, '" . mysql_real_escape_string($last) . "');";
	//execute sql insert
	mysqli_query($dbhandle, $sql) or die (mysql_error());

	//close mysql
	include("db_close.php");
?>
