package prac04;

import java.util.Scanner;

//PhoneInfo타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {
	PhoneInfo[] info;
	Scanner sc;
	int cnt;
	int type;

	PhoneBookManager() {
		info = new PhoneInfo[100];
		sc = new Scanner(System.in);
		cnt = 0;
		type = 0;
	}

	void chooseType() {
		type = sc.nextInt();
	}

	void modifyData() {
		sc.nextLine();
		System.out.println("수정할 이름:");
		String name = sc.nextLine();
		for (int i = 0; i < cnt; i++) {
			if (info[i].name.equals(name)) {
				System.out.println("------------------------------------------");
				System.out.println("정보를 입력하세요");
				System.out.println("이름:");
				name = sc.nextLine();
				System.out.println("전화번호:");
				String phoneNumber = sc.nextLine();
				System.out.println("주소:");
				String addr = sc.nextLine();
				System.out.println("메일:");
				String email = sc.nextLine();
				switch (type) {
				case 1:
					info[i] = new PhoneInfo(name, phoneNumber, addr, email);
					break;
				case 2:
					System.out.println("전공:");
					String major = sc.nextLine();
					System.out.println("학점:");
					String grade = sc.nextLine();
					info[i] = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
					break;
				case 3:
					System.out.println("회사:");
					String company = sc.nextLine();
					System.out.println("부서:");
					String dept = sc.nextLine();
					System.out.println("직책:");
					String job = sc.nextLine();
					info[i] = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
					break;
				case 4:
					System.out.println("동호회 이름:");
					String cafeName = sc.nextLine();
					System.out.println("닉네임:");
					String nickName = sc.nextLine();
					info[i] = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
					break;
				case 5:
					return;
				default:
					break;
				}

				System.out.println("[" + info[i].name + "정보를 수정했습니다]");
				return;
			}
		}
	}

	void EnterData() {
		sc.nextLine();
		System.out.println("------------------------------------------");
		System.out.println("정보를 입력하세요");
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("전화번호:");
		String phoneNumber = sc.nextLine();
		System.out.println("주소:");
		String addr = sc.nextLine();
		System.out.println("메일:");
		String email = sc.nextLine();
		switch (type) {
		case 1:
			info[cnt] = new PhoneInfo(name, phoneNumber, addr, email);
			break;
		case 2:
			System.out.println("전공:");
			String major = sc.nextLine();
			System.out.println("학점:");
			String grade = sc.nextLine();
			info[cnt] = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;
		case 3:
			System.out.println("회사:");
			String company = sc.nextLine();
			System.out.println("부서:");
			String dept = sc.nextLine();
			System.out.println("직책:");
			String job = sc.nextLine();
			info[cnt] = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;
		case 4:
			System.out.println("동호회 이름:");
			String cafeName = sc.nextLine();
			System.out.println("닉네임:");
			String nickName = sc.nextLine();
			info[cnt] = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		case 5:
			return;
		default:
			break;
		}

		System.out.println("[" + info[cnt].name + "정보를 등록했습니다]");
		addData(info[cnt]);
	}

	void searchData() {
		sc.nextLine();
		System.out.println("검색할 이름:");
		String name = sc.nextLine();
		for (int i = 0; i < cnt; i++) {
			if (info[i].name.equals(name))
				info[i].showAllInfo();
		}
	}

	void deleteData() {
		sc.nextLine();
		System.out.println("삭제할 이름:");
		String name = sc.nextLine();
		for (int i = 0; i < cnt; i++) {
			if (info[i].name.equals(name)) {
				for (int j = i; j < cnt - 1; j++) {
					info[j] = info[j + 1];
				}
			}
		}
		info[cnt - 1] = null;

		cnt--;
	}

	void addData(PhoneInfo p) {
		info[cnt++] = p;
	}

	void showAllData() {
		switch(type) {
		case 1:
			for (int i = 0; i < cnt; i++) {
				if(info[i] instanceof PhoneInfo)
					info[i].showAllInfo();
			}
			break;
		case 2:
			for (int i = 0; i < cnt; i++) {
				if(info[i] instanceof PhoneUnivInfo )
					info[i].showAllInfo();
			}
			break;
		case 3:
			for (int i = 0; i < cnt; i++) {
				if(info[i] instanceof PhoneCompanyInfo )
					info[i].showAllInfo();
			}
			break;
		case 4:
			for (int i = 0; i < cnt; i++) {
				if(info[i] instanceof PhoneCafeInfo )
					info[i].showAllInfo();
			}
			break;
		default:
			return;
		}
		for (int i = 0; i < cnt; i++) {
			info[i].showAllInfo();
		}
	}
}
