package prac2;

public class PhoneInfor {
	private String name;
	private String phoneNumber;
	private String birthday;

	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;

	}

	public String getName() {
		return name;
	}

	PhoneInfor(String name, String phoneNumber) {
		this(name, phoneNumber, "생일을 입력하지 않았습니다");
	}

	boolean checkName(String name) {
		return this.name.equals(name);
	}

	void showInfor() {
		System.out.printf("이름:%s\n전화번호:%s\n생일:%s\n", this.name, this.phoneNumber, this.birthday);
		System.out.println("-----------------------------------------------------------------");

	}
}
