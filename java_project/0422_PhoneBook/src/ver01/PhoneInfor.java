package ver01;

/*
 Version 0.1 전화번호 관리 프로그램. 

PhoneInfor 라는 이름의 클래스를 정의해 보자.
 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의

• 이름            name              String
• 전화번호       phoneNumber     String
• 생년월일       birthday            String 

단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.

작성자: 원윤경
작성 일자: 2020/04/22

 */

import java.util.*;

public class PhoneInfor {
//	private: 변수의 직접 참조를 막는다, 정보 은닉
	private String name;// 친구의 이름
	private String phoneNumber;// 친구의 전화번호
	private String birthday;// 친구의 생일

	// 초기화를 위한 생성자
	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneInfor(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this(name, phoneNumber, null);
		this(name, phoneNumber, "입력값이 없습니다");
	}

	void showInfor() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
//		if (this.birthday == null)// null값 초기화되어 있지 않으면 사용 불가
//			System.out.println("생일: 입력값이 없습니다");
//		else
			System.out.println("생일:" + this.birthday);
	}

}
