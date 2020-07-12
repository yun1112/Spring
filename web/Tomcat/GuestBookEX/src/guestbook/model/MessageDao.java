package guestbook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import guestbook.dao.Message;

public class MessageDao {
	private MessageDao() {
	}

	static private MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {return dao;}
	
	public Message selectMessage(Connection conn) throws SQLException {
		Message message=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from guestbook_message";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				message=new Message(
						rs.getInt("message_id"),
						rs.getString("guest_name"),
						rs.getString("password"),
						rs.getString("message")
						);
			}
			
		}finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
		}
		return message;
		
	}
}
