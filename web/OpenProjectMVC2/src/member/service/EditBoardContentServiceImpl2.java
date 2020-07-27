package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class EditBoardContentServiceImpl2 implements Service {

	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int idx=Integer.parseInt(request.getParameter("idx"));
		String userId=request.getParameter("userId");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		System.out.println("idx:"+idx);
		System.out.println("userId:"+userId);
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		
		int resultCnt = 0;

		// 데이터 베이스에 수정 데이터 변수
//		int idx = 0;
		Connection conn = null;
		

		try {

			// 데이터 베이스 저장
			Board board=new Board();
			
			conn = ConnectionProvider.getConnection();
			
			dao = BoardDao.getInstance();
			
			
			board=dao.selectByIdx(conn, idx);
			System.out.println("board확인:"+board);

			board.setTitle(title);
			board.setContent(content);
			resultCnt = dao.BoardUpdate(conn, title, content, idx, board);
			
			request.setAttribute("board",board);
			
			System.out.println("BoardUpdate확인:"+board);
			System.out.println("--------------------");

			request.setAttribute("result", resultCnt);
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return "/editSuccess.jsp";
	}

}
