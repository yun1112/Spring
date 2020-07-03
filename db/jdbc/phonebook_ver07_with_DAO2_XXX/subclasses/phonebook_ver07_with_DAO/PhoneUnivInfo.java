package phonebook_ver07_with_DAO;

public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private String grade;
	private int ref_idx;

	public PhoneUnivInfo(int idx, String name, String phoneNumber, String addr, String email, String major,
			String grade, int ref_idx) {
		super(idx, name, phoneNumber, addr, email);
		this.major = major;
		this.grade = grade;
		this.ref_idx = ref_idx;
	}

	public String getMajor() {
		return major;
	}

	public int getRef_idx() {
		return ref_idx;
	}

	public void setRef_idx(int ref_idx) {
		this.ref_idx = ref_idx;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
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
		System.out.println("출력확인");
		System.out.println("전공:" + this.major);
		System.out.println("학년:" + this.grade);
	}

	@Override
	public void showAllInfo() {
		this.showBasicInfo();
	}

}