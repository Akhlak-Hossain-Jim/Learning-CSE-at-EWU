<?php
// Start session
session_start();

// Check if user is logged in
if (!isset($_SESSION['user_id'])) {
    header('Location: login.php');
    exit();
}

require_once 'config.php';

$conn = getDBConnection();
$user_id = $_SESSION['user_id'];
$stmt = $conn->prepare("SELECT full_name, email, phone, address FROM users WHERE id = ?");
$stmt->bind_param("i", $user_id);
$stmt->execute();
$result = $stmt->get_result();
$user = $result->fetch_assoc();
$stmt->close();
$conn->close();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <div class="card">
            <h1 class="card-title">Welcome, <?php echo htmlspecialchars($user['full_name']); ?>!</h1>
            <p class="card-subtitle">Your account information</p>

            <div class="user-info">
                <div class="info-item">
                    <strong>Full Name:</strong>
                    <span><?php echo htmlspecialchars($user['full_name']); ?></span>
                </div>

                <div class="info-item">
                    <strong>Email:</strong>
                    <span><?php echo htmlspecialchars($user['email']); ?></span>
                </div>

                <div class="info-item">
                    <strong>Phone:</strong>
                    <span><?php echo htmlspecialchars($user['phone']); ?></span>
                </div>

                <div class="info-item">
                    <strong>Address:</strong>
                    <span><?php echo htmlspecialchars($user['address']); ?></span>
                </div>
            </div>

            <div class="form-footer">
                <a href="logout.php" class="btn btn-secondary">Logout</a>
            </div>
        </div>
    </div>
</body>

</html>