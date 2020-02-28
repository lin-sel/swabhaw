use Swabhav;

select count(ENAME) from EMP;

select sum(SAL) from EMP;

select avg(SAL) from EMP;

select count(ENAME), sum(SAL), avg(SAL) from EMP;

select DEPTNO, count(ENAME) from EMP
group by DEPTNO; 

select JOB, count(ENAME) from EMP
group by JOB; 

select DEPTNO,JOB,count(ENAME) from EMP
group by DEPTNO, JOB; 

select * from EMP;


select DEPTNO, count(ENAME) as Total from EMP
where DEPTNO in (10,20)
group by DEPTNO
having Total > 2
order by count(DEPTNO) DESC; 

select e.ENAME, d.DNAME from EMP e
join DEPT d
ON e.DEPTNO = d.DEPTNO;

select d.DNAME, count(e.ENAME) from EMP e
join DEPT d
ON e.DEPTNO = d.DEPTNO
group by d.DNAME;

select d.DNAME,e.JOB, count(e.JOB) from EMP e
join DEPT d
ON e.DEPTNO = d.DEPTNO
group by d.DNAME, e.JOB;

select d.DNAME, d.DEPTNO, e.ENAME from DEPT d
join EMP e
ON d.DEPTNO = e.DEPTNO;

select d.DEPTNO, e.ENAME from DEPT d
left join EMP e
ON d.DEPTNO = e.DEPTNO
where ENAME is null;

select e.ENAME as EMPLOYEE , coalesce(d.ENAME, "PRESIDENT") as BOSS from EMP e
left join EMP d
ON e.MGR = d.EMPNO;

select e.ENAME as EMPLOYEE , ed.DNAME , d.ENAME as BOSS from EMP e
join EMP d
ON e.MGR = d.EMPNO
join DEPT ed
ON e.DEPTNO = ed.DEPTNO



