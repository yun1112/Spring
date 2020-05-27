create table book2 as select * from book;
desc book2;
select * from book2;
select * from customer;
select b.bookid,b.bookname,c.name, b.publisher, o.saleprice
from book2 b, orders o, customer c where b.bookid=o.bookid and c.custid=o.custid
and o.saleprice>=20000;

select bookname,name from (select b.bookid,b.bookname,c.name, b.publisher, o.saleprice
from book2 b, orders o, customer c where b.bookid=o.bookid and c.custid=o.custid
and o.saleprice>=20000);

select * from emp;
select * from dept;
--사원의 이름과 부서의 이름(조인, 스칼라 부속질의)
select ename,(select dname from dept d where d.deptno=e.deptno)dname from emp e;
--'CHICAGO'에 근무하는 사원의 이름을 보이시오(조인/인라인 뷰/중첩질의/EXISTS 사용)
select ename from (select deptno, loc from dept where loc='CHICAGO') d, emp e
where d.deptno=e.deptno;

select deptno,loc from dept;
--평균보다 급여가 많은 직원의 이름을 보이시오.
select ename,sal from emp where sal>(select avg(sal) from emp);
--자기 부서의 평균보다 급여가 많은 직원의 이름을 보이시오(상관 부속질의 사용)
select ename from emp e1 where e1.sal>(select avg(sal) from emp e2 where e1.deptno=e2.deptno);

select ename,hiredate,deptno from emp where hiredate<to_date('82/01/01','yy/mm/dd') order by hiredate;
select ename,hiredate,deptno from emp where hiredate<'1982-01-01' order by hiredate;

-- 1. 급여가 1000 이상인 사원들의 부서별 평균 급여를 출력해보세요
--단, 부서별 평균 급여가 2000 이상인 부서만 출력하세요.
select * from dept;
select * from emp;
select deptno, avg(sal) from emp where sal>=1000 group by deptno having avg(sal)>2000;
-- 2. 각 부서별 같은 업무(job)를 하는 사람의 인원수를 구해서 부서번호, 업무(job), 인원수를 부서번호에 대해서 오름차순 정렬해서 출력해 보세요.
select deptno,job,count(*) from emp group by deptno,job order by deptno asc;
--3. 사원번호,부서번호,부서명을 출력하세요 단, 사원이 근무하지 않는 부서명도 같이 출력해보세요.
select e.empno,d.deptno,d.dname from emp e, dept d where e.deptno(+)=d.deptno;
--4.  'DALLAS' 에서 근무하는 사원의 이름, 부서번호를 출력해보세요.
--(1)
select e.ename,d.deptno from emp e, dept d where e.deptno=d.deptno and d.loc='DALLAS';
--(2)
select ename,deptno from emp where deptno=(select deptno from dept where loc='DALLAS');
--(3)
select ename,(select deptno from dept where loc='DALLAS') from emp e;
--(4)
select ename from emp,(select deptno,loc from dept where loc='DALLAS');
--5. 급여를 3000 이상받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 이름과 급여, 부서번호를 출력해 보세요
select ename,sal,deptno from emp where deptno in(select deptno from emp where sal>=3000);
--6.   IN 연산자를 이용하여 부서별로 가장 급여를 많이 받는 사원의 사원번호, 급여, 부서번호를 출력해보세요.
select ename,sal,deptno from emp where sal in(select max(sal) from emp group by deptno);
--7.   30번 부서의 사원중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력해보세요.
--(1)
select ename,sal from emp where sal>all(select sal from emp where deptno=30);
--(2)
select ename,sal from emp where sal>(select max(sal) from emp group by deptno having deptno=30);
--8. 부서번호가 30번인 사원들의 급여중 최저 급여보다 높은 급여를 받는 사원의 이름, 급여를 출력해보세요.
select ename,sal from emp where sal>(select min(sal) from emp) and deptno=30;
select * from emp;
------------------------------------------------------------------------부속질의 예제
--박지성의 총 구매액
select * from book;
select * from orders;
select * from customer;

select sum(saleprice) from orders where custid in(select custid from customer where name='박지성');

--박지성이 구매한 도서의 수
select bookid from orders where custid in(select custid from customer where name='박지성');






