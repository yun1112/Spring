package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DateServiceImpl;
import service.GreetingServiceImpl;
import service.IndexServiceImpl;
import service.NullServiceImpl;
import service.Service;

public class FrontController3 extends HttpServlet{
	
//	Map<String,Service> 
	
	@Override
	public void init() throws ServletException {
		
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter(name);
//		request.getRequestURL()
//		request.getRequestURI()
//		String type=request.getParameter("type");
		String type=null;
		String command=request.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(request.getContextPath()));
		if(command.indexOf(request.getContextPath())==0) {
			type=command.substring(request.getContextPath().length());
		}
		System.out.println("요청 파악: "+type);
		
//		Object resultObj=null;
//		String page="/WEB-INF/views/simpleView.jsp";
		
		Service service=null;
		
		if(type==null||type.equals("/greeting")) {
			service=new GreetingServiceImpl();
		}else if(type.equals("/date")){
			service=new DateServiceImpl();
		}else if(type.equals("/")||type.equals("index")){
			service=new IndexServiceImpl();
		}else {
			service=new NullServiceImpl();
		}
		
		String page=service.getViewPage(request, response);
	
//		System.out.println("핵심 처리 결과: "+resultObj);
//		request.setAttribute("result",resultObj);
//		System.out.println("속성에 저장");

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
