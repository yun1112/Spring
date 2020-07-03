package phonebook_ver07_with_DAO;

public class PhoneCompanyInfo extends PhoneInfo implements PhoneInfoImpl {
	String company;
	String dept;
	String job;

	PhoneCompanyInfo(int idx, String name, String phoneNumber,
			String addr, String email, String company, String dept,
			String job) {
		super(idx, name, phoneNumber, addr, email);
		this.company = company;
		this.dept = dept;
		this.job = job;
	}

	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("회사:" + this.company);
		System.out.println("부서:" + this.dept);
		System.out.println("직무:" + this.job);
	}

	@Override
	public void showAllInfo() {
		super.showBasicInfo();
	}

}