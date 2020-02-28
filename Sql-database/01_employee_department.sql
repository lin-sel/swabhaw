create database Swabhav;

show databases;

use Swabhav;

create table Department (
	depart int primary key, 
    departmentName varchar(100), 
    location varchar(120)
);

create table Employee (
	id int primary key not null, 
    name varchar(100) not null, 
    salary int not null, 
    departId int not null, 
    foreign key(departId) references Department(depart)
);

insert into Department values (1, "Sale", "Mumbai"),(2, "Marketing", "Pune");

select * from Department;

insert into Employee values (101, "ABC", 12000, 1);

select * from Employee;
