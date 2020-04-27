package ver04;

public class PhoneUnivInfo extends PhoneInfo {
	String major;
	String grade;

	PhoneUnivInfo(String name, String phoneNumber, String addr, String email, String major, String grade) {
		super(name, phoneNumber, addr, email);
		this.major = major;
		this.grade = grade;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	void showAllInfo() {
		super.showAllInfo();
		System.out.println("전공:"+this.major);
		System.out.println("학년:"+this.grade);
	}

}
