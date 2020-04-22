package prac;

public class PhoneInfor3 {
	private String name;
	private String phoneNumber;
	private String birthday;

	PhoneInfor3(String name, String phoneNumber, String birthday) {
		this.name=name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneInfor3(String name, String phoneNumber) {
		this(name, phoneNumber, "생일정보를 입력하지 않았습니다");
	}

	// 동일 이름 검사 메서드
	boolean checkName(String name ) {
		boolean check = false;
		if (this.getName().equals(name))
			check=true;
		return check;
	}

	void showInfor() {
		System.out.printf("이름: %d\n전화번호:%s\n생일:%s\n", this.name, this.phoneNumber, this.birthday);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
