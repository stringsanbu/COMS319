<?php
/**
 * Date: 10/24/2015
 * Time: 1:15 PM
 */
session_start();

$dateTime = new DateTime();
$author = $_SESSION['username'];
$value = $_POST['value'];
$action = null;
$uid = null;

// Let's get the info we need to either edit or make the new post
if (isset($_POST['uid'])) {
    $action = "edit";
    $uid = $_POST['uid'];
} else {
    $action = "new";
    $uid = $dateTime->format('YmdHis');
}

$posts = file_get_contents('posts.txt', true);
$posts = json_decode($posts);

if ($action == null)
    return;
else if ($action == "new") {
    $post = new stdClass();
    $post->uniqueId = $uid;
    $post->content = $value;
    $post->author = $author;
    array_unshift($posts, $post);
}
else {
    // edit post
    $i = 0;
    for (; $i < sizeof($posts); $i++) {
        if($posts[$i]->uniqueId == $uid) break;
    }
    echo "index: $i";
    var_dump($posts[$i]);
    $posts[$i]->content = $value;
}


// Ok, time to rewrite the entire thing
file_put_contents("posts.txt", json_encode($posts));

?>