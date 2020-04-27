package ver04;

import java.util.Scanner;

//PhoneInfo타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {
	PhoneInfo[] books;
	Scanner kb;
	int numOfInfo;// int numOfInfo 배열에 저장된 요소의 개수

	PhoneBookManager() {
		books = new PhoneInfo[100];
		kb = new Scanner(System.in);
		numOfInfo = 0;
	}

	void searchData() {
		String name = kb.nextLine();
		for (int i = 0; i < numOfInfo; i++) {
			if (books[i].name.equals(name))
				books[i].showAllInfo();
		}
	}

	void deleteData() {
		String name = kb.nextLine();
		for (int i = 0; i < numOfInfo; i++) {
			if (books[i].name.equals(name)) {
				for (int j = i; j < numOfInfo - 1; j++) {
					books[j] = books[j + 1];
				}
			}
		}
		books[numOfInfo - 1] = null;

		numOfInfo--;
	}

	void addData(PhoneInfo p) {
		books[numOfInfo++] = p;
	}

	void createInfo() {
		System.out.println("1.일반 2.대학 3.회사 4.동호회");
		System.out.println("입력하고자 하는 번호를 입력해주세요");
//	int select=sc.nextInt();
//	sc.nextLine();
		int select = Integer.parseInt(kb.nextLine());// 공백 문제 해결

		// 기본 정보 수집:이름,전화번호,주소,이메일
		System.out.println("이름을 입력해주세요");
		String name = kb.nextLine();
		System.out.println("전화번호를 입력해주세요");
		String phoneNumber = kb.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = kb.nextLine();
		System.out.println("이메일을 입력해주세요");
		String email = kb.nextLine();

		PhoneInfo info = null;
		if (!(select > 0 && select < 5)) {
			switch (select) {
			case 1:
				info=new PhoneInfo(name, phoneNumber, addr, email);
				break;

			case 2:
				System.out.println("전공을 입력해주세요");
				String major=kb.nextLine();
				System.out.println("학점을 입력해주세요");
				String grade=kb.nextLine();
				info=new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
				break;

			case 3:
				System.out.println("회사를 입력해주세요");
				String company=kb.nextLine();
				System.out.println("부서를 입력해주세요");
				String dept=kb.nextLine();
				System.out.println("직책을 입려해주세요");
				String job=kb.nextLine();
				info=new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
				break;

			case 4:
				System.out.println("동호회 이름을 입력해주세요");
				String cafeName=kb.nextLine();
				System.out.println("닉네임을 입력해주세요");
				String nickName=kb.nextLine();
				info=new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
				break;

			default:
				System.out.println("정상적인 선택이 아닙니다\n메뉴를 다시 선택해주세요");
				return;
			}
		}

		addData(new PhoneInfo(name, phoneNumber, addr, email));

		System.out.println("이름을 입력해주세요");
		System.out.println("이름을 입력해주세요");
	}

	void showAllInfo() {
		//for 반복문
		//for each 반복문
		for(PhoneInfo info: books) {
			info.showAllInfo();
		}
		
//		for (int i = 0; i < numOfInfo; i++) {
//			books[i].showAllInfo();
//
//		}
	}
}
