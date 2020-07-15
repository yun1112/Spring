package guestbook.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.MemberMessage;

public class MemberDao {
	
	private MemberDao() {}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}

	
	//member
	//idx, 
	//uid, upw, uname, photo, regdate
	public int insertMessage(Connection conn, MemberMessage message) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql ="insert into member values (idx, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getUid());
			pstmt.setString(2, message.getUpw());
			pstmt.setString(3, message.getUname());
			pstmt.setString(3, message.getUphoto());
			pstmt.setDate(3, new Date(1));
			
			resultCnt = pstmt.executeUpdate();
			
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		
		return resultCnt;
	}

	
	public List<MemberMessage> selectMessageList(Connection conn, int startRow, int endRow ) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		
		List<MemberMessage> list = new ArrayList();
		
		try {
			
			String sql = "select idx, uid, upw, uname, uphoto, regdate " + 
					"from member order by member.idx desc;";
//			String sql = "select message_id, guest_name, password, message " + 
//					"from( " + 
//					"    select rownum rnum, message_id, guest_name, password, message " + 
//					"    from (" + 
//					"            select * from guestbook_message order by guestbook_message.message_id desc " + 
//					"        ) where rownum <= ? " + 
//					" ) where rnum >= ? ";
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, endRow);
//			pstmt.setInt(2, startRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberMessage message  = new MemberMessage(
						rs.getInt("idx"),
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"));
				
				list.add(message);
			}
			
			
		} finally {
			
			if(rs != null){
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return list;
		
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.createStatement();
			String sql = "select count(*) from member";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		
		
		
		return resultCnt;
	}

	public MemberMessage selectMessage(Connection conn, int mid) throws SQLException {
		
		MemberMessage message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				message = new MemberMessage(
						rs.getInt("idx"),
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"));
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		return message;
	}

	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where idx=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}
	
	
	
	
	
	
	
	
	
}
