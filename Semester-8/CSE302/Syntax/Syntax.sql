-- SQL Full Reference Script
-- Author: ChatGPT

---------------------------------------------------------
-- Part 1: Drop Table
---------------------------------------------------------
DROP TABLE IF EXISTS Employees CASCADE;
DROP TABLE IF EXISTS Departments CASCADE;

---------------------------------------------------------
-- Part 2: Table Creation with Constraints
---------------------------------------------------------
CREATE TABLE Departments (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(100) UNIQUE NOT NULL,
    Budget DECIMAL(15,2) DEFAULT 0 CHECK (Budget >= 0)
);

CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Age INT CHECK (Age > 18),
    Salary DECIMAL(10,2) DEFAULT 50000,
    DepartmentID INT,
    Email VARCHAR(255) UNIQUE,
    ManagerID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DeptID) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (ManagerID) REFERENCES Employees(EmpID)
);

---------------------------------------------------------
-- Part 3: Insert Data
---------------------------------------------------------
INSERT INTO Departments (DeptID, DeptName, Budget) VALUES
(101, 'HR', 50000),
(102, 'IT', 200000),
(103, 'Finance', 150000);

INSERT INTO Employees (EmpID, Name, Age, Salary, DepartmentID, Email, ManagerID) VALUES
(1, 'Alice', 30, 70000, 102, 'alice@example.com', NULL),
(2, 'Bob', 45, 90000, 103, 'bob@example.com', 1),
(3, 'Charlie', 28, 50000, 101, 'charlie@example.com', 1);

---------------------------------------------------------
-- Part 4: Alter Table
---------------------------------------------------------
-- Add Column
ALTER TABLE Employees ADD COLUMN Phone VARCHAR(15);

-- Modify Column (example for MySQL)
-- ALTER TABLE Employees MODIFY COLUMN Salary DECIMAL(12,2);

-- Drop Column
ALTER TABLE Employees DROP COLUMN Phone;

---------------------------------------------------------
-- Part 5: Basic Query
---------------------------------------------------------
SELECT Name, Salary FROM Employees WHERE Age > 30;

---------------------------------------------------------
-- Part 6: Nested Query
---------------------------------------------------------
SELECT Name FROM Employees
WHERE DepartmentID = (
    SELECT DeptID FROM Departments WHERE DeptName = 'IT'
);

---------------------------------------------------------
-- Part 7: Joins
---------------------------------------------------------
-- Inner Join
SELECT e.Name, d.DeptName
FROM Employees e
INNER JOIN Departments d ON e.DepartmentID = d.DeptID;

-- Self Join
SELECT e1.Name AS Employee, e2.Name AS Manager
FROM Employees e1
LEFT JOIN Employees e2 ON e1.ManagerID = e2.EmpID;

-- Natural Join (only if columns match by name)
-- SELECT * FROM Employees NATURAL JOIN Departments;

-- Cross Join
SELECT e.Name, d.DeptName
FROM Employees e
CROSS JOIN Departments d;

-- Left Outer Join
SELECT e.Name, d.DeptName
FROM Employees e
LEFT OUTER JOIN Departments d ON e.DepartmentID = d.DeptID;

-- Right Outer Join
SELECT e.Name, d.DeptName
FROM Employees e
RIGHT OUTER JOIN Departments d ON e.DepartmentID = d.DeptID;

-- Full Outer Join (PostgreSQL Example)
SELECT e.Name, d.DeptName
FROM Employees e
FULL OUTER JOIN Departments d ON e.DepartmentID = d.DeptID;

---------------------------------------------------------
-- Part 8: String Operations
---------------------------------------------------------
SELECT CONCAT(Name, ' - ', Email) AS FullContact FROM Employees;
SELECT UPPER(Name) FROM Employees;
SELECT LOWER(Email) FROM Employees;
SELECT SUBSTRING(Name FROM 1 FOR 3) FROM Employees;
SELECT Name FROM Employees WHERE Name LIKE 'A%';

---------------------------------------------------------
-- Part 9: Set Operations
---------------------------------------------------------
-- Union
SELECT Name FROM Employees
UNION
SELECT DeptName FROM Departments;

-- Union All
SELECT Name FROM Employees
UNION ALL
SELECT DeptName FROM Departments;

-- Intersect (supported in PostgreSQL)
SELECT Name FROM Employees
INTERSECT
SELECT DeptName FROM Departments;

-- Except
SELECT Name FROM Employees
EXCEPT
SELECT DeptName FROM Departments;

---------------------------------------------------------
-- Part 10: Null Values
---------------------------------------------------------
SELECT * FROM Employees WHERE ManagerID IS NULL;
SELECT * FROM Employees WHERE Email IS NOT NULL;

---------------------------------------------------------
-- Part 11: Aggregate Functions
---------------------------------------------------------
SELECT COUNT(*), SUM(Salary), AVG(Salary), MIN(Salary), MAX(Salary)
FROM Employees;

---------------------------------------------------------
-- Part 12: Having Clause
---------------------------------------------------------
SELECT DepartmentID, COUNT(*) AS TotalEmployees
FROM Employees
GROUP BY DepartmentID
HAVING COUNT(*) > 1;

---------------------------------------------------------
-- Part 13: Set Membership
---------------------------------------------------------
SELECT Name FROM Employees
WHERE DepartmentID IN (101, 102);

SELECT Name FROM Employees
WHERE DepartmentID NOT IN (103);

---------------------------------------------------------
-- Part 14: Set Comparisons (ALL, ANY)
---------------------------------------------------------
SELECT Name FROM Employees
WHERE Salary > ALL (
    SELECT Salary FROM Employees WHERE DepartmentID = 101
);

SELECT Name FROM Employees
WHERE Salary > ANY (
    SELECT Salary FROM Employees WHERE DepartmentID = 103
);

---------------------------------------------------------
-- Part 15: Subqueries in FROM Clause
---------------------------------------------------------
SELECT Temp.Name
FROM (
    SELECT Name, Salary FROM Employees WHERE Salary > 60000
) AS Temp;

---------------------------------------------------------
-- Part 16: With Clause (CTE)
---------------------------------------------------------
WITH HighEarners AS (
    SELECT Name, Salary FROM Employees WHERE Salary > 70000
)
SELECT * FROM HighEarners;

---------------------------------------------------------
-- Part 17: Scalar Subqueries
---------------------------------------------------------
SELECT Name,
    (SELECT DeptName FROM Departments WHERE Departments.DeptID = Employees.DepartmentID) AS DepartmentName
FROM Employees;

---------------------------------------------------------
-- Part 18: Deletion, Insertion, Update
---------------------------------------------------------
-- Insert
INSERT INTO Employees (EmpID, Name, Age, Salary, DepartmentID, Email, ManagerID)
VALUES (4, 'David', 32, 85000, 102, 'david@example.com', 1);

-- Update
UPDATE Employees SET Salary = Salary * 1.10 WHERE DepartmentID = 102;

-- Delete
DELETE FROM Employees WHERE EmpID = 4;

---------------------------------------------------------
-- Part 19: CASE Statement
---------------------------------------------------------
SELECT Name, Salary,
    CASE 
        WHEN Salary < 60000 THEN 'Low'
        WHEN Salary BETWEEN 60000 AND 80000 THEN 'Medium'
        ELSE 'High'
    END AS SalaryGroup
FROM Employees;

---------------------------------------------------------
-- Part 20: Views
---------------------------------------------------------
CREATE OR REPLACE VIEW View_HighSalaries AS
SELECT Name, Salary
FROM Employees
WHERE Salary > 80000;

-- Use View
SELECT * FROM View_HighSalaries;

---------------------------------------------------------
-- End of SQL Reference Script
---------------------------------------------------------
