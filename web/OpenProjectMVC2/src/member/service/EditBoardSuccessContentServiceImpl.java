package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.ConnectionProvider;
import service.Service;

public class EditBoardSuccessContentServiceImpl implements Service {

	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("수정");

		int resultCnt = 0;

		// 데이터 베이스에 수정 데이터 변수
		int idx = 0;
		String uid = null;
		String title = null;
		String content = null;

		Connection conn = null;

		try {

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (isMultipart) {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> ite = items.iterator();

				while (ite.hasNext()) {

					FileItem item = ite.next();

					// isFormField() : text value를 가지는 input 확인
					if (item.isFormField()) { // type=file 이외의 input
						// 파라미터 이름
						String paramName = item.getFieldName();
						// 파라미터의 값
						String paramValue = item.getString("utf-8");
						// System.out.println(paramName + " = " + paramValue);

						if (paramName.equals("idx")) {
							idx = Integer.parseInt(paramValue);
						} else if (paramName.equals("title")) {
							title = paramValue;
						}else if (paramName.equals("uid")) {
							uid = paramValue;
						} else if (paramName.equals("content")) {
							// 이전 파일은 새로운 파일이 없을때 업데이트가 되도록합니다.
							content = paramValue;
						}
					} else { // type=file

						if (item.getFieldName().equals("photo") && item.getSize() > 0) {

							System.out.println("파일 없이 들어오면 안된다");
							// 서버 내부의 경로
							String uri = "/upload/users";

							// String uri =
							// request.getSession().getServletContext().getInitParameter("uploadPath");

							// 시스템의 실제(절대) 경로
							String realPath = request.getSession().getServletContext().getRealPath(uri);
							// System.out.println(realPath);

							String newFileName = System.nanoTime() + "_" + item.getName();

							// 서버의 저장소에 실제 저장
							File saveFile = new File(realPath, newFileName);
							item.write(saveFile);
							System.out.println("저장 완료");

							// uphoto = uri+"/"+newFileName;
						}

					}

				}

				// 새로 파일이 저장 되었을 때 처리
				// 이전 파일 삭제.
				// 새로운 파일이 없을 때 이전 파일 이름 저장
//				if(uphoto!=null) {
//					File oFile = new File(request.getSession().getServletContext().getRealPath(oldFile));
//					if(oFile.exists()) {
//						if(oFile.delete()) {
//							System.out.println("새로운 파일이 추가되어 이전파일은 삭제합니다.");
//						}
//					}
//				} else {
//					uphoto = oldFile;
//				}

				// 데이터 베이스 저장
				Board board = new Board();
				board.setIdx(idx);
				board.setUserId(uid);
				board.setTitle(title);
				board.setContent(content);
				
				
				System.out.println("수정 후 uid:"+uid);
				System.out.println("수정 후 title:"+title);
				System.out.println("수정 후 content:"+content);
				System.out.println("수정 후 board:"+board);
				conn = ConnectionProvider.getConnection();

				dao = BoardDao.getInstance();

				resultCnt = dao.BoardUpdate(conn, idx, board);
				
				request.setAttribute("Board", board);
				request.setAttribute("result", resultCnt);

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
//		
//		
//		
//		
//		
//		int resultCnt = 0;
//
//		// 데이터 베이스에 수정 데이터 변수
////		int idx = 0;
//
//		Connection conn = null;
////		
////		System.out.println("----------------------------");
////		String uid=(String) request.getAttribute("uid");
//		String content=(String) request.getAttribute("content");
//		System.out.println(content);
//		content=(String) request.getParameter("content");
//		System.out.println(content);
//		
//		Board board=(Board) request.getAttribute("a");
//		System.out.println(board+"->board 확인");
//		String board2= request.getParameter("board");
//		System.out.println(board2);
//		System.out.println(board+"->board2 확인");
//		List<Board> listAll=(List) request.getAttribute("listAll");
//		System.out.println(listAll+"->listAll 확인");
////		System.out.println("----------------------------");
//		try {
//
//			
//			conn = ConnectionProvider.getConnection();
//			
//			dao = BoardDao.getInstance();
////			board=dao.selectByIdx(conn, idx);
////			
////			
////			System.out.println(board+"->board 확인");
////			System.out.println("----------------------------");
////			
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}

		return "/editSuccess.jsp";
	}

}
