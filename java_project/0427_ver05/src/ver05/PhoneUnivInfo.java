package ver05;

public class PhoneUnivInfo extends PhoneInfo{
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
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("전공:" + this.major);
		System.out.println("학년:" + this.grade);
	}

	@Override
	public void showAllInfo() {
		super.showBasicInfo();
	}

}