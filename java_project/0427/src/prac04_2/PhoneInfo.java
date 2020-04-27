package prac04_2;
/*
 상위클래스
 이름, 전화번호,주소 이메일 
 
 하위클래스
 1.대학
 전공
 학년
 
 2.회사
 회사명,부서,직급
 
 3.동호회
 동호회명,닉네임
 
 
 */

public class PhoneInfo {
	String name;
	String phoneNumber;
	String addr;
	String email;

	PhoneInfo(String name, String phoneNumber, String addr, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}

	void showInfo() {
		System.out.println("이름:" + this.name);
		System.out.println("전화번호:" + this.phoneNumber);
		System.out.println("주소:" + this.addr);
		System.out.println("이메일:" + this.email);
	}

	boolean checkName(String name) {
		boolean check = false;
		if (this.name.equals(name))
			check = true;
		return check;
	}
}

class PhoneUnivInfo extends PhoneInfo {
	String major;
	String grade;

	PhoneUnivInfo(String name, String phoneNumber, String addr, String email, String major, String grade) {
		super(name, phoneNumber, addr, email);
		this.major = major;
		this.grade = grade;
	}

	void showInfo() {
		super.showInfo();
		System.out.println("전공:" + this.major);
		System.out.println("학년:" + this.grade);
	}
}

//2.회사
//회사명,부서,직급

class PhoneCompanyInfo extends PhoneInfo {
	String compnay;
	String dept;
	String job;

	PhoneCompanyInfo(String name, String phoneNumber, String addr, String email, String company, String dept,
			String job) {
		super(name, phoneNumber, addr, email);
		this.compnay = company;
		this.dept = dept;
		this.job = job;

	}
	

	void showInfo() {
		super.showInfo();
		System.out.println("회사:" + this.compnay);
		System.out.println("부서:" + this.dept);
		System.out.println("직급:" + this.job);
	}

}
//3.동호회
//동호회명,닉네임

class PhoneCafeInfo extends PhoneInfo {
	String cafeName;
	String nickName;

	PhoneCafeInfo(String name, String phoneNumber, String addr, String email, String cafeName, String nickName) {
		super(name, phoneNumber, addr, email);
		this.cafeName = cafeName;
		this.nickName = nickName;
	}

	void showInfo() {
		super.showInfo();
		System.out.println("동호회 이름:" + this.cafeName);
		System.out.println("닉네임:" + this.nickName);
	}

}