package examples.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
	
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";

		// 2. 데이터베이스에 접속
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("데이터베이스에 접속했습니다");

		return conn;
	}
}
