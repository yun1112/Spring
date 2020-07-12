package javademo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DriverServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	@Override
	public void init() throws ServletException {
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		String dbID = "temp";
		String dbPW = "temp";
		int idx=0;
		
		try{
			
		Connection conn=DriverManager.getConnection(dbURL,dbID,dbPW);

		System.out.println("Connection OK");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}

}
