package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MemberDao;
import jdbc.ConnectionProvider;
import guestbook.model.MemberMessage;
import guestbook.model.Message;

public class WriteMemberMessageService {
	
	private WriteMemberMessageService() {}
	private static WriteMemberMessageService service = new WriteMemberMessageService();
	public static WriteMemberMessageService getIstance() {
		return service;
	}
		
	MemberDao dao = null;
	
	public int writeMessage(MemberMessage mesage) {
		int result = 0;
		dao = MemberDao.getInstance();
		// Dao의 메서드에 전달할 Connection
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.insertMessage(conn, mesage);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
