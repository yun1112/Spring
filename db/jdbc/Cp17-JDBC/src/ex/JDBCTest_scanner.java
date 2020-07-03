package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest_scanner {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;

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

			// 3. Statement: Connection
			Statement stmt = conn.createStatement();
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("회원의 이름을 입력해주세요.>>");
			String searchName=sc.nextLine();
			
			String sql = "select * from emp order by deptno";// 부서번화,사원이름,직급
			String sql1 = "select o.orderid,c.name,b.bookname from customer c, book b, orders o"
					+ " where c.custid=o.custid and b.bookid=o.bookid"
					+" and c.name='"+searchName+"'";
			
			System.out.println("sql: "+sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			// Select의 결과는 ResultSet이 받음
			// executeQuery(sql문)->ResultSet 반환
			rs = stmt.executeQuery(sql1);

			// ResultSet: next()->행의 존재 유무 확인(커서의 개념)
			System.out.println("판매 리스트");
			System.out.println("---------------------------");
			System.out.println("판매 아이디\t회원이름\t책이름");
			System.out.println("---------------------------");
			while (rs.next()) {// rs가 존재할 동안 반복
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");
//			System.out.println("---------------------------");
//			System.out.print(rs.getInt("deptno")+"\t");
//			System.out.print(rs.getString("ename")+"\t");
//			System.out.print(rs.getString("job")+"\n");
//				System.out.print(rs.getString(1));
//				System.out.print(rs.getString(2));
//				System.out.print(rs.getString(3));

			}

			rs.close();
			stmt.close();

			// 4. close
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();// 연결 오류 발생시 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
