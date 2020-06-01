package examples.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
사원관리프로그램
기능
	1.입력
	2.수정(이름,부서,급여)
	3.삭제(사원번호pk기준)
	4.리스트(전체)
	5.검색(이름기준)
	
부서관리프로그램
기능
	1.입력
	2.수정(부서이름,위치)
	3.삭제(부서번호pk기준)
	4.리스트(전체)
	5.검색(부서이름 or 지역기준)
*/
public class management_of_emp {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String sql = "";
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

			while (true) {
				System.out.println("----------------------------------");
				System.out.println("1.입력 2.수정 3.삭제 4.리스트 5.검색\n6.선택창으로 돌아가기 7. 종료");
				System.out.println("----------------------------------");
				int n = sc.nextInt();
				if(n==6)break;
				switch (n) {
				case 1:// 입력
					System.out.println("사원번호  입력>>");
					int empno = sc.nextInt();
					sc.nextLine();
					System.out.println("사원 이름 입력>>");
					String ename = sc.nextLine();
					System.out.println("급여 입력>>");
					String sal = sc.nextLine();
					System.out.println("직급 입력>>");
					String job = sc.nextLine();
					sql = "insert into emp (empno, ename,sal,job)" + " values(?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, empno);
					pstmt.setString(2, ename);
					pstmt.setString(3, sal);
					pstmt.setString(4, job);

					int resultCnt = pstmt.executeUpdate();
					if (resultCnt > 0) {
						System.out.println("정상적으로 입력되었습니다");
						System.out.println(resultCnt + "행이 입력되었습니다");
					} else {
						System.out.println("입력이 되지 않았습니다\n확인 후 재시도해주세요");
					}
					break;
				case 2:// 수정(이름,부서,급여)
					System.out.println("수정할 직원의 사원번호  입력>>");
					empno = sc.nextInt();
					sc.nextLine();

					System.out.println("사원 이름 입력>>");
					ename = sc.nextLine();
					System.out.println("급여 입력>>");
					sal = sc.nextLine();
					System.out.println("직급 입력>>");
					job = sc.nextLine();
					
//					sql = "update emp set ename='"+ename+"' and job='"+job+"'"
//							+ " where empno="+empno;
					sql = "update emp set ename=?, sal=?, job=?"
							+ " where empno=?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ename);
					pstmt.setString(2, sal);
					pstmt.setString(3, job);
					pstmt.setInt(4, empno);
					// 변수 데이터 설정
//				pstmt.setInt(1, 10);
					rs = pstmt.executeQuery();

					break;
				case 3:// 삭제(사원번호)
					System.out.println("사원번호  입력>>");
					empno = sc.nextInt();
					sc.nextLine();

					sql = "delete from emp where empno='" + empno + "'";
					pstmt = conn.prepareStatement(sql);

					resultCnt = pstmt.executeUpdate();
					if (resultCnt > 0) {
						System.out.println("정상적으로 삭제되었습니다");
					} else {
						System.out.println("삭제가 되지 않았습니다\n확인 후 재시도해주세요");
					}
					break;
				case 4:// 리스트
//				sql = "select * from dept where deptno=?";
					sql = "select * from emp";
					pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
					// 변수 데이터 설정
//				pstmt.setInt(1, 10);
					rs = pstmt.executeQuery();
					System.out.println("사원 리스트");
					System.out.println("==================================");
					// ResultSet->결과 참조
					while (rs.next()) {
						System.out.print(rs.getInt("empno") + "\t");
						System.out.print(rs.getString("ename") + "\t");
						System.out.print(rs.getString("sal") + "\t");
						System.out.print(rs.getString("job") + "\n");
					}
					System.out.println("==================================");
					break;
				case 5:// 검색(이름)
					sc.nextLine();
					System.out.println("이름 입력>>");
					ename = sc.nextLine();
					sql = "select * from emp where ename='" + ename + "'";
					pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
					// 변수 데이터 설정
//				pstmt.setInt(1, 10);
					rs = pstmt.executeQuery();
					System.out.println("사원 리스트");
					System.out.println("==================================");
					// ResultSet->결과 참조
					while (rs.next()) {
						System.out.print(rs.getInt("empno") + "\t");
						System.out.print(rs.getString("ename") + "\t");
						System.out.print(rs.getString("sal") + "\t");
						System.out.print(rs.getString("job") + "\n");
					}
					System.out.println("==================================");
					break;
				case 7:
					System.exit(0);
					conn.close();
				}
				
			}

			// 3.Statement
//			String sql = "insert into emp (empno, ename,job) "
//					+" values('"+empno+"','"+ename+"','"+job+"')";

			// 4. close
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.데이터베이스 연결 종료
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
