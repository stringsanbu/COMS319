<?php
/**
 * Date: 10/24/2015
 * Time: 1:13 PM
 */
session_start();
echo "<h4>Make or view posts</h4>";
 $data=file_get_contents('posts.txt');
 $convertedString=json_encode($data, true);
//$convertedObj=json_decode($convertedString,true);
foreach($separate as $post) {
    echo '<br>' + $post;
}
echo "<a href=\"logout.php\">Logout</a>";
?>