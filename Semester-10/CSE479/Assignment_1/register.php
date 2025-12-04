<?php
// Start session for storing user data
session_start();
require_once 'config.php';

$full_name = $email = $phone = $address = $password = '';
$error_message = '';
$success_message = '';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $full_name = trim($_POST['full_name'] ?? '');
    $email = trim($_POST['email'] ?? '');
    $phone = trim($_POST['phone'] ?? '');
    $address = trim($_POST['address'] ?? '');
    $password = $_POST['password'] ?? '';

    $errors = [];

    if (empty($full_name)) {
        $errors[] = "Full Name is required.";
    }

    if (empty($email)) {
        $errors[] = "Email is required.";
    } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors[] = "Invalid email format.";
    }

    if (empty($phone)) {
        $errors[] = "Phone Number is required.";
    }

    if (empty($address)) {
        $errors[] = "Address is required.";
    }

    if (empty($password)) {
        $errors[] = "Password is required.";
    } elseif (strlen($password) < 6) {
        $errors[] = "Password must be at least 6 characters long.";
    }

    if (empty($errors)) {
        $conn = getDBConnection();

        $check_email = $conn->prepare("SELECT id FROM users WHERE email = ?");
        $check_email->bind_param("s", $email);
        $check_email->execute();
        $result = $check_email->get_result();

        if ($result->num_rows > 0) {
            $error_message = "This email is already registered. Please use a different email or <a href='login.php'>login here</a>.";
        } else {
            $stmt = $conn->prepare("INSERT INTO users (full_name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)");
            $stmt->bind_param("sssss", $full_name, $email, $phone, $address, $password);

            if ($stmt->execute()) {
                $success_message = "Registration successful! You can now <a href='login.php'>login here</a>.";
                $full_name = $email = $phone = $address = $password = '';
            } else {
                $error_message = "Registration failed. Please try again.";
            }

            $stmt->close();
        }

        $check_email->close();
        $conn->close();
    } else {
        $error_message = implode(" ", $errors);
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <div class="card">
            <h1 class="card-title">Create Account</h1>
            <p class="card-subtitle">Register to get started</p>

            <!-- Display error message -->
            <?php if (!empty($error_message)): ?>
                <div class="alert alert-error">
                    <?php echo $error_message; ?>
                </div>
            <?php endif; ?>

            <!-- Display success message -->
            <?php if (!empty($success_message)): ?>
                <div class="alert alert-success">
                    <?php echo $success_message; ?>
                </div>
            <?php endif; ?>

            <form method="POST" action="register.php" class="form">
                <div class="form-group">
                    <label for="full_name">Full Name</label>
                    <input
                        type="text"
                        id="full_name"
                        name="full_name"
                        placeholder="Enter your full name"
                        value="<?php echo htmlspecialchars($full_name); ?>"
                        required>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        placeholder="Enter your email"
                        value="<?php echo htmlspecialchars($email); ?>"
                        required>
                </div>

                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input
                        type="tel"
                        id="phone"
                        name="phone"
                        placeholder="Enter your phone number"
                        value="<?php echo htmlspecialchars($phone); ?>"
                        required>
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <textarea
                        id="address"
                        name="address"
                        placeholder="Enter your address"
                        rows="3"
                        required><?php echo htmlspecialchars($address); ?></textarea>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password (min 6 characters)"
                        required>
                </div>

                <button type="submit" class="btn btn-primary">Register</button>
            </form>

            <div class="form-footer">
                <p>Already have an account? <a href="login.php">Login here</a></p>
            </div>
        </div>
    </div>
</body>

</html>