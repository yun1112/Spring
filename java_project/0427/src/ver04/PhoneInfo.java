package ver04;

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
	void showBasicInfo() {
		System.out.println("이름:"+this.name);
		System.out.println("전화번호:"+this.phoneNumber);
		System.out.println("주소:"+this.addr);
		System.out.println("메일:"+this.email);
	}
	void showAllInfo() {
		showBasicInfo();
	}
	
}
