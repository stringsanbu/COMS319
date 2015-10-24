<?php
/**
 * Date: 10/24/2015
 * Time: 1:15 PM
 */
session_start();
session_destroy();

header( 'Location: login.html' ) ;

?>