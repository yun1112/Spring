create table Contact2(
pidx number(10) primary key,
name varchar2(20) not null,
phonenumber varchar2(20) not null,
address varchar2(50) default 'n' not null,
email varchar2(20) default 'n' not null,
type varchar2(4)
constraint type check(type in ('univ' ,  'com' , 'cafe')),
major varchar2(20),
grade number(1),
company varchar2(20),
department varchar2(20),
job varchar2(20),
cafe varchar2(20),
nickname varchar2(20)
);


drop table Contact2;
select * from dept;
select * from emp;
insert into dept values(11,'MARKETING','AMSTERAM');
update dept set dname='SALES', loc='TAIPEI' where deptno=11;
delete from dept where deptno=11;
desc dept;
desc user_ind_columns;
select index_name,table_name,column_name from user_ind_columns where table_name='emp01';
create index emp_index on emp(ename);
create view emp_view as select * from emp where deptno in(select deptno from dept);
update emp set deptno =(select deptno from emp where ename='SCOTT');
create view emp_view2 as select * from emp;

select * from all_constraints;

create view vw_emp as select empno,ename,job from emp;

--update view vw_emp  select * from emp;

select e.empno,d.deptno from emp e, dept d where e.deptno=d.deptno;
select e.empno,d.deptno from emp e left outer join dept d;--error

--select e.empno,d.deptno from emp e, dept d
select * from dept;
select * from emp;

create table tt as select * from emp;


alter table tt add foreign key(empno) references board(empno);


grant update to user1 with grant option;
alter table tt add primary key(empno);
select * from user_index;
desc emp;
select * from tt;
alter table tt add email varchar(50);
update tt set email='aa' where empno=90;

select * from user_tables;
select * from user_constraints;
select * from user_views;

select e.empno,d.deptno from emp e cross join dept d;
select e.empno,d.deptno from emp e inner join dept d using(deptno);
select e.empno,d.deptno from emp e left outer join dept d;--error

