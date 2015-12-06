<?php

$query  = "SELECT id, name, inserted, name FROM products WHERE name = '$name' ORDER BY $name LIMIT 20, $offset;";
$result = pg_query($conn, $query);

?>
