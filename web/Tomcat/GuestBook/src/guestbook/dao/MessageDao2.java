package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.model.Message;

public class MessageDao2 {
	private MessageDao2() {
		
	}
	
	static private MessageDao2 dao=new MessageDao2();//싱글톤 처리
	
	public static MessageDao2 getInstance() {
		return dao;
	}
	
	public int inserTMessage(Connection conn,Message message) throws SQLException{
		int resultCnt=0;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into guestbook_message values(message_id_seq.nextVal,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,message.getUname());
			pstmt.setString(2,message.getPw());
			pstmt.setString(3,message.getMessage());
			
			pstmt.executeUpdate();
		}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		}
		return resultCnt;
	}
}
