<?php
// Start session
session_start();

// Destroy all session data
session_unset();
session_destroy();

header('Location: login.php');
exit();
