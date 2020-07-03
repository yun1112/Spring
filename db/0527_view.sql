--view
--논리적인 가상 테이블:테이블과 같이 사용 가능, 제약은 존재
--물리적인 테이블을 기반으로 만듦: select 서브쿼리를 이용해서 만듦
--create [or replace] view 뷰명 as 서브쿼리
--자주 사용되는 데이터 뷰로 정의해서 사용
--자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를
--출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다. 
--create table emp_cp as select * from emp;
--create/drop view 권한 부여함
create view emp_view30 as select empno,ename,deptno from emp_cp where deptno=30;--권한부여 필요함
desc emp_view30;
select * from emp_view30;
--데이터 딕셔너리 user_views테이블
--user_views 테이블의 text 컬럼 값: 뷰 정의할 때 기술한 쿼리문 확인
desc user_views;
select view_name,text from user_views;--만든 가상테이블 확인

drop view emp_view30;

--인라인 뷰로 TOP-N 구하기
--1.view 객체 생성
--뷰 만들어서 원하는 정렬 순서대로 rownum 재정렬
create or replace view emp_hir_view as select empno,ename,hiredate from emp order by hiredate asc;
select * from emp_hir_view;
--오름차순으로 rownum 정렬(뷰 생성할 때 설정한 정렬 차순)
select rownum,empno,ename,hiredate from emp_hir_view where rownum<=5;--상위 5명 출력
select rownum,empno,ename,hiredate from emp order by hiredate;--입력된 순서로 rownum 정해짐




create table MEMBER(
idx NUMBER(5) primary key,
id varchar2(50),
name varchar2(20) not null,
password varchar2(20) not null,
pic_id varchar2(20),
sign_date varchar(20) default sysdate
);

create index name_idx on MEMBER(name);

create view member_view as select id, name, pic_id from MEMBER;







