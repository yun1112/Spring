package project1;

import java.util.Scanner;

import project1.pro1.PhoneInfor;

public class pro2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("이름, 전화번호, 생년월일 입력");
			String name = sc.next();
			String phone = sc.next();
			String birth = sc.next();
			PhoneInfor p1 = new PhoneInfor(name, phone, birth);
//			System.out.println("이름, 전화번호 입력");
//			PhoneInfor p2 = new PhoneInfor(name, phone);
			p1.printAl();
//			p2.printAl();
		}
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
			System.out.println("-------------------------------------------------------");
			System.out.println("이름: " + name);
			System.out.println("전화번호: " + phoneNumber);
//			if (birthday.equals("") == false)
			System.out.println("생년월일: " + birthday);
			System.out.println("-------------------------------------------------------");
		}
	}

}

/*
 * Project : ver 0.20 “프로그램 사용자로부터 데이터 입력” 프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를
 * 생성하는 것이 핵심. 단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다. 프로그램 종료를 하지 않으면, 다음과 같은 과정이
 * 반복적으로 이루어짐. 키보드로부터 데이터 입력  입력 받은 데이터로 인스턴스 생성  생성된 인스턴스의 메소드 호출
 */