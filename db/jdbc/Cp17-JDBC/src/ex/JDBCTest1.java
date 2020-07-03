package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) 
			  {
		Connection conn=null;
		
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
		
		//트랜잭션 설정
		conn.setAutoCommit(false);
		
		//3. sql로 데이터 처리->스프링 프레임워크에서는 이부분만 처리하도록 하는 클래스 제공
		
		//commit: 정상처리 완료/처리 완료
		conn.commit();//트랜잭션
		
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
