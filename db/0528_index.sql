-----------------------------------------------------------------------[index]--------
--검색을 빠르게 하기 위해 사용
--DML작업에는 성능 저하가 올 수 있음
desc user_ind_columns;
select index_name,table_name,column_name from user_ind_columns where table_name='emp01';

--테스트 테이블 생성
drop table emp01;

create table emp01
as select * from emp;

desc emp01;

select * from emp01;
insert into emp01 select * from emp01;
select count(*) from emp01;
insert into emp01 (empno,ename) values (2222,'PARK');
delete from emp01 where empno=1111;
select * from emp01 where ename='SON';--F10 누르면 적용된 index 정보 확인할 수 있음
select * from emp01 where ename='PARK';

select * from emp where empno=1111;

--index 생성
--create index 인덱스명 on 테이블명 (컬럼명)
--create index emp01_ename_index on emp01 (ename);--select 속도 향상
-- 1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는
--     이름이 MEMBER인 테이블을 생성하세요.
--     회원 아이디에는 기본키 제약설정을 하고, 이름과 비밀번호에는 not null,
--     가입일은 기본 값으로 sysdate가 입력되도록 하시오.
create table MEMBER(
idx NUMBER(5) primary key,
id varchar2(50),
name varchar2(20) not null,
password varchar2(20) not null,
pic_id varchar2(20),
sign_date varchar(20) default sysdate)

);

--  2. MEMBER 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.
create index name_idx on MEMBER(name);

--  3. MEMBER 테이블에서 회원 아이디, 이름, 사진 정보만을 출력하는 view 객체를
-- 생성하시오.
--   view의 이름은 member_view 로 생성하시오.
create view member_view as select id, name, pic_id from MEMBER;

