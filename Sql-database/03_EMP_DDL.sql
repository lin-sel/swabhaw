use Swabhav;

create Table DEPT (
	DEPTNO integer NOT NULL,
    DNAME varchar(14),
    LOC varchar(13),
    constraint DEPTNO_PRIMARY_KEY PRIMARY KEY (DEPTNO) 
);

INSERT INTO DEPT VALUES (10, "ACCOUNTING", "NEW YORK"),(20, "RESEARCH", 
"DALLAS"),(30,"SALES","CHICAGO"),(40,"OPERATIONS","BOSTON");

CREATE TABLE EMP (
	EMPNO integer not null,
    ENAME varchar(10),
    JOB varchar(9),
    MGR integer ,
    HIREDATE date,
    SAL decimal(15, 2),
    COMM decimal(15,2),
    DEPTNO integer not null,
    constraint EMP_FOREIGN_KEY foreign key (DEPTNO) references DEPT(DEPTNO),
    constraint EMP_PRIMARY_KEY primary key (EMPNO)
);

alter table EMP add constraint SELF_KEY_REFERENCES foreign key EMP(MGR) references EMP(EMPNO);

create table REGIONS (
	REGION_ID int not null,
	REGION_NAME varchar(25),
    constraint reg_id_pk primary key (REGION_ID)
);

create table COUNTRIES (
	COUNTRY_ID char(2) not null,
    COUNTRY_NAME varchar(40),
    REGION_ID int,
    constraint COUNTRY_C_ID_PK primary key(COUNTRY_ID)
);

alter table COUNTRIES add constraint COUNTR_REG_FK foreign key (REGION_ID) 
references REGIONS(REGION_ID);


-- create table LOCATIONS (
-- 	LOCATION_ID int not null
-- )

-- INsertion
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,STR_TO_DATE('17-NOV-81','%d-%M-%y'),5000,NULL,10);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,STR_TO_DATE('1-MAY-81','%d-%M-%y'),2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,STR_TO_DATE('9-JUN-81','%d-%M-%y'),2450,NULL,10);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,STR_TO_DATE('2-APR-81','%d-%M-%y'),2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,STR_TO_DATE('28-SEP-81','%d-%M-%y'),1250,1400,30);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,STR_TO_DATE('20-FEB-81','%d-%M-%y'),1600,300,30);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,STR_TO_DATE('8-SEP-81','%d-%M-%y'),1500,0,30);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,STR_TO_DATE('3-DEC-81','%d-%M-%y'),950,NULL,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,STR_TO_DATE('22-FEB-81','%d-%M-%y'),1250,500,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,STR_TO_DATE('3-DEC-81','%d-%M-%y'),3000,NULL,20);
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,STR_TO_DATE('17-DEC-80','%d-%M-%y'),800,NULL,20);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,STR_TO_DATE('09-DEC-82','%d-%M-%y'),3000,NULL,20);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,STR_TO_DATE('12-JAN-83','%d-%M-%y'),1100,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,STR_TO_DATE('23-JAN-82','%d-%M-%y'),1300,NULL,10); 


select e.ENAME as Employee , m.ENAME as Manager FROM EMP e 
right outer join EMP m 
ON e.EMPNO = m.MGR; 


drop table EMP;

select * from EMP;

select * from EMP 
order by ENAME ;

select * from EMP 
where DEPTNO = 10;

select * from EMP 
where DEPTNO IN (10, 20);


select * from EMP 
where JOB = "CLERK";
 
select * from EMP 
where COMM is null;

select * from EMP
where SAL BETWEEN 2000 AND 5000;

select ENAME, SAL * 12 as 'Annual Salary' from EMP;


select * from EMP 
order by SAL DESC
limit 3; 

select ENAME , date_format(HIREDATE,"%d-%b-%y") as "Joining Date", DATEDIFF(CURRENT_DATE(), HIREDATE) as Tenure from EMP;


select distinct DEPTNO from EMP;

select DEPTNO from EMP
where ENAME = "SCOTT";

select * from EMP 
where DEPTNO = (SELECT DEPTNO from EMP where ENAME = "SCOTT"); 

select * from EMP 
where JOB = (SELECT JOB from EMP where ENAME = "SMITH"); 










