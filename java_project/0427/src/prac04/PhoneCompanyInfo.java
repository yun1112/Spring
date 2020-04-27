package prac04;

public class PhoneCompanyInfo extends PhoneInfo {
	String company;
	String dept;
	String job;

	PhoneCompanyInfo(String name, String phoneNumber, String addr, String email, String company, String dept,
			String job) {
		super(name, phoneNumber, addr, email);
		this.company = company;
		this.dept = dept;
		this.job = job;
	}

	@Override
	void showAllInfo() {
		super.showAllInfo();
		System.out.println("회사:"+this.company);
		System.out.println("부서:"+this.dept);
		System.out.println("직무:"+this.job);
	}

}
