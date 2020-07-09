package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Guest;

public class GuestbookDao {
	
	
	// 외부에서 객체 생성 하는것을 막는다.
	// 생성자의 접근제어지시자 이용 : private
	private GuestbookDao() {
	}
	
	// 사용할 인스턴스 하나를 생성한다.
	private static GuestbookDao dao = new GuestbookDao();
	
	// EmpDao 인스턴스의 참조값을 반환하는 메서드
	public static GuestbookDao getInstance() {
		return dao;
	}
	

	// Connection 을 매개변수로 받는 이유는 트랜젝션 처리 때문.
	public List<Guest> getGuestList(Connection conn) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs = null;

		List<Guest> guestList = new ArrayList();

		
		
		
		// 3. Statement 생성
		stmt = conn.createStatement();

		//String sql = "select * from guestbook_message order by message_id desc";
		String sql = "select * from guestbook_message";

		// select 의 결과 ResultSet 객체에 담는다.
		rs = stmt.executeQuery(sql);

		// 결과 출력
		while (rs.next()) {
			guestList.add(new Guest(
					rs.getInt("message_id"), 
					rs.getString("guest_name"), 
					rs.getString("password"), 
					rs.getString("message")));
		}
		
		return guestList;
		
	}

}
