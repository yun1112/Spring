package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter(name);
//		request.getRequestURL()
//		request.getRequestURI()
		String type=request.getParameter("type");
		System.out.println("요청 파악: "+type);
		
		Object resultObj=null;
		String page="/simpleView.jsp";
		
		if(type==null||type.equals("greeting")) {
			resultObj="안녕하세요";
			page="/view01.jsp";
		}else if(type.equals("date")){
			resultObj=new Date();
			page="/view02.jsp";
		}else {
			resultObj="Invalid type";
		}
		System.out.println("핵심 처리 결과: "+resultObj);
		request.setAttribute("result",resultObj);
		System.out.println("속성에 저장");
		RequestDispatcher dispatcher=request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
}
