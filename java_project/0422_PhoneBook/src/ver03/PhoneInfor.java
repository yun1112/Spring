package ver03;

/*
Project : ver 0.30

배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.

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
	
	//name 속성값과 전달받은 문자열을 비교해서 결과 반환
boolean checkName(String name) {
	return this.name.equals(name);
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
