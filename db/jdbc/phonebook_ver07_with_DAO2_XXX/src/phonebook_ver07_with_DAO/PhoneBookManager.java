package phonebook_ver07_with_DAO;
//수정 날짜: 20/06/02

//일단 대학정보로만 만듦

import java.util.List;


public class PhoneBookManager {
	PhoneBookDao pdao = new PhoneBookDao();

	// 대학/회사/동호회 중 어느 정보인지 받아와서 출력
	public void PhoneBookManager() {
		System.out.println("=======================================================================");
		System.out.println("1.출력 2.입력 3. 검색 4.삭제 5.수정 6.종료");
		System.out.println("=======================================================================");

		int select = PhoneBookMain.sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			phonebookList();
			break;
		case 2:
			phonebookInsert();
			break;
		case 3:
			phonebookSearch();
			break;
		case 4:
			phonebookDelete();
			break;
		case 5:
			phonebookModify();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("올바른 입력이 아닙니다.\n다시 입력해주세요");
			break;
		}
	}

	/*
	 * PhoneUnivInfo phone = new PhoneUnivInfo(rs.getInt("idx"),
	 * rs.getString("name"), rs.getString("phoneNumber"), rs.getString("addr"),
	 * rs.getString("email"), rs.getString("major"), rs.getString("grade"));
	 */
	public void phonebookList() {// 리스트 3종류 만들어야 됨(대학/회사/동호회)
		List<PhoneUnivInfo> univList = pdao.phoneInfoList();

		if (univList != null && !univList.isEmpty()) {
			for (int i = 0; i < univList.size(); i++) {
				System.out.println("정상출력");
				System.out.printf("%5s", univList.get(i).getIdx() + "\t");
				System.out.printf("%12s", univList.get(i).getName() + "\t");
				System.out.printf("%12", univList.get(i).getPhoneNumber() + "\t");
				System.out.printf("%12", univList.get(i).getAddr() + "\t");
				System.out.printf("%12", univList.get(i).getEmail() + "\t");
				System.out.printf("%12", univList.get(i).getMajor() + "\t");
				System.out.printf("%12", univList.get(i).getGrade() + "\t");
				System.out.printf("%5s", univList.get(i).getRef_idx() + "\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다");
		}

	}

	public void phonebookInsert() {

		// 사용자 입력정보 변수
		System.out.println("대학생 정보를 입력해주세요.");

		System.out.println("학번 : ");
		int univ_index = PhoneBookMain.sc.nextInt();
		System.out.println("이름 : ");
		PhoneBookMain.sc.nextLine();
		String student_name = PhoneBookMain.sc.nextLine();
		System.out.println("전화번호 : ");
		String phonenumber = PhoneBookMain.sc.nextLine();
		System.out.println("주소 : ");
		String addr = PhoneBookMain.sc.nextLine();
		System.out.println("이메일 : ");
		String email = PhoneBookMain.sc.nextLine();
		System.out.println("전공 : ");
		String major = PhoneBookMain.sc.nextLine();
		System.out.println("학년(1글자) : ");
		String grade = PhoneBookMain.sc.nextLine();
		System.out.println("참조키 ");// 참조키 빼야됨@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		int ref_idx = 1;

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		PhoneUnivInfo univ = new PhoneUnivInfo(univ_index, student_name, phonenumber, addr, email, major, grade,
				ref_idx);
		univ.showAllInfo();
		int resultCnt = pdao.insertInfo(univ);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재시도해주세요.");
		}
	}

	public void phonebookSearch() {
		System.out.println("찾고자 하는 학생 이름>>");
		PhoneBookMain.sc.nextLine();
		String searchName = PhoneBookMain.sc.nextLine();

//		List<PhoneUnivInfo> univList=pdao.searchInfo(searchName);
		System.out.println("");

	}

	public void phonebookDelete() {

		System.out.println("삭제하고자 하는 부서이름 : ");
		PhoneBookMain.sc.nextLine();
		String searchName = PhoneBookMain.sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		int resultCnt = pdao.deleteInfo(searchName);

		if (resultCnt < 1) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("=================================");
	}

	public void phonebookModify() {
	}
}