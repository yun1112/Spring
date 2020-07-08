package guestbook.service;
import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
public class WriteMessageService {
	MessageDao dao = null;
	
	//싱글톤 패턴 처리
	private WriteMessageService() {}
	private static WriteMessageService service=new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return service;
	}
	public int writeMessage(Message message) {
		int result=0;
		dao=MessageDao.getInstance();
		
		//Dao의 메서드에 전달할 Connection
		Connection conn=null;
		try {
		conn=ConnectionProvider.getConnection();
		result=dao.inserTMessage(conn,message);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
