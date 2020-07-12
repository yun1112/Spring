package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {
	public static Scanner sc = new Scanner(System.in);


	public static void selectQuery(Connection conn) throws SQLException {
		String query = "select * from users";
		PreparedStatement preparedStmt;
		ResultSet rs = null;

		try {
			String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
			String dbID = "temp";
			String dbPW = "temp";


			System.out.println("Connection OK");
			
			preparedStmt = conn.prepareStatement(query);
			System.out.println("----------users----------");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				System.out.printf("%s\t%s\t%d\t\n", rs.getString("first_name"), rs.getString("last_name"),
						rs.getInt("num_points"));

			}

			if (conn != null)
				conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}