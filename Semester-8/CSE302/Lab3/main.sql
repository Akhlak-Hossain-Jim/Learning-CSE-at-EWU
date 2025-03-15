-- Lab tasks

-- Q1
SELECT branch_name, branch_city
FROM branch
WHERE assets > 1000000;

-- Q2
SELECT account_number, balance
FROM account
WHERE branch_name = 'Downtown' OR balance BETWEEN 600 AND 750;

-- Q3
SELECT account_number
FROM account a, branch b
WHERE a.branch_name = b.branch_name AND b.branch_city = 'Rye';

-- Q4
SELECT l.loan_number
FROM loan l
JOIN borrower b ON l.loan_number = b.loan_number
JOIN customer c ON b.customer_name = c.customer_name
WHERE c.customer_city = 'Harrison';

-- Q5
SELECT *
FROM account
ORDER BY balance DESC;

-- Q6
SELECT *
FROM customer
ORDER BY customer_city ASC;

-- Q7
SELECT customer_name
FROM depositor
INTERSECT
SELECT customer_name
FROM borrower;

-- Q8
SELECT customer_name
FROM depositor
UNION
SELECT customer_name
FROM borrower;

-- Q9
SELECT customer_name,customer_city
From customer NATURAL JOIN (SELECT customer_name
FROM borrower
MINUS
SELECT customer_name
FROM depositor);

-- Q10
SELECT SUM(assets) AS total_assets 
FROM branch;

-- Q11
SELECT branch_name, AVG(balance) AS avg_balance
FROM account
GROUP BY branch_name;

-- Q12
SELECT branch_city, AVG(balance) AS avg_balance
FROM account NATURAL JOIN branch
GROUP BY branch_city;

-- Q13
SELECT branch_name, MIN(amount) AS lowest_loan
FROM loan
GROUP BY branch_name;

-- Q14
SELECT branch_name, COUNT(loan_number) AS loans
FROM loan
GROUP BY branch_name

-- Q15
SELECT c.customer_name, a.account_number
FROM account a
JOIN depositor d ON a.account_number = d.account_number
JOIN customer c ON d.customer_name = c.customer_name
WHERE a.balance = (SELECT MAX(balance) FROM account);
