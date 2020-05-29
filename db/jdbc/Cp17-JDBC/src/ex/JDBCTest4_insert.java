package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest4_insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		// 1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다");

			// 3.Statement
			stmt = conn.createStatement();
			String sql = "insert into dept (deptno, dname,loc) "
					+" values(60,'design','jeju')";
		
			int resultCnt=stmt.executeUpdate(sql);
			
			System.out.println(resultCnt+"개 행이 입력되었습니다.");
			
			// 4. close
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
