select * from project.guestbook_message;
select message_id,guest_name,password,message 
from project.guestbook_message order by project.guestbook_message.message_id desc;


"select message_id, guest_name, password, message " + 
					"from( " + 
					"    select rownum rnum, message_id, guest_name, password, message " + 
					"    from (" + 
					"            select * from guestbook_message order by guestbook_message.message_id desc " + 
					"        ) where rownum <= ? " + 
					" ) where rnum >= ? ";