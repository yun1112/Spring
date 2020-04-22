package prac;

import java.util.Scanner;

/*
Project : ver 0.20
"프로그램 사용자로부터 데이터 입력"
프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
핵심.
단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.

키보드로부터 데이터 입력 
↓
입력 받은 데이터로 인스턴스 생성
↓
생성된 인스턴스의 메소드 호출


 */
public class PhoneBookManager {// 입력 처리 클래스
	Scanner sc = new Scanner(System.in);
	PhoneBookInfor info = null;

	void getInfor() {
		System.out.println("이름 입력>>");
		String name = sc.nextLine();
		System.out.println("전화번호 입력>>");
		String phoneNumber = sc.nextLine();
		System.out.println("생년월일 입력>>");
		String birthday = sc.nextLine();

		if (birthday == null || birthday.trim().isEmpty()) {
			info = new PhoneBookInfor(name, phoneNumber);
		} else {
			info = new PhoneBookInfor(name, phoneNumber,birthday);
		}
		info.printInstance();

	}

}
