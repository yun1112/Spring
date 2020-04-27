package prac04_2;

import java.util.Scanner;

public class PhoneManager {
	PhoneInfo[] books;
	int numOfInfo;
	int N;
	Scanner sc;
	int type;

	PhoneManager() {
		books = new PhoneInfo[N];
		numOfInfo = 0;
		N = 0;
		sc = new Scanner(System.in);
		type = 0;
	}

	int searchIndex() {
		System.out.println("검색할 이름 입력");
		String name = sc.nextLine();
		int searchIndex = -1;
		if (searchIndex < 0) {
			System.out.println("해당 정보가 없습니다");
		} else {
			for (int i = 0; i < numOfInfo; i++) {
				if (books[i].name.equals(name)) {
					searchIndex = i;
					break;
				}
			}
		}
		return searchIndex;
	}

	/*
	 * 상위클래스 이름, 전화번호,주소 이메일
	 * 
	 * 하위클래스 1.대학 전공 학년
	 * 
	 * 2.회사 회사명,부서,직급
	 * 
	 * 3.동호회 동호회명,닉네임
	 * 
	 * 
	 */

	void showAllInfo() {
		for (int i = 0; i < numOfInfo; i++) {
			books[i].showInfo();
		}
	}

	void saveInfo() {
		PhoneInfo p = null;

		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("전화번호:");
		String phoneNumber = sc.nextLine();
		System.out.println("주소:");
		String addr = sc.nextLine();
		System.out.println("이메일:");
		String email = sc.nextLine();
		switch (type) {
		case 1:
			p = new PhoneInfo(name, phoneNumber, addr, email);
			break;
		case 2:
			System.out.println("전공:");
			String major = sc.nextLine();
			System.out.println("학년:");
			String grade = sc.nextLine();
			p = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;
		case 3:
			System.out.println("회사:");
			String company = sc.nextLine();
			System.out.println("부서:");
			String dept = sc.nextLine();
			System.out.println("직급:");
			String job = sc.nextLine();
			p = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;
		case 4:
			System.out.println("동호회 이름:");
			String cafeName = sc.nextLine();
			System.out.println("닉네임:");
			String nickName = sc.nextLine();
			p = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		default:
			return;
		}

		addInfo(p);
	}

	void searchInfo() {
		System.out.println("검색할 이름 입력");
		String name = sc.nextLine();
		int searchIndex = searchIndex();
		if (searchIndex < 0) {
			System.out.println("해당 정보가 없습니다");
		} else {
			books[searchIndex].showInfo();

		}
	}

	void deleteInfo() {
		System.out.println("삭제할 이름 입력");
		String name = sc.nextLine();
		int searchIndex = searchIndex();
		if (searchIndex < 0) {
			System.out.println("해당 정보가 없습니다");
		} else {
			for (int i = searchIndex; i < numOfInfo - 1; i++) {
				books[i] = books[i + 1];
			}
		}
		numOfInfo--;
	}

	void editInfo() {
		System.out.println("수정할 이름 입력");
		String name = sc.nextLine();
		int searchIndex = searchIndex();
		if (searchIndex < 0) {
			System.out.println("해당 정보가 없습니다");
		} else {
			System.out.println("전화번호:");
			String phoneNumber = sc.nextLine();
			System.out.println("주소:");
			String addr = sc.nextLine();
			System.out.println("이메일:");
			String email = sc.nextLine();

			PhoneInfo p = null;
			for (int i = 0; i < numOfInfo; i++) {

				if (books[i] instanceof PhoneUnivInfo) {
					System.out.println("전공:");
					String major = sc.nextLine();
					System.out.println("학년:");
					String grade = sc.nextLine();

					p = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
				} else if (books[i] instanceof PhoneCompanyInfo) {// 회사명,부서,직급
					System.out.println("회사명:");
					String company = sc.nextLine();
					System.out.println("부서:");
					String dept = sc.nextLine();
					System.out.println("직급:");
					String job = sc.nextLine();

					p = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
				} else if (books[i] instanceof PhoneCafeInfo) {// 동호회명,닉네임
					System.out.println("동호회 이름:");
					String cafeName = sc.nextLine();
					System.out.println("닉네임:");
					String nickName = sc.nextLine();

					p = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);

				} else if (books[i] instanceof PhoneInfo) {// 기본 정보에 해당될 경우(상위클래스) 가장 나중에 조건 체크
					p = new PhoneInfo(name, phoneNumber, addr, email);
				}
			}

		}
	}

	void addInfo(PhoneInfo p) {
		books[numOfInfo++] = p;
	}

}
