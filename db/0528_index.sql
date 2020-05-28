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
create index emp01_ename_index on emp01 (ename);--select 속도 향상
