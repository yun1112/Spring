package prac_0601;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pwd="tiger";

			conn=DriverManager.getConnection(url,user,pwd);
					
			System.out.println("데이터베이스 접속 성공");
			
			System.out.println("부서 번호  입력>>");
			int empno=sc.nextInt();
			sc.nextLine();
			System.out.println("사원 이름 입력>>");
			String ename=sc.nextLine();
			System.out.println("직급 입력>>");
			String job=sc.nextLine();
			
			stmt=conn.createStatement();
			String sql="insert into emp(empno,ename,job)"
					+" values('"+empno+"','"+ename+"','"+job+"')";
			
			int resultCnt=stmt.executeUpdate(sql);
			
			System.out.println(resultCnt+"개 행이 입력되었습니다");
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("해당 클래스를 찾을 수 없습니다 "+e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
