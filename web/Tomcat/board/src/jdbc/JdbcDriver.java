package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

public class JdbcDriver extends HttpServlet {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		String dbID = "temp";
		
		String dbPW = "temp";

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			System.out.println("Connection OK");

			Statement stmt = conn.createStatement();

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

		}
	}
}
