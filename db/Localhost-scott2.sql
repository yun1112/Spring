
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
FOREIGN KEY(fr_ref) REFERENCES phoneInfo_basic(idx)
);
drop table phoneInfo_com;

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
delete phoneInfo_basic;
--phoneInfo_basic
--전체 친구 목록 출력: 테이블 3개 JOIN
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(1,'가나다','010-1212-1212','gnd@h.com','서울',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(2,'김김','010-2222-1212','kk@h.com','제주',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(3,'이황','010-1231-1111','lh@h.com','안동',sysdate);
insert into phoneInfo_basic(idx,fr_name,fr_phonenumber,fr_email,fr_address,fr_regdate) values(4,'강','010-2222-2222','k@h.com','춘천',sysdate);
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
insert into phoneInfo_univ(idx,fr_u_major,fr_u_year,fr_ref) values(1,'컴퓨터공학',1,1);--1,가나다~(기본정보)
insert into phoneInfo_univ(idx,fr_u_major,fr_u_year,fr_ref) values(2,'체육교육',3,3);
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_univ);

desc phoneInfo_com;
--phoneInfo_com
insert into phoneInfo_com(idx,fr_c_company,fr_ref) values(1,'엔씨소프트',2);
insert into phoneInfo_com(idx,fr_c_company,fr_ref) values(2,'넥슨',4);
select * from phoneInfo_basic where idx in(select fr_ref from phoneInfo_com);

-------------------------------------------------------------------05/27
--1.회사친구의 정보 변경
update phoneInfo_com set fr_c_company='삼성' where idx=2;
update phoneInfo_com set fr_c_company='애플' where fr_ref=(select idx from phoneInfo_basic where fr_name='김김');

select * from phoneInfo_com;
--2.학교 친구 정보 변경
update phoneInfo_univ set fr_u_major='유아교육',fr_u_year=2 where idx=2;
update phoneInfo_univ set fr_u_major='수학교육' where fr_ref=(select idx from phoneInfo_basic where fr_address='서울');

--1. 회사 친구 정보를 삭제
delete from phoneInfo_com where idx=1;
rollback;
delete from phoneInfo_com where fr_ref=2;
delete from phoneInfo_basic where idx=2;
--2. 학교 친구 정보를 삭제
delete from phoneInfo_univ where fr_u_major='유아교육';
delete from phoneInfo_basic;

delete from phoneInfo_univ where fr_ref=1;
delete from phoneInfo_basic where idx=1;

select * from phoneInfo_basic;
select * from phoneInfo_univ;
select * from phoneInfo_com;

select idx from phoneInfo_basic where fr_address='서울';