package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginInfo;

public class IndexServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		LoginInfo info=(LoginInfo)request.getSession().getAttribute("info");
		System.out.println("info:"+info);
		String page = "/ex.jsp";
//		String page = "/WEB-INF/views/index.jsp";
		return page;
	}

}
