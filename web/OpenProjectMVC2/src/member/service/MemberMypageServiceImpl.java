package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import login.LoginInfo;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MemberMypageServiceImpl implements Service {

	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		LoginInfo info=(LoginInfo)request.getSession().getAttribute("info");
		System.out.println("info확인:"+info);
		// ---------------------------------------------------------------------------확인
		// 아이디 비밀번호 체크
//		MemberListView listView = (MemberListView) request.getAttribute("listView");
//		System.out.println("전체회원정보확인:" + listView);
		List<Member> list = null;
		MemberDao dao = MemberDao.getInstance();
		Connection conn;
		Boolean loginCheck = false;

		try {
			conn = ConnectionProvider.getConnection();
			list=dao.selectAllList(conn);
			Member member=dao.selectMemberById(conn, info.getUid());
			
			String str=member.getAddress();
			System.out.println("str:"+str);
			StringTokenizer st=new StringTokenizer(str,",");
			String[] arr=new String[4];
//			String[] arr=new String[st.countTokens()];
			int i=0;
			while(st.hasMoreElements()) {
				if(i==4)
					break;
				arr[i++]=st.nextToken();
			}
			for(i=0;i<st.countTokens();i++) {
				System.out.println(arr[i]);
			}
			String postcode=arr[0];
			String address=arr[1];
			String detailAddress=arr[2];
			String extraAddress=arr[3];
			
			System.out.println("member:"+member);
			request.setAttribute("member", member);
			request.setAttribute("arr", arr);
			
			request.setAttribute("postcode", postcode);
			request.setAttribute("address", address);
			request.setAttribute("detailAddress", detailAddress);
			request.setAttribute("extraAddress", extraAddress);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("회원정보확인:"+list);
		request.setAttribute("list", list);
		return "/mypage.jsp";
	}

}
