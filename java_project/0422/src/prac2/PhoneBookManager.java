package prac2;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneBookManager {
	PhoneInfor[] pBooks;
	int cnt;
	Scanner sc;

	PhoneBookManager() {
		pBooks = new PhoneInfor[100];
		cnt = 0;
		sc = new Scanner(System.in);
	}

	PhoneInfor createInstance() {
		System.out.println("이름을 입력하세요>>");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력하세요>>");
		String phoneNumber = sc.nextLine();

		System.out.println("생일을 입력하세요>>");
		String birthday = sc.nextLine();

		if (birthday == null || birthday.trim().isEmpty()) {
			pBooks[cnt] = new PhoneInfor(name, phoneNumber);
		} else {
			pBooks[cnt] = new PhoneInfor(name, phoneNumber, birthday);
		}

		cnt++;
		
		return pBooks[cnt];
	}
	
//	void addInstance() {}

	void showAllData() {
		for (int i = 0; i < cnt; i++) {
			pBooks[i].showInfor();
		}
	}

	int searchIndex(String name) {
//		int searchindex = -1;
		int searchindex = -1;
		for (int i = 0; i < cnt; i++) {
			if (pBooks[i].getName().equals(name)) {
				searchindex=i;
			}
		}
		return searchindex;
	}

	void searchInfor() {
		String name = sc.nextLine();
		int searchindex = searchIndex(name);
		if (searchindex < 0) {
			System.out.println("해당 정보가 존재하지 않습니다");
		} else {
			pBooks[searchindex].showInfor();
		}

	}

	void deleteInfor() {
		String name = sc.nextLine();
		int searchindex = searchIndex(name);

		if (searchindex < 0) {
			System.out.println("해당 정보가 존재하지 않습니다");
		} else {
			
			for (int i = searchindex; i < cnt; i++) {
				pBooks[i] = pBooks[i + 1];
			}
			cnt--;
		}
		System.out.println("삭제를 완료했습니다");
	}
}
