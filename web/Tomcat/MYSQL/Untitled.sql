SELECT * FROM project.member;

select count(*) from project.member where uid='cool';
select * from project.member limit 0,3;
select * from project.member limit 3,3;
commit;


select * from guestbook_message;
select rownum rnum,guest_name from guestbook_message;
desc guestbook_message;



select rownum, message_id, message from (select * from guestbook_message order by message_id);
select rownum, message_id, guest_name,password, message from (select * from guestbook_message order by message_id desc);



select rownum rnum, message_id, guest_name,password, message from 
(select * from guestbook_message order by message_id desc)
where rownum<=6;

select message_id, guest_name,password,message
from (select rownum rnum, message_id, guest_name,password, message from 
(select * from guestbook_message order by message_id desc)
where rownum<=3)
where rnum>=1
;

select message_id, guest_name,password,message
from (select rownum rnum, message_id, guest_name,password, message from 
(select * from guestbook_message order by message_id desc)
where rownum<=6)
where rnum>=4
;

select message_id, guest_name,password,message
from (select rownum rnum, message_id, guest_name,password, message from 
(select * from guestbook_message order by message_id desc)
where rownum<=9)
where rnum>=7
;



insert into guestbook_message values(message_id_seq.nextVal,"테스터01","1111","글쓰기 테스트);

