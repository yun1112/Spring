//4. EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ex_04_print_emp_after_select {

	public static void main(String[] args) {
		Connection conn=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		//1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Oracle 드라이버 로드 성공");
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String pw="tiger";
		
		//2. 데이터베이스에 접속
		conn=DriverManager.getConnection(url,user,pw);
		System.out.println("데이터베이스에 접속했습니다");
		
		//3. Statement: Connection
		Statement stmt=conn.createStatement();
		
		String sql="select * from emp where ename='SCOTT'";
		
		//Select의 결과는 ResultSet이 받음
		//executeQuery(sql문)->ResultSet 반환
		rs=stmt.executeQuery(sql);
		
		//ResultSet: next()->행의 존재 유무 확인(커서의 개념)
		while(rs.next()) {//rs가 존재할 동안 반복
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\n");
//			System.out.print(rs.getInt("deptno")+"\t");
//			System.out.print(rs.getString("dname")+"\t");
//			System.out.print(rs.getString("loc")+"\n");
			
		}
		
		rs.close();
		stmt.close();
		
		//4. close
		conn.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();//연결 오류 발생시 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}
	
	

}
