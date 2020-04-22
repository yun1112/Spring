package prac;

import java.util.Scanner;

//PhoneInfor 객체 배열 100개 생성
//
public class PhoneBookManager2 {
	PhoneInfor2[] info = new PhoneInfor2[100];

	int cnt = 0;

	void getInfor(PhoneInfor2 info) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("이름 입력>>");
			String name = sc.nextLine();
			System.out.println("전화번호 입력>>");
			String phoneNumber = sc.nextLine();
			System.out.println("생일 입력>>");
			String birthday = sc.nextLine();

			if (birthday == null || birthday.trim().isEmpty()) {
				info = new PhoneInfor2(name, phoneNumber);
			} else {
				info = new PhoneInfor2(name, phoneNumber, birthday);
			}

			cnt++;
		}
	}
}
