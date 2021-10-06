CREATE DATABASE exercise;
CREATE TABLE Input (
	resource int auto_increment,
    name varchar(45) not null,
    profession varchar(45) not null,
    primary key (resource));
    
INSERT INTO Input VALUES 
(1, 'Anand', 'Doctor'),
(2, 'Abirami', 'Teacher'),
(3, 'Sukanya', 'Engineer'),
(4, 'Sukumar', 'Lawyer');

SELECT Resource, CONCAT(name, "(", profession, ")") AS Details FROM Input;

-- end of Exercise 1

CREATE TABLE Employee (
	EmpId int auto_increment,
    FName varchar(45) not null,
    LName varchar(45) not null,
    DOB date not null,
    Sex varchar(15),
    Email varchar(100) not null,
    Salary int(10),
    MgrId int,
    DeptId int,
    primary key (EmpId));

INSERT INTO Employee VALUES 
(1, 'Abirami', 'Bob', 1990-01-10, 'Female' 'Abirami@hcl.com', 1000, 2, 10),
(2, 'Bhuvi', 'Rob', 1991-02-10, 'Female' 'Bhuvi@xyz', 500, 3, 20),
(3, 'Chandrima', 'Derek', 1992-03-10, 'Female' '@abc.com', 2000, 4, 30),
(4, 'Debasis', 'Pringle', 1993-04-10, 'Male' 'Debasis@hcl.com', 3000, 5, 40),
(5, 'Engima', 'Gefree', 1995-05-10, 'Female' 'Engima@gmail.com', 4500, 6, 10),
(6, 'Funnel', 'Samas', 1999-06-10, 'Male' 'Funnel@hcl.com', 5500, 7, 20),
(7, 'Gabriel', 'Lal', 1997-07-10, 'Male' 'Gabriel@xyz.com', 6500, 8, 30),
(8, 'Hari', 'Fedrik', 1998-08-10, 'Male' 'Hari@hcl.com', 7900, 9, 40),
(9, 'Inia', 'Gunjan', 1999-09-10, 'Female' 'Inia@hcl.com', 8900, 10, 10),
(10, 'Jaisna', 'Singh', 2000-10-10, 'Female' 'Jaisna@hcl.com', 1000, null, 20);

-- a.	Fetch all the employees data
select * from employee;

-- b.	Fetch only those employees who draws more than minimum salary
select * from employee where salary not in (select min(Salary) from employee);

-- c.	Fetch only those employees who draws more than minimum salary of their department
select * from employee where salary not in (select min(Salary) from employee group by DeptId);

-- d.	Fetch all the employee data along with their Manager Name
-- there is no manager table..gonna create one
create table Manager(
MgrId int not null,
MgrName varchar(100) not null,
primary key(MgrId));

alter table employee
ADD FOREIGN KEY (MgrId) REFERENCES manager(MgrId);

select * from employee inner join manager on employee.MgrId = manager.MgrId;

-- e.	Fetch all the employees who born between 1990 and 1995
select * from employee where DOB BETWEEN CAST('1990-01-01' AS DATE) AND CAST('1995-12-28' AS DATE);

-- f.	Fetch all the employees who draws same salary
(select * from employee group by salary);

-- g.	Fetch all the employees who have a valid email address
select * from employee where Email like '%_@%.com';

-- h.	Fetch all the employees who works for HCL
select * from employee where Email Like '%@hcl.com';

-- i.	Fetch all Female employees data
select * from employee where Sex = 'Female';

-- j.	Fetch all the employees who have Lname as palindrome.
select * from employee where LName = reverse(lName);

-- k.	Fetch all the employees who gets salary more than average salary.
select * from employee where salary > (select avg(Salary) from employee);

-- l.	Fetch highest paid salaried emp details who belongs to department 20.
select * from employee where salary = (select max(salary) from employee where DeptId = 20);

-- m.	Find the employee whose salary is not less than other salary in department.
select * from employee where salary = (select max(salary) from employee);

-- n.	Find the employee whose salary is more than average salary and how much more.
select empId, fName, lName, salary, salary - (select avg(Salary) from employee) AS howMuchMore from employee where salary > (select avg(Salary) from employee);

-- o.	Find the hierarchy with all the levels of data along with their path.

-- -----------------------------------------------------------------------------------
-- 3.	Create a table and load the data.

CREATE TABLE emp (
  empno    int(4),
  ename    varchar(10),
  job      varchar(9),
  mgr      int(4),
  hiredate DATE,
  sal      numeric(7,2),
  comm     numeric(7,2),
  deptno   int(2),
  primary key(empno)
);

INSERT INTO emp VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
INSERT INTO emp VALUES (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30);
INSERT INTO emp VALUES (7566,'JONES','MANAGER',7839,'1981-2-4',2975,NULL,20);
INSERT INTO emp VALUES (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30);
INSERT INTO emp VALUES (7698,'BLAKE','MANAGER',7839,'1981-5-1',2850,NULL,30);
INSERT INTO emp VALUES (7782,'CLARK','MANAGER',7839,'1981-6-9',2450,NULL,10);
INSERT INTO emp VALUES (7788,'SCOTT','ANALYST',7566,'1987-07-13',3000,NULL,20);
INSERT INTO emp VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp VALUES (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30);
INSERT INTO emp VALUES (7876,'ADAMS','CLERK',7788,'1987-07-13',1100,NULL,20);
INSERT INTO emp VALUES (7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30);
INSERT INTO emp VALUES (7902,'FORD','ANALYST',7566,'1981-12-3',3000,NULL,20);
INSERT INTO emp VALUES (7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);
COMMIT;

-- a.	Fetch emp record along with their average salary.
select *, avg(sal) AS AvgSalary from emp; 

-- b.	Fetch emp record along with their average salary per department.
select * from emp e, (select deptno, avg(sal) avg_sal from emp group by
deptno) e1
where e.deptno=e1.deptno;

-- c.	Fetch emp record along with first salary reported in each department.
select eName, sal, deptno, hiredate from emp group by deptno;

-- d.	Fetch emp record along with average department salary so far (cumulative total).
select * from emp e, (select deptno, avg(sal) avg_sal from emp group by
deptno) e1
where e.deptno=e1.deptno;
-- e.	Fetch emp record (salary in ascending order) along with previous record salary and next record salary
select ename, empno, job, sal from emp order by sal;
-- 4.	Create a Customer table with following fields:
-- 		CustId, FirstName, LastName, DOB, Sex, Address, Country, On_Board_Date 

create table Customer(
custId int auto_increment,
firstName varchar(50),
lastName varchar(50),
DOB date,
Sex varchar(8),
Address varchar(100),
Country varchar(100),
OBDate Date,
primary key(custId));

 -- a)	Create b-tree index on CustId
 create index idx_custId using btree
 on Customer (custId);
 
-- b)	Create bit map index on Sex
 create index idx_sex using hash
 on Customer (Sex);
 
-- c)	Create Range Partitioned table like Customer with range column as On-Board_Date
CREATE TABLE RangePartitionedCustomer (
    custId int auto_increment,
firstName varchar(50),
lastName varchar(50),
DOB date,
Sex varchar(8),
Address varchar(100),
Country varchar(100),
OBDate Date,
primary key(custId))

PARTITION BY RANGE (OBDate) (
    PARTITION p0 VALUES LESS THAN ('1960-01-01'),
    PARTITION p1 VALUES LESS THAN ('1970-01-01'),
    PARTITION p2 VALUES LESS THAN ('1980-01-01'),
    PARTITION p3 VALUES LESS THAN ('1990-01-01'),
	PARTITION p4 VALUES LESS THAN MAXVALUE

);
-- d)	Create List Partitioned table like Customer with list column on Country
CREATE TABLE ListPartitionedCustomer (
custId int auto_increment,
firstName varchar(50),
lastName varchar(50),
DOB date,
Sex varchar(8),
Address varchar(100),
Country varchar(100),
OBDate Date,
primary key(custId))

PARTITION BY LIST(Country) (
    PARTITION pCountry_1 VALUES IN('United States', 'United Kingdom', 'UAE'),
    PARTITION pCountry_2 VALUES IN('Candada', 'Africa', 'Australia'),
    PARTITION pCountry_3 VALUES IN('Russia', 'Vietnam', 'China'),
    PARTITION pCountry_4 VALUES IN('Japan', 'Korea', 'India')
);
-- e)	Create a composite Rang-List Partitioned table like Customer


