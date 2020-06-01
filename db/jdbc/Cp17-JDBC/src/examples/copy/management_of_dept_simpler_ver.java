package examples.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class management_of_dept_simpler_ver {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String sql = "";
		// 1. DB드라이버 로드

		while (true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Oracle 드라이버 로드 성공");

				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pw = "tiger";

				// 2. 데이터베이스에 접속
				conn = DriverManager.getConnection(url, user, pw);
				System.out.println("데이터베이스에 접속했습니다");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("----------------------------------");
			System.out.println("1.입력 2.수정 3.삭제 4.리스트 5.검색\n6.선택창으로 돌아가기 7. 종료");
			System.out.println("----------------------------------");
			int n = sc.nextInt();
			if (n == 6)
				break;
			switch (n) {
			case 1:// 입력
				insert(pstmt, conn);
				break;
			case 2:// 수정(부서이름,위치)
				modify(pstmt, conn);
				break;
			case 3:// 삭제(사원번호)
				delete(pstmt, conn);
				break;
			case 4:// 리스트
				print(pstmt, conn);
				break;
			case 5:// 검색(이름)
				search(pstmt, conn);
				break;
			case 7:
				System.exit(0);
			}
		}
	}

	static void insert(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		try {
			System.out.println("부서번호  입력>>");
			int deptno = sc.nextInt();
			sc.nextLine();
			System.out.println("부서명 입력>>");
			String dname = sc.nextLine();
			System.out.println("위치 입력>>");
			String loc = sc.nextLine();
			String sql = "insert into dept (deptno,dname,loc)" + " values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int resultCnt = pstmt.executeUpdate();
			if (resultCnt > 0) {
				System.out.println("정상적으로 입력되었습니다");
				System.out.println(resultCnt + "행이 입력되었습니다");
			} else {
				System.out.println("입력이 되지 않았습니다\n확인 후 재시도해주세요");
			}
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

	static void delete(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("부서번호  입력>>");
			int deptno = sc.nextInt();
			sc.nextLine();

			String sql = "delete from dept where deptno='" + deptno + "'";
			pstmt = conn.prepareStatement(sql);

			int resultCnt = pstmt.executeUpdate();
			if (resultCnt > 0) {
				System.out.println("정상적으로 삭제되었습니다");
			} else {
				System.out.println("삭제가 되지 않았습니다\n확인 후 재시도해주세요");
			}
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

	static void modify(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		try {
			System.out.println("수정할 부서의 부서번호  입력>>");
			int deptno = sc.nextInt();
			sc.nextLine();

			System.out.println("부서 이름 입력>>");
			String dname = sc.nextLine();
			System.out.println("위치 입력>>");
			String loc = sc.nextLine();

			String sql = "update dept set dname=?, loc=?" + " where deptno=?";

			System.out.println("sql:" + sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			rs = pstmt.executeQuery();
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

	static void print(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		try {
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
			// 변수 데이터 설정
//		pstmt.setInt(1, 10);
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

	static void search(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		try {
			System.out.println("부서명 입력>>");
			String dname = sc.nextLine();
			String sql = "select * from dept where dname='" + dname + "'";
			pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
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
