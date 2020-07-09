package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Guest;

public class GuestListService {
	
	// 싱클톤 패턴
	private GuestListService() {
	}
	private static GuestListService service = new GuestListService();
	public static GuestListService getInstance() {
		return service;
	}
	
	
	
	GuestbookDao dao ;
	
	// 예외처리 , 트랜젝션
	public List<Guest> getGuestbookList(){
		// 사용할 Dao 인스턴스
		dao = GuestbookDao.getInstance();
		// Connection 
		Connection conn=null;
		List<Guest> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			list = dao.getGuestList(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
