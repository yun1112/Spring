-- dual 테이블 구조 확인
desc dept

-- dummy 컬럼 저장 값 확인
select * from emp;

select abs(sal-1000) as abs from emp where sal-1000>300 order by (sal-1000) desc;

select sal, nvl(comm,0) as k from emp;

--숫자처리함수
-- trunc 특정 자릿수 잘라냄(버림)

--문자처리함수
--initcap 첫 글자만 대문자, 나머지 글자 소문자 변환

select empno, concat(initcap(ename),'는') as initcap_name,concat(job,'입니다') as concat_job from emp order by empno;
--group by->rollup(), cube()
--함수() over(partition by sth order by sth2)

select substr(ename,1,2) as substr_name,length(ename) as length, sal,lpad(job,5), trim(job)
from emp order by sal desc, ename asc;

select ascii(ename) as ascii, concat(sysdate,'입니다') as today, lpad(job,5) from emp;

--select concat(trunc(months_between(sysdate,'99/01/01')),'개월') from emp;
select to_char(hiredate,'yyyy/mm/dd day') as before, to_char(add_months(hiredate,5),'yy/mon/dd dy') as after, concat(abs(round(months_between(hiredate,sysdate))),'개월 지났습니다') as passedtime from emp;
select ename,sal,to_char(sal,'l999,999')as price, to_char(123456,'99999999999') from emp;
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_date(19990101,'yyyymmdd'), to_date(20000101,'yyyymmdd') from dual;
select ename,hiredate from emp where hiredate=to_date(19810220,'yyyymmdd');
select concat(trunc(sysdate-to_date('1999/01/01','yyyy/mm/dd')),'days have passed')from dual;

--decode(): switch case문과 같은 기능(선택)
--to_char(job)='analyst'
select ename,empno,deptno, decode(deptno, 10, 'accounting',20,'resaerch',30,'sales',40,'operations') as danem from emp;
select empno, ename,job, sal, decode(sal,'analyst',sal*1.05,'salesman',sal*1.1,'manager',sal*1.15,'clerk',sal*1.2) as upsal from emp;

----------------------------------------------------------------------------------문제 8번
select empno, ename, job, sal, decode(job,'ANALYST',to_char(to_number(sal)*1.05),'SALESMAN',to_char(to_number(sal)*1.1),'MANAGER',to_char(to_number(sal)*1.15),'CLERK',to_char(to_number(sal)*1.2),sal) upsal from emp;
--case() : if else문과 유사한 기능
select ename,deptno, case when deptno=10 then 'accounting' when deptno=20 then 'resaerch' when deptno=30 then'sales' when deptno=40 then 'operations' end as dname from emp where deptno is not null;

select deptno, count(*) as num_of_emps, count(comm) as getting_comm from emp group by deptno;


--non-equi join: 특정 범위 내 있는지 확인
select ename,sal,grade from emp,salgrade where sal between losal and hisal;

--self join
select employee.ename ||'의 매니저는' ||manager.ename||'입니다' from emp employee,emp manager where employee.mgr=manager.empno;

--outer join: 조인 조건에 만족하지 못하더라도 해당 row 나타내고 싶을 때 사용
select employee.ename||'의 매니저:'||manager.ename from emp employee, emp manager
where employee.mgr=manager.empno(+);

--ANSI cross join
select * from emp cross join dept where comm is not null;

--ANSI inner join
select ename,dname from emp inner join dept on emp.deptno=dept.deptno where ename='scott';

--동일 이름 컬럼 using(공통컬럼)
select emp.ename, dept.dname from emp inner join dept using(deptno);
select emp.ename,dept.dname from emp natural join dept;


--ANSI outer join
--새로운 ANSI 구문의 outer join: left outer join, righbt outer join, full outer join
--outer join: 한 테이블에는 데이터 존재, 다른 테이블에는 존재x
--            left outer join, right outer join, full outer join
select * from dept dept01 left outer join dept dept02 on dept01.deptno=dept02.deptno;

--example
create table tbl1(id int, name varchar(8));
insert into tbl1(id,name) values(1,'aaa');
insert into tbl1(id,name) values(2,'bbb');
insert into tbl1 values(3,'ccc');
insert into tbl1 values(4,'ddd');
insert into tbl1 values(5,'eee');
--delete from tbl1;
select * from tbl1;

create table tbl2(id int, car varchar(8));
insert into tbl2(id,car) values(2,'avante');
insert into tbl2 values(3,'sonata');
insert into tbl2 values(2,'mini');
update tbl2 set id=2 where car='mini';
update tbl2 set id=3 where car='sonata';
update tbl2 set id=4 where car='avante';
select * from tbl2;

--inner join1
select a.id, a.name, b.car from tbl1 a inner join tbl2 b on a.id=b.id;
--inner join2(=inner join1)
select a.id,a.name,b.car from tbl1 a,tbl2 b where a.id=b.id;

--left outer join(좌측 테이블의 모든 데이터 포함하는 결과 집합 생성)
select a.id,a.name,b.car from tbl1 a left outer join tbl2 b on a.id=b.id;
select a.id,a.name,b.car from tbl1 a left outer join tbl2 b on a.id=b.id where b.id is not null;

--right outer join
select a.id, a.name, b.car from tbl1 a right outer join tbl2 b on a.id=b.id;

--cross join(카티전 조인)
select * from tbl1 cross join tbl2;
select * from tbl1,tbl2;


-------------------------------------------------------------------문제1

--EMP 테이블과 DEPT 테이블을 이용해서 풀이해 주세요.
--1. 덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후
--사원의 이름, 급여, 인상된 급여를 출력하시오.
select ename,sal,sal+300 as incresed from emp;

--2. 사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력하시오,
--연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.
select ename,sal,sal*12+100 as result from emp order by sal*12 desc;

--3. 급여가 2000을 넘는 사원의 이름과 급여를 표현, 급여가 많은 것부터 작은 순으로 출력하시오.
select ename,sal from emp where sal>2000 order by sal desc;

--4. 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
select ename,deptno from emp where empno=7788;

--5. 급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
select ename,sal from emp where sal not between 2000 and 3000;

--6. 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당업무, 입사일을 출력하시오.
select ename,job,hiredate from emp where hiredate between '81/02/20' and '81/05/01';

--7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
select ename,deptno from emp where deptno in(20,30) order by ename desc;

--8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 
--사원의 이름, 급여와 부서번호를 출력, 이름순(오름차순)으로 출력하시오.
select ename,sal,deptno from emp where (sal between 2000 and 3000)
and (deptno in(20,30)) order by ename;

--9. 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. (like 연산자와 와일드카드 사용)
select ename,hiredate from emp where to_char(hiredate,'yyyy') like '1981%';

--10. 관리자가 없는 사원의 이름과 담당 업무를 출력하시오.
select ename,job from emp where mgr is null;

--11. 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 
--급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
select ename,sal,comm from emp where comm is not null order by sal desc,comm desc;

--12. 이름의 세번째 문자가 R인 사원의 이름을 표시하시오.
select ename from emp where ename like '__R%';

--13. 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
select ename from emp where ename like '%A%E%';

--14. 담당업무가 CLERK, 또는 SALESMAN이면서 급여가 $1600, $950 또는 $1300이 아닌 
--사원의 이름, 담당업무, 급여를 출력하시오.
select ename,job,sal from emp where job in('CLERK','SALESMAN') and sal not in(1600,950,1300);

--15. 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.
select ename,sal,comm from emp where comm>=500;


-------------------------------------------------------------------문제2


-- 이름: demo_madang.sql
-- 설명
-- madang 스키마를 생성하고 MADANG 서점 실습테이블과 데이터를 입력한다.

CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

CREATE TABLE  Customer (
  custid      NUMBER(2) PRIMARY KEY,  
  name        VARCHAR2(40),
  address     VARCHAR2(50),
  phone       VARCHAR2(20)
);


CREATE TABLE Orders (
  orderid NUMBER(2) PRIMARY KEY,
  custid  NUMBER(2) REFERENCES Customer(custid),
  bookid  NUMBER(2) REFERENCES Book(bookid),
  saleprice NUMBER(8) ,
  orderdate DATE
);
-- Book, Customer, Orders 데이터 생성
INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '역도 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');  
INSERT INTO Customer VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전',  NULL);

-- 주문(Orders) 테이블의 책값은 할인 판매를 가정함
INSERT INTO Orders VALUES (1, 1, 1, 6000, TO_DATE('2014-07-01','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (2, 1, 3, 21000, TO_DATE('2014-07-03','yyyy-mm-dd'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, TO_DATE('2014-07-03','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (4, 3, 6, 6000, TO_DATE('2014-07-04','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (5, 4, 7, 20000, TO_DATE('2014-07-05','yyyy-mm-dd'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, TO_DATE('2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, TO_DATE( '2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, TO_DATE('2014-07-08','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (9, 2, 10, 7000, TO_DATE('2014-07-09','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (10, 3, 8, 13000, TO_DATE('2014-07-10','yyyy-mm-dd'));

select * from Book;
select * from Customer;
select * from Orders;


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(1) 도서번호가1인도서의이름
select bookname from book where bookid=1;

--(2) 가격이20,000원이상인도서의이름
select bookname from book where price>=20000;

--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) from Orders where custid=1;

--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
select count(*) from Orders where custid=1;

select * from Book;
select * from Customer;
select * from Orders;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(1) 마당서점도서의총개수
select count(*) from Book;

--(2) 마당서점에도서를출고하는출판사의총개수
select count(unique publisher) from Book;

--(3) 모든고객의이름, 주소
select name, address from Customer;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select orderid from Orders where to_char(orderdate) between '14/07/04' and '14/07/07';

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
select orderid from Orders where to_char(orderdate) not between '14/07/04' and '14/07/07';

--(6) 성이‘김’씨인고객의이름과주소
select name,address from Customer where name like '김%';

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name,address from Customer where name like '김%' and name like '%아';



select * from emp;


--------------------------------------------------------------문제 3
--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select ename,substr(to_char(hiredate),1,2) 입사_년도, substr(to_char(hiredate),4,2) as 입사_달 from emp;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select ename from emp where substr(to_char(hiredate),4,2)=4;

--18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select ename from emp where mod(empno,2)=0;

--19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
select to_char(hiredate,'yy/mm/dy') from emp;

--20. 올해 며칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고@@@@@
--TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.// 며칠 지났는지
select to_date(sysdate-2020/01/01,'yyyy/mm/dd') from emp;
--select months_between(to_number(sysdate),2020/01/01) from emp;


--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select ename,nvl(mgr,0) as mgr from emp;

--22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오.
--직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
select ename, job, sal, decode(job,'ANALYST',to_char(to_number(sal)+200),'SALESMAN',to_char(to_number(sal)+180),'MANAGER',to_char(to_number(sal)+150),'CLERK',to_char(to_number(sal)+100),sal) upsal from emp;

--case() : if else문과 유사한 기능
select ename,job,sal, case when job='ANALYST' then to_char(to_number(sal)+200) when job='SALESMAN' then to_char(to_number(sal)+180) when job='MANAGER' then to_char(to_number(sal)+150) when job='CLERK' then to_char(to_number(sal)+100) when job='PRESIDENT' then to_char(to_number(sal)) end from emp;

--23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오.
--평균에 대해서는 정수로 반올림하시오.
select max(sal)max, min(sal)min,sum(sal)sum,trunc(avg(sal))avg from emp;

--24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 평균에 대해서는 정수로 반올림 하시오.
--25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select job,count(*) from emp group by job;

--26. 관리자 수를 출력하시오.
select count(unique mgr) from emp where mgr is not null;

--27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
select max(sal)-min(sal) from emp;

--28. 직급별 사원의 최저 급여를 출력하시오.
--관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고
--결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
select job,min(sal) min from emp where job is not null group by job having min(sal)>=2000
order by min(sal) desc;

--29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오.
--평균 급여는 소수점 둘째 자리로 반올림 하시오.
select deptno, count(*),round(avg(sal),2) from emp group by deptno;

--30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여를 출력하시오.
--평균 급여는 정수로 반올림 하시오. DECODE 사용.
select dept.deptno,dname,loc,count(*), trunc(avg(sal))
from dept,emp where dept.deptno=emp.deptno group by dept.deptno,dname,loc;

--31. 업무를 표시한 다음 해당 업무에 대해
--부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오.
--별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오.
--( hint. Decode, group by )
select dept.deptno as job,sum(sal) dno from dept,emp where dept.deptno=emp.deptno group by dept.deptno order by dept.deptno;


select * from emp;
----------------------------------------------문제 4번
--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select dept.deptno,dname from emp,dept where emp.deptno=dept.deptno and ename='SCOTT';

--33. INNER JOIN과 ON 연산자를 사용하여
--사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select ename,dname,loc from emp e inner join dept d on e.deptno=d.deptno;

--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select ename,dname from emp e inner join dept d on e.deptno=d.deptno where ename like '%A%';

--37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
--using(deptno)
select ename,job, dname from emp e inner join dept d on e.deptno=d.deptno where loc='NEW YORK';

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename,e.empno,m.ename from emp e, emp m where e.mgr=m.empno;

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 
--사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select e.empno,e.ename,m.ename from emp e, emp m where e.mgr=m.empno(+) order by e.empno desc;

--40. SELF JOIN을 사용하여
--지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select e1.ename,e1.deptno,e2.ename from emp e1, emp e2 where e1.deptno=e2.deptno and e1.ename='SCOTT';

--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select e1.ename,e1.hiredate,e2.ename,e2.hiredate from emp e1, emp e2 where e1.ename='WARD' and to_char(e1.hiredate)<to_char(e2.hiredate);

--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select m.ename manager,m.hiredate,e.ename employee,e.hiredate from emp m, emp e where m.empno=e.mgr and(to_char(e.hiredate)<to_char(m.hiredate));



--부속질의
--ROWNUM
select * from customer;
select rownum "순번", custid,name,phone from customer where rownum<=2;
select * from orders;
select * from book;

--스칼라 부속질의: select 절에서 사용, 부속질의 결과를 단일행&열 스칼라 값으로 반환
select custid,(select name from customer cs where cs.custid=od.custid), sum(saleprice) from orders od group by custid;
select (select name from customer cs where cs.custid=od.custid) "name", sum(saleprice) "total" from orders od group by od.custid;

select (select bookname from book bk where bk.bookid=od.bookid) "book" from orders od;

--인라인 뷰: from 절에서 사용, 테이블 이름 대신 인라인 뷰 부속질의 사용 가능->테이블처럼 이용 가능
select cs.name,sum(od.saleprice) "total" from (select custid, name from customer where custid <=2) cs, orders od where cs.custid=od.custid group by cs.name;

--중첩질의(부속질의): where 절에서 사용
select orderid,saleprice from orders where saleprice<=(select avg(saleprice) from orders);
select orderid, custid, saleprice from orders od where saleprice>(select avg(saleprice) from orders so where od.custid=so.custid);

--all, some(any)
select orderid, saleprice from orders where saleprice>all(select saleprice from orders where custid='3');

--exists, not exists: 데이터 존재 유무 확인
select sum(saleprice) "total" from orders od where exists (select * from customer cs where address like '%대한민국%' and cs.custid=od.custid);


--------------------------------------------예제
select * from book;
select * from customer;
select * from orders;

select * from emp;
select * from dept;

--SMITH의 부서를 알아내는 단일행 서브쿼리
select dname from dept where deptno=(select deptno from emp where ename='SMITH');
--CLARK의 급여와 동일하거나 더 많이 받는 사원의 이름과 급여, 입사일 출력
select ename,sal from emp where sal=(select sal from emp where ename='CLARK');--CLARK의 급여
select ename,sal,hiredate from emp where sal>=(select sal from emp where ename='CLARK') and ename<>'CLARK';

--SALES 부서를 근무하는 사원의 이름과 급여를 추출하는 쿼리(JOIN, Subquery 이용)
--JOIN
select e.ename,e.sal from emp e, dept d where e.deptno=d.deptno and d.dname='SALES';
--Subquery
select ename,sal from emp where deptno=(select deptno from dept where dname='SALES');

--다중행 서브쿼리: 수행 결과 여러개 반환, 반드시 다중행 연산자와 함께 사용해야 함
--IN, ANY/SOME, ALL, EXISTS(속도 향상)
-- >ANY: 최솟값보다 큰 값 모두/ <ANY: 최댓값보다 작은 값 모두, 여러 결과 값 중 하나의 값만 만족하면 행 반환
--EXITS 조건 충족하는 값 찾았을 때 바로 검색 중지
--IN: 다중행연산자, 하나의 컬럼이 여러개의 =조건을 가지는 경우
--ALL: 서브쿼리 결과값 중 모든 결과를 만족하는 행 반환
select * from emp where sal>=3000;
select ename,deptno from emp where deptno in(select deptno from emp where sal>=3000) ;
--IN 연산자를 이용하여 부서별로 가장 많은 급여를 받는 사원의 이름, 급여, 부서번호 출력
select ename,sal, deptno from emp where sal in(select max(sal) from emp group by deptno);
--JOB이 MANAGER인 사원이 속한 부서의 부서번호,부서명,근무지역 출력
select deptno,dname,loc from dept where deptno in(select deptno from emp where job='MANAGER');
--이름에 T를 포함하고 있는 사원과 같은 부서에서 근무하는 사원의 이름과 월급,부서번호 출력
select ename,sal,deptno from emp where deptno in(select deptno from emp where ename like'%T%');
--30번 부서 소속 사원 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 추출
--MAX 사용할 필요 없음, 서브쿼리에서 나오는 모든 쿼리를 만족하는 행만 출력
select ename,sal from emp where sal>ALL(select sal from emp where deptno=30);
-- >ALL 최댓값보다 큰 값 모두
--자신의 급여가 평균 급여보다 많고 이름에 S자가 들어가는 사원과 동일한 부서에서 근무하는 모든 사원의
--이름 급여 입사일 출력
select ename,sal,hiredate from emp 
where deptno in(select deptno from emp 
where sal>ALL(select avg(sal) from emp) and ename like '%S%');

select ename,sal,hiredate from emp where deptno in(select deptno from emp where sal>ALL(select avg(sal) from emp) and ename like '%S%'); 

--영업 사원들보다 급여를 많는 받는 사원들의 이름과 급여를 출력하되 영업 사원은 제외
select ename,sal from emp where sal>ALL(select sal from emp where job='SALESMAN') ;

--부서번호가 30번인 사원들의 급여 중 가장 낮은 값보다 높은 급여를 받는 사원이름, 급여,입사일 추출
select ename,sal,hiredate from emp where sal>ANY(select sal from emp where deptno=30) order by sal;
--min함수 이용
select ename,sal,hiredate from emp where sal>(select min(sal) from emp where deptno=30) order by sal;

--부서번호가 10,20인 사원들의 평균 월급보다 많은 사원의 이름, 월급 출력
--다중행연산자 ALL이용
select ename,sal from emp where sal>ALL(select avg(sal) from emp where deptno in(10,20));
--다중행연산자 사용x
select ename,sal from emp where sal>(select avg(sal)from emp where deptno=10 or deptno=20);
--다중컬럼 서브쿼리: 서브쿼리 결과 다중컬럼으로 나옴
select * from emp where(deptno,sal) in(select deptno,max(sal) from emp group by deptno);


select * from emp;
select * from dept;

select b1.bookname from book b1 where b1.price>(select avg(b2.price) from book b2 where b2.publisher=b1.publisher);
select name from customer 
where custid in(select custid from orders 
where bookid in(select bookid from book where publisher='대한미디어'));
select name from customer where custid in(select custid from orders);
select bookname from book where price=(select max(price) from book);
--------------------------------------------

select * from emp;
select * from dept;
--------------------------------------------문제 5번
--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select ename,job from emp where job=(select job from emp where empno=7788);
--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 담당 업무
select ename,job from emp where sal>(select sal from emp where empno=7499);
--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename,job,sal from emp where sal=(select min(sal) from emp);
--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
--job select->그룹함수 중첩해서 사용하려면 서브쿼리 써야함
--select min(avg(sal)) from emp group by job;
select job,avg(sal) from emp group by job having avg(sal)=(select min(avg(sal)) from emp group by job);
--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select ename,sal,deptno from emp where sal in(select min(sal) from emp group by deptno) order by deptno;
--48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시
--(사원번호, 이름, 담당 업무, 급여)하시오.
select empno,ename,job,sal from emp where sal<ALL(select sal from emp where job='ANALYST') and job<>'ANALYST';
--49. 부하직원이 없는 사원의 이름을 표시하시오.
--mgr 번호에 속하지 않는 empno@@@
select ename from emp where empno not in (select mgr from emp where mgr is not null);
select ename from emp where empno in (select mgr from emp);
--50. 부하직원이 있는 사원의 이름을 표시하시오.
select ename from emp where empno in (select mgr from emp);
--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오.
--( 단 BLAKE는 제외 )
select ename,hiredate from emp where deptno in (select deptno from emp where ename='BLAKE') and ename<>'BLAKE';
--52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되
--결과를 급여에 대해서 오름차순으로 정렬하시오.
select empno, ename from emp where sal>ALL(select avg(sal) from emp) order by sal;
--53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select empno,ename from emp where deptno in (select deptno from emp where ename like '%K%');
--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select ename,deptno,job from emp where deptno in(select deptno from dept where loc='DALLAS');
--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select ename,sal from emp where mgr in(select empno from emp where ename='KING');
--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select empno,ename,job from emp where deptno in(select deptno from dept where dname='RESEARCH');
--57. 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.@@@@@
select empno,ename,sal from emp where sal>ALL(select avg(sal) from emp where ename like '%M%');
--58. 평균급여가 가장 적은 업무를 찾으시오.
select job,avg(sal) from emp group by job having avg(sal)=(select min(avg(sal)) from emp group by job);
--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select ename from emp where deptno in(select deptno from emp where job='MANAGER');

--------------------------------------------문제 6번
--마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
select count(publisher) from book where bookid in(select bookid from orders where custid in(select custid from customer where name='박지성'));
--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname,abs(price-saleprice) pricegap from book b,orders o, customer c where b.bookid=o.bookid and o.custid=c.custid and name='박지성';

--(7) 박지성이구매하지않은도서의이름
select bookname from book b,orders o, customer c where b.bookid=o.bookid and o.custid=c.custid;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
select name from customer where custid not in(select custid from orders);
--(9) 주문금액의총액과주문의평균금액
select sum(saleprice) total,avg(saleprice) avgsaleprice from orders;
--(10) 고객의이름과고객별구매액@@@@@
select name,sum(price), avg(price) from customer,orders,book where customer.custid=orders.custid and orders.bookid=book.bookid group by name;
--(11) 고객의이름과고객이구매한도서목록
select * from book;
select * from customer;
select * from orders;

select c.name,b.bookname from customer c, book b, orders o where c.custid=o.custid and o.bookid=b.bookid;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문@@@@@@@@@@@@@@
select * from orders where orderid in(select orderid from orders,book where orders.bookid=book.bookid and price-saleprice=(select max(price-saleprice) from orders,book where orders.bookid=book.bookid));
select orderid,custid,bookid,saleprice,orderdate,bookid from orders where orderid in(select orderid from orders,book where orders.bookid=book.bookid and price-saleprice=(select max(price-saleprice) from orders,book where orders.bookid=book.bookid));

select * from orders where orderid in(select orderid from orders,book where orders.bookid=book.bookid and price-saleprice=(select max(price-saleprice) from orders,book where orders.bookid=book.bookid));

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름@+@@@@
select name from customer c where custid in(select custid from orders o , book b where o.bookid=b.bookid group by custid having avg(price)>(select avg(price) from orders o, book b where o.bookid=b.bookid));

select * from book;
select * from customer;
select * from orders;
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name from customer where custid in(select custid from orders where bookid in(select bookid from book where publisher in(select publisher from book where bookid in(select bookid from orders where custid in(select custid from customer where name='박지성'))))and name<>'박지성');
--select publisher from book where bookid in(select bookid from orders where custid in(select custid from customer where name='박지성'));
--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name from customer where custid in(select custid from orders where bookid in(select bookid from book where publisher in(select count(*) from orders where custid in(select custid from customer) group by custid)));

select name from (select name,publisher from customer,orders,book where customer.custid=orders.custid and orders.bookid=book.bookid group by name, publisher) group by name having count(publisher)>1;


select publisher from book where bookid in(select bookid from orders);
select count(*) from book where bookid in(select bookid from orders);
------------------------------------------------실습1
create table phoneInfo_basic(
idx NUMBER(6),
fr_name VARCHAR2(20) NOT NULL,
fr_phonenumber VARCHAR2(20) NOT NULL,
fr_email VARCHAR2(20),
fr_address VARCHAR2(20),
fr_regdate DATE DEFAULT sysdate,--default sysdate
PRIMARY KEY(idx)
);


create table phoneInfo_com(
idx NUMBER(6),
fr_c_company VARCHAR2(20) DEFAULT 'N',
fr_ref NUMBER(6),
PRIMARY KEY(idx),
FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx)
);

create table phoneInfo_univ(
idx NUMBER(6),
fr_u_major VARCHAR2(20) DEFAULT 'N',
fr_u_year NUMBER(1) DEFAULT 1,
CONSTRAINT c CHECK(fr_u_year>0 and fr_u_year<5),
fr_ref NUMBER(7),
PRIMARY KEY(idx),
FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx)
);

drop table phoneInfo_univ;

------------------------------------------------실습2
drop table Contact;

create table Contact(
pbidx number(4),
constraint pb_pbidx_pk primary key(pbidx),
pbname varchar2(10) not null,
pbnumber varchar(13) not null,
pbaddr varchar(50) default '입력 없음' not null,
pbmail varchar2(50) default '입력 없음' not null,
pbtype varchar2(10) not null,
constraint pb_type_check check(pbtype in('univ','com','cafe')),
pbmajor varchar2(20),
pbgrade number(1),
constraint pb_grade_ck check(pbgrade between 1 and 4),
pbcomName varchar2(50),
pbcomDept varchar2(50),
pbcomJob varchar2(50),
pbcafeName varchar2(50),
pbcafeNickname varchar2(50)
--constraint pb_pbidx_pk primary key(pbidx),
--constraint pb_type_check check(pbtype in ('univ','com','cafe')),
--constraint pb_grade_ck check(pbgrade between 1 and 4)
);


select * from Contact;
select * from phoneInfo_univ;
select * from phoneInfo_com;
select * from phoneInfo_basic;

--기본정보 입력
--학교친구/회사친구/모임친구 정보 입력

desc Contact;
delete from Contact;
--기본 정보 입력
insert into Contact(pbidx,pbname,pbnumber,pbaddr,pbmail,pbtype) values(1,'가나다','010-1212-1212','서울','gnd@h.com','univ');
--학교 친구 정보 입력
insert into Contact(pbidx,pbname,pbnumber,pbaddr,pbmail,pbtype,pbmajor,pbgrade) values(2,'홍길동','010-1111-1111','서울','h@h.com','univ','컴퓨터공학',1);
--회사 친구 정보 입력
insert into Contact(pbidx,pbname,pbnumber,pbaddr,pbmail,pbtype,pbcomname,pbcomdept,pbcomjob) values(3,'김김','010-1231-1111','부산','k@h.com','com','엔씨소프트','개발부','팀장');
--모임 친구 정보 입력
insert into Contact(pbidx,pbname,pbnumber,pbaddr,pbmail,pbtype,pbcafename,pbcafeNickname) values(4,'김등산','010-2222-1111','제주','hiking@h.com','cafe','등산','하이킹머신');

select * from contact;
drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_univ;
------------------------------------------------실습
--phoneInfo_basic
--전체 친구 목록 출력: 테이블 3개 JOIN
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(1,'가나다','010-1212-1212','gnd@h.com','서울',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(2,'김김','010-2222-1212','kk@h.com','제주',sysdate);

--테이블 3개 JOIN-1
select * from phoneinfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx=pu.fr_ref (+) and pb.idx=pc.fr_ref(+);

--테이블 3개 JOIN-2(left out join 이용)
select * from phoneInfo_basic pb
left outer join phoneInfo_univ pu on pb.idx=pu.fr_ref
left outer join phoneInfo_univ pc on pb.idx=pc.fr_ref
;

--phoneInfo_univ
insert into phoneInfo_univ(idx,fr_u_major,fr_u_year,fr_ref) values(1,'컴퓨터공학',1,1);--1,가나다~(기본정보)
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_univ);

--phoneInfo_com
insert into phoneInfo_com(idx,fr_c_company,fr_ref) values(1,'엔씨소프트',2);
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_com);

select * from book;
select * from orders;
select * from customer;
-------------------------------------------------예제
--도서 총 개수
select count(*) cnt from book;
--출판사 총 개수
select count(distinct publisher) cnt from book;
--모든 고객 이름, 주소
select name,address from customer;
--2014/07/04~2014/07/07 주문받은 도서의 주문번호
select orderid, orderdate from orders where orderdate between to_date('2014/07/04','yyyy-mm-dd') and to_date('2014/07/07','yyyy-mm-dd');
select orderid, orderdate from orders where orderdate between '2014-07-04' and '2014-07-07';
--2014/07/04~2014/07/07 주문받은 도서를 제외한 도서의 주문번호
select orderid from orders where orderid not in(select orderid from orders where orderdate between to_date('2014-07-04','yyyy-mm-dd') and to_date('2014-07-07','yyyy/mm/dd'));
--성이 김씨인 고객의 이름, 주소
select name,address from customer where name like '김%';
--성이 김씨이고 이름이 아로 끝나는 고객의 이름, 주소
select name,address from customer where name like '김%아';
--주문하지 않은 고객의 이름(부속질의)
select name from customer where custid not in(select custid from orders);
select name from customer c where not exists(select custid from orders o where o.custid=c.custid);
--주문 금액의 총액과 주문의 평균금액
select sum(saleprice),avg(saleprice) from orders;
--고객의 이름, 고객별 구매액 합과 평균금액
select name,sum(price),avg(price) from customer c,orders o,book b where c.custid=o.custid and b.bookid=o.bookid group by name;
--고객 이름, 고객이 구매한 도서 목록
select name,bookname from customer c, orders o, book b where c.custid=o.custid and b.bookid=o.bookid;
--도서의 가격(book테이블)과 판매가격(orders테이블)의 차이가 가장 많은 주문
select * from orders where orderid in(select orderid from orders,book where orders.bookid=book.bookid and price-saleprice=(select max(price-saleprice) from orders,book where orders.bookid=book.bookid));

select * from orders where orderid in(select orderid from orders,book where orders.bookid=book.bookid
and price-saleprice=(select max(price-saleprice) from orders,book where orders.bookid=book.bookid));

--도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select name from customer where custid in(select custid from orders);
