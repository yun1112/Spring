package phonebook_ver07_with_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*데이터베이스를 이용해서 친구의 정보를 CRUD 하는 프로그램을 만들어 봅시다.

- JDBC 이용
- 테이블 생성 DDL 실행 ( 수업시간에 작성한 테이블을 이용해고 됩니다.)
- 데이터 처리를 위한 질의와 DML 작성
- 핵심기능 클래스와 DAO 클래스를 별도로 구현하는 구조로 작성해주세요.*/

public class PhoneBookDao {
	public void searchInfo(String searchName) {
	};

	public int editInfo(PhoneUnivInfo univ, Connection conn) {
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

			// 일단 이름과 주소만 수정
			String sql = "update phoneInfo_univ  set student_name=?, addr=? " + " where deptno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, univ.getName());
//					pstmt.setString(3, univ.getPhoneNumber());
			pstmt.setString(2, univ.getAddr());
			pstmt.setInt(3, univ.getIdx());
//					pstmt.setString(5, univ.getEmail());
//					pstmt.setString(6, univ.getMajor());
//					pstmt.setString(7, univ.getGrade());
//					pstmt.setInt(8, univ.getRef_idx());

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

//					if (conn != null) {
//						try {
//							conn.close();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}

		}

		return resultCnt;
	};

	public int deleteInfo(String searchName) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			String sql = "delete from phoneInfo_univ  where student_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

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
	};

	public PhoneUnivInfo univSearchName(String searchName, Connection conn) {
		PhoneUnivInfo univ = null;

		// Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = ConnectionProvider.getConnection();

			String sql = "select * from phoneInfo_univ where student_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				univ = new PhoneUnivInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return univ;
	}

	public int univSearchCount(String searchName, Connection conn) {
		// Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCnt = 0;

		try {
			// conn = ConnectionProvider.getConnection();

			String sql = "select count(*) from phoneInfo_univ where student_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

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

	public int insertInfo(PhoneUnivInfo univ) {
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

			String sql = "insert into phoneInfo_univ  (idx,student_name,phonenumber,addr,email,major,grade,ref_idx) "
					+ " values (?, ?, ?,?, ?, ?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, univ.getIdx());
			pstmt.setString(2, univ.getName());
			pstmt.setString(3, univ.getPhoneNumber());
			pstmt.setString(4, univ.getAddr());
			pstmt.setString(5, univ.getEmail());
			pstmt.setString(6, univ.getMajor());
			pstmt.setString(7, univ.getGrade());
			pstmt.setInt(8, univ.getRef_idx());
			System.out.println("성공");
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
	};

	public List<PhoneUnivInfo> phoneInfoList() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		 * public PhoneUnivInfo(int idx,String name, String phoneNumber, String addr,
		 * String email, String major, String grade) }
		 */
		List<PhoneUnivInfo> phoneList = new ArrayList<PhoneUnivInfo>();
//'n'
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "select * from phoneInfo_univ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// phoneInfo에 id값(pk) 추가
			// String name, String phoneNumber, String addr, String email
			// PhoneInfo 추상클래스라서 객체 생성 못함->하위클래스형으로 객체 생성
			// PhoneUnivInfo(int idx,String name, String phoneNumber,
			// String addr, String email, String major, String grade)

//			---------- -------- ------------ 
//			IDX        NOT NULL NUMBER(6)    
//			FR_U_MAJOR          VARCHAR2(20) 
//			FR_U_YEAR           NUMBER(1)    
//			FR_REF              NUMBER(7)    

			while (rs.next()) {
//				PhoneInfo phone=new PhoneInfo(rs.getString(1));
				PhoneUnivInfo phone = new PhoneUnivInfo(rs.getInt("idx"), rs.getString("student_name"),
						rs.getString("phonenumber"), rs.getString("addr"), rs.getString("email"), rs.getString("major"),
						rs.getString("grade"), rs.getInt("ref_idx"));
//				PhoneUnivInfo phone = new PhoneUnivInfo(rs.getInt("idx"), rs.getString("name"),
//						rs.getString("phoneNumber"), rs.getString("addr"), rs.getString("email"), rs.getString("major"),
//						rs.getString("grade"), rs.getInt("ref_idx"));
				phone.showAllInfo();
				phoneList.add(phone);
			}
			System.out.println("=======================================================================");
			
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
			return phoneList;
		}
	}
}