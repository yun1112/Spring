package ex_0601;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest5 {

	public static void main(String[] args) {
		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 0.드라이버 LIB추가
			// 1.데이터베이스 드라이버 로드
			// Class.forname(드라이버 클래스 전체이름)
			// Oracle:oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.데이터베이스 연결
			// String url="jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3.SQL처리
			// Statement or PreparedStatement
			// pstmt=conn.prepareStatement(SQL문장);->sql문 먼저 등록
			// 변수처리 해야 하는 부분 ?로 처리
			// 변수처리 많을 경우 PreparedStatement가 좋음
			String sql = "select * from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
			// 변수 데이터 설정
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("====================================");
			// ResultSet->결과 참조
			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");
			}
			System.out.println("====================================");

			// 4.데이터베이스 연결 종료
//			rs.close();
//			pstmt.close();
//			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

}
