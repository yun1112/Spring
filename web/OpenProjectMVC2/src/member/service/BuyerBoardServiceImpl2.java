package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.model.Board;
import board.model.BoardListView;
import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class BuyerBoardServiceImpl2 implements Service {

MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
//		title content
		
		BoardDao dao=BoardDao.getInstance();
		List<Board> listAll=new ArrayList<>();
		
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			listAll=dao.selectAllList(conn);
			System.out.println("listAll:"+listAll);
			
			int cntAll=dao.selectTotalCount(conn);
			request.setAttribute("cntAll",cntAll);
			
			request.setAttribute("listAll",listAll);
			System.out.println("listAll:"+listAll);
			
			//-------------------------------------------------------------------------------------07/24 추가
			
			
			String tmp=request.getParameter("page");//파라미터로 값 전달받아와야됨
			System.out.println("@@@@@page파라미터값 전달확인:"+tmp);//전달받음
			int currentPageNumber=1;//첫번째 페이지가 기본페이지
			
			if(tmp!=null) {//startRow값 존재할 경우
				currentPageNumber=Integer.parseInt(tmp);
			}
			
			int BoardTotalCount=dao.selectTotalCount(conn);//전체 게시물 수
			final int BoardCountPerpage=5;//한 페이지에 표시할 게시물 수
			
//			int startRow=currentPageNumber*BoardTotalCount-1;//시작 행
			int startRow=BoardTotalCount/currentPageNumber+1;
			System.out.println("페이지 시작행:"+startRow);
			
			List<Board> BoardList=dao.selectList(conn, startRow, BoardTotalCount);//한 페이지 게시물 가져옴
			BoardListView listView=new BoardListView(BoardTotalCount, currentPageNumber, BoardList, BoardCountPerpage, startRow, startRow+BoardCountPerpage);
			
			
			System.out.println("--------------------------");
			request.setAttribute("BoardList",BoardList);
			System.out.println("BoardList:"+BoardList);
			System.out.println("--------------------------");
			request.setAttribute("listView",listView);
			System.out.println("listView:"+listView);
			System.out.println("--------------------------");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// view 로 전달할 결과 데이터
//		MemberListView listView = null;
//		
//		Connection conn = null;
//		
//		try {
//			conn = ConnectionProvider.getConnection();
//			dao = MemberDao.getInstance();
//			
//			// 전체 게시물 개수 구하기
//			int totalCnt =  dao.selectTotalCount(conn);
//			
//			// 한 페이지 당 노출할 게시물의 개수
//			final int MEMBER_CNT_PER_PAGE = 2;
//			
//			// 현재 페이지 번호
//			int currentPageNumber = 1;
//			String page = request.getParameter("page");
//			if(page != null) {
//				try {
//					currentPageNumber = Integer.parseInt(page);
//				} catch (NumberFormatException e) {
//					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
//				}
//			}
//			
//			// 게시물의 첫번째 행의 index
//			int startRow = 0;
//			
//			// 한 페이지에 누출할 리스트
//			List<Member> memberList = null;
//			
//			if(totalCnt > 0) {
//				startRow = (currentPageNumber-1)*MEMBER_CNT_PER_PAGE;
//				
//				System.out.println(startRow);
//				
//				memberList = dao.selectList(conn, startRow, MEMBER_CNT_PER_PAGE);
//			} else {
//				currentPageNumber = 0;
//				memberList = Collections.emptyList();
//			}
//			
//			
//			listView = new MemberListView(
//					totalCnt, 
//					currentPageNumber, 
//					memberList, 
//					MEMBER_CNT_PER_PAGE, 
//					startRow);
//			
//			System.out.println(listView);
//			
//			
//			
//			
//		} catch (SQLException e) {
//			System.out.println("SQL 오류 발생");
//			e.printStackTrace();
//		}
//		
//		
//		request.setAttribute("listView", listView);
		return "/buy.jsp";
	}

}









