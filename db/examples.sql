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
select count(bookid)cnt from orders where custid in(select custid from customer where name='박지성');
desc orders;

create table orders2 as select * from orders;
select * from orders2;
insert into orders2 values(11,1,1,6000,sysdate);--중복값 제거하기 위한 데이터 추가
--중복되는 칼럼값이 있을 때 한번만 나타내도로 하는 키워드 distinct
select count(distinct bookid) from orders2 where custid=(select custid from customer where name='박지성');
--서브쿼리의 결과가 여러 건일 때(다중행), =, <=, >=, !=연산자 바로 사용 못함
--다중행 연산자 사용해야 함 in, any, some, all >=, <=, >, <

--박지성이 구매한 도서의 출판사 수
--(1)
select count(distinct publisher)cnt from book where bookid in(select bookid from orders where custid in(select custid from customer where name='박지성'));
--(2)
select count(distinct publisher)cnt from book,orders where book.bookid=orders.bookid and custid=(select custid from customer where name='박지성');
--박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이 
select bookname,price,abs(price-saleprice)diff from book,orders where book.bookid=orders.bookid and custid=(select custid from customer where name='박지성');
--박지성이 구매하지 않은 도서의 이름
select bookname from book where bookid in(select bookid from orders where custid in(select custid from customer where name<>'박지성'));
--union: 검색한 결과 합침
--minus: 검색한 결과에서 뺌
select bookname from book minus select bookname from book where bookid in(select bookid from orders where custid in(select custid from customer where name='박지성'));

--2014년 7월 4일 ~ 7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
--(1)
select orderid from orders minus select orderid from orders where orderdate between '14/07/04' and '14/07/07';
--(2)
select orderid from orders where orderdate not between '14/07/04' and '14/07/07';

--박지성 고객의 2014년도의 주문 총금액의 평균금액을 출력
select sum(saleprice)sum,avg(saleprice)avg from orders where custid in(select custid from customer where name='박지성')and substr(orderdate,1,2)='14';
select sum(saleprice)sum,avg(saleprice)avg from orders where custid in(select custid from customer where name='박지성')and to_char(orderdate,'yyyy')=2014;

--(1-1)고객의 이름과 고객별 구매액
select name,sum(saleprice)sum from customer, orders where customer.custid=orders.custid group by name;
--(1-2)구매내역이 없는사람은 0으로 출력(구매액이 높은순) @@
select name,nvl(sum(saleprice),0)sum from customer left join orders on customer.custid=orders.custid group by name order by sum desc;

--검색한 레코드 중에 상위 몇개만 추출해야할 경우가 있다.(ex TOP10, TOP3)
--오라클에서 검색한 행의 행번호를 붙여주는 속성이 있다.
--rownum ==> 행번호 붙일때 사용하는 명령어 !!!!!!! 매우 유용하게 쓰임!!!!!!!










