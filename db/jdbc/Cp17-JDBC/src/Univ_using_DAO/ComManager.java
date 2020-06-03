package Univ_using_DAO;
/*
 * 입력할 때 무결성 제약조건때문에 pk중복된값 입력할 경우에 무한루프 도는 문제 발생
 * 
 * */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ComManager {

	ComDao dao = new ComDao();

	/////////////////////////////////////////////////////////////////
	// DEPT MANAGER
	/////////////////////////////////////////////////////////////////

	public void comManager() {

		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = ManageMain.sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("사원 정보를 입력합니다.");
			deptInsert(); // 사용자의 입력데이터 dept 객체에 담아서 dao insert 메서드로 전달
			break;
		case 3:
			System.out.println("사원 정보를 검색합니다.");
			deptSearch(); // 사용자가 입력한 이름을 dao search 전달
			break;
		case 4:
			System.out.println("사원 정보를 삭제합니다.");
			deptDelete(); // 이름 또는 부서번호 dao delete 전달
			break;
		case 5:
			System.out.println("사원 정보를 수정합니다.");
			deptEdit(); // 1. 수정ㅎ고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달
			break;

		}

	}

	public void deptEdit() {

		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false); // 기본값은 true : 자동 커밋

			// 1. 수정하고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달

			// 사용자 입력정보 변수

			System.out.println("수정하고자 하는 부서 이름 : ");
			ManageMain.sc.nextLine();
			String searchName = ManageMain.sc.nextLine();

			// 1. 수정하고자 하는 데이터 유무 확인
			int rowCnt = dao.deptSearchCount(searchName, conn);
			// System.out.println(rowCnt);

			if (rowCnt > 0) {
				Com dept2 = dao.deptSearchName(searchName, conn);

				if (dept2 == null) {
					System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
					return;
				}

				// 사용자 입력정보 변수
				System.out.println("사원 정보를 입력해주세요.");

				System.out.println("사원 번호 : " + dept2.getIdx());
				System.out.println("부서 번호는 수정되지 않습니다.");

				System.out.println("사원 이름 (" + dept2.getEmployee_name() + "  ) : ");
				String employee_name = ManageMain.sc.nextLine();

				System.out.println("전화번호 ( " + dept2.getPhonenumber() + "  ) : ");
				String phonenumber = ManageMain.sc.nextLine();
				System.out.println("주소 ( " + dept2.getAddress() + "  ) : ");
				String address = ManageMain.sc.nextLine();
				System.out.println("이메일 ( " + dept2.getEmail() + "  ) : ");
				String email = ManageMain.sc.nextLine();
				System.out.println("회사명 ( " + dept2.getCom_name() + "  ) : ");
				String com_name = ManageMain.sc.nextLine();
				System.out.println("부서 ( " + dept2.getDept() + "  ) : ");
				String dept = ManageMain.sc.nextLine();
				System.out.println("직급 ( " + dept2.getJob() + "  ) : ");
				String job = ManageMain.sc.nextLine();


				// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

				Com com = new Com(dept2.getIdx(), 
						employee_name,phonenumber,address,email,com_name,dept,job
						);

				int resultCnt = dao.comEdit(com, conn);

				if (resultCnt > 0) {
					System.out.println("정상적으로 수정 되었습니다.");
					System.out.println(resultCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
				}

			} else {
				System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
			}
			


			conn.commit();
			
			

		} catch (SQLException e) {
			
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}
			
			
			
			e.printStackTrace();
		}

	}

	public void deptInsert() {

		// 사용자 입력정보 변수
		System.out.println("사원 정보를 입력해주세요.");

		System.out.println("사원번호 : ");
		int idx = ManageMain.sc.nextInt();
		System.out.println("사원이름 : ");
		ManageMain.sc.nextLine();
		String employee_name = ManageMain.sc.nextLine();
		System.out.println("전화번호: ");
		String phonenumber = ManageMain.sc.nextLine();
		System.out.println("주소 : ");
		String address = ManageMain.sc.nextLine();
		System.out.println("이메일 : ");
		String email = ManageMain.sc.nextLine();
		System.out.println("회사명: ");
		String com_name = ManageMain.sc.nextLine();
		System.out.println("부서 : ");
		String dept = ManageMain.sc.nextLine();
		System.out.println("직급 : ");
		String job = ManageMain.sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		Com com = new Com(idx,
				employee_name,phonenumber,address,email,com_name,dept,job
				);


		int resultCnt = dao.deptInsert(com);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}

	}

	public void deptDelete() {

		// 사용자 입력정보 변수

		System.out.println("삭제하고자 하는 회원이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		int resultCnt = dao.deptDelete(searchName);

		if (resultCnt < 1) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("=================================");

	}

	public void deptSearch() {

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 회원이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();

		List<Com> list = dao.deptSearch(searchName);

		System.out.println("검색 결과");
		System.out.println("-------------------------------------------------------------------------------------");
		for (Com d : list) {
			System.out.printf("%5s", d.getIdx() + "\t");
			System.out.printf("%10s", d.getEmployee_name() + "\t");
			System.out.printf("%10s", d.getPhonenumber() + "\t");
			System.out.printf("%10s", d.getAddress() + "\t");
			System.out.printf("%10s", d.getEmail() + "\t");
			System.out.printf("%10s", d.getCom_name() + "\t");
			System.out.printf("%10s", d.getDept() + "\t");
			System.out.printf("%10s", d.getJob() + "\n");
		}
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public void deptList() {

		List<Com> deptList = dao.deptList();

		if (deptList != null && !deptList.isEmpty()) {

			for (int i = 0; i < deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getIdx() + "\t");
				System.out.printf("%10s", deptList.get(i).getEmployee_name() + "\t");
				System.out.printf("%10s", deptList.get(i).getPhonenumber() + "\t");
				System.out.printf("%10s", deptList.get(i).getAddress() + "\t");
				System.out.printf("%10s", deptList.get(i).getEmail() + "\t");
				System.out.printf("%10s", deptList.get(i).getCom_name() + "\t");
				System.out.printf("%10s", deptList.get(i).getDept() + "\t");
				System.out.printf("%10s", deptList.get(i).getJob() + "\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}

}