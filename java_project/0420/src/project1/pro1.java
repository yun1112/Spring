package project1;

import java.util.Scanner;

public class pro1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름, 전화번호, 생년월일 입력");
		String name = sc.next();
		String phone = sc.next();
		String birth = sc.next();
		PhoneInfor p1 = new PhoneInfor(name, phone, birth);
		System.out.println("이름, 전화번호 입력");
		String name2 = sc.next();
		String phone2 = sc.next();
		PhoneInfor p2 = new PhoneInfor(name2, phone2);
		p1.printAl();
		p2.printAl();

	}

	static class PhoneInfor {
		String name;
		String phoneNumber;
		String birthday;

		PhoneInfor() {

		}

		PhoneInfor(String n, String p) {
			name = n;
			phoneNumber = p;
		}

		PhoneInfor(String n, String p, String b) {
			name = n;
			phoneNumber = p;
			birthday = b;
		}

		public void printAl() {
			System.out.println("이름: " + name);
			System.out.println("전화번호: " + phoneNumber);
			System.out.println("생년월일: " + birthday);
		}
	}

}

/*
 * Version 0.1 전화번호 관리 프로그램. PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열
 * 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의 • 이름 name String • 전화번호
 * phoneNumber String • 생년월일 birthday String 단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔
 * 생성자 생성.
 */