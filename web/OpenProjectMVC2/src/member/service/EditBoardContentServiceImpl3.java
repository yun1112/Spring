package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class EditBoardContentServiceImpl3 implements Service {

	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;

		// 데이터 베이스에 수정 데이터 변수
//		int idx = 0;
		String upw = null;
		String uname = null;

		Connection conn = null;
		
		List<Board> listAll=(List)request.getAttribute("listAll");
		System.out.println("수정할 리스트 확인:"+listAll);
		System.out.println("--------------------");

		try {

			// 데이터 베이스 저장
			Board board=new Board();
			
			int idx=(int)request.getAttribute("idx");
			
			conn = ConnectionProvider.getConnection();
			
			dao = BoardDao.getInstance();
			
			
			board=dao.selectByIdx(conn, idx);
			System.out.println("board확인:"+board);
			System.out.println("--------------------");
			System.out.println("idx확인:"+idx);
			board.setIdx(idx);
			System.out.println("idx확인:"+idx);
			System.out.println("--------------------");

			request.setAttribute("board",board);
			
			resultCnt = dao.BoardUpdate(conn, idx,board);
			System.out.println("BoardUpdate확인:"+board);
			System.out.println("--------------------");

			request.setAttribute("board", board);
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

		return "/index.jsp";
	}

}
