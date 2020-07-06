package text;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//응답 처리 
//1. 서블릿 클래스를 만들기 위해서 HttpServlet클래스를 반드시 상속해야 함
//@WebServlet("/hello")
public class NowServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//응답처리: HTML 문서를 만듦  
		resp.setContentType("text/html;charsest=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("\t<head>");
		out.println("\t\t<title>서블릿 테스트</title>");
		out.println("\t</head>");
		out.println("\t<body>");
		out.println("\t\t<h1>안녕하세요 서블릿 클래스로 응답 처리된 페이지입니다</h1>");
		out.println("\t\t<p>현재 시간은 :"+new Date()+"</p>");
		
		
		out.println("\t</body>");
		out.println("\t</html>");
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//2. 요청에 맞는 처리를 위한 메서드 선택 후 오버라이딩 함  
//		doGet(req,resp);
//	}
}
