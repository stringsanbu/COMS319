<?php
/**
 * Date: 10/24/2015
 * Time: 1:15 PM
 */
session_start();
$user = $_POST['username'];
$pass = $_POST['password'];

$userlist = file ('users.txt');

$success = false;
foreach ($userlist as $individual) {
    $individual = preg_replace("/[\n\r]/", "", $individual);
    $separate = explode(' ', $individual);
    if ($separate[0] == $user && $separate[1] == $pass) {
        $success = true;
        break;
    }
}

if($success) {
    $_SESSION['username'] = $user;
    echo "success";
}

?>