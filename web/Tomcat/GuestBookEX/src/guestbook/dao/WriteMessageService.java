package guestbook.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.jdbc.ConnectionProvider;
import guestbook.model.MessageDao;

public class WriteMessageService {
	private WriteMessageService() {}
	static private WriteMessageService service=new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	
	MessageDao dao=null;
	
	public void writeMessage(Message message) throws SQLException {
		dao=MessageDao.getInstance();
		
		Connection conn=null;
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=MessageDao.getInstance();
			
			List<Message> messageList=null;
			messageList.add(dao.selectMessage(conn));
			
		} finally {
			
			if(conn!=null)
				conn.close();
		}
		
		
		
	}
}
