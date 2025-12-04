<?php
define('DB_HOST', 'mysql');
define('DB_USER', 'root');
define('DB_PASS', '');
define('DB_NAME', 'user_auth_system');

/**
 * Create database connection
 * 
 * @return mysqli|false Returns mysqli connection object or false on failure
 */
function getDBConnection()
{
    $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $conn->set_charset("utf8mb4");

    return $conn;
}
