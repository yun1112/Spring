package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
public class ex_01_insert_emp {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		Scanner sc=new Scanner(System.in);
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

			System.out.println("부서번호  입력>>");
			int empno = sc.nextInt();
			sc.nextLine();
			System.out.println("사원 이름 입력>>");
			String ename = sc.nextLine();
			System.out.println("직급 입력>>");
			String job = sc.nextLine();
	
			
			// 3.Statement
			stmt = conn.createStatement();
			String sql = "insert into emp (empno, ename,job) "
					+" values('"+empno+"','"+ename+"','"+job+"')";
		
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
