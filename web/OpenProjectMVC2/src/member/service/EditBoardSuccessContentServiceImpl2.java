package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class EditBoardSuccessContentServiceImpl2 implements Service {

	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
System.out.println("수정");
		int resultCnt = 0;

		// 데이터 베이스에 수정 데이터 변수
//		int idx = 0;

		Connection conn = null;
		
//		List<Board> listAll=(List)request.getAttribute("listAll");
//		System.out.println("수정할 리스트 확인:"+listAll);
		int idx=Integer.parseInt(request.getParameter("idx"));
		String uid=request.getParameter("uid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		System.out.println("--------@@@------------");

		try {

			// 데이터 베이스 저장
			//Board board=new Board();
			Board board=(Board)request.getAttribute("board");
			
//			idx, uid, title, content->getParameter
			System.out.println("---------------");
			System.out.println("uid"+uid);
			System.out.println("title"+title);
			System.out.println("content"+content);
			System.out.println("---------------");
			board.setUserId(uid);
			board.setTitle(title);
			board.setContent(content);
			
			conn = ConnectionProvider.getConnection();
			
			dao = BoardDao.getInstance();

			
			
			board=dao.selectByIdx(conn, idx);
			System.out.println("board확인:"+board);
			System.out.println("--------------------");
			System.out.println("idx확인:"+idx);
			System.out.println("--------------------");

			System.out.println("board 업데이트 전:"+board);
			dao.BoardUpdate(conn, idx, board);
			System.out.println("board 업데이트 후:"+board);
			System.out.println("--------------------");
			request.setAttribute("board",board);

			

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

		return "/ex.jsp";
//		return "/editSuccess.jsp";
	}

}
