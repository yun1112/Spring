package ver05;
//3.PhoneInfor 클래스에 interface 추가->추상 클래스화

public abstract  class PhoneInfo implements PhoneInfoImpl{
	private String name;
	private String phoneNumber;
	private String addr;
	private String email;

	PhoneInfo(String name, String phoneNumber, String addr, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}

	public void showBasicInfo() {
		System.out.println("이름:" + this.name);
		System.out.println("전화번호:" + this.phoneNumber);
		System.out.println("주소:" + this.addr);
		System.out.println("메일:" + this.email);
	}

//	public void showAllInfo() {
//		showBasicInfo();
//	}

	boolean checkName(String name) {
		boolean check = false;
		if (name.equals(this.name))
			check = true;
		return check;
	}
}