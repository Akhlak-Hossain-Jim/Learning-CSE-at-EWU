-- Create database (if it doesn't exist)
CREATE DATABASE IF NOT EXISTS user_auth_system 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE user_auth_system;

CREATE TABLE IF NOT EXISTS users (
    id INT(11) NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    address TEXT NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- INSERT INTO users (full_name, email, phone, address, password) 
-- VALUES ('Test User', 'test@example.com', '1234567890', '123 Test Street', 'test123');

