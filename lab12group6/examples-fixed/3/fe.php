
<?php
$files  =  array("form.php");
if ( isset( $_GET['COLOR'] ) ) {
   if(!in_array($_GET['COLOR'],  $files))
      exit;
}
?>


