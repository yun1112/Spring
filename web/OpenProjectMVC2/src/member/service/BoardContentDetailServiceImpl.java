package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class BoardContentDetailServiceImpl implements Service {
	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		int idx=Integer.parseInt(request.getParameter("idx"));
		System.out.println("idx전달 확인:"+idx);
		Board board=null;
		String content=null;
		
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			dao=BoardDao.getInstance();
			
			board=dao.selectByIdx(conn, idx);
			
			content=dao.selectContentById(conn, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("board확인:"+board);
		request.setAttribute("board",board);
		request.setAttribute("content",content);
		
		return "/contentDetails.jsp";// @@@@@@@@@@@@@@@@@@@@@@@임시
	}

}
