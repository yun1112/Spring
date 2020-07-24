package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import service.Service;

public class TempImpl implements Service {

BoardDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
//		String uid=(String)request.getParameter("uid");
//		System.out.println("uid확인:"+uid);
//
//		Connection conn;
//		
//		dao=BoardDao.getInstance();
//		
//		try {
//			conn = ConnectionProvider.getConnection();
//			Board board=dao.selectBoardByUid(conn, uid);
//			
//			dao.insertBoard(conn, board);
//			System.out.println("board확인:"+board);
//			request.setAttribute("board",board);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		
		return "/temp.jsp";
	}

}

//
//package member.service;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import board.dao.BoardDao;
//import board.model.Board;
//import jdbc.ConnectionProvider;
//import service.Service;
//
//public class TempImpl implements Service {
//
//BoardDao dao;
//	
//	@Override
//	public String getViewPage(
//			HttpServletRequest request, 
//			HttpServletResponse response) {
//		
//		String uid=(String)request.getParameter("uid");
//		System.out.println("uid확인:"+uid);
//
//		Connection conn;
//		
//		dao=BoardDao.getInstance();
//		
//		try {
//			conn = ConnectionProvider.getConnection();
//			Board board=dao.selectBoardByUid(conn, uid);
//			
//			dao.insertBoard(conn, board);
//			System.out.println("board확인:"+board);
//			request.setAttribute("board",board);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		return "/buy.jsp";
//	}
//
//}
//
//
//
//
//
//
//
//
//







