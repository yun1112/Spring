package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class EditBoardContentServiceImpl implements Service {

	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;


		Connection conn = null;
		

		try {

			// 데이터 베이스 저장
			Board board=new Board();
			
			//int idx=(int)request.getAttribute("idx");
			int idx=Integer.parseInt(request.getParameter("idx"));
			System.out.println("idx확인:"+idx);
			
			conn = ConnectionProvider.getConnection();
			
			dao = BoardDao.getInstance();
			board=dao.selectByIdx(conn, idx);
			System.out.println("@@@@@@@@@@@@@@@@@@@board확인:"+board);
			request.setAttribute("board",board);
			request.setAttribute("idx",idx);
			
			

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

		return "/editPage.jsp";
	}

}
