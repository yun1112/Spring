package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet") // 현재 servlet 파일의 url 알려주는 annotation

public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);// get방식으로 요청이 들어와도 post방식으로 처리함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String first=request.getParameter("first");
		String second=request.getParameter("second");
		
		int firstNumber=Integer.parseInt(first);
		int secondNumber=Integer.parseInt(second);
		
		int additionResult=firstNumber+secondNumber;
		
		System.out.println(additionResult);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>this screen is sent by servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(additionResult);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
