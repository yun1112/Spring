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


SELECT A.TABLE_NAME AS "테이블명",
       A.COLUMN_NAME AS "컬럼명",
       A.DATA_TYPE AS "데이터타입",
       A.DATA_LENGTH AS "길이",
       A.NULLABLE AS "Null 여부",
       B.COMMENTS AS "Comments"
FROM   dba_tab_columns A,
       all_col_comments B
WHERE  A.OWNER = B.OWNER
AND    A.TABLE_NAME = B.TABLE_NAME
AND    A.COLUMN_NAME = B.COLUMN_NAME
AND    A.OWNER = 'LOTOSDEV'
ORDER BY A.TABLE_NAME




CREATE TABLE project.MemberBoard (
	idx INT NOT NULL auto_increment PRIMARY KEY ,
	userid varchar(200) NOT NULL,
	userpw varchar(200) NOT NULL,
    usernickname varchar(20) NOT NULL,
    contactnumber varchar(20) NOT NULL,
    address vachar(200) NOT NULL,
    member
    
    
	regdate DATETIME DEFAULT NOW() NOT NULL,
	title varchar(200) NOT NULL,
	content varchar(10000) NOT NULL,
	viewcount INT NOT NULL DEFAULT 0,
	filecontentaddr varchar(2000) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=1;













