package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.model.Board;

public class BoardDao {

	private BoardDao() {
	}

	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	public int insertBoard(Connection conn, Board board) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.board (user_id,title,item_category,content,view_count,file_content_addr ) VALUES (?,?,?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getUserId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getItemCategory());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getViewCount());
			pstmt.setString(6, board.getFileContentAddr());

			resultCnt = pstmt.executeUpdate();
			System.out.println("내용 추가");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	// -----------------------------------------------------------------------------------------------------------07/24
	// 추가
	public String selectContentById(Connection conn, int id) throws SQLException {
		String content = null;
		PreparedStatement pstmt = null;
		ResultSet rs;

		String sql = "select content from project.board where idx=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				content = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		System.out.println("content SQL확인:" + content);
		return content;

	}

	public Board selectBoardByUid(Connection conn, String uid) throws SQLException {
		String content = null;
		PreparedStatement pstmt = null;
		ResultSet rs;

		Board board = new Board();
		String sql = "select * from project.board where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board.setIdx(rs.getInt("idx"));
				board.setUserId(rs.getString("user_id"));
				board.setTitle(rs.getString("title"));
				board.setItemCategory(rs.getString("item_category"));
				board.setContent(rs.getString("content"));
				board.setViewCount(rs.getString("view_count"));
				board.setFileContentAddr(rs.getString("file_content_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		System.out.println("board SQL확인:" + board);
		return board;

	}
	// -----------------------------------------------------------------------------------------------------------

	public int selectById(Connection conn, String id) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			String sql = "select count(*) from project.board where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select count(*) from project.board");

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return resultCnt;
	}

	public List<Board> selectList(Connection conn, int startRow, int count) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Board> BoardList = new ArrayList<Board>();

		String sql = "select * from project.board order by idx limit ?, ?";
//		String sql = "select * from project.board order by user_name limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board Board = new Board();
				Board.setIdx(rs.getInt("idx"));
				Board.setUserId(rs.getString("user_id"));
				Board.setTitle(rs.getString("title"));
				Board.setItemCategory(rs.getString("item_category"));
				Board.setContent(rs.getString("content"));
				Board.setContent(rs.getString("reg_date"));
				Board.setViewCount(rs.getString("view_count"));
				Board.setFileContentAddr(rs.getString("file_content_addr"));

				BoardList.add(Board);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return BoardList;
	}

	public List<Board> selectAllList(Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Board> BoardList = new ArrayList<Board>();

		String sql = "select * from project.board order by reg_date desc";
//		String sql = "select * from project.board order by user_name limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board Board = new Board();
				Board.setIdx(rs.getInt("idx"));
				Board.setUserId(rs.getString("user_id"));
				Board.setTitle(rs.getString("title"));
				Board.setItemCategory(rs.getString("item_category"));
				Board.setContent(rs.getString("content"));
				Board.setContent(rs.getString("reg_date"));
				System.out.println("reg_date:" + rs.getString("reg_date"));

				Board.setViewCount(rs.getString("view_count"));
				Board.setFileContentAddr(rs.getString("file_content_addr"));

				BoardList.add(Board);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return BoardList;
	}

	public int BoardDelete(Connection conn, int idx) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from project.board where idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	public int BoardUpdate(Connection conn, int idx, Board board) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "update project.board set title=?, content=? where idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getIdx());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		if (result != 0) {
			System.out.println("수정 완료");
		}
		return result;
	}

	public Board selectByIdx(Connection conn, int idx) throws SQLException {

		Board board = new Board();

		PreparedStatement pstmt = null;
		ResultSet rs;
//		private int idx;
//		private String user_id;
//		private String title;
//		private String item_category;
//		private String content;
//		private String view_count;
//		private String file_content_addr;
		try {
			String sql = "select * from project.board where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				board.setIdx(rs.getInt("idx"));
				board.setUserId(rs.getString("user_id"));
				board.setTitle(rs.getString("title"));
				board.setItemCategory(rs.getString("item_category"));
				board.setContent(rs.getString("content"));
				board.setViewCount(rs.getString("view_count"));
				board.setFileContentAddr(rs.getString("file_content_addr"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return board;
	}

	// 수정기능 나중에 추가

//	public int editBoard(Connection conn, Board Board) throws SQLException {
//		
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//		String sql = "update project.board set "
//				   + " user_pw=?, user_name=?, photo=? "
//				   + " where idx=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, Board.getUserPw());
//			pstmt.setString(2, Board.getUserName());
//			pstmt.setString(3, Board.getPhoto());
//			pstmt.setInt(4, Board.getIdx());
//			
//			result = pstmt.executeUpdate();
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return result;
//	}

}
