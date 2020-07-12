package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDAO.User;
@WebServlet("/ServletResult")
public class ServletResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<User> userList=new ArrayList<>();

	public ServletResult() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet result");
	
		
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		int num_points=Integer.parseInt(request.getParameter("num_points"));
		System.out.println(num_points);
		
		
		User user=new User(first_name,last_name,num_points);
		
		userList.add(user);
		System.out.println(userList);
		
		request.setAttribute("userList",userList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request,response);
	}

}
