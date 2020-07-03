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
	public void searchInfo() {
	};

	public void editInfo() {
	};

	public void deleteInfo() {
	};

	public void createInfo() {
	};

	public void showAllInfo() {
	};

	public List<PhoneUnivInfo> phoneInfoList() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PhoneUnivInfo> phoneList = new ArrayList<>();

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
				PhoneUnivInfo phone = new PhoneUnivInfo(rs.getInt("idx"), rs.getString("name"),
						rs.getString("phoneNumber"), rs.getString("addr"), rs.getString("email"), rs.getString("major"),
						rs.getString("grade"));
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