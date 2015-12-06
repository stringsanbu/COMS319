<?php
print("Please specify the name of the file to delete");
print("<p>");
$file =  array("r",  "w",  "a");
if(!in_array($_GET['filename'],  $file))
    exit ;
system("rm $file");
?>

