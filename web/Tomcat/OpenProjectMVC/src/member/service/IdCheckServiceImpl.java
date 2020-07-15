package member.service;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class IdCheckServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String result="N";
		
		String id=request.getParameter("uid");
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			int resultCnt=dao.selectById(conn,id);
			if(resultCnt<1) {//해당 데이터 가진 사용자 존재하지 않음
				result="Y";
			}
			
			request.setAttribute("idcheck", result);
			
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "/WEB-INF/views/member/idCheck.jsp";
	}

}






