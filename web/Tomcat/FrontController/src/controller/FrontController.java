package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NullServiceImpl;
import service.Service;

public class FrontController extends HttpServlet{
	
	Map<String,Service> commands=new HashMap<>();
	
	@Override
	public void init(ServletConfig config ) throws ServletException {
		Properties prop=new Properties();
		
		FileInputStream fis=null;

		//설정파일의 웹 경로
		String path="/WEB-INF/commandService.properties";
		
		//설정파일의 시스템 절대경로
		String configFile=config.getServletContext().getRealPath(path);
		
		
		try {
			fis=new FileInputStream(configFile);
			
			//프로퍼티객체로 파일을 읽어 옴
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Iterator itr=prop.keySet().iterator();
//		
//		while(itr.hasNext()) {
//			String command=(String)itr.next();
//			String serviceClassName=prop.getProperty(command);
//			System.out.println(command+" = "+serviceClassName);
//			
//		}
		Iterator itr=prop.keySet().iterator();
		
		while(itr.hasNext()) {
			//사용자 요청 URI
			String command=(String)itr.next();
			//사용자 요청의 처리를 위한 클래스 이름, 정보
			String serviceClassName=prop.getProperty(command);
			
			try {
				//인스턴스 생성을 위한 클래스 객체
				Class serviceClass=Class.forName(serviceClassName);
				//인스턴스 생성
				Service service=(Service) serviceClass.newInstance();
				
				commands.put(command,service);
				
				System.out.println(command+" = "+service);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
//		commands.put("/", new IndexServiceImpl());
//		commands.put("/index", new IndexServiceImpl());
//		
//		commands.put("/greeting", new GreetingServiceImpl());
//		
//		commands.put("/date", new DateServiceImpl());
//		
//		commands.put("null", new NullServiceImpl());
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
		
		Service service=commands.get(type);
		if(service==null) {
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
