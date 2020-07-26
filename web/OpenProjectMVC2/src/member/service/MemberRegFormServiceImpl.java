package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberRegFormServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		String kakaoNickname=(String)request.getParameter("kakaoNickname");
		String id=(String)request.getParameter("id");
//		LoginInfo info=(LoginInfo)request.getSession().getAttribute("info");
//		System.out.println("info:"+info);
		Member member;
		try {
			MemberDao dao=MemberDao.getInstance();
			Connection conn=ConnectionProvider.getConnection();
			dao.selectById(conn, id);
			member=dao.selectMemberById(conn, id);
			System.out.println("카카오가입정보:"+member);
			if(member!=null) {
				request.setAttribute("member", member);
				return "/member/memberLoginSuccess.do";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("kakaoNickname", kakaoNickname);
		request.setAttribute("id", id);
		return "/reg.jsp";
	}

}
