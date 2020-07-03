package Univ_using_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComDao {

	// DAO = Data Acess Object
	// 데이터베이스 처리 하는 클래스
	//

	// MVC -> Model, View, Controller
	// model -> Service , Dao
	// 데이터베이스

	public int comEdit(Com com, Connection conn) {

		// JDBC 사용 객체
		// Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {
			// Connection 객체 생성
			// conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.

			String sql = "update phoneInfo_com  set  employee_name=?,"
					+ " phonenumber=?, " 
					+ " address=?, " 
					+ " email=?, " 
					+ " com_name=?, " 
					+ " dept=?, " 
					+ " job=? " 
					+ " where idx=?";


			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, com.getEmployee_name());
			pstmt.setString(2, com.getPhonenumber());
			pstmt.setString(3, com.getAddress());
			pstmt.setString(4, com.getEmail());
			pstmt.setString(5, com.getCom_name());
			pstmt.setString(6, com.getDept());
			pstmt.setString(7, com.getJob());
			pstmt.setInt(8, com.getIdx());// 일단 정보 두개만 변경@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}

		}

		return resultCnt;

	}

	public int deptDelete(String employee_name) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			String sql = "delete from phoneInfo_com  where employee_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee_name);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return resultCnt;

	}

	public List<Com> deptSearch(String employee_name) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Com> list = new ArrayList<Com>();

		try {

			// 2. 데이터베이스 연결
			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// Mysql
			// "SELECT * FROM dept WHERE dname LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from dept where dname like '%'||?||'%'

//			String sql = "select * from phoneInfo_univ  where student_name like '%'||?||'%' or  addr like '%'||?||'%'";
			String sql = "select * from phoneInfo_com  where employee_name like '%'||?||'%' ";
			// String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee_name);
//			pstmt.setString(2, student_name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Com(rs.getInt("idx"),
						rs.getString("employee_name"),
						rs.getString("phonenumber"),
						rs.getString("address"), 
						rs.getString("email"),
						rs.getString("com_name"),
						rs.getString("dept"),
						rs.getString("job")));
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return list;

	}

	public int deptInsert(Com Com) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into phoneInfo_com "
					+ " (idx,employee_name,phonenumber,address,email,com_name,dept,job) "
					+ "  values (?, ?, ?,?, ?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Com.getIdx());
			pstmt.setString(2, Com.getEmployee_name());
			pstmt.setString(3, Com.getPhonenumber());
			pstmt.setString(4, Com.getAddress());
			pstmt.setString(5, Com.getEmail());
			pstmt.setString(6, Com.getCom_name());
			pstmt.setString(7, Com.getDept());
			pstmt.setString(8, Com.getJob());

			resultCnt = pstmt.executeUpdate();

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return resultCnt;

	}

	public List<Com> deptList() {

		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object getter/setter , toString, equals

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<Com> deptList = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 2. 데이터베이스 연결
			conn = ConnectionProvider.getConnection();

			String sql = "select * from phoneInfo_com  order by employee_name";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Com dept = new Com(rs.getInt("idx"), rs.getString("employee_name"), 
						rs.getString("phonenumber"),
						rs.getString("address"), rs.getString("email"),
						rs.getString("com_name"), rs.getString("dept"),rs.getString("job"));

				deptList.add(dept);

//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.printf("%15s", rs.getString("dname") + "\t");
//				System.out.printf("%15s", rs.getString("loc") + "\n");
//				resultCnt++;
			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}

		}
		return deptList;

	}

	public int deptSearchCount(String employee_name, Connection conn) {

		// Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCnt = 0;

		try {
			// conn = ConnectionProvider.getConnection();

			String sql = "select count(*) from phoneInfo_com where employee_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee_name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rowCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCnt;
	}

	public Com deptSearchName(String searchName, Connection conn) {

		Com dept = null;

		// Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = ConnectionProvider.getConnection();

			String sql = "select * from phoneInfo_com where employee_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Com(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),rs.getString(8));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dept;

	}

}