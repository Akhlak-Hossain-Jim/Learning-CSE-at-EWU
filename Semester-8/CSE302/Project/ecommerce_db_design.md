# E-Commerce Database Design

## Entity-Relationship Diagram Description

### Entities (12 Total)

#### Strong Entities (11):
1. **Customer** - Registered users who can make purchases
2. **Product** - Items available for sale
3. **Category** - Product classification system
4. **Supplier** - Vendors who provide products
5. **Order** - Purchase transactions
6. **Payment** - Payment processing records
7. **Shipping** - Delivery information
8. **Review** - Customer product reviews
9. **Coupon** - Discount codes
10. **Inventory** - Stock management
11. **Admin** - System administrators

#### Weak Entity (1):
12. **OrderItem** - Individual items within an order (weak entity dependent on Order)

### ISA Relationship
**Person** (Superclass)
- **Customer** (Subclass)
- **Admin** (Subclass)

## Detailed Entity Attributes

### 1. Person (Superclass)
- **person_id** (PK) - Primary Key
- **full_name** (Composite: first_name, last_name)
- **email**
- **phone_numbers** (Multivalued)
- **created_at**

### 2. Customer (ISA from Person)
- **customer_id** (PK) - Primary Key
- **person_id** (FK) - Foreign Key to Person
- **date_of_birth**
- **gender**
- **loyalty_points**
- **registration_date**
- **shipping_addresses** (Multivalued: street, city, state, zip, country)
- **age** (Derived from date_of_birth)

### 3. Admin (ISA from Person)
- **admin_id** (PK) - Primary Key
- **person_id** (FK) - Foreign Key to Person
- **role**
- **hire_date**
- **access_level**

### 4. Product
- **product_id** (PK) - Primary Key
- **category_id** (FK) - Foreign Key to Category
- **supplier_id** (FK) - Foreign Key to Supplier
- **name**
- **description**
- **price**
- **weight**
- **dimensions** (Composite: length, width, height)
- **is_active**
- **created_date**
- **avg_rating** (Derived from Reviews)

### 5. Category
- **category_id** (PK) - Primary Key
- **name**
- **description**
- **parent_category_id** (FK) - Self-referencing for subcategories

### 6. Supplier
- **supplier_id** (PK) - Primary Key
- **company_name**
- **contact_person**
- **email**
- **phone**
- **address** (Composite: street, city, state, zip, country)
- **rating**

### 7. Order
- **order_id** (PK) - Primary Key
- **customer_id** (FK) - Foreign Key to Customer
- **order_date**
- **status**
- **total_amount** (Derived from OrderItems)
- **shipping_address** (Composite: street, city, state, zip, country)
- **billing_address** (Composite: street, city, state, zip, country)

### 8. OrderItem (Weak Entity)
- **order_id** (Partial Key, FK) - Foreign Key to Order
- **product_id** (Partial Key, FK) - Foreign Key to Product
- **quantity**
- **unit_price**
- **subtotal** (Derived: quantity × unit_price)

### 9. Payment
- **payment_id** (PK) - Primary Key
- **order_id** (FK) - Foreign Key to Order
- **payment_method**
- **amount**
- **payment_date**
- **status**
- **transaction_id**

### 10. Shipping
- **shipping_id** (PK) - Primary Key
- **order_id** (FK) - Foreign Key to Order
- **carrier**
- **tracking_number**
- **shipping_date**
- **delivery_date**
- **shipping_cost**
- **status**

### 11. Review
- **review_id** (PK) - Primary Key
- **product_id** (FK) - Foreign Key to Product
- **customer_id** (FK) - Foreign Key to Customer
- **rating**
- **comment**
- **review_date**
- **is_verified**

### 12. Coupon
- **coupon_id** (PK) - Primary Key
- **code**
- **discount_type** (percentage/fixed)
- **discount_value**
- **min_order_amount**
- **start_date**
- **end_date**
- **usage_limit**
- **times_used**
- **is_active**

### 13. Inventory
- **inventory_id** (PK) - Primary Key
- **product_id** (FK) - Foreign Key to Product
- **quantity_in_stock**
- **reorder_level**
- **last_updated**

## Relationships & Cardinalities

### One-to-One (1:1)
1. **Order** *processes* **Payment** (1:1)
2. **Order** *ships via* **Shipping** (1:1)

### One-to-Many (1:M)
1. **Customer** *places* **Order** (1:M)
2. **Category** *contains* **Product** (1:M)
3. **Supplier** *supplies* **Product** (1:M)
4. **Product** *has* **Inventory** (1:M)
5. **Product** *receives* **Review** (1:M)
6. **Customer** *writes* **Review** (1:M)
7. **Category** *has* **Category** (1:M) - Self-referencing for subcategories

### Many-to-Many (M:N)
1. **Order** *contains* **Product** (M:N) - Resolved through OrderItem weak entity
2. **Customer** *uses* **Coupon** (M:N) - Resolved through CustomerCoupon bridge table

## SQL Schema Implementation

```sql
-- Person (Superclass)
CREATE TABLE Person (
    person_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Phone Numbers (Multivalued attribute)
CREATE TABLE PersonPhone (
    person_id INT,
    phone_number VARCHAR(15),
    phone_type ENUM('mobile', 'home', 'work'),
    PRIMARY KEY (person_id, phone_number),
    FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE
);

-- Customer (ISA subclass)
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    person_id INT UNIQUE NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    loyalty_points INT DEFAULT 0,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE
);

-- Customer Addresses (Multivalued attribute)
CREATE TABLE CustomerAddress (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    street VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    country VARCHAR(50),
    address_type ENUM('shipping', 'billing', 'both'),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE
);

-- Admin (ISA subclass)
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    person_id INT UNIQUE NOT NULL,
    role VARCHAR(50),
    hire_date DATE,
    access_level ENUM('Super', 'Manager', 'Staff'),
    FOREIGN KEY (person_id) REFERENCES Person(person_id) ON DELETE CASCADE
);

-- Category
CREATE TABLE Category (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    parent_category_id INT,
    FOREIGN KEY (parent_category_id) REFERENCES Category(category_id)
);

-- Supplier
CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(100) NOT NULL,
    contact_person VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    street VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    country VARCHAR(50),
    rating DECIMAL(3,2)
);

-- Product
CREATE TABLE Product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT,
    supplier_id INT,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    weight DECIMAL(8,2),
    length DECIMAL(8,2),
    width DECIMAL(8,2),
    height DECIMAL(8,2),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(category_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

-- Inventory
CREATE TABLE Inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT UNIQUE NOT NULL,
    quantity_in_stock INT NOT NULL DEFAULT 0,
    reorder_level INT DEFAULT 10,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE
);

-- Order
CREATE TABLE `Order` (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Processing', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    shipping_street VARCHAR(200),
    shipping_city VARCHAR(50),
    shipping_state VARCHAR(50),
    shipping_zip VARCHAR(10),
    shipping_country VARCHAR(50),
    billing_street VARCHAR(200),
    billing_city VARCHAR(50),
    billing_state VARCHAR(50),
    billing_zip VARCHAR(10),
    billing_country VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- OrderItem (Weak Entity)
CREATE TABLE OrderItem (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

-- Payment (1:1 with Order)
CREATE TABLE Payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT UNIQUE NOT NULL,
    payment_method ENUM('Credit Card', 'Debit Card', 'PayPal', 'Bank Transfer'),
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Completed', 'Failed', 'Refunded') DEFAULT 'Pending',
    transaction_id VARCHAR(100),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE
);

-- Shipping (1:1 with Order)
CREATE TABLE Shipping (
    shipping_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT UNIQUE NOT NULL,
    carrier VARCHAR(50),
    tracking_number VARCHAR(100),
    shipping_date DATE,
    delivery_date DATE,
    shipping_cost DECIMAL(8,2),
    status ENUM('Preparing', 'Shipped', 'In Transit', 'Delivered', 'Returned'),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE
);

-- Review
CREATE TABLE Review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    customer_id INT NOT NULL,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_verified BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE
);

-- Coupon
CREATE TABLE Coupon (
    coupon_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE NOT NULL,
    discount_type ENUM('percentage', 'fixed') NOT NULL,
    discount_value DECIMAL(8,2) NOT NULL,
    min_order_amount DECIMAL(10,2) DEFAULT 0,
    start_date DATE,
    end_date DATE,
    usage_limit INT,
    times_used INT DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE
);

-- CustomerCoupon (M:N relationship bridge table)
CREATE TABLE CustomerCoupon (
    customer_id INT,
    coupon_id INT,
    used_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    order_id INT,
    PRIMARY KEY (customer_id, coupon_id, used_date),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (coupon_id) REFERENCES Coupon(coupon_id) ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id)
);

-- Views for derived attributes
CREATE VIEW CustomerWithAge AS
SELECT 
    c.*,
    TIMESTAMPDIFF(YEAR, c.date_of_birth, CURDATE()) as age
FROM Customer c;

CREATE VIEW ProductWithAvgRating AS
SELECT 
    p.*,
    COALESCE(AVG(r.rating), 0) as avg_rating
FROM Product p
LEFT JOIN Review r ON p.product_id = r.product_id
GROUP BY p.product_id;

CREATE VIEW OrderWithTotal AS
SELECT 
    o.*,
    COALESCE(SUM(oi.quantity * oi.unit_price), 0) as total_amount
FROM `Order` o
LEFT JOIN OrderItem oi ON o.order_id = oi.order_id
GROUP BY o.order_id;
```

## Key Features Summary

### Academic Requirements Met:
✓ **12 Entities** (11 strong, 1 weak)  
✓ **ISA Relationship** (Person → Customer/Admin)  
✓ **All Cardinalities** (1:1, 1:M, M:N)  
✓ **Composite Attributes** (full_name, address, dimensions)  
✓ **Multivalued Attributes** (phone_numbers, shipping_addresses)  
✓ **Derived Attributes** (age, avg_rating, total_amount)  
✓ **Weak Entity** (OrderItem depends on Order)

### Business Value:
- Complete customer management system
- Product catalog with categories and suppliers
- Order processing workflow
- Inventory tracking
- Payment processing
- Shipping management
- Customer reviews and ratings
- Coupon/discount system
- Multi-level user access (Customer/Admin)

This design provides a solid foundation for a real e-commerce platform while satisfying all your academic requirements. The schema is normalized, includes proper constraints, and supports common e-commerce operations like order processing, inventory management, and customer relationship management.