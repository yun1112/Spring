package example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet3")
public class AdditionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionServlet3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		
		int firstNumber = Integer.parseInt(first);
		int secondNumber = Integer.parseInt(second);
		
		int result = firstNumber + secondNumber;
		
		request.setAttribute("first",first);
		request.setAttribute("second",second);
		request.setAttribute("result",result);
		
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request,response);
	}

}
