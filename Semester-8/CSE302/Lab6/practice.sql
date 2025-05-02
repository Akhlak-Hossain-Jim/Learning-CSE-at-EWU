create view customer_at_stamford as
select *
from Customer
where customer_city = 'Stamford';

select *
from customer_at_stamford;

CREATE USER Dabba IDENTIFIED BY chicken_momo;

