select * from project.guestbook_message;
select message_id,guest_name,password,message 
from project.guestbook_message order by project.guestbook_message.message_id desc;
select * from project.member;
select idx,uid,upw,uname,uphoto,regdate from project.member order by project.member.idx desc;
delete from project.member where idx between 12 and 18;
delete from project.member where idx=2;