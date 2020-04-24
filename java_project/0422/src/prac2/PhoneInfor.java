package prac2;
/*
 * 다음 두 클래스를 추가로 삽입. 상속 구조가 가능하다면 상속 구조로 구성 해보세요.
PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가
PhoneUnivInfor
이름 name String
전화번호 phoneNumber String
주소 address String
이메일 email String


전공 major String
학년 year String

PhoneCompaanyInfor
이름 name String
전화번호 phoneNumber String
주소 address String

이메일 email String
회사 company String

추가한 클래스
+PhoneUnivInfor, PhoneCompaanyInfor, PhoneAcademyInfor

Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가해 보자

작성자: 원윤경
작성 일자:2020/04/24
변경 사항: 클래스 추가, 상속
*/

//상속 후 상위클래스의 기능 사용이 필요할 경우
//메서드 오버라이딩 이용할 것 

//초기화 생성자 매개변수 수정할 것
class PhoneUnivInfor extends PhoneInfor {
	String major;
	String year;

	PhoneUnivInfor(String name, String phoneNumber, String address, String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.year = year;
	}

	@Override
	public String toString() {
		return "전공:" + major + ", 연도:" + year+"";
	}

}

class PhoneCompanyInfor extends PhoneInfor {
	String email;
	String company;

	PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}

	@Override
	public String toString() {
		return "PhoneCompanyInfor [email:" + email + ", company:" + company + "]";
	}

}

class PhoneAcademyInfor extends PhoneInfor {// 새로 정의한 클래스
	String id;

	PhoneAcademyInfor(String name, String phoneNumber, String address, String email, String id) {
		super(name, phoneNumber, address, email);
		this.id = id;
	}

	@Override
	public String toString() {
		return "PhoneAcademyInfor [id:" + id + "]";
	}

}

public class PhoneInfor {
	private String name;
	private String phoneNumber;
//	private String birthday;
	private String address;
	private String email;

	PhoneInfor(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
//		this.birthday = birthday;

	}

	public String getName() {
		return name;
	}

	boolean checkName(String name) {
		return this.name.equals(name);
	}

	void showInfor() {
		System.out.printf("이름:%s\n전화번호:%s\n생일:%s\n", this.name, this.phoneNumber);
		System.out.println("-----------------------------------------------------------------");

	}

	@Override
	public String toString() {
		return "PhoneInfor [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", email=" + email
				+ "]";
	}
	
	
}
