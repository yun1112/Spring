package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import board.Board;

public class BoardDao extends HttpServlet{
	Connection conn = null;
	
	@Override
	public void init() throws ServletException {
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		String dbID = "temp";
		String dbPW = "temp";
		
		try {
			conn=DriverManager.getConnection(dbURL,dbID,dbPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private BoardDao() {
	}

	static private BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	public List<Board> selectDao() throws SQLException {
		Board board = null;
		List<Board> boardList = new ArrayList<Board>();
//		Driver driver;
//		driver = Driver.getInstance();
//		Connection conn = driver.getConnection();

//		System.out.println("Connection OK");

		
//		PreparedStatement pstmt=null;
		ResultSet rs = null;

//		board_no int(10) not null auto_increment primary key,
		
//		board_pw varchar(50) not null,
//		board_title varchar(50) not null,
//		board_content text not null,
//		board_user varchar(50) not null,
		
//		board_date date
		
		String sql = "select * from board";
		Statement stmt = null;

		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			board=new Board(rs.getString("board_pw"),
					rs.getString("board_title"),
					rs.getString("board_content"),
					rs.getString("board_user"));
			System.out.println(board);
			boardList.add(board);
		}

		System.out.println("stmt");
	

		if (rs != null)
			rs.close();
		
		if (stmt != null)
			stmt.close();

		if (conn != null)
			conn.close();

		return boardList;
	}
}
