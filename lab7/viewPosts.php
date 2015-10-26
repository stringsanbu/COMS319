<?php
/**
 * Date: 10/24/2015
 * Time: 1:13 PM
 */
session_start();
// It doesn't really make sense to store the user name here, so we'll be storing it in checkLogin.
if(!isset($_SESSION['username'])){
    exit("Not Logged In");
}
// We'll grab the data here and use it later
$posts = file_get_contents('posts.txt', true);
$posts = json_decode($posts);

// Let's generate the rows now

$rows = array();

// format for table is Content,Whoby,EditButton
foreach ($posts as $post) {
    $row = <<<ROW
        <tr>
            <td>{$post->content}</td>
            <td>{$post->author}</td>
            <td>
                <button type="button" class='edit' data-uid='{$post->uniqueId}' data-current='{$post->content}' data-author='{$post->author}'>Edit</button>
            </td>
        </tr>
ROW;
    $rows[] = $row;
}


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Posts</title>
    <style type="text/css">

    </style>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<h4>Make or view posts</h4>
<div id="table_div">
<table id="postsTable" border="1">
    <tr>
        <th>Post</th>
        <th>Author</th>
        <th>Edit</th>
    </tr>
    <?php
    foreach ($rows as $row) echo $row;
    ?>

</table>
</div>

<?php




echo "<br><a class='new_post' href='#'>New Post</a><br>
<a href=\"logout.php\">Logout</a>";
?>

<script>
    $(document).ready(function () {
        var author = "<?php echo $_SESSION['username']?>";

        $('body').on('click', '.edit', function () {
            var id = $(this).data('uid'),
                value = $(this).data('current'),
                postAuthor = $(this).data('author');
            if (author != postAuthor) {
                alert("You are not the author of this post and cannot edit.");
                return;
            }
            var nextValue = prompt("Edit Post", value);
            if (value == nextValue || nextValue == null) {
                return;
            }
            // OK, looks good let's send it in
            $.ajax({
                type: 'post',
                url: 'updatePosts.php',
                data: {
                    uid: id,
                    value: nextValue
                },
                success: function (html) {
                    console.log(html);
                    $('#table_div').load('viewPosts.php #postsTable');
                }
            });
        });

        $('.new_post').click(function () {
            var value = prompt("New Post", value);
            if (value == null) {
                return;
            }
            // OK, looks good let's send it in
            $.ajax({
                type: 'post',
                url: 'updatePosts.php',
                data: {
                    value: value
                },
                success: function (html) {
                    console.log(html);
                    $('#table_div').load('viewPosts.php #postsTable');
                }
            });
        });
    });

</script>

</html>
