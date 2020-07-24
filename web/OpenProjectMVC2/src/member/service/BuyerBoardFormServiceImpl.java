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
//public class BuyerBoardFormServiceImpl implements Service {
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
//		return "/ex.jsp";
//
//	}
//
//}
package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class BuyerBoardFormServiceImpl implements Service {

BoardDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
//		LoginInfo info=(LoginInfo)request.getAttribute("info");
//		Member member=(Member)request.getAttribute("member");
//		List<Member> list=(List)request.getAttribute("list");
		
		
		String uid=(String)request.getParameter("uid");
		System.out.println("uid확인:"+uid);
		String title=(String)request.getParameter("title");
		System.out.println("title확인:"+title);
		String content=(String)request.getParameter("content");
		System.out.println("content확인:"+content);
//		System.out.println("info확인:"+info);
//		System.out.println("member확인:"+member);
//		System.out.println("list확인:"+list);

		Connection conn;
		
		dao=BoardDao.getInstance();
		
		try {
			conn = ConnectionProvider.getConnection();
			Board board=new Board();
			board.setUserId(uid);
			board.setTitle(title);
			board.setContent(content);
			
			dao.insertBoard(conn, board);
			System.out.println("board확인:"+board);
			request.setAttribute("board",board);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return "/ex.jsp";
	}

}


















