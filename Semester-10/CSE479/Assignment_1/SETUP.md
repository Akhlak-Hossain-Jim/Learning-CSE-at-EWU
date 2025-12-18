# Login and Registration System

A complete web-based authentication system built with HTML, CSS, PHP, and MySQL, designed to run in a Docker XAMPP environment.

## 📚 Table of Contents

1. [High Level Explanation](#1-high-level-explanation)
2. [Design Specification](#2-design-specification)
3. [Database Schema and SQL](#3-database-schema-and-sql)
4. [All Code Files](#4-all-code-files)
5. [Setup Steps](#5-setup-steps)

---

## 1. High Level Explanation

### System Architecture

This Login and Registration system is a **client-server web application** that follows a traditional **3-tier architecture**:

1. **Presentation Layer (Frontend)**: HTML forms with CSS styling
2. **Application Layer (Backend)**: PHP scripts handling business logic
3. **Data Layer**: MySQL database storing user information

### How It Works

**Registration Flow:**

1. User fills out registration form with personal details
2. PHP validates all inputs (email format, required fields, password length)
3. System checks if email already exists in database
4. If unique, user data is inserted into MySQL `users` table
5. Success message displayed with link to login page

**Login Flow:**

1. User enters email and password
2. PHP queries database to find matching email
3. Password is compared (plain text as per requirements)
4. If match found, PHP session is created
5. User redirected to dashboard showing their information

**Session Management:**

- PHP sessions store user ID and name after successful login
- Dashboard page checks for active session
- Logout destroys session and redirects to login

### Key Features

- ✅ Form validation (client-side HTML5 + server-side PHP)
- ✅ Duplicate email prevention
- ✅ User-friendly error messages
- ✅ Responsive design (mobile-friendly)
- ✅ Secure prepared statements (SQL injection prevention)
- ✅ Session-based authentication
- ✅ Clean, modern UI design

---

## 2. Design Specification

### Color Palette

**Primary Colors:**

- **Primary Blue**: `#4A90E2` - Main buttons, links, focus states
- **Primary Hover**: `#357ABD` - Button hover state
- **Primary Light**: `#E8F4FD` - Background accents

**Status Colors:**

- **Success Green**: `#28A745` - Success messages
- **Error Red**: `#DC3545` - Error messages
- **Success Background**: `#D4EDDA` - Success message background
- **Error Background**: `#F8D7DA` - Error message background

**Neutral Colors:**

- **Background**: `#F5F7FA` - Main page background
- **Card Background**: `#FFFFFF` - Form card background
- **Text Primary**: `#2C3E50` - Main text color
- **Text Secondary**: `#6C757D` - Secondary text, labels
- **Border**: `#E1E8ED` - Input borders, dividers

### Typography

**Font Family:**

```css
-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
'Helvetica Neue', Arial, sans-serif
```

- Uses system fonts for optimal performance and native feel

**Font Sizes:**

- Base: `16px` - Body text, inputs
- Small: `14px` - Labels, helper text
- Large: `24px` - Subtitles
- Title: `32px` - Page titles

### Layout Specifications

**Card Design:**

- Width: `480px` (max-width, responsive)
- Padding: `32px` (desktop), `24px` (tablet), `16px` (mobile)
- Border Radius: `12px`
- Box Shadow: `0 10px 25px rgba(0, 0, 0, 0.15)`
- Centered on page with flexbox

**Form Elements:**

- Input Height: `48px` (with padding)
- Input Padding: `16px`
- Border Width: `2px`
- Border Radius: `8px`
- Focus Border: `3px` shadow with primary color

**Spacing System:**

- Extra Small: `8px`
- Small: `12px`
- Medium: `16px`
- Large: `24px`
- Extra Large: `32px`
- XXL: `48px`

**Button Specifications:**

- Height: `48px` (with padding)
- Padding: `16px 32px`
- Border Radius: `8px`
- Full width on mobile
- Hover effect: `translateY(-1px)` with shadow
- Transition: `0.15s ease`

### Responsive Breakpoints

- **Desktop**: Default (480px card width)
- **Tablet**: `< 600px` (reduced padding)
- **Mobile**: `< 400px` (minimal padding, smaller fonts)

### Dark Theme Support

The CSS includes optional dark theme support using `@media (prefers-color-scheme: dark)`:

- Automatically adapts to user's system preference
- Maintains same color relationships
- Improved contrast for dark backgrounds

### Visual Design Principles

1. **Consistency**: Uniform spacing, colors, and typography
2. **Clarity**: Clear labels, helpful error messages
3. **Feedback**: Visual states for hover, focus, success, error
4. **Accessibility**: Focus indicators, semantic HTML
5. **Modern**: Clean lines, subtle shadows, smooth transitions

---

## 3. Database Schema and SQL

### Database Structure

**Database Name:** `user_auth_system`

**Table Name:** `users`

### Table Schema

| Column     | Type         | Attributes                  | Description                  |
| ---------- | ------------ | --------------------------- | ---------------------------- |
| id         | INT(11)      | PRIMARY KEY, AUTO_INCREMENT | Unique user identifier       |
| full_name  | VARCHAR(100) | NOT NULL                    | User's full name             |
| email      | VARCHAR(100) | NOT NULL, UNIQUE            | User's email (unique)        |
| phone      | VARCHAR(20)  | NOT NULL                    | User's phone number          |
| address    | TEXT         | NOT NULL                    | User's address               |
| password   | VARCHAR(255) | NOT NULL                    | User's password (plain text) |
| created_at | TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP   | Record creation time         |
| updated_at | TIMESTAMP    | ON UPDATE CURRENT_TIMESTAMP | Last update time             |

### Indexes

- **PRIMARY KEY**: `id`
- **INDEX**: `idx_email` on `email` column (for faster lookups)

### SQL Commands

See `database.sql` file for complete SQL schema. Key commands:

```sql
-- Create database
CREATE DATABASE IF NOT EXISTS user_auth_system
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Create users table
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
```

### Database Connection

Connection is handled in `config.php`:

```php
// For Docker: DB_HOST = 'mysql'
// For XAMPP: DB_HOST = 'localhost'
// Username: 'root'
// Password: '' (empty)
// Database: 'user_auth_system'
```

---

## 4. All Code Files

### File Structure

```
Assignment_1/
├── config.php          # Database configuration
├── register.php        # Registration page
├── login.php           # Login page
├── dashboard.php       # User dashboard
├── logout.php          # Logout handler
├── style.css           # Main stylesheet
├── database.sql        # Database schema
├── docker-compose.yml  # Docker configuration
├── SETUP.md           # Setup instructions
└── README.md          # This file
```

### File Descriptions

1. **config.php**: Database connection settings and connection function
2. **register.php**: Registration form with validation and database insertion
3. **login.php**: Login form with authentication logic
4. **dashboard.php**: Protected page showing user information
5. **logout.php**: Session destruction and redirect
6. **style.css**: Complete styling for all pages
7. **database.sql**: SQL commands to create database and table
8. **docker-compose.yml**: Docker configuration for XAMPP-like environment

All files are fully commented and beginner-friendly.

---

## 5. Setup Steps

### Option A: Docker XAMPP Environment (Recommended)

#### Step 1: Prerequisites

- Install Docker Desktop: https://www.docker.com/products/docker-desktop
- Ensure Docker is running

#### Step 2: Start Services

```bash
cd Assignment_1
docker-compose up -d
```

This starts:

- **Apache/PHP** on `http://localhost:8080`
- **MySQL** on port `3306`
- **phpMyAdmin** on `http://localhost:8081`

#### Step 3: Wait for Initialization

Wait 10-20 seconds for MySQL to fully start. Check status:

```bash
docker-compose ps
```

#### Step 4: Database Setup

The database should auto-create. If not:

1. Open phpMyAdmin: http://localhost:8081
2. Username: `root`, Password: (empty)
3. Click "SQL" tab
4. Copy/paste contents from `database.sql`
5. Click "Go"

#### Step 5: Access Application

- Registration: http://localhost:8080/register.php
- Login: http://localhost:8080/login.php
- phpMyAdmin: http://localhost:8081

#### Step 6: Stop Services

```bash
docker-compose down
```

### Option B: Traditional XAMPP

#### Step 1: Install XAMPP

Download from: https://www.apachefriends.org/

#### Step 2: Start Services

- Open XAMPP Control Panel
- Start Apache and MySQL

#### Step 3: Place Files

Copy all files to:

- Windows: `C:\xampp\htdocs\assignment1\`
- Mac: `/Applications/XAMPP/htdocs/assignment1/`
- Linux: `/opt/lampp/htdocs/assignment1/`

#### Step 4: Create Database

1. Open phpMyAdmin: http://localhost/phpmyadmin
2. Click "SQL" tab
3. Copy/paste `database.sql` contents
4. Click "Go"

#### Step 5: Update Config (if needed)

Edit `config.php` - ensure `DB_HOST` is `'localhost'`

#### Step 6: Access Application

- Registration: http://localhost/assignment1/register.php
- Login: http://localhost/assignment1/login.php

### Testing Checklist

- [ ] Register a new user
- [ ] Try registering with duplicate email (should show error)
- [ ] Login with correct credentials
- [ ] View dashboard with user info
- [ ] Logout and verify redirect to login
- [ ] Try accessing dashboard without login (should redirect)

### Troubleshooting

**Connection Error:**

- Verify MySQL is running
- Check `config.php` DB_HOST setting
- Wait longer for Docker MySQL to initialize

**Database Not Found:**

- Manually create database in phpMyAdmin
- Run SQL from `database.sql`

**Styling Not Working:**

- Check `style.css` is in same directory
- Clear browser cache
- Check browser console for errors

**Port Already in Use:**

- Change ports in `docker-compose.yml`
- Or stop conflicting services

---

## 🎯 Quick Reference

### URLs (Docker)

- App: http://localhost:8080
- phpMyAdmin: http://localhost:8081

### Database Credentials

- Host: `mysql` (Docker) or `localhost` (XAMPP)
- User: `root`
- Password: (empty)
- Database: `user_auth_system`

### Default Ports

- Apache: `8080`
- MySQL: `3306`
- phpMyAdmin: `8081`

---

## 📝 Notes

- Passwords stored in **plain text** (as per requirements - not for production)
- Uses PHP sessions for authentication
- Prepared statements prevent SQL injection
- Responsive design works on all devices
- Clean, commented code for learning

---

**Ready to use! Start with `docker-compose up -d` and visit http://localhost:8080/register.php**

# Setup Guide: Login and Registration System

This guide will help you set up and run the Login and Registration system in a Docker XAMPP environment.

## 📋 Prerequisites

- Docker and Docker Compose installed on your system
- A web browser
- Basic knowledge of terminal/command line

## 🚀 Quick Start with Docker

### Step 1: Start the Docker Containers

Open your terminal in the project directory and run:

```bash
docker-compose up -d
```

This will start three services:

- **Apache/PHP** on port `8080`
- **MySQL** on port `3306`
- **phpMyAdmin** on port `8081`

### Step 2: Wait for Services to Initialize

Wait about 10-20 seconds for MySQL to fully initialize. You can check the status with:

```bash
docker-compose ps
```

### Step 3: Access the Application

- **Registration Page**: http://localhost:8080/register.php
- **Login Page**: http://localhost:8080/login.php
- **phpMyAdmin**: http://localhost:8081

### Step 4: Database Setup

The database should be automatically created when the MySQL container starts. However, if you need to manually set it up:

1. Open phpMyAdmin: http://localhost:8081
2. Username: `root`
3. Password: (leave empty)
4. Click on "SQL" tab
5. Copy and paste the contents from `database.sql`
6. Click "Go"

## 🛠️ Alternative: Traditional XAMPP Setup

If you prefer to use traditional XAMPP instead of Docker:

### Step 1: Install XAMPP

1. Download XAMPP from https://www.apachefriends.org/
2. Install it on your system
3. Start Apache and MySQL from the XAMPP Control Panel

### Step 2: Configure Database

1. Open phpMyAdmin: http://localhost/phpmyadmin
2. Click on "SQL" tab
3. Copy and paste the contents from `database.sql`
4. Click "Go"

### Step 3: Place Files

1. Copy all project files to: `C:\xampp\htdocs\assignment1\` (Windows) or `/Applications/XAMPP/htdocs/assignment1/` (Mac)
2. Update `config.php` to use `localhost` instead of `mysql` (already configured)

### Step 4: Access the Application

- **Registration Page**: http://localhost/assignment1/register.php
- **Login Page**: http://localhost/assignment1/login.php

## 📁 Project Structure

```
Assignment_1/
├── config.php          # Database configuration
├── register.php        # Registration page
├── login.php           # Login page
├── dashboard.php       # User dashboard (after login)
├── logout.php          # Logout handler
├── style.css           # Main stylesheet
├── database.sql        # Database schema
├── docker-compose.yml  # Docker configuration
└── SETUP.md           # This file
```

## 🧪 Testing the System

### Test Registration:

1. Go to http://localhost:8080/register.php
2. Fill in the form:
   - Full Name: John Doe
   - Email: john@example.com
   - Phone: 1234567890
   - Address: 123 Main Street
   - Password: test123
3. Click "Register"
4. You should see a success message

### Test Login:

1. Go to http://localhost:8080/login.php
2. Enter the email and password you registered with
3. Click "Login"
4. You should be redirected to the dashboard

### Test Duplicate Email:

1. Try registering with the same email again
2. You should see an error message

## 🔧 Troubleshooting

### Issue: "Connection failed" error

**Solution:**

- Make sure MySQL container is running: `docker-compose ps`
- Wait a bit longer for MySQL to initialize
- Check if port 3306 is already in use

### Issue: Database not found

**Solution:**

- Manually create the database using phpMyAdmin
- Run the SQL from `database.sql` file

### Issue: Page not loading

**Solution:**

- Check if Apache container is running
- Verify you're using the correct port (8080 for Docker)
- Check Docker logs: `docker-compose logs apache`

### Issue: Styling not working

**Solution:**

- Make sure `style.css` is in the same directory
- Check browser console for 404 errors
- Clear browser cache

## 🛑 Stopping the Services

To stop all Docker containers:

```bash
docker-compose down
```

To stop and remove all data (including database):

```bash
docker-compose down -v
```

## 📝 Notes

- Passwords are stored in **plain text** as per project requirements (not recommended for production)
- The system uses PHP sessions for authentication
- All form inputs are sanitized to prevent basic XSS attacks
- Email validation ensures proper email format
- Database uses UTF8MB4 encoding for international character support

## 🔐 Security Considerations (For Future Enhancement)

For production use, consider:

- Hashing passwords using `password_hash()` and `password_verify()`
- Using prepared statements (already implemented)
- Adding CSRF protection
- Implementing rate limiting
- Using HTTPS
- Adding input validation on both client and server side

## 📞 Support

If you encounter any issues:

1. Check the Docker logs: `docker-compose logs`
2. Verify all services are running: `docker-compose ps`
3. Check the browser console for JavaScript errors
4. Review PHP error logs in the container

---

**Happy Coding! 🎉**
