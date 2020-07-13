package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import dao.BoardDao;

@WebServlet({ "/ServletTest", "/test" })
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<Board> boardList=new ArrayList<>();
    
    public ServletTest() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		<!-- 
//		board_no int(10) not null auto_increment primary key,
		
		
//	board_pw varchar(50) not null,
//	board_title varchar(50) not null,
//
//	board_content text not null,
//
//	board_user varchar(50) not null,
		
//	board_date date -->
		System.out.println("servlet result");
	
		
		String pw=request.getParameter("pw");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String user=request.getParameter("user");
		
		
		//Board board=new Board(pw,title,content,user);
		//System.out.println(board);
		//boardList.add(board);
		 
		BoardDao dao;
		dao=BoardDao.getInstance();
		try {
			boardList=dao.selectDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("boardList",boardList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request,response);
	}
}
