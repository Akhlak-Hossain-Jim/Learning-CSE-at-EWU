CREATE TABLE instructor_2022360057 (
    ID NUMBER,
    NAME VARCHAR2(20),
    DEPT_NAME VARCHAR2(10),
    SALARY NUMBER
);

CREATE TABLE COURSE_2022360057 (
    COURSE_ID VARCHAR2(10),
    TITLE VARCHAR2(50),
    DEPT_NAME VARCHAR2(15),
    CREDITS NUMBER
);

INSERT INTO instructor_2022360057 (ID, name, dept_name, salary)
VALUES
(10101, 'Srinivasan', 'Comp. Sci.', 65000),
(12121, 'Wu', 'Finance', 90000),
(15151, 'Mozart', 'Music', 40000),
(22222, 'Einstein', 'Physics', 95000),
(32343, 'El Said', 'History', 60000),
(33456, 'Gold', 'Physics', 87000),
(45565, 'Katz', 'Comp. Sci.', 75000),
(58583, 'Califieri', 'History', 62000),
(76543, 'Singh', 'Finance', 80000),
(76766, 'Crick', 'Biology', 72000),
(83821, 'Brandt', 'Comp. Sci.', 92000),
(98345, 'Kim', 'Elec. Eng.', 80000);

INSERT INTO COURSE_2022360057 (course_id, title, dept_name, credits)
VALUES
('BIO-101', 'Intro. to Biology', 'Biology', 4),
('BIO-301', 'Genetics', 'Biology', 3),
('BIO-399', 'Computational Biology', 'Biology', 3),
('CS-101', 'Intro. to Computer Science', 'Comp. Sci.', 4),
('CS-190', 'Game Design', 'Comp. Sci.', 4),
('CS-315', 'Robotics', 'Comp. Sci.', 3),
('CS-319', 'Image Processing', 'Comp. Sci.', 3),
('CS-347', 'Database System Concepts', 'Comp. Sci.', 3),
('EE-181', 'Intro. to Digital Systems', 'Elec. Eng.', 2),
('FIN-201', 'Investment Banking', 'Finance', 3),
('HIS-351', 'World History', 'History', 3),
('MU-199', 'Music Video Production', 'Music', 3),
('PHY-101', 'Physical Principles', 'Physics', 4);

-- QUERIES
SELECT NAME FROM instructor_2022360057;
SELECT COURSE_ID, TITLE FROM COURSE_2022360057;
SELECT NAME, DEPT_NAME FROM Instructor_2022360057 WHERE ID = 22222;
SELECT TITLE, CREDITS FROM COURSE_2022360057 WHERE DEPT_NAME = 'Comp. Sci.';
SELECT NAME, DEPT_NAME FROM Instructor_2022360057 WHERE SALARY > 70000;
SELECT TITLE FROM COURSE_2022360057 WHERE CREDITS >= 4;
SELECT NAME, DEPT_NAME FROM Instructor_2022360057 WHERE SALARY >= 80000 AND SALARY <= 100000;
SELECT TITLE, CREDITS FROM COURSE_2022360057 WHERE NOT DEPT_NAME = 'Comp. Sci.';
SELECT * FROM Instructor_2022360057;
SELECT TITLE, CREDITS FROM COURSE_2022360057 WHERE DEPT_NAME='Biology' AND NOT CREDITS = 4;