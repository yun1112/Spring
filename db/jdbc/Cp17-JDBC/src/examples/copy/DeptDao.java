package examples.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeptDao {
	// DAO=Data Access Object
	// 데이터베이스 처리하는 클래스

	// MVC->Model,View,Controller
	// model->Service(데이터를 내부적으로 분리하는 목적으로 사용하는 클래스), Dao(데이터베이스 처리 목적)
	// 데이터베이스
	public void insert(PreparedStatement pstmt, Connection conn) {
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

	public void delete(PreparedStatement pstmt, Connection conn) {
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

	public void modify(PreparedStatement pstmt, Connection conn) {
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

	public void print(PreparedStatement pstmt, Connection conn) {
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

	public void search(PreparedStatement pstmt, Connection conn) {
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		List<Dept> deptList = new ArrayList<>();
		try {
			sc.nextLine();
			System.out.println("부서명 입력>>");
			String dname = sc.nextLine();
			String sql = "select * from dept where dname='" + dname + "'";
			pstmt = conn.prepareStatement(sql);// 메서드는 prepare~
			rs = pstmt.executeQuery();
			System.out.println("부서 리스트");
			System.out.println("====================================");
//			 ResultSet->결과 참조
			while (rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				deptList.add(dept);
			}
//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.print(rs.getString("dname") + "\t");
//				System.out.print(rs.getString("loc") + "\n");
//			}
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

	public static List<Dept> deptList() {
		// VO: Value Object
		// DTO:Data Transfer Object

		// JDBC사용 객체
		Statement stmt = null;
//		Connection conn;
		ConnectionProvider cp=new ConnectionProvider();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// Dao클래스 추가
		List<Dept> deptList = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된 것으로 가정
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//driver는 처음 시작할 때 한 번만 호출
			System.out.println("Oracle 드라이버 로드 성공");
			cp.getConnection();
			//Connection pool 여러 Connection객체를 가지고 있다가 필요한 쪽에 제공(처리 시간 단축)
			//Transaction 처리(한 Transaction이 끝날 때까지 기다렸다가 다른 Transaction 처리)
			//Connection하나 static으로 두고 쓰면 안됨(동시접속시 문제 발생)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return deptList;
	}
}
