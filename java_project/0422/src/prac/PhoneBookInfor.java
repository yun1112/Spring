package prac;

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
public class PhoneBookInfor {
	private String name;
	private String phoneNumber;
	private String birthday;

	PhoneBookInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneBookInfor(String name, String phoneNumber) {
		this(name,phoneNumber,"생년월일을 입력하지 않았습니다");
	}
	void printInstance() {
		
		System.out.println(this.name+" "+this.phoneNumber+" "+this.birthday);
	}
}
