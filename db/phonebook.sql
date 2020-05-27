
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
drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_uiv;
rollback;
desc phoneInfo_basic;
create table phoneInfo_com(
idx NUMBER(6),
fr_c_company VARCHAR2(20) DEFAULT 'N',
fr_ref NUMBER(6),
PRIMARY KEY(idx),
FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx) on delete cascade
);
drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_univ;

create table phoneInfo_univ(
idx NUMBER(6),
fr_u_major VARCHAR2(20) DEFAULT 'N',
fr_u_year NUMBER(1) DEFAULT 1,
CONSTRAINT c CHECK(fr_u_year>0 and fr_u_year<5),
fr_ref NUMBER(7),
PRIMARY KEY(idx),
FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx) on delete set null
);
--외래키 설정시 부모의 행이 삭제될 때 설정
--REFERENCES phoneInfo_basic(idx) on delete 설정 옵션
--on 이벤트가 발생했을 때
--on delete
--on update
--no action 모두 삭제 불가
--@cascade 참조를 하고 있는 자식테이블의 모든 행도 삭제
--@set null 참조를 하고 있는 자식테이블의 모든 행의 외래키 컬럼 값을 null로 변경
--set default 참조를 하고 있는 자식테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경

drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_univ;
------------------------------------------------실습
delete phoneInfo_basic;
--phoneInfo_basic
--전체 친구 목록 출력: 테이블 3개 JOIN
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(pb_basic_idx_seq,'가나다','010-1212-1212','gnd@h.com','서울',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(pb_basic_idx_seq.nextval,'김김','010-2222-1212','kk@h.com','제주',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(pb_basic_idx_seq.nextval,'이황','010-1231-1111','lh@h.com','안동',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(pb_basic_idx_seq.nextval,'강','010-2222-2222','k@h.com','춘천',sysdate);
rollback;
drop table phoenInfo_basic;

desc phoneInfo_basic
--테이블 3개 JOIN-1
select * from phoneinfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx=pu.fr_ref (+) and pb.idx=pc.fr_ref(+);

--테이블 3개 JOIN-2(left out join 이용)
select * from phoneInfo_basic pb
left outer join phoneInfo_univ pu on pb.idx=pu.fr_ref
left outer join phoneInfo_univ pc on pb.idx=pc.fr_ref
;

--phoneInfo_univ
insert into phoneInfo_univ(idx,fr_u_major,fr_u_year,fr_ref) values(pb_com_idx_seq,'컴퓨터공학',1,pb_basic_idx_seq.currval);--1,가나다~(기본정보)
insert into phoneInfo_univ(idx,fr_u_major,fr_u_year,fr_ref) values(pb_com_idx_seq.nextval,'체육교육',3,pb_basic_idx_seq.nextval);
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_univ);

desc phoneInfo_com;
--phoneInfo_com
insert into phoneInfo_com(idx,fr_c_company,fr_ref) values(pb_basic_idx_seq.nextval,'엔씨소프트',2);
insert into phoneInfo_com(idx,fr_c_company,fr_ref) values(pb_com_idx_seq.nextval,'넥슨',pb_basic_idx_seq.currval);
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_com);

-------------------------------------------------------------------05/27
--1.회사친구의 정보 변경
update phoneInfo_com set fr_c_company='삼성' where idx=2;
update phoneInfo_com set fr_c_company='애플' where fr_ref=(select idx from phoneInfo_basic where fr_name='김김');
select * from phoneInfo_com;
--2.학교 친구 정보 변경
update phoneInfo_univ set fr_u_major='유아교육',fr_u_year=2 where idx=2;
update phoneInfo_univ set fr_u_major='수학교육' where fr_ref=(select idx from phoneInfo_basic where fr_address='서울');
select * from phoneInfo_univ;

--1. 회사 친구 정보를 삭제

delete from phoneInfo_com where fr_ref=2;
delete from phoneInfo_basic where idx=2;

delete from phoneInfo_com where fr_ref=4;
delete from phoneInfo_basic where idx=4;

--2. 학교 친구 정보를 삭제
--delete from phoneInfo_univ where fr_u_major='유아교육';
--delete from phoneInfo_basic;

delete from phoneInfo_univ where fr_ref=1;
delete from phoneInfo_basic where idx=1;

delete from phoneInfo_univ where fr_ref=3;
delete from phoneInfo_basic where idx=3;
------------------------------------------------------------------------
select * from phoneInfo_basic;
select * from phoneInfo_univ;
select * from phoneInfo_com;

select idx from phoneInfo_basic where fr_address='서울';

------------------------------------------------------------------------
--view 생성
------------------------------------------------------------------------
--조인
select * from phoneinfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx=pu.fr_ref (+) and pb.idx=pc.fr_ref(+);

select * from pb_all_view pb, pb_uiv_view pu, pb_com_view pc
where pb.idx=pu.fr_ref (+) and pb.idx=pc.fr_ref(+);

--뷰 생성 pb_all_view
--select
create or replace view pb_all_view as select idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate
from phoneinfo_basic;
select * from pb_all_view;

create or replace view pb_all_view (name,phonenumber,email,address,major,grade,company)--(별칭)
as select pb.fr_name,pb.fr_phonenumber,pb.fr_email,pb.fr_address,pu.fr_u_major,pu.fr_u_year,pc.fr_c_company
from phoneinfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx=pu.fr_ref (+) and pb.idx=pc.fr_ref(+);
select * from pb_all_view;
select * from pb_all_view where name='김김';

drop view pb_all_view;
--pb_uiv_view
--select * from phoneinfo_univ where idx in(select fr_ref from phoneInfo_univ);
create or replace view pb_univ_view (name,phonenumber,email,address,major,grade)
as select pb.fr_name,pb.fr_phonenumber,pb.fr_email,pb.fr_address,pu.fr_u_major,pu.fr_u_year
from phoneinfo_basic pb, phoneInfo_univ pu;
select * from pb_univ_view;

--create or replace view pb_uiv_view as select idx,fr_u_major,fr_u_year,fr_ref
--from phoneinfo_univ;
--select * from pb_uiv_view;

--pb_com_view
--select * from phoneInfo_com where idx in(select fr_ref from phoneInfo_com);
create or replace view pb_com_view (name,phonenumber,email,address,company)as select pb.fr_name,pb.fr_phonenumber,pb.fr_email,pb.fr_address,pc.fr_c_company
from phoneinfo_basic pb, phoneInfo_com pc;
select * from pb_com_view;


------------------------------------------------------------------------------------05/27 시퀀스추가
--시퀀스 생성
------------------------------------------------------------------------------------
--1.basic 테이블 sequence
create sequence pb_basic_idx_seq
start with 1;

drop sequence pb_basic_idx_seq;
--2.com 테이블 sequence
create sequence pb_com_idx_seq
start with 1;
--3.univ 테이블 sequence
create sequence pb_univ_idx_seq
start with 1;


--시퀀스 수정
