select empno,job from emp;
select job,sal,empno from emp;
select * from emp;
select * from EMP order by sal desc;
select * from tab;

-- 로그인한 계정이 소유한 테이블 확인
select * from tab;

--emp: 사원정보 가지고 있음
--dept: 부서정보
--bonus: 상여금 테이블
--salgrade: 급여 테이블
select * from bonus;

--desc: 테이블 구조 확인
desc dept;
desc emp;
desc salgrade;

--not null: insert/update시 null값 허용 안함, PK
--varchar2: 가변 문자열, Oracle, MySQL, MSSQL 표기 방법 약간씩 다름
--char: 고정 길이 문자열
--date: 날짜 타입형
--number(precision, scale)

select * from emp;
select * from dept;
select distinct sal from emp order by sal desc;
select sal from emp order by sal desc;

--데이터 검색 질의
select ename,sal,empno --컬럼 이름
from emp --테이블 이름
--order by empno,sal,ename asc
;


select * from dept;

select deptno
from dept;

--select의 결과는 새로운 테이블이다
--컬럼의 산술연산이 가능하다
-- +,-,/,*,mod함수 이용

select * from emp;
select ename,sal,sal+comm from emp;
select ename,sal,sal+500 from emp;
select ename,sal,sal-100 from emp;
select ename,sal,sal*12 as 월급 from emp;
select ename,sal,sal*0.5 as 특별보너스 from emp;

--null: 미확정된 값, 알 수 없는 값
--      연산, 할당, 비교 불가능
--      함수로 null여부 확인 가능
--      null의 연산 결과는 null
--nvl(comm,0): comm이 null인 경우 값 0으로 변경

--null값의 확인
select ename, job, sal, comm, SAL*12, SAL*12+COMM
from emp
;

--null값 치환 함수: nvl(컬럼명, 기본값)
--기본값은 컬럼의 도메인의 자료형과 일치해야 함
select ename, job, sal, nvl(comm,100), sal*12 as salary,
sal*12+nvl(comm,100) as total
from emp
;


--db 문자열표현: 작은따옴표'' 사용
--문자열을 붙여서 출력하는 연산-> ||(파이프 연산자) 사용
select ename||' is a '||job as message from emp;
select ename, job from emp;

--출력 컬럼의 중복을 제거하고 하나씩만 출력: distinct
select deptno from emp;
select distinct deptno from emp;

select distinct deptno,job from emp;






