package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request,response);
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
		out.println("<head><title>this screen is sent by servlet</title></head>");
		out.println("<body>");
		out.println(additionResult);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
