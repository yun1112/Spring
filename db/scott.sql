-- 방명록 테이블
create table guestbook_message(
message_id number(4) primary key,
guest_name varchar2(50) not null,
password varchar2(10) not null,
message varchar2(2000)
);

create sequence message_id_seq INCREMENT by 1 START WITH 1;--message_id 입력할 때 사용
